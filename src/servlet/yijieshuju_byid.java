package servlet;

import entity.Page;
import entity.library;
import service.imp.serviceDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/yijieshuji_byid")
public class yijieshuju_byid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取搜索框中的值
        String name = request.getParameter("name");
        if (name==null)
            name="";

        //获取当前页数和每页行数的目的是进行分页查询并返回User对象

        Page page=new Page();

        serviceDaoImp serviceDaoImp=new serviceDaoImp();

        //获取当前页数
        String currentPage =request.getParameter("currentPage");
        if (currentPage==null){
            currentPage="1";
        }

        if (Integer.parseInt(currentPage)<=1){
            currentPage="1";
        }

        page.setCurrentPage(Integer.parseInt( currentPage));

        //获取每页行数
        String rows =request.getParameter("rows");
        if (rows==null){
            rows="7";
        }
        page.setRows(Integer.parseInt( rows));

        //计算start值
        int start=(Integer.parseInt(currentPage)-1)*Integer.parseInt( rows);

        //获取用户id


        HttpSession session = request.getSession();
//        session.setAttribute("uid","1");
        int uid=(Integer) session.getAttribute("uid");

        //通过用户uid,start和rows获取分页查询出来的library对象，并存入page对象当中（通过jdbc查询）
        //不符合搜索框信息
        List<library> list = serviceDaoImp.yijieshuji_byid(name,uid,start,Integer.parseInt(rows));
        System.out.println("list:"+list);
        page.setList(list);

//        计算总条数（通过jdbc查询）
        int count=serviceDaoImp.yijie_count_byid(uid);
//        int count=list.size();
        System.out.println("count:"+count);

        page.setCount(count);

        //计算总页数
        int totalCount=count%Integer.parseInt(rows) ==0 ?count/Integer.parseInt( rows):count/Integer.parseInt(rows)+1;
        System.out.println("totalCount:"+totalCount);

        page.setTotalCount(totalCount);

        request.setAttribute("page",page);

        //完成数据回显
        request.setAttribute("name",name);

        request.getRequestDispatcher("/reader/yijieshuji.jsp").forward(request,response);


    }
}
