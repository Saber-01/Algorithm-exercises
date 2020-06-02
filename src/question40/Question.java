package question40;

import java.util.Scanner;

public class Question {
    public static void printTheKthSmallNumbers(int[] array,int k){
        if(array==null||array.length==0){
            System.out.println("输入的数组为空");
            return;
        }
        if(k>array.length){
            System.out.print("数组没有K个数");
            return;
        }
        if(k<1){
            System.out.print("输入的K有错误");
            return;
        }
        int start=0;
        int end =array.length-1;
        int index = partition(array,array.length,start,end);
        while(index!=k-1){
            if(index>k){
                end=index-1;
                index=partition(array,array.length,start,end);
            }
            else{
                start=index+1;
                index=partition(array,array.length,start,end);
            }
        }
        for(int i=0;i<k;i++){
            System.out.print(" "+array[i]);
        }
    }
    public static int partition(int[] array,int length,int start,int end){
        int pivot =array[start];//使用数组的第一个值作为轴值，用于比较
        int left=start+1;
        int right=end;
        while(left < right){//左右指针没遇到
            while(left<right&&array[right]>pivot)
                right--;//直到右边遇到一个不比轴值大的，就停止。
            while(left<right&&array[left] <= pivot)
                left++;//直到左边遇到一个比轴值大的,左指针才停止
            int temp = array[right];//交换2个值。
            array[right] = array[left];
            array[left]=temp;
        }
        int temp =array[left];
        array[left]=pivot;
        array[start]=temp;
        return left;
    }
    public static void main(String[] args){
        System.out.println("输入n个整数，每个整数逗号隔开，输出其中最小的k个数");
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
        System.out.println("输入K");
        int k=0;
        if(scan.hasNextInt()){
            k=scan.nextInt();
        }
        System.out.println("输出的k个数为：");
        printTheKthSmallNumbers(array,k);
    }
}
