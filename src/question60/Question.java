package question60;

import java.util.Scanner;

public class Question {
    //分析问题，从number=1开始，和有6中可能，组合情况只有6种，和是1到6的出现情况都是1种，概率为1/6；
    //当有n个骰子，和就有n到6n种可能。且一共有组合情况6^n,所以要判断每个和分别有几种组合情况。才能求出概率。
    //因为加一个骰子，和的情况会多6种，且之前n-1个骰子的和情况数会有变化，因为一个骰子面值从1到6.我们可以进行推算。
    //设f(s,n)表示和为s，骰子为n个时情况总数。则可知
    //f(s,n) = f(s-1,n-1) +f (s-2,n-1)+f(s-3,n-1)+f(s-4,n-1)+f(s-5,n-1);
    //所以我们可以循环，从n=1开始，大循环每次加一个骰子，在大循环中，要保存加个骰子以后每个s出现的情况，方便下次循环计算。
    //我们需要一个数组保存n-1个骰子时，每个和s的情况个数，即数组角标代表了和s,存储值表示情况个数。
    //每一个大循环中 小循环为设置n个骰子时每个可能s的出现的情况数，
    //为了避免小循环过程出现反复计算情况，每一次大循环需要更换1个数组保存当前n个骰子的情况，并且上一个保存n-1的数组要清空。
    public static void printProbability(int number) {
        if (number < 0) {
            System.out.println("the input number is error");
            return;
        }
        int[][] probabilities = new int[2][number*6+1];//为了保证角标都是和S对应，所以+1；
        int flag = 0 ;//从第一个数组开始存储。标识数组
        probabilities [1-flag][0] = 1;
        for (int n = 1; n <= number; n++) {//大循环
            probabilities[flag][n-1] = 0; //多了一个骰子，所以上一个和最小值不可能出现，所以设为0；
            for (int s = n; s <= n*6; s++) {//从n个骰子可能出现的最小值n到最大值n*6进行赋值。
                int sum = 0;
                for (int i = 1; i <= 6 && i <= s; i++) { //f(s,n)=f(s-1,n)+...+f(s-6,n),但是注意其中s-1到s-6大于0，数组才不会越界。
                    sum += probabilities[1-flag][s-i];
                }
                probabilities[flag][s] = sum;
            }
            flag = 1 - flag;
        }
        double total = Math.pow(6,number);
        for (int i = number; i <= number*6; i++) {
            double ratio = probabilities[1-flag][i]/total;
            System.out.println("sum: "+ i+" ratio: "+ratio);
        }
    }
    public static void main (String[] args) {
        System.out.println("input the number of dice:");
        Scanner scan = new Scanner(System.in);
        int number = 0;
        if (scan.hasNextInt())
            number = scan.nextInt();
        printProbability(number);
    }
}
