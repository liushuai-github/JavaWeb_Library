package servlet;

import entity.user;
import service.imp.serviceDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        /**
         * 用户的uid和uname通过session方式设置
         */


        //获取登录界面数据
        String uname = req.getParameter("uname");
        String pwd=req.getParameter("pwd");

        if (uname==null){
            uname="";
        }

        if (pwd==null){
            pwd="";
        }

        //返回1，登录成功，返回0登录失败
        serviceDaoImp service=new serviceDaoImp();
        List<user> list = service.login(uname, pwd);

        if (list.size()==0){
            //登录失败
            //设置登录失败提示:Tipe
            req.setAttribute("Tipe","账号或密码错误");
            try {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            //将用户id和用户uname写入session
            user user = list.get(0);
            HttpSession session = req.getSession();
            session.setAttribute("uid",user.getUid());
            session.setAttribute("uname",user.getUname());
//            System.out.println("uid:"+session.getAttribute("uid"));

            try {
                resp.sendRedirect("/user_library_byid");
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
