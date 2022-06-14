package Dao.imp;

import Dao.Dao;
import entity.jieshu;
import entity.leibie;
import entity.user;
import entity.library;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DaoImp implements Dao {

    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<library> library_all() {
        String sql="select library_id,name from library";
        List<library> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<library>(library.class));
        return list;
    }

    @Override
    public List<leibie> leibie_all() {
        String sql="select name,leibie_id from leibie";
        List<leibie> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<leibie>(leibie.class));
        return list;
    }

    @Override
    public int insert_jieshu(int uid, String library_id) {
        String sql1="select * from jieshu where uid=? and library_id=?";
        int i=0;
        List<jieshu> list = jdbcTemplate.query(sql1, new BeanPropertyRowMapper<jieshu>(jieshu.class), uid, library_id);
        i = list.size();
//        System.out.println("i="+i);

        //i=0,没有借过此书
        if (i==0) {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            String sql = "insert into jieshu() values(null ,?,?,?)";
            jdbcTemplate.update(sql, uid, library_id,format);
        }
        return i;
    }

    @Override
    public List<library> selByname(String name,int start,int rows) {
        String sql="select * from library where name like '%"+name+"%' limit "+start+","+rows+"";
        List<library> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<library>(library.class));
        return list;
    }

    @Override
    public int delet_jieshu(int uid, String library_id) {

        //先判断是否借过此书
        String sql="select * from jieshu where uid=? and library_id=?";
        List<jieshu> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<jieshu>(jieshu.class), uid, library_id);
        int i=list.size();
        if (i==0){
            //如果结果为0，则没有借过
            return 0;
        }
        else {

            //先将数据添加到huanshu数据库在删除数据
            DaoImp daoImp=new DaoImp();
            daoImp.insert_huanshu_(uid,library_id);

            String sql1="DELETE FROM jieshu WHERE uid=? AND library_id=?";
            jdbcTemplate.update(sql1,uid,library_id);
        }

        return i;
    }

    @Override
    public List<library> pagin(int start, int rows) {
        String sql="select * from library limit ?,?";
        List<library> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<library>(library.class), start, rows);
        return list;
    }

    @Override
    public int count() {
        String sql="select * from library";
        List<library> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<library>(library.class));
        return list.size();
    }

    @Override
    public int countByname(String name) {
        String sql="select count(*) from library where name like '%"+name+"%'";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public int countByleibie_id(String leibie_id) {
        String sql="select count(id) from library where leibie_id=?";
        int count=jdbcTemplate.queryForObject(sql,Integer.class,leibie_id);
        return count;
    }

//    @Override
//    public void insert_huanshu(int uid, String library_id) {
//        String sql = "insert into huanshu() values(?,?,?,null)";
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = simpleDateFormat.format(new Date());
//        jdbcTemplate.update(sql,uid,library_id,format);
//    }

    @Override
    public void insert_huanshu_(int uid, String library_id) {
        //通过uid和library_id 在jieshu数据库中将数据提取出来，然后保存到huanshu数据库当中

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());

//        System.out.println(uid+library_id);

        //将jieshu数据库中的数据提取出来
//        String sql="select * from jieshu where uid=? and library_id=?";
//        jieshu jieshu = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<jieshu>(jieshu.class), uid, library_id);
        String sql="select * from jieshu where uid=? and library_id=?";
        List<jieshu> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<jieshu>(jieshu.class), uid, library_id);
//        System.out.println(list.size());
        jieshu jieshu=list.get(0);

//        System.out.println(jieshu.getId()+jieshu.getUid()+jieshu.getLibrary_id()+jieshu.getJieshu());

        int id=jieshu.getId();
        int u_id=jieshu.getUid();
        String libraryid=jieshu.getLibrary_id();
        String ago= jieshu.getJieshu();

        //将数据插入huanshu数据库
        String sql2="insert into huanshu() values(null,?,?,?,?)";
        jdbcTemplate.update(sql2,u_id,libraryid,ago,format);


    }

    @Override
    public List<library> yijieshuji_byid(String name,int uid, int start, int rows) {
        //4个问好
//        String sql="SELECT s1.id,s1.library_id,s1.name,s1.leibie_id FROM library s1,(SELECT s2.library_id FROM jieshu s2,USER s1 WHERE s1.uid=? AND s2.uid=? ) s2 WHERE s1.library_id=s2.library_id LIMIT ?,?";
        String sql="SELECT * FROM (SELECT s1.id,s1.library_id,s1.name,s1.leibie_id FROM library s1,(SELECT s2.library_id FROM jieshu s2,USER s1 WHERE s1.uid=? AND s2.uid=? ) s2 WHERE s1.library_id=s2.library_id) s1 WHERE s1.name LIKE '%"+name+"%' LIMIT ?,?";
        List<library> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<library>(library.class), uid, uid, start, rows);
        return list;
    }

    @Override
    public int yijie_count_byid(int uid) {
        //2个问好
        String sql="SELECT count(*) FROM library s1,(SELECT s2.library_id FROM jieshu s2,USER s1 WHERE s1.uid=? AND s2.uid=? ) s2 WHERE s1.library_id=s2.library_id ";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class,uid,uid);
        return count;
    }

    @Override
    public List<user> login(String uname, String pwd) {
        String sql="select * from user where uzh=? and upsd=?";
//        System.out.println(uname);
//        System.out.println(pwd);
        List<user> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<user>(user.class),uname,pwd);
        return list;

    }

    @Override
    public List<leibie> sel_leibie() {
        String sql="select * from leibie";
        List<leibie> leibies = jdbcTemplate.query(sql, new BeanPropertyRowMapper<leibie>(leibie.class));
        return leibies;
    }

    @Override
    public List<library> library_Byleibie_id(String leibie_id,int start,int rows) {
        String sql="select * from library where leibie_id=? limit ?,?";
        List<library> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<library>(library.class), leibie_id,start,rows);
        return list;
    }

    @Override
    public void modify(int uid, String uname, String upsd) {
        String sql="update user set uname=?,upsd=? where uid=?";
        jdbcTemplate.update(sql,uname,upsd,uid);
    }
}
