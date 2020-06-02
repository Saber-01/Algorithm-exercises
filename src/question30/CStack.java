package question30;

import java.util.Stack;

public class CStack<T extends Comparable> {
    private Stack<T> Stack1=new Stack<T>();//正常存放的栈
    private Stack<T> Stack2=new Stack<T>();//辅助栈，存放最小值
    public T pop(){
        try{
            if(Stack1.empty())//如果为空，不能弹出，
                throw new Exception();
            //需要维护两个栈。
            T value=Stack1.pop();
            Stack2.pop();
            return value;
        }catch (Exception e){
            System.out.print("栈为空，不能弹出");
            return null;
        }
    }
    public void push(T value){//两个栈都要存入，只是辅助栈存入的是这个值和已经在栈中的元素的最小值，这样保证了每次弹出弹入，栈的状态和辅助栈栈顶元素一一对应。即辅助栈栈顶存的是这个栈状态的最小值
        //同样维护两个栈
        Stack1.push(value);
        if(Stack2.empty())//如果为空，则第一个进去的就是最小值
            Stack2.push(value);
        else{//不为空时
            T minNumber=Stack2.peek();//获得上一状态的最小值保存，不弹出，用于比较
            if(minNumber.compareTo(value)<0){//弹入的值大于最小值，则最小值不变
                Stack2.push(minNumber);//如果最小值不变，则还是弹入最小值
            }
            else{//如果最小值更新了
                Stack2.push(value);//这时弹入最新弹入的值。
            }
        }
    }
    public T min(){
        try{
            return  Stack2.peek();//返回辅助栈顶的元素、
        }
        catch (Exception e){
            System.out.print("栈为空");
            return null;
        }
    }
}
