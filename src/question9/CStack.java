package question9;

import java.util.LinkedList;
import java.util.Queue;

public class CStack<T> {
    private Queue<T> queue1=new LinkedList<T>();
    private Queue<T> queue2=new LinkedList<T>();

    public void push(T a){
        if(!queue1.offer(a)){//offer成功返回true，满了失败返回false
            System.out.print("添加失败，栈满了");
        }
    }
    public T pop(){
        try {
            if (queue1.isEmpty()) {
                throw new Exception();
            }
            while (queue1.size()>1)//队列中不止一个数的时候
            {
                T temp = queue1.poll();
                queue2.offer(temp);
            }
            T a = queue1.poll();//将最后这个输出就是栈的最新进的数了
            while (!queue2.isEmpty())//还原
            {
                T temp = queue2.poll();
                queue1.offer(temp);
            }
            return a;
        }
        catch (Exception e)
        {
            System.out.print("栈为空");
            return null;
        }
    }

}
