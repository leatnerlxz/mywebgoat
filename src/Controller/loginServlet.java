package Controller;

import entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class loginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        //System.out.println("req = " + userName + ", resp = " + userPwd);
        User user =new User();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        String result = user.userSelect(user);
        System.out.println("result:"+result);

        req.setAttribute("users",result);
        req.getRequestDispatcher("/login.jsp").forward(req,
                resp);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
