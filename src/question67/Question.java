package question67;

import java.util.Scanner;

public class Question {
    static boolean isLegal = true;
    public static int strToInt(String str) {
        if (str == null) {
            System.out.println("the input str is null");
            return 0;
        }
        if (str.trim().length() == 0)
            return 0;
        long result = 0;
        char[] chars = str.toCharArray();
        int curPoint = 0;
        int sign = 1;//初始为正。、
        if (chars[curPoint] == '+' || chars[curPoint] == '-') {
            if (chars[curPoint] == '-')
                sign = 0;//代表负数
            curPoint ++ ;
        }
        while (curPoint < chars.length) {
            if (chars[curPoint] < '0' || chars[curPoint] > '9') {
                isLegal = false;
                return 0;
            }
                result = result * 10 + (chars[curPoint] - '0');
            if (sign == 1 && result > Integer.MAX_VALUE || sign == 0 && result < Integer.MIN_VALUE) {
                    System.out.println("the value is out of the max value of integer");
                    return 0;
            }
            curPoint++;
        }
        return sign == 1?(int)result : (int)(-result);
    }
    public static void main(String[] args) {
        System.out.println("input the string");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        long  a =-2147483648 ;
        a--;
        System.out.println("the result int is :" +strToInt(str)+" "+Integer.MIN_VALUE+" "+Integer.MAX_VALUE);
    }
}
