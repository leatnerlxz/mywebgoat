package JdbcUtils;

import org.w3c.dom.ls.LSOutput;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;

    private static String driver;
    //静态代码块加载资源,文件读取只需要一次
    static {
        //            1.创建properties集合类
        Properties pro = new Properties();
        try {
            //            2.加载文件
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL url1 = classLoader.getResource("jdbc.properties");
//            获取资源文件的绝对路径
            String path = url1.getPath();
            pro.load(new FileReader(path));
//            3.获取数据，赋值
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            String test = print(url,user,password);
//            4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static String print(String url,String user,String password){
        return url+user+password;
    }
    public static Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection(url,user,password);
        System.out.println(conn);
        return conn;
    }
    /*
    * 释放资源
    * @param Statement
    * @param Connection*/
    public static void close(PreparedStatement ps,Connection conn){
        if (ps != null){
            try {
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs,Statement ps,Connection conn){
        if (rs != null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
