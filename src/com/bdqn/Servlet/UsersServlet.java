package com.bdqn.Servlet;

import com.bdqn.Service.UsersService;
import com.bdqn.Service.impl.UsersServiceimpl;
import com.bdqn.pojo.Page;
import com.bdqn.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/UsersServlet")
public class UsersServlet extends BaseServlet {

    UsersService usersService=new UsersServiceimpl();
    public String Login(HttpServletRequest request,HttpServletResponse response){
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        try {
            Users users = usersService.getLoginByNamePassWords(uname, upwd);
            //System.out.println(users.getStatus());
            if (users!=null){
                if (users.getStatus()==1) {
                    request.getSession().setAttribute("users",users);
                }else {
                    request.getSession().setAttribute("meg","登录失败！该用户账号已冻结!");
                    return "/Login.jsp";
                }
            }else {
                request.getSession().setAttribute("meg","登录失败！该用户账号或者密码不对!");
                return "/Login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/UsersPage/index.jsp";
    }
    public String selAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
        int currentPage=-1;
        UsersService usersService=new UsersServiceimpl();
        String names = request.getParameter("names");
        List<Users> list=null;
        String number = request.getParameter("currentPage");
        if (number==null){
            currentPage=1;
        }else {
            currentPage=Integer.parseInt(number);
        }
        Page pages = usersService.sellists(currentPage);
        if (names==null){
            list = usersService.selectAlls("");
        }else {
            list = usersService.selectAlls(names);
            if (list.size()==0){
                request.setAttribute("sss","抱歉！暂时没有数据");
            }
        }
        request.setAttribute("pages",pages);
        request.setAttribute("list",list);
        return "/UsersPage/selectAll.jsp";
    }

    public String updatePWD(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String olePwd = request.getParameter("olePwd");
        String newPwd = request.getParameter("newPwd");
        String newPwds = request.getParameter("newPwds");
    if (!newPwd.equals(newPwds)){
            request.getSession().setAttribute("meg","密码与确认密码不一样");
            return "/UsersPage/updatePwd.jsp";
        }else {
            Users users =(Users) request.getSession().getAttribute("users");
            int i = usersService.updatePwds(newPwd, users.getName());
            if (i>0){
                request.getSession().setAttribute("meg","修改成功");
                return "/UsersPage/updatePwd.jsp";
            }else {
                request.getSession().setAttribute("meg","修改失败");
                return "/UsersPage/updatePwd.jsp";
            }
        }

    }
}
