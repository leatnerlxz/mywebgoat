package Controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class uploadFileServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("进入servlet");
        //判断是否有文件上传请求且为带文件上传的表单
        if (ServletFileUpload.isMultipartContent(req)){
            //System.out.println("req有内容");
            //创建fileItemFactory工厂实现类
            FileItemFactory fif = new DiskFileItemFactory();
            //创建解析工具类ServletFileUpload类
            //设置编码规则一定要在获取内容之前
            req.setCharacterEncoding("UTF-8");
            ServletFileUpload servletFileUpload = new ServletFileUpload(fif);
            try{
                //解析上传的数据，得到每一个表单相FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);

                for (FileItem item : list){
                    //判断每个表单项是普通类型还是带文件上传的的表单
                    if (item.isFormField()){
                        System.out.println("普通表单对象，不符合要求");
                    }else {
                        //System.out.println("表单项的name:"+item.getFieldName());
                        //System.out.println("上传的文件名："+item.getName());
                        //绝对地址，直接存储
                        String str = "D:\\CODE\\JAVA\\MyWebGoat\\src\\UploadFile\\"+item.getName();
                        item.write(new File(str));
                        //将信息返回前端展示：
                        //ServletContext context = this.getServletContext();
                        String patha = "上传文件所在路径为："+str;
                        System.out.println(patha);
                        req.setAttribute("patha",patha);
                        req.getRequestDispatcher("/upload.jsp").forward(req,
                                resp);
                    }
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
