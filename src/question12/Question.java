package question12;

import java.util.Scanner;

public class Question {
    public static char[][] matrixInput(){
        char[][] result=new char[3][4];
        result[0][0]='a';
        result[0][1]='b';
        result[0][2]='t';
        result[0][3]='g';
        result[1][0]='c';
        result[1][1]='f';
        result[1][2]='c';
        result[1][3]='s';
        result[2][0]='j';
        result[2][1]='d';
        result[2][2]='e';
        result[2][3]='h';
        return result;
    }
    public static boolean hasPath(char[][] matrix,char[] str){
        if(matrix==null){//如果输入的是空矩阵，显然不存在返回，false;
            return false;
        }
        else{//首先找到要开始的第一个点，并且每个点在一次路径中只能过一次，所以需要申请一个同样大小的布尔矩阵用于标记。
            int row= matrix.length;//矩阵的行数
            int column=matrix[0].length;//矩阵的列数
            boolean isVisit[][]=new boolean[row][column];//boolean数值初始就是false ，不需要使用array.fill填充；
            int catchLength=0;//定义一个变量表示已经匹配字符串到哪个字符，用于遍历时候比较；
            for(int i=0;i<row;i++){//二重循环用于遍历整个矩阵，每一个都当做起点来判断是否匹配，其实起点和中间点都是个同样的子问题，所以从第一个点就可以调用函数了。
                for(int j=0;j<column;j++){
                        if(hasPathCore(matrix,isVisit,str,row,column,i,j,catchLength)){//如果返回true，说明存在，不用判断后面，直接打断循环返回
                            return true;
                        }
                }
            }
            return false;
        }
    }
    //内核函数，用于递归调用，发现类似可以分析成树结构的都可考虑用递归调用实现；因为每个节点具有同样的操作，即为子问题
    //参数为，2个矩阵，原矩阵和含有对应点是否被访问的布尔矩阵，矩阵长宽，当前到达的点的坐标，字符串匹配的当前字符位置。
    public static boolean hasPathCore(char[][] matrix,boolean[][]isVisit,char[]str,int row,int column,int curRow,int curColumn,int catchLength){
        if(str==null||catchLength>=str.length){//如果字符串为空，肯定匹配，同样遍历过程中，直到目标字符串全部被匹配完成，即catchLength已经超出字符串范围，说明全部匹配完成，也返回true;（确定递归结束条件）
            return true;
        }
        boolean result=false;//定义用于存放判断结果的布尔型
        if(0<=curRow&&curRow<row&&0<=curColumn&&curColumn<column&&matrix[curRow][curColumn]==str[catchLength]&&!isVisit[curRow][curColumn]){//当前考虑点无越界，若在矩阵中则要没在isVisit中标记，且值要匹配等。
            catchLength++;//匹配到后，当前匹配字符串的角标向后移位。
            isVisit[curRow][curColumn]=true;//当前点被匹配后，就标记为已遍历。
            //这个点是否满足就要看这个点的上下左右的新起点的子问题，
            result=hasPathCore(matrix,isVisit,str,row,column,curRow-1,curColumn,catchLength)||
                    hasPathCore(matrix,isVisit,str,row,column,curRow+1,curColumn,catchLength)||
                    hasPathCore(matrix,isVisit,str,row,column,curRow,curColumn-1,catchLength)||
                    hasPathCore(matrix,isVisit,str,row,column,curRow,curColumn+1,catchLength);
            //如果result没有被赋值成true，说明四条子路径都不满足， 需要到前面路径选择其他分支，则退回前面一个字符重新选,说明当前分支不行，当前节点重置为未遍历。递归只关注每一个小问题的当前点
            if(!result){//result 还是false 时候执行，即四条路径都不行，进行回溯。
                catchLength--;//匹配字符回溯到上个字符。
                isVisit[curRow][curColumn]=false;//遍历状态回溯到未访问
            }
        }
        return result;
    }
    public static void main(String[] args){
        char[][] matrix =matrixInput();
        System.out.print("输入路劲");
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        char[] charArray=str.toCharArray();
        // for(char c:charArray){System.out.print(c+ " ");}
        if(hasPath(matrix,charArray)){
            System.out.print("存在匹配的路径");
        }
        else{
            System.out.print("不存在匹配的路径");
        }
    }
}
