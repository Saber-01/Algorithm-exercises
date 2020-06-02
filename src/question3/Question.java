package question3;

import java.util.Scanner;

public class Question {
    public static int[] inArray(){
        System.out.printf("输入n个数，每个数值在0到n-1，每个数空格隔开，enter结束输入");
        Scanner input =new Scanner(System.in);
        //nextLine读取一行 ，保存在temp 字符串中
        String temp=input.nextLine();
        //接下来用split 去划分字符串分别保存在数组中，
        //split 返回的是字符串数组，为了避免输入的习惯不同，还需要先用trim去除两遍空格。
        String[] tempArray=temp.trim().split(" ");
        //需要把字符串数组转换为整型数组。先声明整型数组
        int [] array=new int[tempArray.length];
        for(int i=0;i<tempArray.length;i++){
            //先转化为整数
            int tempInt=Integer.parseInt(tempArray[i]);
            //判断数值是否满足0到n-1
            if(tempInt<0||tempInt>=tempArray.length){
                System.out.printf("输入的数值"+tempInt+"不满足输入条件");
                return null;
            }
            else{//就是满足条件，赋值
                array[i]=tempInt;
            }
        }
        return array;
    }
    public static void main(String[] args){
            int[] array=inArray();
            if (array!=null){//先判断是否为有效输入
                for(int i=0;i<array.length;i++) {
                    while(array[i]!=i) {//直到放到对应位置，否则不退出循环比较
                        if (array[i] != array[array[i]]) {//如果数值和脚标为改数值的对应位置上的值不同的话，
                            int temp = array[i];
                            array[i] = array[array[i]];
                            array[temp] = temp;
                        } else {//如果相等，说明找到了重复的，直接打印出来就行。
                            System.out.printf("其中一个重复数字为" + array[i]);
                            break;
                        }
                    }
                }
            }
//                for(int p:array){
//                    System.out.print(p);
//                }
    }
}
