package question46;
import java.util.Scanner;
public class Question {
    //动态规划问题，一个数的几种翻译数目，跟后面一位或者两位开始翻译的数目的个数相关
    //用f(i)代表从第i位开始的翻译数目的话，那么f(i)=f(i-1)+g(i,i-1)*f(i-2);g(i,i-1)只有在i和i-1位上组合出10到25这数字时候取1，
    //则因为递归有不必要的计算，所以可以从右到左，将值保存在数组中，进行边保存，边计算。
    public static int getTranslationCount(int n) {
        if (n < 0) {
            System.out.println("the  input  n is error");
            return 0;
        }
        char[] str = String.valueOf(n).toCharArray();
        return getTranslationCountCore(str);
    }
    public static int getTranslationCountCore(char[] str) {
        int[] counts = new int[str.length];//用于保存每一位数最多有多少种可能翻译数目。
        for (int i = str.length -1;i >= 0;i--) {
            int count = 0; //存储每一次循环位数的数目。
            if (i < str.length-1)//不是第一个。
                count = count +counts[i+1];//对应f(i+1)
            else
                count =1;//如果是最右边开始的第一位，则只有一种翻译。
            if (i < str.length-1) {
                int digit1 = str[i] -'0';
                int digit2 = str[i+1] - '0';
                int number = digit1 *10 + digit2;
                if (number > 9 && number < 26) {//说明在 10 到25之间，g(i)取1
                    if (i < str.length-2) {//只有在超过2位数时，f(i+2)才有值。
                        count = count + counts[i+2];
                    }
                    else
                        count += 1;//f(i+2)没有值的时候，只有一种翻译。
                }
            }
            counts[i] =count; //f(i)=f(i+1)+g(i,i+1)*f(i+2);
        }
        return  counts[0];
    }
    public static void main (String[] args) {
        System.out.println("input a number:");
        Scanner scan=new Scanner(System.in);
        int n=-1;
        if (scan.hasNextInt()) {
            n = scan.nextInt();
        }
        System.out.println("the count of the translation is"+getTranslationCount(n));
    }
}
