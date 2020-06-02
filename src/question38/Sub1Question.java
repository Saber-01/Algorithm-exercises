package question38;//求组合，

import java.util.Scanner;

public class Sub1Question {
    //N个数字可以组成含有1到n的数字的 组合。
    //在求n个字符中含m个字符的组合有多少种情况时，我们可以分成2个部分
    //第一个字符和其他字符。第一个字符假定为c，第二部分为剩下的m-1个字符。而m字符的组合中，只有两种情况
    //第一种就是含有这个字符c的组合，第二种就是不含有这个c的组合。
    //即问题变为求含有c之后，剩下n-1中选出m-1个组合，和不含C，在剩下n-1个中选出m个数的组合。这两个子问题
    //这两个问题我们可以通过递归实现。
    public static void printCombination(char[] str){
        if(str==null||str.length==0){
            System.out.print("输入的字符串为空");
            return;
        }
        StringBuffer result=new StringBuffer();
        for(int i=1;i<=str.length;i++){//从n中，取出
            printCombinationCore(str,i,result);
        }
    }
    public static void printCombinationCore(char[] str,int m,StringBuffer result){
        if(m==0){//递归结束
            for(int i=0;i<result.length();i++){
                System.out.print(" "+result.charAt(i));
            }
            System.out.println();
            return;
        }
        if(str.length!=0&&m<=str.length){//剩下还有子串，且M不为0，则还可以递归。
            result.append(str[0]);//包含第一个值，在剩下的子串中选择m-1个。
            printCombinationCore(String.valueOf(str).substring(1).toCharArray(),m-1,result);
            result.deleteCharAt(result.length()-1);//删除最后一个。即不选择当前值。则在剩下子串中选m个。
            printCombinationCore(String.valueOf(str).substring(1).toCharArray(),m,result);
        }
        else return;
    }
    public static void main(String[] args){
        System.out.println("输入要排列的字符串");
        Scanner scan=new Scanner(System.in);
        String temp=scan.nextLine();
        char[] str=temp.trim().toCharArray();
        System.out.println("字符串的组合结果为：");
        printCombination(str);

    }
}
