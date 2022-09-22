package cn.book;

import cn.mysql.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TurnHug
 * @date 2022/9/21 9:15
 */
public class bookOperate {
    static Connection con = null;

    public static boolean addBook(Book b){
        String sql = "insert into book(id,name,type,free,price,state) " +
                "values(?,?,?,?,?,?);";
        try {
            con = Connect.getConnection();
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, b.getId());
            pstmt.setString(2, b.getName());
            pstmt.setString(3, b.getType());
            pstmt.setBoolean(4, b.getFree());
            pstmt.setDouble(5, b.getPrice());
            pstmt.setBoolean(6,b.getState());
            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Connect.closeConnection(con);
        }
        return true;
    }

    public static List<Book> showBook(){
        List<Book> booklist = new ArrayList<>();
        String sql = "select * from book";
        try{
            con = Connect.getConnection();
            assert con != null;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Book b = new Book();
                b.setId(rs.getString("id"));
                b.setName(rs.getString("name"));
                b.setType(rs.getString("type"));
                b.setFree(rs.getBoolean("free"));
                b.setPrice(rs.getDouble("price"));
                b.setState(rs.getBoolean("state"));
                b.setPeople(rs.getString("pname"));
                booklist.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Connect.closeConnection(con);
        }
        return booklist;
    }

    public static void output(List<Book> bookList){

        System.out.println(" 书号\t"+" 书名\t"+"类型\t"+"是否免费\t"+"价格\t"+"状态");
        for (Book book : bookList) {
            System.out.println(book.getId()+"\t"+book.getName()+"\t"+book.getType()+"\t"
                    +book.getFree()+"\t"+book.getPrice()+"\t"+book.getState());
        }
    }

}
