package question5;

import java.util.Scanner;

public class Question {
    public static int countBrank(char[] str){
        int count=0;//空格数初始为0
        if(str!=null){
            for(char c:str){
                if(c==' '){
                    count++;
                }
            }
        }
        return count;
    }
    public static char[] transform(char[] array,int originalLength,int newLength){
        int p2=newLength-1;//定义两个角标，p2指向新数组末端
        int p1=originalLength-1;//p1指向原始数组的末端
//        System.out.print(p2);
//        System.out.print(p1);
        while(p1>=0){
            if(array[p1]==' '){//遇到的是空格
                array[p2--]='0';
                array[p2--]='2';
                array[p2--]='%';
            }
            else {//遇到的不是空格
                array[p2--]=array[p1];
            }
            p1--;
        }
        return array;
    }
    //区别StringBuffer 和StringBuilder以及String的区别。
    //这里用StringBuffer和StringBuilder 都可以。
    public static void main(String[] args){
        System.out.printf("输入一个字符串：");
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        //StringBuffer str=new StringBuffer(s);//将String 转成StringBuffer
        char[] str=s.toCharArray();//将字符串装换成char数组。
        //假设题目要求不新增数组，在原来数组上替换，假设数组原来是给定长度的
        System.out.printf("输入字符串的长度：");
        int length=0;
        if(input.hasNextInt()){
            length=input.nextInt();
        }
        char[] charArray=new char[length];
        System.out.print("提供的数组长度为"+charArray.length);
        //则要判断是否空间够存储转换后的字符串。
        //先计算字符串空格的数量
        int blankNumber=countBrank(str);
        System.out.print("提供的数组中空格个数"+blankNumber);
        if((str.length+2*blankNumber)>length)//如果转换后的长度大于说明不够
        {
            System.out.print("提供的数组长度不够转换");
            return;
        }
        else{
            for(int i=0;i<str.length;i++){//先转移到目标提供的，这一步是因为JAVA的数组都是定长的不能改变,所以这么设置
                charArray[i]=str[i];
            }
            System.out.printf("转换后的字符串为：");
            System.out.print(transform(charArray,str.length,str.length+2*blankNumber));
        }
        //System.out.printf(""+str.charAt(0));
    }
}
