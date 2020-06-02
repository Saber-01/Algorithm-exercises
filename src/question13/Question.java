package question13;

import java.util.Scanner;

public class Question {
    public static boolean check(int row,int column,int curRow,int curColumn,int k,boolean[][] isVisit)//确定该点是否能到达。
    {
        if(curRow>=0&&curRow<row&&curColumn>=0&&curColumn<column&&//确保坐标点在定义的矩阵内，并且该点还没有被计算，且这点符合坐标点位数之和不大于K
                getDigitSum(curRow,curColumn)<=k&&!isVisit[curRow][curColumn]){
            return  true;
        }
        else
            return false;
    }
    public static int getDigitSum(int row,int column){//获得这个位置的横纵坐标位数之和。
        int sum=0;//存放总合
        while(row!=0){
            sum=row%10+sum;//取最右边的位数
            row=row/10;//去掉这一位数
        }
        while(column!=0){
            sum=column%10+sum;
            column=row/10;
        }
        return sum;
    }
    public static int movingCount(int k,int row,int column){
        int count=0;//定义一个记录可以到达点的个数。
        int curRow=0,curColumn=0;//一开始从（0,0）开始
        boolean[][] isVisit=new boolean[row][column];//定义一个同样大小矩阵，标记是否访问，
        count=movingCountCore(row,column,curRow,curColumn,k,isVisit);
        return count;
    }
    public static int movingCountCore(int row,int column,int curRow,int curColumn,int k,boolean[][] isVist){
        int count=0;//用于经过当前点能到达的所有点的记录（包括本身）
        if(check(row,column,curRow,curColumn,k,isVist)){//如果该点能到达，则进行上下左右四个点判断。
            isVist[curRow][curColumn]=true;//到达了就标记为已经到过了。不参与计算count了
            //经过这个节点能到的节点数为，自己本身加上经过其上下左右节点能到达的节点数之和，参考树的节点计算。
            count=1+ movingCountCore(row,column,curRow-1,curColumn,k,isVist)+
            movingCountCore(row,column,curRow+1,curColumn,k,isVist)+
            movingCountCore(row,column,curRow,curColumn-1,k,isVist)+
            movingCountCore(row,column,curRow,curColumn+1,k,isVist);
        }
        return count;
    }
    public static void main(String[] args){
        System.out.print("输入m*n形式，代表矩阵行列");
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        String[] strArray=str.trim().split("\\*");
        int row=Integer.parseInt(strArray[0]);
        int column=Integer.parseInt(strArray[1]);
        System.out.print("输入k");
        int k=0;
        if(scan.hasNextInt()){
            k=scan.nextInt();
        }
        int count=movingCount(k,row,column);
        System.out.print("能到达的点数为："+count);
    }
}
