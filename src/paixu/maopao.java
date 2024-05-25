//2024年5月5日
//冒泡排序算法


package paixu;

import java.util.Arrays;
import java.util.Random;

public class maopao {
    public static void main(String[] args) {
        long statime = System.currentTimeMillis();
        Random r=new Random();
        paixu(r);
        long endtime = System.currentTimeMillis();
        System.out.println("\n用时" + (endtime - statime) + "ms");
    }
    public static void paixu(Random r){


        int[] arr=new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=r.nextInt(10000);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i]<arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
