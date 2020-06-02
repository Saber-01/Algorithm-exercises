package question9;

import java.util.Stack;

public class CQueue<T> {
    private Stack<T> stack1=new Stack<T>();//不new的话。类就算实例化以后，Stack还是为NULL，会报错，注意！！！
    private Stack<T> stack2=new Stack<T>();
    public  T deleteHead() {//这边需要了解异常抛出的问题。
        try {
            if (stack1.empty()) {//队列为空时
                throw new Exception();
            } else {
                while (!stack1.empty()) {
                    T temp = stack1.pop();
                    stack2.push(temp);
                }
                T result = stack2.pop();//弹出的即为栈1 的底部最后一个数，即队列中最先进的最先出的数
                while (!stack2.empty())//还原队列结构
                {
                    T temp = stack2.pop();
                    stack1.push(temp);
                }
                return result;
            }
        }
        catch (Exception e){
            System.out.print("队列为空");
            return null;
        }
    }
    public void appendTail(T a){
        stack1.push(a);
    }
}
