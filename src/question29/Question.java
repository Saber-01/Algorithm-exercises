package question29;

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
        int[][] array=new int[row][column];//初始化数组。
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
        }
        return array;
    }
    public static void printMatrixClockwise(int[][] array){
        if(array==null){
            System.out.println("输入的矩阵为空");
            return;
        }
        int column=array.length;
        int row=array[0].length;
        //顺时针，则定义四个边界，上下左右，当指针从左上角往右移动，纵坐标自加，直到碰到右边界将上边界下移，因为第一行打印完毕。并且变化的坐标变为横坐标自加，即向下运动，
        //当向下运动时候，直到碰到下边界时候，右边界左移，因为最右一列打印完毕，并且变化的坐标变为纵坐标自减，即向左运动，
        //当向左运动，直到碰到左边界时候，下边界上移，因为最下边的一行已经打印完毕。并且变化坐标变为横坐标自减，即向上移动。
        //当向上运动，直到碰到上边界时，左边界右移，因为坐左边的一列打印完毕。此时最外围一圈已经打印完毕。开始内圈的左上角为起点，开始新一轮循环。
        int leftBorder=0;
        int rightBorder=row-1;
        int upBorder=0;
        int downBorder=column-1;
        column=0;row=0;//初始定义为0.
        int stateCode=1;//定义状态码，1位向右，2位向下，3位向左，4 为向上
        while(leftBorder<=rightBorder&&upBorder<=downBorder){
            System.out.print(" "+array[column][row]);
            if(stateCode==1){//向右移动，则列自加。
                row++;
                if(row>rightBorder){//碰到右边界
                    row--;
                    column++;
                    stateCode=2;
                    upBorder++;
                }
            }
            else if(stateCode==2){//向下运动，则行自加。
                column++;
                if(column>downBorder){//碰到下边界
                    column--;
                    row--;
                    stateCode=3;
                    rightBorder--;
                }
            }
            else if(stateCode==3){//向左运动，则列自减，
                row--;
                if(row<leftBorder){//碰到左边界
                    row++;
                    column--;
                    stateCode=4;
                    downBorder--;
                }
            }
            else if(stateCode==4){//向上运动，则行自减
                column--;
                if(column<upBorder){//碰到上边界
                    column++;
                    row++;
                    stateCode=1;
                    leftBorder++;
                }
            }
        }
    }
    public static void main(String[] args){
        int[][] array=inArray();
        System.out.println("从左上角瞬时针输出的结果为：");
        printMatrixClockwise(array);
    }
}
