//2024年5月5日
//希尔排序


package paixu;

import java.util.Arrays;
import java.util.Random;


public class xier {
    public static void main(String[] args) {
        long statime = System.currentTimeMillis();
        Random r = new Random();
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10);
        }
        shuchu(paixu(arr));
        long endtime = System.currentTimeMillis();
        System.out.println("\n用时" + (endtime - statime) + "ms");
    }

    public static int[] paixu(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //二分
            for (int i = gap; i < arr.length; i++) {
                //
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        return arr;
    }

    public static void shuchu(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
