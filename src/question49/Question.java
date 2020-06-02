package question49;

import java.util.Scanner;

public class Question {
    //因为丑数只含2,3,5三个因子，因此，所有的丑数都是通过小的丑数乘若干个因子(2,3,5)组成的。
    //可以申请一个数组，存放从小到大的丑数，这样可以通过前面的丑数通过乘2,3,5获得到新的丑数
    //问题是要保证丑数序列是从小到大的，因此。假定当前最大丑数是M。
    //则一定存在在M前的丑数乘一个2得到M2刚好大于M，同样也要这样的M3,M5
    //从M2.M3.M5中选取最小的就是下一个丑数。
    //而每一步找M2,M3,M5没必要从0开始，一定是从上一次用于乘因数的T2,T3,T5往后遍历。
    public static int getUglyNumberByIndex (int index) {
        if (index <= 0) {
            System.out.println("the index is error");
            return 0;
        }
        int[] uglyNumbers =new int[index];
        uglyNumbers[0] = 1; //第一个丑数默认为1；
        int t2 =0;
        int t3 =0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            int min = Math.min(Math.min(uglyNumbers[t2]*2,uglyNumbers[t3]*3),uglyNumbers[t5]*5);//获得下一个丑数
            uglyNumbers[i] = min ;
            while (uglyNumbers[t2]*2 <= uglyNumbers[i])
                t2++;
            while (uglyNumbers[t3]*3 <= uglyNumbers[i])
                t3++;
            while (uglyNumbers[t5]*5 <= uglyNumbers[i])
                t5++;
        }
        return uglyNumbers[index-1];
    }
    public static void main (String[] args) {
        System.out.println("input the index of the ugly number order");
        Scanner scan =new Scanner(System.in);
        int index = 0;
        if (scan.hasNextInt()) {
            index = scan.nextInt();
        }
        System.out.println("the ugly number is"+getUglyNumberByIndex(index));
    }
}
