package servlet;

import service.imp.serviceDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/huanshu")
public class huanshu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //创建service对象调用方法
        serviceDaoImp serviceDaoImp=new serviceDaoImp();

        //获取用户id和图书id
//        String uid = req.getParameter("uid");
        int uid=(Integer) req.getSession().getAttribute("uid");
        String library_id = req.getParameter("library_id");


        //删除jieshu中的数据
        int i = serviceDaoImp.delet_jieshu(uid, library_id);

        //判断i是否为0，为0则是没有借过，不为0则是删除成功

        if (i==0){
//            req.setAttribute("msg","您没有结果此书，请先借取");
//            req.getRequestDispatcher("/paging").forward(req,resp);
            HttpSession session = req.getSession();
            session.setAttribute("msg","您没有借过此书，请先借取");
//            resp.sendRedirect("/paging");

            String name =(String) req.getAttribute("name");
            if (name==null){
                name="";
            }
            req.setAttribute("name",name);

//            resp.sendRedirect("/paging");

            req.getRequestDispatcher("/user_library_byid").forward(req,resp);

        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("msg","归还成功");

            //还书的同时并将还书的时间写入huanshu数据库
//            serviceDaoImp.insert_huanshu_(Integer.parseInt(uid),library_id);

            String name =(String) req.getAttribute("name");
            if (name==null){
                name="";
            }
            req.setAttribute("name",name);

//            resp.sendRedirect("/paging");

            req.getRequestDispatcher("/user_library_byid").forward(req,resp);

//            resp.sendRedirect("/paging");
        }



    }
}
