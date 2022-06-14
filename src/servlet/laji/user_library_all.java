package servlet.laji;

import entity.library;
import service.imp.serviceDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet("/user_library_all")
public class user_library_all extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //创建service对象调用方法
            serviceDaoImp serviceDaoImp=new serviceDaoImp();

        /**
         * 目的：遍历所有的图书信息
         * 返回library对象集合
         */
        List<library> list = serviceDaoImp.library_all();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/reader/book.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
