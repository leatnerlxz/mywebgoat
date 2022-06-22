package Controller;

import org.w3c.dom.ls.LSOutput;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phoneClientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userURL = req.getParameter("userURL");//url
        String htmlcontent = "";
        try {
            URL u = new URL(userURL);
            URLConnection urlConnection = u.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            BufferedReader base = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuffer html = new StringBuffer();
            while ((htmlcontent = base.readLine())!= null){
                html.append(htmlcontent);
            }
            base.close();
            System.out.println("端口探测");
            System.out.println(urlConnection);
            System.out.println(html.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
