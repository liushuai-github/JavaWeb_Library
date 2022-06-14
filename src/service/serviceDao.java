package service;

import entity.leibie;
import entity.library;
import entity.user;

import java.util.List;

public interface serviceDao {
    /**
     * 返回一个存储library的list集合
     */
    public List<library> library_all();

    /**
     * 返回一个储存leibie的list集合
     */
    public List<leibie> leibie_all();

    /**
     * 往jieshu数据库中存入数据,并接受返回值
     */
    public int insert_jieshu(int uid,String library_id);

    /**
     * 通过图书名称查询图书信息
     */
    public List<library> selByname(String name,int start,int rows);

    /**
     * 通过用户id和图书id进行还书
     */
    public int delet_jieshu(int uid,String library_id);

    /**
     * 通过索引值和行数进行返回
     * @param start
     * @param rows
     * @return
     */
    List<library> paging(int start, int rows);

    /**
     * 返回library数据总数
     * @return
     */
    public int count();

    /**
     * 通过用户id查询所借书籍的总数
     */
    public int yijie_count_byid(int uid);

    /**
     * 通过图书id返回library数据总数
     * @return
     */
    public int countByname(String name);

    /**
     * 通过类别id返回该类别对应的library数据总数
     */
    public int countByleibie_id(String leibie_id);

    /**
     * 往huanshu数据库中添加数据
     * @param uid
     * @param library_id
     */
//    void insert_huanshu(int uid, String library_id);

    /**
     * 将将jieshu数据库中的信息插入还书数据库
     */
    void insert_huanshu_(int uid, String library_id);

    /**
     * 通过uid来获取用户所借图书的list集合，并完成分页
     * @param uid
     * @param start
     * @param rows
     * @return
     */
    public List<library> yijieshuji_byid(String name,int uid,int start,int rows);

    /**
     * 通过获取账号密码进行查询，返回list用户集合
     * @param uname
     * @param pwd
     * @return
     */
    List<user> login(String uname, String pwd);

    /**
     * 获取leibie对象集合
     * @return
     */
    List<leibie> sel_leibie();

    /**
     * 通过leibie_id查找符合信息的library集合
     * @return
     */
    List<library> library_Byleibie_id(String leibie_id,int start,int rows);

    /**
     * 通过用户uid修改用户名字和用户密码
     * @param uid
     * @param uname
     * @param upsd
     */
    void modify(int uid, String uname, String upsd);
}
