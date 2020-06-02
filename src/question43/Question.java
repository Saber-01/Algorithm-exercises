package question43;

import java.util.Scanner;

public class Question {
    public static int NumberOf1Between1fromN(int n) {
        if (n <= 0) {
            System.out.println("n is a error input");
            return 0;
        }
        char[] number= String.valueOf(n).toCharArray();
        return NumberOf1(number);
    }

    public static int NumberOf1 (char[] number) {
        if (number == null || number.length == 0 )
            return 0;
        int firstDigit = number[0] - '0';//取得首位字
        int length =number.length;//位数
        if (firstDigit == 0 && length == 1) {//递归结束条件
            return 0;
        }
        if (firstDigit > 0 && length == 1) {//递归结束条件
            return  1;
        }
        //递归开始。假设 数为21345. 分为2段， 1到1345 和 1346到21345，
        int numberOf1 = 0;//用于返回
        int numberOf1Sub = 0; //存储 1到1345的1的出现次数
        int numberOf1FistDigit = 0; //存储1346到21345中最高位出现1的次数。
        int numberOf1OtherDigit = 0;//存储1346到21345中其他位数出现1的次数。
        if (firstDigit == 1) { //如果首位为1，且位数还大于1.例如：11345中最高位是1，1346到11345最高位其实中出现在10000到11345的1346个数中。
            numberOf1FistDigit = Integer.parseInt(String.valueOf(number).substring(1))+1;
        }
        else if (firstDigit > 1) {//如果大于1，位数不止一位，例如，21345,最高位是2,1345到21345最高位出现了10000到19999 一共10000个
            numberOf1FistDigit = (int)Math.pow(10,length-1);
        }
        numberOf1OtherDigit = firstDigit*(length-1)*(int)Math.pow(10,length-2); //1345到21345其他位数，因为可分次1346到11345,11346到21345,两段，2*4*10^3；
        numberOf1Sub = NumberOf1(String.valueOf(number).substring(1).toCharArray());
        return  numberOf1FistDigit+numberOf1Sub+numberOf1OtherDigit;
    }

    public static void main(String[] args) {
        System.out.println("input n");
        Scanner scan = new Scanner(System.in);
        int n = 0;
        if (scan.hasNextInt()) {
            n = scan.nextInt();
        } else {
            System.out.println("n is error");
            return;
        }
        System.out.println("the number of 1 between 1from n is:" + NumberOf1Between1fromN(n));
    }
}
