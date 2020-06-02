package question9;

public class Question {
    public static void main(String[] args){
            CQueue<Integer> queue=new CQueue<Integer>();
            //queue.deleteHead();
            queue.appendTail(3);
            queue.appendTail(2);
            queue.appendTail(1);
            queue.appendTail(0);
            Integer a =queue.deleteHead();
            System.out.print(a);
            CStack<Integer> stack1=new CStack<Integer>();
            stack1.pop();
            stack1.push(3);
            stack1.push(2);
            stack1.push(1);
            System.out.print(stack1.pop());
            System.out.print(stack1.pop());
            System.out.print(stack1.pop());
    }
}
