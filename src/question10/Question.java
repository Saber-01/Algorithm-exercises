package question10;

import java.util.Scanner;

public class Question {
    public static int recursion(int n){
        if(n==0){
            return  0;
        }
        if(n==1){
            return 1;
        }
        else{
            return recursion(n-2)+recursion(n-1);
        }
    }
    public static int loop(int n){
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return  1;
        }
        else{
            int a=0,b=1,result=0;
            for(int i=1;i<n;i++){
                result=a+b;
                a=b;
                b=result;
            }
            return result;
        }
    }
    public static void main(String[] args){
        System.out.print("输入N，输出为斐波那列数列的第N项");
        Scanner input =new Scanner(System.in);
        int n=-1;
        if(input.hasNextInt()){
            n =input.nextInt();
        }
        if(n==-1){//输入了无效的N
            System.out.print("输入的N无效");
        }
        else
        {
            int a=recursion(n);
            System.out.print("递归求出的第"+n+"项的斐波那列数为："+a);
            int b=loop(n);
            System.out.print("循环求出的第"+n+"项的斐波那列数为："+b);
        }
    }
}
