package shuangseqiu;
//抽奖判断

import java.util.Random;
import java.util.Scanner;

public class shuangseqiu {
    public static void main(String[] args) {
        //中奖号码预览
        int[] number = haomasc();
        System.out.println("=====================");
        for (int i = 0; i < number.length; i++) {
            System.out.printf(number[i] + " ");
        }
        System.out.println("\n=====================");
        //用户输入
        int[] user = usershuru();
        //中奖判断
        int newarr[] = zhongjiangpd(number, user);
        //判断中几等奖
        zhongjiangdengji(newarr);
    }

    //中奖号码生成
    //6个红球1个蓝球
    public static int[] haomasc() {

        int[] arr = new int[7];
        Random r = new Random();
        for (int i = 0; i < 6; ) {
            int rednumber = r.nextInt(33) + 1;
            if (chachongfu(arr, rednumber)) {
            } else {
                arr[i] = rednumber;
                i++;
            }
        }
        //蓝球
        int bulenumber = r.nextInt(16) + 1;
        arr[6] = bulenumber;
        return arr;
    }

    //用户输入号码
    public static int[] usershuru() {
        Scanner sc = new Scanner(System.in);

        int userarr[] = new int[7];
        for (int i = 0; i < userarr.length - 1; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码");
            int rednumber = sc.nextInt();


            if (rednumber >= 1 && rednumber <= 33) {
                if (!chachongfu(userarr, rednumber)) {

                    //不存在
                    userarr[i] = rednumber;
                    i++;
                } else {
                    //存在
                    System.out.println("第" + (i + 1) + "个输入重复，请重新输入");
                }
            } else {
                System.out.printf("红球号码超出范围");
            }
        }

        //用户输入蓝球号码
        while (true) {
            System.out.println("请输入蓝球号码");
            int bulenumber = sc.nextInt();

            if (bulenumber >= 1 && bulenumber <= 16) {
                userarr[userarr.length - 1] = bulenumber;
                break;
            } else {
                System.out.printf("输入超出范围请重新输入");
            }


        }
        return userarr;
    }

    //判断用户是否中奖
    public static int[] zhongjiangpd(int[] arr1, int[] arr2) {
        int[] newarr = {0, 0};
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = 0; j < arr2.length - 1; j++) {
                if (arr1[i] == arr2[j]) {
                    newarr[0]++;
                    break;
                }
            }
        }
        if (arr1[arr1.length - 1] == arr2[arr2.length - 1]) {
            newarr[1] += 1;
        }
        return newarr;
    }

    //重复查询
    public static boolean chachongfu(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }

    //中奖判断
    public static void zhongjiangdengji(int newarr[]) {
        switch (newarr[0] + newarr[1]) {
            case 1:
                if (newarr[1] == 1) {
                    System.out.println("恭喜中六等奖5元");
                    break;
                } else System.out.println("很遗憾没中奖，谢谢参与");
                break;
            case 2:
            case 3:
                System.out.println("恭喜中六等奖5元");
                break;
            case 4:
                System.out.println("恭喜中五等奖10元");
                break;
            case 5:
                System.out.println("恭喜中四等奖200元");
                break;
            case 6:
                if (newarr[0] == 5) {
                    System.out.println("恭喜中三等奖3000元");
                } else System.out.println("恭喜中二等奖500万元");
                break;
            case 7:
                System.out.println("恭喜中一等奖1000万元");
                break;
            default:
                System.out.println("很遗憾没中奖，谢谢参与");
                break;
        }
    }
}



