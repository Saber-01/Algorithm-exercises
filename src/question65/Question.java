package question65;

import java.util.Scanner;

public class Question {
    public static int Add(int a, int b) {
        int  carry = 1;
        int result = 0;
        while (carry != 0) {
            result = a ^ b;//这一步会将各个二进制位上的计算好。0+0=0；1+0=0+1=1；1+1=0；
            carry = (a & b) <<1; //这一步会计算出各个位置相加是否进位，因为只有1+1 才会进位。因为是进位，所以要左移才是正确值。
            a = result;
            b = carry;
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println("input the a ");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("input the b ");
        int b = scan.nextInt();
        System.out.println("the result of a+b is " + Add(a, b));
    }
}
