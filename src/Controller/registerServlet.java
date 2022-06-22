package Controller;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xssName = req.getParameter("XSSName");
        String xssPwd = req.getParameter("XSSPwd");
        String result = xssName+":"+xssPwd;
        req.setAttribute("users",result);
        req.getRequestDispatcher("/register.jsp").forward(req,
                resp);

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
