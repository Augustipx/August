//2024年5月3日
//打乱数组生成随机数

package shuijishu;

import java.util.Random;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("请输入生成随机数的个数");
        int num1=sc.nextInt();
        bianli(shuijishu(sc, r),num1);
    }
    public static int[] shuijishu(Scanner sc, Random r) {
        System.out.println("请输入生成随机数范围的最小值");
        int min = sc.nextInt();
        System.out.println("请输入生成随机数范围的最大值");
        int max = sc.nextInt();
        int[] arr=new int[max-min+1];
        for (int i = 0, j = min; i < arr.length && j <= max; i++, j++) {
            arr[i] = j;
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int num = r.nextInt(arr.length);
            arr[i] = arr[num];
            arr[num] = temp;
        }
        return arr;
    }

    public static void bianli(int[] arr,int num) {
        for (int i = 0; i < num; i++) {
            if (i%10==0){
                System.out.println();
            }
            System.out.print(arr[i]+" ");
        }
    }
}
