package question19;

import java.util.Scanner;

public class Question {
    public static boolean match(char[] str, char[] pattern){
        if(str.length==0||pattern.length==0){
            System.out.print("输入的字符串或表达式为空");
            return false;
        }
        else
            return matchCore(str,pattern,0,0);
    }
    public static boolean matchCore(char[] str,char[] pattern,int strCurPosition,int patternCurPosion){
        if(strCurPosition==str.length&&patternCurPosion==pattern.length){//递归结束条件之一，就是都匹配到了末尾。
            return true;
        }
        else if(strCurPosition!=str.length&&patternCurPosion==pattern.length){//当pattern先匹配完，则false,但是当str先匹配完，而pattern可能存在*的情况，则不能确定，所以以下判断要加上str是否越界的判断。
            return false;
        }
        else if(patternCurPosion+1<pattern.length&&pattern[patternCurPosion+1]=='*'){//匹配的子表达式的第二个字符如果是*就要分情况讨论了。一共有四种情况。
            if(strCurPosition<str.length&&(str[strCurPosition]==pattern[patternCurPosion]||pattern[patternCurPosion]=='.')){//首先是这个*前的字符（包括特殊字符'.'）和字符串匹配的情况，将有三种可能，
                return   matchCore(str,pattern,strCurPosition,patternCurPosion+2)||//第一种，把c*当做0个c处理，即略过了c*，只有表达式往后，（c指代任意个在*前的字符，下同）。
                        matchCore(str,pattern,strCurPosition+1,patternCurPosion+2)||//第二种，把c*当做1个c处理。即一对一，表达式和字符串都往后移动，
                        matchCore(str,pattern,strCurPosition+1,patternCurPosion);//把c*当做多个c处理，即只有字符串往后，继续判断c*，
            }
            else
                return  matchCore(str,pattern,strCurPosition,patternCurPosion+2);//第四种，就算*前字符不相同(包括了str已经匹配完毕的情况)，也可以把c*略去，即只移动表达式。
        }
        else if(strCurPosition<str.length&&(str[strCurPosition]==pattern[patternCurPosion]||pattern[patternCurPosion]=='.')){//如果没遇到*,就正常单个字符对比，只要相同，或者pattern对应位置是'.'就都能对应。
            return matchCore(str,pattern,strCurPosition+1,patternCurPosion+1);
        }
        return false;
    }
    public static void main(String[] args){
        System.out.print("输入待匹配的字符串：");
        Scanner scan=new Scanner(System.in);
        String temp=scan.nextLine();
        char[] str=temp.toCharArray();
        System.out.print("输入正则表达式：");
        String temp1=scan.nextLine();
        char[] pattern=temp1.toCharArray();
        if(match(str,pattern)){
            System.out.print("字符匹配");
        }
        else{
            System.out.print("字符不匹配");
        }
    }
}
