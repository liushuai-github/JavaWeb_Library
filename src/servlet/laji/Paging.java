package servlet.laji;

import entity.Page;
import entity.library;
import service.imp.serviceDaoImp;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "paging", value = "/paging")
public class Paging extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //获取当前页数和每页行数的目的是进行分页查询并返回User对象

        Page page=new Page();
//        service service=new service_impl();
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
            rows="5";
        }
        page.setRows(Integer.parseInt( rows));

        //计算start值
        int start=(Integer.parseInt(currentPage)-1)*Integer.parseInt( rows);

        //通过start和rows获取分页查询出来的library对象，并存入page对象当中
        List<library> list= serviceDaoImp.paging(start,Integer.parseInt(rows));
        page.setList(list);

//        计算总条数
        int count=serviceDaoImp.count();
        page.setCount(count);

        //计算总页数
        int totalCount=count/Integer.parseInt(rows) ==0 ?count/Integer.parseInt( rows):count/Integer.parseInt(rows)+1;

        page.setTotalCount(totalCount);

        request.setAttribute("page",page);

        request.getRequestDispatcher("/reader/book.jsp").forward(request,response);

    }
}
