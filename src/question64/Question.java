package question64;

import java.util.Scanner;

public class Question {
    //不能用循环，所以只能用递归，
    //递归终止条件不能用if等判别。那么可以用&&
    //因为&&只有在前方条件满足时，才会运行后面条件。
    public static  int Sum_Solution(int n) {
        int sum = n ;
        boolean b = (n > 1) && (sum += Sum_Solution(n - 1)) > 0;
        return  sum;
    }
    public static void main(String[] args) {
        System.out.println("input the n");
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        System.out.println(Sum_Solution(n));
    }
}
