package entity;

import JdbcUtils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String userSelect(User user){
        Connection conn =null;
        ResultSet rs = null;
        Statement sm = null;
        String userInfo = "";
        try {
            conn = JDBCUtils.getConnection();
            sm = conn.createStatement();
            String name = user.getUserName();
            String pwd = user.getUserPwd();
            String sql = "select * from User_Info where user_name = '"+ name +"' and user_password = '" + pwd +"'";
            //System.out.println(sql);
            rs = sm.executeQuery(sql);
            while (rs.next()){
                String UseNname = rs.getString(1);
                String UserPassword = rs.getString(2);
                userInfo = userInfo+UseNname+":"+UserPassword;
                //System.out.println(userInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(rs,sm,conn);
        }
        return userInfo;
    }

}
