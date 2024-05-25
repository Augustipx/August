package StudentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class studentText {
    public static void Startstudentsysytem() {
        Student stu = new Student();
        ArrayList<Student> list = new ArrayList<>();
        Menu(stu, list);
    }

    //菜单
    public static void Menu(Student stu, ArrayList<Student> list) {
        ArrayList<Student> list1 = new ArrayList<>();
        loop:
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("==================================");
            System.out.println("欢迎来到ikun学生管理系统");
            System.out.println("1,添加学生");
            System.out.println("2,删除学生");
            System.out.println("3,修改学生");
            System.out.println("4,查询学生");
            System.out.println("5,退出");
            System.out.println("====================================");

            System.out.println("请输入你的选择:");
            switch (sc.next()) {
                case "1":
                    list = Addstudent(list, stu);
                    list1 = list;
                    break;
                case "2":
                    Deletestudent(list1, stu);
                    break;
                case "3":
                    Changestudent(list1, stu);
                    break;
                case "4":
                    Chaxunstudent(list1);
                    break;
                case "5":
                    break loop;
                default:
                    System.out.println("您输入有误");
            }
        }
    }

    //添加学生
    public static ArrayList<Student> Addstudent(ArrayList<Student> list, Student stu) {
        Scanner sc = new Scanner(System.in);
        stu = new Student();
        System.out.println("请输入学生id");
        String id = sc.next();
        idshuru(list, id, stu);
        return list;
    }

    //通过id删除学生
    public static void Deletestudent(ArrayList<Student> list, Student stu) {
        Scanner sc = new Scanner(System.in);
        if (list.size() == 0) {
            System.out.println("当前没有数据，请添加后操作");
            return;
        }
        System.out.println("请输入学生ID");
        String id = sc.next();
        boolean flag = repeat(list, id);
        if (flag) {
            for (int i = 0; i < list.size(); i++) {
                if (id.equals(list.get(i).getId())) {
                    list.remove(list.get(i));
                }
            }
            System.out.println("删除成功");
        } else {
            System.out.println("ID不存在删除失败!");
        }
    }

    //修改学生信息
    public static void Changestudent(ArrayList<Student> list, Student stu) {
        if (list.size() == 0) {
            System.out.println("当前没有数据，请添加后操作");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的id");
        String id = sc.next();
        while (true) {
            boolean flag = repeat(list, id);
            if (flag) {
                for (int i = 0; i < list.size(); i++) {
                    if (id.equals(list.get(i).getId())) {
                        list.remove(list.get(i));
                        break;
                    }
                }
                System.out.println("请重新输入该学生的信息");
                System.out.println("学生id");
                String id1 = sc.next();
                idshuru(list, id1, stu);
                break;
            } else {
                System.out.println("id不存在");
                break;
            }
        }

    }

    //查询学生信息
    public static void Chaxunstudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前没有数据，请添加后操作");
            return;
        }
        System.out.println("ID\t姓名\t年龄\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getADD() + "\t");

        }
    }

    //判断ID是否存在
    public static boolean repeat(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    //输入学生信息
    public static void idshuru(ArrayList<Student> list, String id, Student stu) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            boolean flag1 = repeat(list, id);
            if (flag1) {
                System.out.println("ID重复请重新输入！");
                id = sc.next();
            } else {
                stu.setId(id);
                break;
            }
        }
        System.out.println("请输入学生姓名");
        stu.setName(sc.next());
        System.out.println("请输入学生年龄");
        stu.setAge(sc.next());
        System.out.println("请输入学生家庭住址");
        stu.setADD(sc.next());
        list.add(stu);
    }
}

