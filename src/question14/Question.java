package question14;

import java.util.Scanner;

public class Question {
    public static int maxProductAfterCutting_dynamic(int length){//绳子至少要剪一刀。
        if(length==0)//先定义最底层的子问题的最优解，
            return 0;
        if(length==1)//少于2的绳子都减不了，属于特殊情况。
            return 0;
        if(length==2)//长度为2 。为1*1=1;比绳子本身长度小
            return  1;
        if(length==3)//长度3.为1*2=2，比绳子本身长度小，所以额外设定条件返回
            return  2;
        //因为题目要求至少剪一刀，所以在长度在3以下的，其实剪完后的乘积是会少于本身不剪时候的长度的，所以要注意的是：
        //在绳子在4以上时候，剪的时候，f(3)以下的子问题，定义值为他们不剪时候的本身长度，即以下赋值
        int[] product=new int[length+1];//加一是因为product[0]不使用，为了让f(1)就对应着product(1);
        product[0]=0;//即绳子长度在3以下的时候，f(3)，f(2),f(1)子问题为本身，算出来的f(4),f(5)才是最大的。
        product[1]=1;
        product[2]=2;
        product[3]=3;
        for(int i=4;i<length+1;i++){//第一个循环代表自下而上的取优过程。从更小的子问题到相对小的子问题的过程。
            int result=0;//用于第二个循环中，寻找f(n)子问题最优解的比较变量。最终存储max{f(1)f(n-1),f(2)f(n-2)......}
            for(int j=1;j<=i/2;j++){//如：长度为4时候f(1)f(3)=f(3)f(1)，所以只要判断到i的一半就可以了。取等是因为f(2)*f(2)这种情况
                if(product[j]*product[i-j]>result){//如果大于 就对result重新赋值，即找过程中最大值
                    result=product[j]*product[i-j];
                }
            }
            product[i]=result;//将循环找到的最优解，赋值到product[i]，代表f(i)的最优解，为了上层更大问题的最优解服务。
        }
        //第一个大循环结束后，数组product 存放了对应角标指i的绳子长度的最优解。即product[length]=f(length)
        return product[length];
    }
    public static int maxProductAfterCutting_greedy(int length){
        if(length==0)//先定义最底层的子问题的最优解，0,1,2,3为特殊情况，单独分析
            return 0;
        if(length==1)//少于2的绳子都减不了，属于特殊情况。
            return 0;
        if(length==2)//长度为2 。为1*1=1;比绳子本身长度小
            return  1;
        if(length==3)//长度3.为1*2=2，比绳子本身长度小，所以额外设定条件返回
            return  2;
        //我们考虑在每一次剪绳子的时候，都做到尽可能的使得乘积最大，所以，当第一次剪只剪1cm，显然不会最大，(n-1)*1<n,
        // 则考虑(n-2)*2>n时，n>4,(n-3)*3>n,时n>=5;当尝试剪4cm时候，发现4cm可以分成2条2cm，(n-4)*4=(n-4)2*2，问题其实变成第一次剪2cm的选择。
        //考虑一次剪5cm时，因为n>=5;s所以(n-5)5<(n-5)(5-3)*3,即问题就变成第一次剪3cm时候的最优了，所以，每一次考虑剪多少cm，只要在2cm和3cm里面选、
        //但，（n-2)*2>(n-3)*3时,发现n<5时候，第一次剪2cm会是最优选择。所以当n>=5时候，第一次必定剪3cm是最优选择。则问题转化为贪婪问题，在n>=5时每次都剪3cm.
        // 直到最后剩下的绳子肯定是2cm,3cm,4cm时候就可以停止剪了，因为这时候不剪的话绳子本身长度就是这小段绳子的最大乘积。
        int result=1;
        if(length==4){//n<5都单独处理了
            return 4;
        }
       while(length>=5){//循环结束以后存放的是剪完所出所有3cm并把这些3cm相乘后的值。length为剪完以后剩下的小于5的一条绳子。
           result=result*3;
           length=length-3;
       }
       result=result*length;
       return result;
    }
    public static void main(String[] args){
        System.out.print("输入绳子的长度");
        Scanner scan =new Scanner(System.in);
        int length=0;
        if(scan.hasNextInt()){
            length=scan.nextInt();
        }
        System.out.print("剪的绳子乘积最大为(动态规划)："+maxProductAfterCutting_dynamic(length));
        System.out.print("剪的绳子乘积最大为（贪心算法）："+maxProductAfterCutting_greedy(length));
    }
}
