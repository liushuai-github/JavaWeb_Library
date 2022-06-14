package servlet;

import service.imp.serviceDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/jieshu")
public class jieshu extends HttpServlet {
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


        //根据uid和libraryid，将数据插入jieshu表
        int i = serviceDaoImp.insert_jieshu(uid, library_id);



        //判断i是否为0，为0提示成功

        if (i==0){
//            req.setAttribute("msg","借取成功,请到3308来拿书");
//            req.getRequestDispatcher("/paging").forward(req,resp);
            HttpSession session = req.getSession();
            session.setAttribute("msg","借取成功,请到3308来拿书");

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
            session.setAttribute("msg","借取失败,请先将书归还");


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
