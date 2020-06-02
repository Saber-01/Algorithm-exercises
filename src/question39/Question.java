package question39;

import java.util.Scanner;

public class Question {
    //因为如果有一位数是出现了超过一半的，那么我们在遍历数组的时候，记住2个数即可，
    //一是数组中的数，一个是次数。
    //当遍历是时，遇到和之前保存的数相同的数时，次数加1，遇到不相同就减1.
    //如果次数变为0了，则下一次遍历时，将次数重置为1，保存的数也进行更新。
    //因为该数出现次数是所有数目的一半还多。所以最后一次保存的数就是我们要找的数。
    public static int FindTheNumberOfMoreThanHalfTime(int[] array){
        int number =1;//初始设为1.
        int result = array[0];//初始为数组第一个数
        for(int i = 1;i < array.length; i++){
            if(number == 0){//次数为0时，
                result = array[i];
                number = 1;
            }
            else if(array[i] != result){//遇到不等于保存的数的
                number--;//次数减1
            }
            else{
                number++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.print("输入数组，数字间用逗号隔开。");
        Scanner scan = new Scanner(System.in);
        String temp=scan.nextLine();
        String[] str=temp.trim().split(",");
        int[] array=new int[str.length];
        try{
            for(int i=0;i<str.length;i++){
                array[i]=Integer.parseInt(str[i]);
            }
        }
        catch (Exception e){
            System.out.print("输入的数组有误");
            return;
        }
        int result = FindTheNumberOfMoreThanHalfTime(array);
        System.out.print("数组中出现超过一半次数的数为："+result);
    }
}
