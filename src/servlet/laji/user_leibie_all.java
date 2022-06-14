package servlet.laji;

import entity.leibie;
import service.imp.serviceDaoImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "user_leibie_all", value = "/user_leibie_all")
public class user_leibie_all extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 目的：遍历所有图书类别信息，只包括图书类别和类别所对应的id
         * 返回一个类别对象集合
         */

        //创建service对象调用方法
        serviceDaoImp serviceDaoImp=new serviceDaoImp();
        List<leibie> list = serviceDaoImp.leibie_all();

        request.setAttribute("list",list);
        request.getRequestDispatcher("/leibie_all.jsp").forward(request,response);
    }
}
