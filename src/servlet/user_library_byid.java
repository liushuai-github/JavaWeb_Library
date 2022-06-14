package servlet;

import entity.Page;
import entity.leibie;
import entity.library;
import service.imp.serviceDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user_library_byid")
public class user_library_byid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        /**
         * 将page对象通过request传入book.jsp中
         * 将leibie对象集合通过request传入book.jsp中
         * 判断接收到的leibie_id是否为null，不为nll证明是通过类别查询，为null证明是显示所有图书并通过图书名字
         */

        String name;
        String currentPage;
        String rows;
        int start;
        List<leibie> leibies;
        List<library> list;
        int count=0;
        int totalCount=0;

        //获取搜索框中的值进行条件搜索
        name = request.getParameter("name");
        if (name==null)
            name="";

        //获取当前页数和每页行数的目的是进行分页查询并返回User对象

        Page page=new Page();
        serviceDaoImp serviceDaoImp=new serviceDaoImp();

        //获取当前页数
        currentPage =request.getParameter("currentPage");
        if (currentPage==null){
            currentPage="1";
        }

        if (Integer.parseInt(currentPage)<=1){
            currentPage="1";
        }



        //获取每页行数
        rows =request.getParameter("rows");
        if (rows==null){
            rows="7";
        }


        //计算start值
        start=(Integer.parseInt(currentPage)-1)*Integer.parseInt( rows);

        //获取leibie对象集合
        leibies=serviceDaoImp.sel_leibie();
        request.setAttribute("leibies",leibies);

        /**
         * 判断leibie_id是否为null，为null执行名字搜索返回library信息，不为null返回类别搜索的library信息
         * 通过start和rows获取分页查询出来的library对象,并且是符合搜索框信息，并存入page对象当中
         */
        String leibie_id = request.getParameter("leibie_id");
        if (leibie_id!=null){
            list=serviceDaoImp.library_Byleibie_id(leibie_id,start,Integer.parseInt(rows));

            //计算总条数
            count=serviceDaoImp.countByleibie_id(leibie_id);

            //计算总页数
            totalCount=count%Integer.parseInt(rows) ==0 ?count/Integer.parseInt( rows):count/Integer.parseInt(rows)+1;
        }
        else {
            list = serviceDaoImp.selByname(name, start, Integer.parseInt(rows));

            //计算总条数
            count=serviceDaoImp.countByname(name);

            //计算总页数
            totalCount=count%Integer.parseInt(rows) ==0 ?count/Integer.parseInt( rows):count/Integer.parseInt(rows)+1;
        }


        page.setCurrentPage(Integer.parseInt( currentPage));
        page.setRows(Integer.parseInt( rows));
        page.setCount(count);
        page.setTotalCount(totalCount);
        page.setList(list);


        request.setAttribute("page",page);

        //完成数据回显
        request.setAttribute("name",name);

        request.getRequestDispatcher("/reader/book.jsp").forward(request,response);


    }
}
