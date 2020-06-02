package question16;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.lang.Math.*;
public class Question {
    public static double Power(double base,int exponent){
        double e=0.0000001;//默认精度
        if(Math.abs(base)-0.0<e){//底数为零时，结果都为0
            try{
                if(Math.abs(exponent)-0.0<e){
                    throw new Exception();
                }
            }catch (Exception a){
                System.out.print("0的0次方没有意义");
            }
            return 0;
        }
        if(exponent<0){//指数小于0时，需要求倒数。
            exponent=-exponent;//先取正数，
            DecimalFormat df=new DecimalFormat("0.0000000");
            double result =1/PowerCore(base,exponent);
            return Double.parseDouble(df.format(result));
        }
        else if(Math.abs(exponent)-0.0<e){//指数为0时，
           return 1;
        }
        else{
            DecimalFormat df=new DecimalFormat("0.0000000");
            double result =PowerCore_inprove(base,exponent);
            return Double.parseDouble(df.format(result));
        }
    }
    public static double PowerCore_inprove(double base,int exponent){
        if(exponent==0){
            return 1;
        }
        if(exponent==1){
            return  base;
        }
        else
        {
            double result=PowerCore_inprove(base,exponent>>1);
            result*=result;
            if((exponent&1)==1){//奇数还要乘原数。
                result=result*base;
            }
            return result;
        }
    }
    public static double PowerCore(double base,int exponent){
        double result=1;//初始为1；
        while(exponent>0){
            result=result*base;
            exponent--;
        }
        return  result;
    }
    public static void main(String[] args){
        System.out.print("输入底数");
        Scanner scan=new Scanner(System.in);
        double base=0.0;
        if(scan.hasNextDouble())
        {
            base=scan.nextDouble();
        }
        System.out.print("输入指数");
        int exponent=0;
        if(scan.hasNextDouble())
        {
            exponent=scan.nextInt();
        }
        double result =Power(base,exponent);
        System.out.print("底数"+base+"的"+exponent+"次方的结果为"+result);
    }
}
