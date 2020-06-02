package question17;

import java.util.Scanner;

public class Question {
    public static void printToMaxOfNDigits(int n){
        if(n<=0){
            System.out.print("输入的N有误");
            return;
        }
        char[] result =new char[n];
        while(1==1){
            char[] c=addOneOperation(result);
            if(c!=null){
                System.out.print(String.valueOf(c)+" ");
            }
            else break;
        }
    }
    public static char[] addOneOperation(char[] c){
        int length=c.length;
        int curPosition=length-1;//光标默认最后
        while(c[curPosition]=='9'){//遇到9，就继续向左动，直到遇到不是9的停下来。
            curPosition--;//往左移动符合算数规则。
            if(curPosition==-1){
                return null;//如果到最后还是没遇到不是9的，说明已经最大了。这时退出就行。
            }
        }
        if (c[curPosition]=='\u0000') {//注意char默认值是\u0000
            c[curPosition]='0';
        }
        c[curPosition]=(char)(c[curPosition]+1);//从右边开始第一个非9的加1，
        for(int i= length-1;i>curPosition;i--){
            c[i]='0';
        }
        return c;
    }
    public static void recursionPrintToMaxOfNDigits(int n){
        char[] result =new char[n];
        for(int i=0;i<10;i++){
            result[0]=(char) ('0'+i);//int 转换成char 需要显式转换
            recursionCore(result,0);
        }
    }
    public static void recursionCore(char[] result,int curPosition){
        int length=result.length;
        if(curPosition==length-1){//递归到最后一位
            printWithoutBeginZero(result);
            System.out.print(" ");
            return;
        }
        for(int i=0;i<10;i++){
            result[curPosition+1]=(char)('0'+i);
            recursionCore(result,curPosition+1);
        }
    }
    public static void printWithoutBeginZero(char[] result){
        int cur=0;
        while(result[cur]=='0'){
            if(cur==result.length-1)
                return;
            cur++;
        }
        for(int i=cur;i<result.length;i++){
            System.out.print(result[i]);
        }
    }
    public static void main(String[] args){
        System.out.print("输入数字N");
        Scanner scan=new Scanner(System.in);
        int n=0;
        if(scan.hasNextInt()){
            n=scan.nextInt();
        }
        System.out.print("输出1到最大N为数字的结果为：");
//        char[] a=new char[10];
//        a[9]='1';
//        a[8]='2';
//        if(a[9]=='1')
//        System.out.print(a[9]);
           printToMaxOfNDigits(n);
           recursionPrintToMaxOfNDigits(n);
    }
}
