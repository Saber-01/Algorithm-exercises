package question3;

import java.util.Scanner;

public class SubQuestion {
    public static int[] inArray(){
        System.out.printf("输入n+1个数，每个数值在1到n，每个数逗号隔开，enter结束输入");
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        String[] strArray=str.trim().split(",");
        int[] array=new int[strArray.length];
        for(int i=0;i<strArray.length;i++){
            int temp=Integer.parseInt(strArray[i]);
            if(temp<1||temp>=strArray.length){
                System.out.printf("输入的"+temp+"不符合要求");
                return null;
            }
            else{
                array[i]=temp;
            }
        }
        return array;
    }
    public static int countNumber(int[] array,int length,int begin,int end){
        int count=0;//赋初值，
        for(int i=0;i<length;i++){
            if(array[i]>=begin&&array[i]<=end)//夹在区间就记数
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] array=inArray();
        if(array!=null){//判断是否为有效输入
            int length=array.length;
            int begin=1;//区间起始点
            int end=length-1;//区间终点
            while(end>begin){//还没收敛到一个数，就继续执行2
                int middle=(end+begin)/2;
                int leftCount=countNumber(array,length,begin,middle);//左区间的个数
                //System.out.printf("leftCount:"+leftCount);
                if(leftCount>middle-begin+1)//说明存在重复的数
                {
                    end=middle;
                }
                else{//反之，区间内的数都不存在重复值，考虑右区间。
                    begin=middle+1;
                }
            }
            System.out.printf("其中一个重复值为"+begin);
        }
    }
}
