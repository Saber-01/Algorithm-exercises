package question38;

import java.util.Scanner;

public class Sub2Question {
    //排列组合的思想，将输入的8个数字，进行排列组合，
    //然后对每一个组合的结果，进行判断，判断是否符合题目要求的条件。
    //只要有一个符合就返回true。
    public static  boolean checkIsSumEqual(int[] array){
        if(array==null||array.length!=8){
            System.out.print("输入的数组有误");
            return false;
        }
        return  checkIsSumEqualCore(array,0);
    }
    public static boolean checkIsSumEqualCore(int[] array,int curPosition){
        if(curPosition==array.length-1){//如果排列已经到了最后一位数。则开始判断。
            if(array[0]+array[1]+array[2]+array[3]==array[4]+array[5]+array[6]+array[7]&&
                    array[0]+array[1]+array[4]+array[5]==array[2]+array[3]+array[6]+array[7]&&
                    array[1]+array[3]+array[5]+array[7]==array[0]+array[2]+array[4]+array[6])
                return true;
            else  return  false;
        }
        boolean result=false;
        for(int i=curPosition;i<array.length;i++){
            int temp=array[curPosition];//依次交换剩余数组，每一次交换，当前首部位置上变为新的值。
            array[curPosition]=array[i];
            array[i]=temp;
            result=checkIsSumEqualCore(array,curPosition+1);//递归到下一层。
            temp=array[curPosition];//交换完以后，需要交换回来，避免重复。
            array[curPosition]=array[i];
            array[i]=temp;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.print("输入8个数字逗号隔开，判断8和数字放在正方体顶点，是否可以使得正方体上三组相对面4个顶点和相同");
        Scanner scan= new Scanner(System.in);
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
        if(checkIsSumEqual(array)){
            System.out.print("可以作为正方体的8个顶点");
        }
        else
            System.out.print("不可以作为正方体的8个顶点");
    }
}
