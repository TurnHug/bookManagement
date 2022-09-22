package test;

import cn.book.bookOperate;
import cn.user.AdminAction;
import cn.user.Enter;
import cn.user.userAction;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author TurnHug
 * @date 2022/9/21 10:02
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        while (true){
            System.out.println("************欢迎来到图书管理系统************"+"\n");
            System.out.println("             1.读者登录   ");
            System.out.println("             2.管理员登录   ");
            System.out.println("请选择登录用户,输入0退出:");
            int x;
            Scanner in = new Scanner(System.in);
            x= in.nextInt();
            if(x==1) {
                System.out.println("老用户请输入1登录,新用户2请注册,输入0退出系统:");
                int c;
                Scanner ii = new Scanner(System.in);
                c = ii.nextInt();
                if (c == 1) {
                    String n = Enter.userlogin();
                    System.out.println("请选择您的操作:");
                    System.out.println("1.借书");
                    System.out.println("2.还书");
                    int m;
                    m = ii.nextInt();
                    if (m == 1) {
                        while (true) {
                            userAction.lendBook(n);
                            System.out.println("输入0退出系统！");
                            Scanner b = new Scanner(System.in);
                            int e = b.nextInt();
                            if (e == 0) {
                                break;
                            }
                        }
                    }
                    if (m == 2) {
                        while (true) {
                            userAction.returnbook(n);
                            System.out.println("输入0退出系统！");
                            Scanner b = new Scanner(System.in);
                            int e = b.nextInt();
                            if (e == 0) {
                                break;
                            }
                        }

                    }
                }

                if(c==2){
                    Enter.register();
                    String v = Enter.userlogin();
                    System.out.println("请选择您的操作:");
                    System.out.println("1.借书");
                    System.out.println("2.还书");
                    int m;
                    m = ii.nextInt();
                    if(m==1){
                        while (true){
                            userAction.lendBook(v);
                            System.out.println("输入0退出系统！");
                            Scanner b= new Scanner(System.in);
                            int e=b.nextInt();
                            if (e==0){
                                break;
                            }
                        }
                    }
                    if(m==2){
                        while (true){
                            userAction.returnbook(v);
                            System.out.println("输入0退出系统！");
                            Scanner b= new Scanner(System.in);
                            int e=b.nextInt();
                            if (e==0){
                                break;
                            }
                        }

                    }
                }
                if (c==0){
                    break;
                }
            }
            if(x==2){

                Enter.adminlogin();
                while (true){

                    System.out.println("输入1增添书籍,输入2查看在馆书籍,输入0退出系统！");
                    Scanner b= new Scanner(System.in);
                    int e=b.nextInt();
                    if (e==0){
                        break;
                    }
                    if(e==1) {
                        AdminAction.add();
                    }
                    if(e==2){
                        bookOperate.output(bookOperate.showBook());
                    }
                }

            }
            if(x==0){
                break;
            }

        }
    }
}
