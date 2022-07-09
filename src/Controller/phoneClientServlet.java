package Controller;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class phoneClientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userURL = req.getParameter("userUrl");//url
        System.out.println(userURL);
        String html = null;
        try {
            if(userURL == null){
                System.out.println("路径为空");
            }
            else {
                //创建一个httpclient对象
                CloseableHttpClient httpclient = HttpClients.createDefault();
                //创建HttpGet请求，并进行相关设置
                HttpGet httpGet = new HttpGet(userURL);
                //发起请求
                CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);
                try {
                    System.out.println(closeableHttpResponse.getStatusLine());//输出http状态
                    //获取http的response的请求实体
                    HttpEntity entity = closeableHttpResponse.getEntity();
                    //将网页内容转成字符串
                    html = EntityUtils.toString(entity,"UTF-8");
                    System.out.println(html);
                    //释放httpEntity所持有的资源
                    EntityUtils.consume(entity);

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    closeableHttpResponse.close();
                }
                req.setAttribute("htmlContent",html);
                req.getRequestDispatcher("/clientPhone.jsp").forward(req,
                        resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
