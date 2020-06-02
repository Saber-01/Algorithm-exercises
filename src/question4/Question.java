package question4;

import java.util.Scanner;

public class Question {
    public static int[][] inArray(){
        System.out.printf("请输入矩阵的行数和列数，用逗号隔开");
        Scanner scan=new Scanner(System.in);
        Scanner scan1=new Scanner(System.in);
        String str=scan.nextLine();
        String[] strTemp=str.split(",");
        int row =Integer.parseInt(strTemp[0]);
        int column =Integer.parseInt(strTemp[1]);
        int[][] array=new int[row][column];
        System.out.printf("依次输入数字用空格隔开,行间换行");
        for(int i=0;i<row;i++){
                String temp=scan.nextLine();//先接收一行
                String[] strArray= temp.trim().split(" ");
                if(strArray.length!=column){
                    System.out.print("输入的矩阵有误");
                    return null;
                }
                else{
                    for(int j=0;j<column;j++){
                        array[i][j]=Integer.parseInt(strArray[j]);
                    }
                }
                System.out.print("已输入第"+(i+1)+"行");
                //array[row][column]=0;
            }
        return array;
    }
    public static void main(String[] args){
        int[][] array=inArray();
        System.out.print("输入一个你要找的数：");
        Scanner input=new Scanner(System.in);
        int number=0;
        if(input.hasNextInt()){
            number= input.nextInt();
        }
        if(array!=null)
        {
            System.out.print("矩阵的阶数："+array.length+"*"+array[0].length);
            int row=array.length;
            int column=array[0].length;
            int i=0;int j=column-1; //定义比较的位置标点，初始从右上角开始比较
            while(i<row&&j>=0){
                System.out.print("右上位置数是"+array[i][j]);
                if(array[i][j]>number){//如果要找的数小于，说明这个数不可能在这一列，先排除一列。
                    j--;
                }
                else if(array[i][j]<number){//如果要找的数比较大，说明不在这一行，排除这行
                    i++;
                }
                else {//如果相等 ，就找到了
                    System.out.print("矩阵中含有数"+number);
                    return ;
                }
            }
            System.out.print("矩阵中不含有该数");
        }

    }
}
