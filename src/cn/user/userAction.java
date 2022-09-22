package cn.user;

import cn.book.Book;
import cn.mysql.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author TurnHug
 * @date 2022/9/21 11:48
 */
public class userAction  {
    static Connection con = null;

    public static List<Book> selectState(Boolean tf){
        List<Book> booklist = new ArrayList<>();
        String sql = "select * from book where state = ?;";
        try {
            con = Connect.getConnection();
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(tf));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Book b = new Book();
                b.setId(rs.getString("id"));
                b.setName(rs.getString("name"));
                b.setType(rs.getString("type"));
                b.setFree(rs.getBoolean("free"));
                b.setPrice(rs.getDouble("price"));

                booklist.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connect.closeConnection(con);
        }
        return booklist;
    }

    public static void lend(String id) {
        String sql = "update book set state= '1' where id = ?;";
        try {
            con = Connect.getConnection();
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection(con);
        }

    }

    public static String getname(String id) throws SQLException {
        String sql = "select name from book where id = ?;";
        con = Connect.getConnection();
        assert con != null;
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        String name = null;
        while (rs.next()) {
            name = rs.getString("name");
        }
        return name;
    }

    public static void lendBook(String name) throws SQLException {
        List<Book> l = selectState(true);
        System.out.println(" 书号\t"+" 书名\t"+"类型\t"+"是否免费\t"+"价格\t");
        for (Book book : l) {
            System.out.println(book.getId()+"\t"+book.getName()+"\t"+book.getType()+"\t"
                    +book.getFree()+"\t"+book.getPrice());
        }
        String input = null;
        while (true) {
            System.out.println("请输入要借的书的序号,输入#号键结束借书。");
            Scanner in = new Scanner(System.in);
            input = in.next();
            if (input.equals("#")){
                break;
            }
            lend(input);
            savename(name,input);
            String bname = getname(input);
            System.out.println("书《" + bname + "》" + "已借成功！");
        }
    }

    public static void savename(String name,String id){
        String sql = "update book set pname= ? where id = ?;";
        try {
            con = Connect.getConnection();
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection(con);
        }
    }

    public static List<Book> showreturnbook(Boolean t, String name){
        List<Book> booklist = new ArrayList<>();
        String sql = "select * from book where state = ? and pname = ?;";
        try {
            con = Connect.getConnection();
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setBoolean(1,t);
            pstmt.setString(2, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Book b = new Book();
                b.setId(rs.getString("id"));
                b.setName(rs.getString("name"));
                b.setType(rs.getString("type"));
                b.setFree(rs.getBoolean("free"));
                b.setPrice(rs.getDouble("price"));
                b.setState(rs.getBoolean("state"));
                booklist.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connect.closeConnection(con);
        }
        return booklist;
    }

    public static void returnb(String id){
        String sql = "update book set state= '0' , pname = NULL where id = ?;";
        try {
            con = Connect.getConnection();
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connect.closeConnection(con);
        }

    }
    public static void returnbook(String name) throws SQLException {
        System.out.println("以下是您未还的书:");
        List<Book> lb = showreturnbook(true,name);
        System.out.println(" 书号\t"+" 书名\t"+"类型\t"+"是否免费\t"+"价格\t"+"状态");
        for (Book book : lb) {
            System.out.println(book.getId()+"\t"+book.getName()+"\t"+book.getType()+"\t"
                    +book.getFree()+"\t"+book.getPrice()+"\t"+book.getState());
        }
        while (true){
            System.out.println("请输入要还的书的序号,输入#号键结束还书。");
            Scanner in = new Scanner(System.in);
            String input = in.next();
            if (input.equals("#")){
                break;
            }
            returnb(input);
            String bookname = getname(input);
            System.out.println("书《" + bookname + "》" + "已还成功！");
        }
    }


}
