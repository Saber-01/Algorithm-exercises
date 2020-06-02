package question29;

import java.util.Scanner;

public class QuestionBookSolution {
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
    //可以发现，每次绕圈，从左上角开始，瞬时间回到这点，为一圈，
    //我们可以把矩阵看成是多个从小到大的圆圈。第一个圈起点为(0,0),第二圈起点为(1,1),类推
    //（start,start）的边界容易分析的，start*2<column&&start*2<row;
    //平常一圈是向右，向下，向左，向上。为四步，但是最后一圈有可能只需要一步，2步，或者三步的情况，所以后三步需要添加判断条件。
    public static void printMatrixClockwise(int[][] array){
        if(array==null){
            System.out.print("矩阵为空");
            return;
        }
        int column=array.length;
        int row=array[0].length;
        int start=0;
        while(start*2<column&&start*2<row){//最外层循环，即从外圈到最内圈
            printCircle(array,start);
            start++;
        }
    }
    public static void printCircle(int[][] array,int start){
        int endX=array[0].length-1-start;//本次绕圈，X轴的移动最大边界
        int endY=array.length-1-start;//Y轴的最大移动边界。
        for(int i=start;i<=endX;i++){//第一步,为必须
            System.out.print(" "+array[start][i]);
        }
        if(endY>start){//第二步向下要求最大移动的Y边界大于start，则向下移动。
            for(int i=start+1;i<=endY;i++)
                System.out.print(" "+array[i][endX]);
        }
        if(endX>start&&endY>start){//第三步向左要求，最大移动X边界要大于start，则向左运动(要满足第二步条件)
            for(int i=endX-1;i>=start;i--)
                System.out.print(" "+array[endY][i]);
        }
        if(endX>start&&endY>start+1){//第四步要求，Y轴最大要大于start2格，且要满足第三步条件。
            for(int i=endY-1;i>=start+1;i--)
                System.out.print(" "+array[i][start]);
        }
    }
    public static void main(String[] args){
        int[][] array=inArray();
        System.out.println("从左上角瞬时针输出的结果为：");
        printMatrixClockwise(array);
    }
}
