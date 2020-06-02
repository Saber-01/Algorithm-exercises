package question31;

import java.util.Scanner;
import java.util.Stack;

public class Question {
    //第一个序列是栈的压入顺序，则容易想到使用栈去按照这个第一个序列压入序列中值，同时要注意根据第二个序列，进行弹出
    //首先，分析弹出序列的第一个值a，a只可能是压入再弹出，因为此时栈还是空的，所以我们要一直按第一个序列进行压入，如果全压入完都没a，就返回false，
    //如果遇到了a，则压入a后，进行弹出，这时，第一个序列需要一个指针记录下一个压入的是哪个值，即现在是指向a后面一个位置，第二个序列要有个指针记录匹配到哪个位置，此时指向a后面一个位置
    //分析第二个序列b.可以发现，他只能有两种情况，第一是从第一个序列中继续压直到遇到b，第二种则是此时栈顶元素刚好是b，才能进行弹出。
    //理清这个思路，可以发现第二个序列中每一个值都只可能是两种情况。
    //终止条件是，在第二个序列中匹配到的值刚好不满足2种，则返回false，
    public static boolean isPopOrder(int[] pushOrder,int[] popOrder){
        if((pushOrder==null||pushOrder.length==0)&&(popOrder==null||popOrder.length==0))
            return false;
        if(pushOrder.length!=popOrder.length)//弹出和压入个数都不一样，说明肯定错。
            return false;
        int pushPoint=0;//上面分析中提到的，记录下一个压入的是什么值。
        int popPoint=0;//记录下一个匹配弹出的是什么值。
        Stack<Integer> stack=new Stack<>();//额外的辅助栈，用于模拟压入和压出。
        while(popPoint<popOrder.length){//只要没有匹配到末尾，就继续进行
            if(stack.empty()||stack.peek()!=popOrder[popPoint]){//如果栈中没元素或者栈顶元素不是这个值，则第二种情况栈顶元素为第二序列刚好匹配的字符就不满足，只能第一种去按压入序列压入直到遇到这个元素。
                for(;pushPoint<pushOrder.length;pushPoint++){//从下一个压入的指针开始，压入一个就移动一个。
                    stack.push(pushOrder[pushPoint]);//每一次遍历都进行压入。
                    if(pushOrder[pushPoint]==popOrder[popPoint]){//如果遇到第一个序列中和当前匹配的值，就停下,否则直到循环到末尾。
                        pushPoint++;//此时pushOrder为加1，因为break,会导致未+1;
                        break;
                    }
                }
                if(stack.peek()!=popOrder[popPoint]){//如果是遍历到最后都没找到匹配的，则放回false;
                    return  false;
                }
                else{//如果遇到了
                    stack.pop();//则进行弹出
                    popPoint++;
                }
            }
            else{//栈顶元素是这个值时，
                stack.pop();//弹出栈顶元素。
                popPoint++;//匹配的弹出指针往下移动一位，进行下一次判断
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("输入整数序列代表栈的压入顺序，整数不重复，逗号隔开，换行结束");
        Scanner scan=new Scanner(System.in);
        String temp=scan.nextLine();
        String[] str=temp.trim().split(",");
        int[] pushOrder=new int[str.length];
        try{
            for(int i=0;i<pushOrder.length;i++){
                pushOrder[i]=Integer.parseInt(str[i]);
            }
        }catch (Exception e){
            System.out.print("输入的序列出错");
            pushOrder=null;
            return;
        }
        System.out.println("输入整数序列代表栈的压出顺序，整数不重复，逗号隔开，换行结束");
        String temp1=scan.nextLine();
        String[] str1=temp1.trim().split(",");
        int[] popOrder=new int[str1.length];
        try{
            for(int i=0;i<popOrder.length;i++){
                popOrder[i]=Integer.parseInt(str1[i]);
            }
        }catch (Exception e){
            System.out.print("输入的序列出错");
            popOrder=null;
            return;
        }
        if(isPopOrder(pushOrder,popOrder)){
            System.out.print("弹出序列是栈的弹出顺序");
        }
        else
            System.out.print("弹出序列不是栈的弹出顺序");
    }
}
