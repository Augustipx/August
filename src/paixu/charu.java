//2024年5月5日
//插入排序算法


package paixu;

import java.util.Arrays;
import java.util.Random;

public class charu {
    public static void main(String[] args) {
        long statime = System.currentTimeMillis();

        Random r = new Random();
        paixu(r);

        long endtime = System.currentTimeMillis();
        System.out.println("\n用时" + (endtime - statime) + "ms");

    }

    public static void paixu(Random r) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(1000);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
