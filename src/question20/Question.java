package question20;
import java.util.Scanner;
public class Question {
    public static boolean checkIsNumeric(char[] str){
        //字符串遵循A[.[B]][e|EC]或，.B[e|EC]模式，其中A和C都是以都是可能开头带+、-的1到9的数字串。
        //而B是小数部分，只能是没有符号的由1到9组成的数位串。而判断数字是属于A、B、C需要判断是否遇到了.或者e或者E。
        if(str.length==0){
            System.out.print("输入字符串为空");
            return false;
        }
        int length=str.length;
        boolean numeric=false;
        int curPosition=0;//用于判断的光标，初始为0；
        if(str[curPosition]=='+'||str[curPosition]=='-'){
            curPosition++;//字符串开头是+或-符合，就判断下一个。
        }
        boolean haveA=false;
        int originalCurPositon=curPosition;
        while(curPosition<length&&str[curPosition]>='0'&&str[curPosition]<='9'){//判断玩+-以后，开头只能是0~9，这部分对应A。
            curPosition++;//两种情况退出，一是到末尾了，二是遇到非0~9,。
        }
        if(originalCurPositon!=curPosition)
            haveA=true;//如果移位了，说明整数A非空。
            boolean haveB=false;
        if(curPosition<length&&str[curPosition]=='.'){//则若遇到.说明后面需要小数部分B。
            curPosition++;//遇到.了先要自加移动一位。小数部分B开始。
            originalCurPositon=curPosition;
            while(curPosition<length&&str[curPosition]>='0'&&str[curPosition]<='9'){//B是无符号整数串，则只能包含0~9，
                curPosition++;//也是两种情况退出，一是到末尾了，二是遇到非0~9,。因为小数部分是可以为空。
            }
            if(originalCurPositon!=curPosition)
                haveB=true;//说明小数部分B非空
        }
        numeric=haveA||haveB;//最后的结果中，不管有没有e、E。A和B肯定要至少有一个存在。
        if(curPosition<length&&(str[curPosition]=='e'||str[curPosition]=='E')){//如果还未到末尾，遇到e或E说明C部分开始。
            curPosition++;//遇到E或e，则先要自加移动一位。C开始。判断步骤与A类似。但是C无论是否有+ -开头都不能为空。
            if(curPosition<length&&(str[curPosition]=='+'||str[curPosition]=='-')){
                curPosition++;//字符串开头是+或-符合，就判断下一个。
            }
            boolean havaC=false;
            originalCurPositon=curPosition;
            while(curPosition<length&&str[curPosition]>='0'&&str[curPosition]<='9'){//判断玩+-以后，开头只能是0~9，这部分对应A。
                curPosition++;//两种情况退出，一是到末尾了，二是遇到非0~9,。
            }
            if(originalCurPositon!=curPosition){//说明C部分存在。。
                havaC=true;
            }
            numeric=numeric&&havaC;//当遇到了e或者E时，C必须存在。所以这里为&&
        }
        if(curPosition!=length)//当ABC部分全判断完以后，还是没有到末尾，说明后面含有非数字，返回false.
            return false;
        //如果到了末尾。
        return numeric;
    }

    public static void main(String[] args){
        System.out.print("输入字符串");
        Scanner scan=new Scanner(System.in);
        String temp=scan.nextLine();
        char[] str=temp.toCharArray();
        if(checkIsNumeric(str)){
            System.out.print("该字符串是表示数值");
        }
        else{
            System.out.print("该字符串不是表示数值");
        }
    }
}
