package question15;

import java.util.Scanner;

public class Question {
    public static int numberOf1(int n){
        int a=1;//用于位与，可以判断这个对应位数是否为1
        int count=0;//记数1几个。
        while(a!=0){
            if((n&a)!=0){//按位与，只有当n中 a上1对应的位置上为1时候才不等于0
                count++;
            }
            a=a<<1;//a左移移位，用于判断下一个高位是否为1.
        }
        return count;
    }
    public static int numberOf1_optimize(int n){
        //通过观察可以发现，二进制的n 经过-1以后，n的最右边位数上的1会变成0，在此位数左边数不变，但这个数的右边，将全部变为1；
        //所以将n和n-1以后的数做位与运算得到的结果p，那么n最右边1的对应位数左边，1与1还为1，0和0与预算还是0，即P和n在n最右边1对应位数的左边数值不变。
        // n的最右边1的位数右边为0，而n-1上面说了对应位数上值全变成了1，所以n与n-1做与运算这些数还是为0，所以p和n在最右边1数位的右边数也不变、
        //而n的最右边1 和n-1的对应位置变为的0,做与，得到的是0，而n这个位数上值为1，即P和n就差别就是n中最右边的1变为了0，这样就可以优化算法。
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
    public static void main(String[] args){
        System.out.print("输入一个数，输出为这个数二进制表示含有的1的个数");
        Scanner scan=new Scanner(System.in);
        int n=0;
        if(scan.hasNextInt()){
            n=scan.nextInt();
        }
        System.out.print("二进制表示1的个数有"+numberOf1(n));
        System.out.print("二进制表示1的个数有(优化法)"+numberOf1_optimize(n));
    }
}
