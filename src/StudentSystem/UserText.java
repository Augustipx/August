package StudentSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserText {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        menu(list, sc);
    }

    public static void menu(ArrayList<User> list, Scanner sc) {
        ArrayList<User> list1 = new ArrayList<>();
        while (true) {
            User u = new User();
            System.out.println("==================================================");
            System.out.println("欢迎来到ikun学生管理系统登录界面");
            System.out.println("      请选择操作\n1注册\t2登录\t3忘记密码");
            System.out.println("==================================================");
            switch (sc.next()) {
                case "1":
                    u = userRegister(list, sc, u);
                    u = pwdregister(list, sc, u);
                    u = IDcardvalidat(list, sc, u);
                    u = Phonenumber(list, sc, u);
                    list.add(u);
                    break;
                case "2":
                    Login(list, sc);
                    break;
                case "3":
                    forget(list, sc);
                    break;
                default:
            }
            System.out.println("y/n?");
            String str = sc.next();
            if (str.equals("n")) {
                break;
            }
        }
    }

    //用户注册**********

    //用户名输入
    public static User userRegister(ArrayList<User> list, Scanner sc, User u) {
        System.out.println("请输入用户名");
        while (true) {
            String str = sc.next();
            boolean flag = usernumber(str);
            if (flag) {
                if (list.size() == 0) {
                    u.setUsername(str);
                    return u;
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        if (!str.equals(list.get(i).getUsername())) {
                            u.setUsername(str);
                            return u;
                        } else if (i == list.size() - 1) {
                            System.out.println("ID重复请重新输入");
                        }
                    }
                }
            } else {
                System.out.println("输入有误请重新输入");
            }
        }
    }

    //密码输入
    public static User pwdregister(ArrayList<User> list, Scanner sc, User u) {
        while (true) {
            System.out.println("请输入密码");
            String pwd1 = sc.next();
            System.out.println("请再次输入密码");
            String pwd2 = sc.next();
            if (pwd1.equals(pwd2)) {
                u.setPassword(pwd1);
                break;
            } else {
                System.out.println("两次输入不一致，重新输入");
            }
        }
        return u;
    }

    //身份证号码输入
    public static User IDcardvalidat(ArrayList<User> list, Scanner sc, User u) {
        while (true) {
            System.out.println("请输入身份证号码");
            String IDcard = sc.next();
            boolean falg = IDcardnumber(IDcard);
            if (falg) {
                u.setIdcard(IDcard);
                break;
            } else {
                System.out.println("输入有误请重新输入");
            }
        }
        return u;
    }

    //手机号输入
    public static User Phonenumber(ArrayList<User> list, Scanner sc, User u) {
        while (true) {
            System.out.println("请输入手机号");
            String phonenumber = sc.next();
            boolean flag = phonenumber(phonenumber);
            if (flag) {
                u.setPhonenumber(phonenumber);
                break;
            } else {
                System.out.println("输入有误请重新输入");
            }
        }
        return u;
    }


    //用户登录*********

    //输入用户名密码和验证码
    public static void Login(ArrayList<User> list, Scanner sc) {

        for (int i = 0; i < 3; ) {
            System.out.println("请输入用户名");
            String username = sc.next();
            for (int j = 0; j < list.size(); j++) {
                if (username.equals(list.get(j).getUsername())) {
                    System.out.println("请输入密码");
                    String pwd = sc.next();
                    while (true) {
                        String vcodenum = vcode();
                        System.out.println("请输入验证码" + vcodenum);
                        String vcode = sc.next();
                        if (vcode.equalsIgnoreCase(vcodenum)) {
                            if (username.equals(list.get(j).getUsername()) && pwd.equals(list.get(j).getPassword())) {
                                System.out.println("登入成功");
                                studentText ss = new studentText();
                                studentText.Startstudentsysytem();
                                return;
                            } else {
                                i++;
                                System.out.println("账号或密码输入错误\n您还有" + (3 - i) + "次机会");
                                break;
                            }
                        } else {
                            System.out.println("验证码输入错误请重新输入");
                        }
                    }
                }
                if (j == list.size() - 1 && !username.equals(list.get(j).getUsername())) {
                    System.out.println("用户未注册,请先注册");
                }
            }
        }
    }

    //忘记密码**********
    public static void forget(ArrayList<User> list, Scanner sc) {
        System.out.println("请输入用户名");
        String username = sc.next();
        for (int i = 0; i < list.size(); i++) {
            if (!username.equals(list.get(i).getUsername())) {
                System.out.println("用户名未注册，请先注册");
                return;
            } else {
                for (int j = 0; j < 3; ) {
                    System.out.println("请输入身份证id");
                    String IDcard = null;
                    while (true) {
                        IDcard = sc.next();
                        boolean flag = IDcardnumber(IDcard);
                        if (flag) {
                            break;
                        } else {
                            System.out.println("身份证格式错误，请重新输入");
                        }
                    }
                    System.out.println("请输入手机号码");
                    String phonenumber = null;
                    while (true) {
                        phonenumber = sc.next();
                        boolean flag = phonenumber(phonenumber);
                        if (flag) {
                            break;
                        } else {
                            System.out.println("手机号格式错误，请重新输入");
                        }
                    }
                    if (IDcard.equals(list.get(i).getIdcard()) && phonenumber.equals(list.get(i).getPhonenumber())) {
                        System.out.println("请输入新的密码");
                        list.get(i).setPassword(sc.next());
                        System.out.println("修改成功！");
                        return;
                    } else {
                        j++;
                        System.out.println("账号信息不匹配，修改失败\n您还有" + (3 - i) + "次机会");
                    }
                }
            }
        }
    }

    //随机验证码生成
    public static String vcode() {
        Random r = new Random();
        String[] arr = new String[5];
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            char c = (char) (r.nextInt(26) + 65);
            char d = (char) (r.nextInt(26) + 97);
            str += c + String.valueOf(d);
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = String.valueOf(r.nextInt(10));
            } else {
                arr[i] = String.valueOf(str.charAt(i));
            }
        }
        int[] arrnum = new int[5];
        for (int i = 0; i < arrnum.length; i++) {
            int num = r.nextInt(5);
            while (true) {
                boolean flag = chongfu(num, arrnum, i);
                if (flag) {
                    num = r.nextInt(5);
                } else {
                    arrnum[i] = num;
                    break;
                }
            }
        }
        String vcode = "";
        for (int i = 0; i < arr.length; i++) {
            vcode += arr[arrnum[i]];
        }
        return vcode;
    }

    //随机数不重复
    public static boolean chongfu(int num, int[] arr, int j) {
        for (int i = 0; i < j; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    //判断username输入是否符合条件
    public static boolean usernumber(String str) {
        if (str.length() >= 3 && str.length() <= 15) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if ((c >= 65 && c <= 90) || (c >= 97 & c <= 122)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    //判断IDcard输入是否符合条件
    public static boolean IDcardnumber(String IDcard) {
        if (IDcard.length() == 18 && IDcard.charAt(0) - '0' != 48) {
            for (int i = 0; i < IDcard.length() - 1; i++) {
                char c = IDcard.charAt(i);
                if (c > 57 || c < 48) {
                    return false;
                }
            }
            char cha = IDcard.charAt(IDcard.length() - 1);
            return (cha == 'X' || cha == 'x') || (cha >= 48 && cha <= 57);
        }
        return false;
    }

    //判断输入手机号是否符合条件
    public static boolean phonenumber(String str) {
        if (str.length() == 11 && str.charAt(0) != '0') {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c > 57 || c < 48) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}