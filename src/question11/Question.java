package question11;

import java.util.Scanner;

public class Question {
    public static int[] arrayInput(){
        System.out.print("输入目标数组，用逗号隔开，换行结束");
        Scanner input=new Scanner(System.in);
        String str=input.nextLine();
        String[] strArray=str.trim().split(",");
        int[] array=new int[strArray.length];
        System.out.print(str.length());
        if(str.length()!=0){
            for(int i=0;i<strArray.length;i++)
            {
                if(Integer.valueOf(strArray[i])<48||Integer.valueOf(strArray[i])>57)
                {
                    array[i]=Integer.parseInt(strArray[i]);
                }
                else
                {
                    System.out.print("输入的数组有误");
                    return null;
                }
            }
        }
        else{
            return null;
        }
        return  array;
    }
    public static int minimumRotateArray(int[] array){
        if(array!=null){
            int left=0;//定义二分法查找的两个角标
            int right=array.length-1;//初始分别为数组的前和尾
            int middle=0;
            while(array[left]>=array[right]){//因为是旋转数组，需要找到右边数组的第一个值，所以过程总左角标指的值都大于右边角标指的值。
                if(right-left==1){//人为设置循环结束条件，如果数组只有两个了， 那么肯定一个在左边数组，一个在右边数组，所以输出右边的就是最小值
                    middle=right;
                    break;
                }
                middle=(left+right)/2;
                if(array[left]==array[middle]&&array[right]==array[middle]){//因为没有严格升序，说以有可能遇到三个值相同，这时候只能顺序遍历查找
                    int result=array[left];
                    for(int i=left+1;i<right;i++){
                        if(array[i]<result)
                        {
                            result=array[i];
                        }
                    }
                    return result;
                }
                else{//没遇到特殊情况
                    if(array[left]<=array[middle]){//右边数组都小于等于左边，所以如果左边值小于了说明中间值还是再左边数组，舍弃左边的部分数组。
                        left=middle;
                    }
                    if(array[right]>=array[middle]){//同理，如果右边值大于中间值，说明middle还是再右边数组，舍弃掉右边部分数组。
                        right=middle;
                    }
                }
            }
            return array[middle];
        }
        else{
            System.out.print("数组为空");
            return 0;
        }
    }
    public static void main(String[] args){
        int[] array=arrayInput();//输入数组
        int result =minimumRotateArray(array);
        System.out.print("旋转数组的最小值为："+result);

    }
}
