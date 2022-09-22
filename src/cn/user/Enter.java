package cn.user;

import cn.mysql.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author TurnHug
 * @date 2022/9/21 11:13
 */
public class Enter {
    static Connection con = null;

    public static Boolean adduser(String name, String pwd){
        String sql = "insert into user(pname,passwd) values(?,?);";
        try {
            con = Connect.getConnection();
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, pwd);
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connect.closeConnection(con);
        }
        return true;
    }

    public static void register(){
        while (true){
            System.out.println("请设置您的用户名:");
            String name;
            Scanner in = new Scanner(System.in);
            name = in.next();

            System.out.println("请设置您的密码:");
            String pwd;
            pwd = in.next();

            if (adduser(name, pwd)){
                System.out.println("注册成功!");
                break;
            }else System.out.println("用户名已存在！");
        }

    }

    public static String userlogin() {
        String name;
        while (true) {
            System.out.println("请输入您的用户名:");
            Scanner in = new Scanner(System.in);
            name = in.next();

            System.out.println("请输入您的密码:");
            String pwd;
            pwd = in.next();

            String sql = "select passwd from user where pname = ?;";

            String pd = null;
            try {
                con = Connect.getConnection();
                assert con != null;
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, name);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next())
                    pd = rs.getString("passwd");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Connect.closeConnection(con);
            }

            if (Objects.equals(pd, pwd)) {
                System.out.println("登录成功！");
                break;
            } else System.out.println("用户名或密码错误！");
        }
        return name;
    }

    public  static void adminlogin(){
        System.out.println("请输入管理员的名称:");
        Scanner in = new Scanner(System.in);
        String adminname = in.next();
        System.out.println("请输入管理员的暗号:");
        String pwd = in.next();
        if(Objects.equals(adminname, "lsx") && Objects.equals(pwd, "love")){
            System.out.println("登录成功！");
        }
    }


}
