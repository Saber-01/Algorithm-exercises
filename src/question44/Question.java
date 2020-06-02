package question44;

import java.util.Scanner;

public class Question {
    public static int digitAtIndex (int n) {
        if (n < 0) {
            System.out.println(" n is error input ");
            return 0;
        }
        int digit = 1; //位数从1开始
        while (1 == 1) {
            if (n < countOfIntegers(digit)*digit) {
                return numberAtIndex(n,digit);
            }
            n -= countOfIntegers(digit)*digit;
            digit++;
        }
    }
    public static  int numberAtIndex (int n,int digit) { //计算出在M位数序列中的第n个位置的值。
        int number;
        if(digit ==1 )
            number = 0 +n/digit;//只有1位数，直接从0开始计算，因为10的0次方等于1 会导致错误。
         else
             number = (int)Math.pow(10,digit-1) +n/digit;//计算第N个位置是在哪个M位数上。
        int rightPoint = digit - n%digit; //记录从右边数，需要数多少位才能到N位置。
        for(int i = 1; i < rightPoint; i++) {//因为第0 位也包括，所以从右到左要少数以为，所以从1开始。
            number=number/10;
        }
        return number%10;
    }
    public static int countOfIntegers(int digits) { //计算M位数一共有多少个数。
        if (digits == 1)
            return  10;
        int count = 0;
        if (digits > 1) {
            count = (int)Math.pow(10,digits-1)*9;
        }
        return count;
    }
    public static void main (String[] args) {
        System.out.println("input n");
        Scanner scan = new Scanner(System.in);
        int n = 0;
        if (scan.hasNextInt()) {
            n = scan.nextInt();
        } else {
            System.out.println("n is error");
            return;
        }
        System.out.println("数字序列中第N位为：(从第0位开始计算)" + digitAtIndex(n));

    }
}
