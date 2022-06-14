package servlet;

import service.imp.serviceDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modify")
public class Modify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        /**
         *         更改用户的名字和密码，用户的性别可不改
         *         更改session中的uname，并跳转到user_liabrary_byid 中
         */

        int uid =(Integer) req.getSession().getAttribute("uid");
        String uname = req.getParameter("uname");
        String upsd=req.getParameter("upsd");

        serviceDaoImp serviceDaoImp=new serviceDaoImp();

        //修改信息
        serviceDaoImp.modify(uid,uname,upsd);

        //跳转页面



    }
}
