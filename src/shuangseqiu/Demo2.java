package shuangseqiu;

import java.util.Random;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            Random r = new Random();

            tongjics(sc, r);//双色球中奖次数统计

            //

            System.out.println("y/n?");
            String c1 = "y";
            if (!sc.next().equals(c1)) {
                break;
            }
        }
    }

    //统计中奖次数
    public static void tongjics(Scanner sc, Random r) {
        int sum;
        System.out.println("输入抽奖的次数");
        int num = sc.nextInt();
        int[] arr = tongji(r, num);
        int[] arr1 = number(r);
        System.out.println("========================");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf(arr1[i] + " ");
        }
        System.out.println("\n一等奖500w 二等奖20w 三等奖3000 四等奖200 五等奖10 六等奖5");
        System.out.println("========================");

        System.out.println("中奖等级1-6的次数依次为");
        System.out.println(arr[5] + "\t" + arr[4] + "\t" + arr[3] + "\t" + arr[2] + "\t" + arr[1] + "\t" + arr[0]);
        sum = arr[5] * 5000000 + arr[4] * 200000 + arr[3] * 3000 + arr[2] * 200 + arr[1] * 10 + arr[0] * 5;
        int zhichu = num * 2;
        int zhuanqu = sum - zhichu;
        System.out.println("中奖" + sum + "元" + " " + "支出" + zhichu + "元" + " " + "赚了" + zhuanqu + "元");

    }

    //统计几等奖中了几次
    public static int[] tongji(Random r, int num) {
        int[] arr = new int[6];
        for (int i = 0; i < num; i++) {

            int[] newarr = panduan(number(r), usernumber(r));
            if (newarr[0] == 6 && newarr[1] == 1) {
                arr[5]++;

            } else if (newarr[0] <= 2 && newarr[1] == 1) {
                arr[0]++;

            } else if (newarr[0] + newarr[1] == 4) {
                arr[1]++;

            } else if (newarr[0] + newarr[1] == 5) {
                arr[2]++;

            } else if (newarr[0] == 5 && newarr[1] == 1) {
                arr[3]++;

            } else if (newarr[0] == 6 && newarr[1] == 0) {
                arr[4]++;

            }

        }
        return arr;
    }

    //中奖号码生成
    public static int[] number(Random r) {
        int[] arr = new int[7];
        for (int i = 0; i < arr.length - 1; i++) {
            while (true) {
                int rednumber = r.nextInt(33) + 1;
                boolean flag = chongfu(arr, rednumber);
                if (!flag) {
                    arr[i] = rednumber;
                    break;
                }
            }
        }
        arr[6] = r.nextInt(16) + 1;

        return arr;
    }

    //用户输入号码
    public static int[] usernumber(Random r) {
        return number(r);
    }

    //判断用户是否中奖
    public static int[] panduan(int[] arr, int[] userarr) {
        int[] newarr = {0, 0};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < userarr.length - 1; j++) {
                if (arr[i] == userarr[j]) {
                    newarr[0]++;
                    break;
                }
            }
        }
        if (arr[6] == userarr[6]) {
            newarr[1]++;
        }
        return newarr;
    }

    //判断红球号码的重复性
    public static boolean chongfu(int[] arr, int number) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }
}
