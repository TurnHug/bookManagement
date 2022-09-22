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
            System.out.println("�����������û���:");
            String name;
            Scanner in = new Scanner(System.in);
            name = in.next();

            System.out.println("��������������:");
            String pwd;
            pwd = in.next();

            if (adduser(name, pwd)){
                System.out.println("ע��ɹ�!");
                break;
            }else System.out.println("�û����Ѵ��ڣ�");
        }

    }

    public static String userlogin() {
        String name;
        while (true) {
            System.out.println("�����������û���:");
            Scanner in = new Scanner(System.in);
            name = in.next();

            System.out.println("��������������:");
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
                System.out.println("��¼�ɹ���");
                break;
            } else System.out.println("�û������������");
        }
        return name;
    }

    public  static void adminlogin(){
        System.out.println("���������Ա������:");
        Scanner in = new Scanner(System.in);
        String adminname = in.next();
        System.out.println("���������Ա�İ���:");
        String pwd = in.next();
        if(Objects.equals(adminname, "lsx") && Objects.equals(pwd, "love")){
            System.out.println("��¼�ɹ���");
        }
    }


}
