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
            System.out.println("************��ӭ����ͼ�����ϵͳ************"+"\n");
            System.out.println("             1.���ߵ�¼   ");
            System.out.println("             2.����Ա��¼   ");
            System.out.println("��ѡ���¼�û�,����0�˳�:");
            int x;
            Scanner in = new Scanner(System.in);
            x= in.nextInt();
            if(x==1) {
                System.out.println("���û�������1��¼,���û�2��ע��,����0�˳�ϵͳ:");
                int c;
                Scanner ii = new Scanner(System.in);
                c = ii.nextInt();
                if (c == 1) {
                    String n = Enter.userlogin();
                    System.out.println("��ѡ�����Ĳ���:");
                    System.out.println("1.����");
                    System.out.println("2.����");
                    int m;
                    m = ii.nextInt();
                    if (m == 1) {
                        while (true) {
                            userAction.lendBook(n);
                            System.out.println("����0�˳�ϵͳ��");
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
                            System.out.println("����0�˳�ϵͳ��");
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
                    System.out.println("��ѡ�����Ĳ���:");
                    System.out.println("1.����");
                    System.out.println("2.����");
                    int m;
                    m = ii.nextInt();
                    if(m==1){
                        while (true){
                            userAction.lendBook(v);
                            System.out.println("����0�˳�ϵͳ��");
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
                            System.out.println("����0�˳�ϵͳ��");
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

                    System.out.println("����1�����鼮,����2�鿴�ڹ��鼮,����0�˳�ϵͳ��");
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
