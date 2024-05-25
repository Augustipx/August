//2024年5月3日
//判断重复性生成随机数


package shuijishu;

import java.util.Random;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        bianli(shuijishu(r, sc));
    }

    public static int[] shuijishu(Random r, Scanner sc) {
        System.out.println("输入生成的个数");
        int num = sc.nextInt();
        int[] arr = new int[num];
        System.out.println("请输入生成随机数范围的,最小值");
        int min = sc.nextInt();
        System.out.println("请输入生成随机数范围的,最大值");
        int max = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(max - min + 1) + min;
            while (true) {
                if (panduan(arr, i)) {
                    arr[i] = r.nextInt(max - min + 1) + min;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    public static boolean panduan(int[] arr, int j) {
        for (int i = 0; i < j; i++) {
            if (arr[i] == arr[j]) {
                return true;
            }
        }
        return false;
    }

    public static void bianli(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
