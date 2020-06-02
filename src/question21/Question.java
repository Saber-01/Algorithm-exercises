package question21;
import java.util.Scanner;
public class Question {
    public static int[] reorderArray(int[] array){
        if(array==null||array.length==0){
            System.out.print("数组为空");
            return null;
        }
        int leftPoint=0;//定义两个用于滑动判断的指针,初始为两端，分别向中靠近。
        int rightPoint=array.length-1;
        //更广泛的情况，不一定是奇数位于数组前部分，偶数位于后部分，我们可以把判断的条件抽取出来，
        //这个判断方法，可以是更广泛的二类区分。两个循环分别用于移动两个指针。
        while(leftPoint<rightPoint)
        {
            while(leftPoint!=rightPoint&&isOddNumber(array[leftPoint])){
                leftPoint++;
            }
            while (rightPoint!=leftPoint&&!isOddNumber(array[rightPoint])){
                rightPoint--;
            }
            if(leftPoint<rightPoint){
                int temp=array[leftPoint];
                array[leftPoint]=array[rightPoint];
                array[rightPoint]=temp;
            }
        }
        return array;

    }
    public static boolean isOddNumber(int a){
        if((a&1)==1){
            return true;
        }
        else  return  false;
    }
    public static void main(String[] args){
        System.out.print("输入数组逗号隔开，换行结束");
        Scanner scan =new Scanner(System.in);
        String temp=scan.nextLine();
        String[] str=temp.trim().split(",");
        int[] array=new int[str.length];
        for(int i=0;i<array.length;i++){
            try {
                array[i]=Integer.parseInt(str[i]);
            }
            catch (Exception e){
                System.out.print("输入有误");
                array=null;
                break;
            }
        }
        int[] result=reorderArray(array);
        for(int c:result){
            System.out.print(c+",");
        }
    }
}
