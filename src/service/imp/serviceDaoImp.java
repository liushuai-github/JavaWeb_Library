package service.imp;

import Dao.imp.DaoImp;
import entity.leibie;
import entity.library;
import entity.user;
import service.serviceDao;

import java.util.List;

public class serviceDaoImp implements serviceDao {
    DaoImp daoImp=new DaoImp();

    @Override
    public List<library> library_all() {
        List<library> list = daoImp.library_all();
        return list;
    }

    @Override
    public List<leibie> leibie_all() {
        List<leibie> list = daoImp.leibie_all();
        return list;
    }

    @Override
    public int insert_jieshu(int uid, String library_id) {
        int i = daoImp.insert_jieshu(uid, library_id);
        return i;
    }

    @Override
    public List<library> selByname(String name,int start,int rows) {
        List<library> list = daoImp.selByname(name,start,rows);
        return list;
    }

    @Override
    public int delet_jieshu(int uid, String library_id) {
        int i = daoImp.delet_jieshu(uid, library_id);
        return i;
    }

    @Override
    public List<library> paging(int start, int rows) {
        List<library> list=daoImp.pagin(start,rows);
        return list;
    }

    @Override
    public int count() {
        int count = daoImp.count();
        return count;
    }

    @Override
    public int yijie_count_byid(int uid) {
        int count=daoImp.yijie_count_byid(uid);
        return count;
    }

    @Override
    public int countByname(String name) {
        int i = daoImp.countByname(name);
        return i;
    }

    @Override
    public int countByleibie_id(String leibie_id) {
        int count=daoImp.countByleibie_id(leibie_id);
        return count;
    }

//    @Override
//    public void insert_huanshu(int uid, String library_id) {
//        daoImp.insert_huanshu(uid,library_id);
//    }

    @Override
    public void insert_huanshu_(int uid, String library_id) {
        daoImp.insert_huanshu_(uid,library_id);
    }

    @Override
    public List<library> yijieshuji_byid(String name,int uid, int start, int rows) {
        List<library> list=daoImp.yijieshuji_byid(name,uid,start,rows);
        return list;
    }

    @Override
    public List<user> login(String uname, String pwd) {
        List<user> list=daoImp.login(uname,pwd);
        return list;
    }

    @Override
    public List<leibie> sel_leibie() {
        List<leibie> leibies=daoImp.sel_leibie();
        return leibies;
    }

    @Override
    public List<library> library_Byleibie_id(String leibie_id,int start,int rows) {
        List<library> list=daoImp.library_Byleibie_id(leibie_id,start,rows);
        return list;
    }

    @Override
    public void modify(int uid, String uname, String upsd) {
        daoImp.modify(uid,uname,upsd);
    }


}
