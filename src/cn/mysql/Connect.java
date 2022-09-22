package cn.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author TurnHug
 * @date 2022/9/21 9:18
 */
public class Connect {
    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URL = "jdbc:mysql://192.168.75.147:3306/bookdb?serverTimezone=GMT&useSSL=false";
    final static String USER = "root";
    final static String PASSWORD = "mysql";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            // System.out.println("连接成功");
            return (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
