package cn.user;

import cn.book.Book;
import cn.book.bookOperate;

import java.util.Scanner;

/**
 * @author TurnHug
 * @date 2022/9/22 9:59
 */
public class AdminAction {
    public static void add(){
        System.out.println("请输入要增添的书籍,以逗号分割(书号,书名,类型,是否免费(true or false),价格):");
        String ss ;
        Scanner in = new Scanner(System.in);
        ss = in.next();
        String[] input = ss.split(",");
        Book b = new Book();
        b.setId(input[0]);
        b.setName(input[1]);
        b.setType(input[2]);
        b.setFree(Boolean.valueOf(input[3]));
        b.setPrice(Double.parseDouble(input[4]));
        b.setState(false);
        bookOperate.addBook(b);
        System.out.println("书籍《"+b.getName()+"》添加成功！");
    }
}
