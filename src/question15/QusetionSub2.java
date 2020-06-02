package question15;

import java.util.Scanner;

public class QusetionSub2 {
    public static int changeToN_countDigit(int m,int n){
        //先做异或处理，不同为1，相同为0；
        int result=m^n;
        //数一数异或后几个1就知道有几个位数是要改变的了
        int count=0;
        while(result!=0){//直到计算完全部的1，即就是所有1都变为0，结果就是0
            count++;
            result=result&(result-1);//将最右边的1变为0，即找到一个1后，改变为0，不重复计算。
        }
        return count;
    }
    public static void main(String[] args){
        System.out.print("输入2个数，m和n,逗号隔开，输出为改变m中二进制多少位才能变成n");
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        String[] strArray=str.trim().split(",");
        int m=Integer.parseInt(strArray[0]);
        int n=Integer.parseInt(strArray[1]);
        System.out.print("需要改变的位数有"+changeToN_countDigit(m,n));
    }
}
