package question38;

import java.util.Scanner;

public class Question {
    //将字符串中的每一个字符进行排列组合，将组合成的字符串输出。
    //则通过数学知识，可以知道排列的方式组合有Ann方式，
    //分析过程，第一个数可以有n中选择，第二个则是n-1中，第三个是n-2种。知道排列到最后一位。
    //则，第一个数可以是数组中的任何一个数，其之后的排列，其实就是n-1个剩下的数的排列组合。
    //这样就可以发现子问题，可以用递归实现。
    //当第一个值用for循环遍历交换后，剩下的数组的排列顺序用递归进行。。知道递归到最后一位没得交换后，打印出来。
    //在一次循环汇中，发现交换玩数值以后，其实我们不想破坏数组原来的结构，我们只是相当于想把这个值放在首位尝试递归排序
    //等到排完以后，应该交换回来，使得下一次for循环交换的也是我们之前未曾交换过的值。
    public static void printpermutation(char[] str){
        if(str==null||str.length==0){
            System.out.print("输入的字符串为空");
            return;
        }
        printpermutationCore(str,0);//初始为0
    }
    public static void printpermutationCore(char[] str,int curPoint){
        if(curPoint==str.length-1){//到达了最后一位数
            for(char c:str){//到达最后一位，就打印出
                System.out.print(" "+c);
            }
            System.out.println();
            return;
        }
        for(int i=curPoint;i<str.length;i++){//从当前位开始和数组剩下的位数交换，每一次交换都递归判断下一次。
            char temp= str[curPoint];//中间值，用于交换
            str[curPoint]=str[i];
            str[i]=temp;
            printpermutationCore(str,curPoint+1);//递归下一层，指针移到下一位。
            temp= str[curPoint];//交换完尝试递归后，需要交换回来，才能保证下一次循环放到首位的是一个还未尝试的情况。
            str[curPoint]=str[i];
            str[i]=temp;
        }
    }
    public static void main(String[] args){
        System.out.println("输入要排列的字符串");
        Scanner scan=new Scanner(System.in);
        String temp=scan.nextLine();
        char[] str=temp.trim().toCharArray();
        System.out.println("字符串的排列结果为：");
        printpermutation(str);
    }
}
