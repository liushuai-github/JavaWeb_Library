package test.DaoImp;


import Dao.imp.DaoImp;
import org.junit.Test;

public class test {

    DaoImp daoImp=new DaoImp();

    @Test
    public void modify(){
        daoImp.modify(4,"测试","12311111");
    }


}
