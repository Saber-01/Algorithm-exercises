package question15;
import  java.util.Scanner;
public class QuestionSub1 {
    public static boolean isPowerof2(int n){
        int result=n&(n-1);//去掉n中最右边的1；如果它是2的次方，那这个数的二进制肯定只有一个1;
        if(result==0){
            return true;//如果变为0了，说明是2的次方。
        }
        else return false;
    }
    public static void main(String[] args){
        System.out.print("输入一个整数，判断其是否是2的整数次方");
        Scanner scan=new Scanner(System.in);
        int n=0;
        if(scan.hasNextInt()){
            n=scan.nextInt();
        }
        if(isPowerof2(n)){
            System.out.print("该数是2的次方");
        }
        else
            System.out.print("该数不是2的次方");
    }
}
