package question57;


import java.util.Scanner;

public class SubQuestion {
    public static void printContinuousSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int left = 1;
        int right = 2;
        int curSum = 3;//当前序列累加值
        while (left < (sum +1)/2) {
            if (curSum == sum) {
                for (int i = left; i <= right; i++) {
                    System.out.print(i + " ");
                }
                System.out.println("");
                right ++;
                curSum = curSum + right;
            }
            if (curSum > sum) {
                curSum -= left ;
                left ++ ;
            }
            if (curSum < sum) {
                right ++;
                curSum += right;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("input the sum s:");
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        printContinuousSequence(s);
    }
}
