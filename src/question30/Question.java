package question30;

public class Question {
    //栈的先入先出原则，不能改变，则要考虑弹出的时候，是不是当前栈最小值，那么每一次弹出都需要找出剩下的栈中哪个元素最小，这样很麻烦
    //所以考虑在弹入的时候，每一步弹入都找出弹入后最小值，但是如果只是记录当前栈的最小值，如果弹出了这个最小值，倒二小的数是多少我们就不知道。
    //因而，我们需要保存每一步存入前的最小值，即和栈元素状态对应的辅助栈，辅助栈每一次的弹入和弹出跟随主栈。
    //使得辅助栈在压入还是弹出的时候，栈顶值，就代表着主栈经过弹出或弹入操作时候，栈中元素的最小值。
    //这样即使最小值弹出以后，我们辅助栈的栈顶元素也弹出，新的栈顶元素还是这个栈的最小值。就实现了最小值的更替。
    public static void main(String[] args){
        CStack<Integer> stack=new CStack<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        stack.pop();
        stack.pop();
        stack.push(0);
        System.out.print("栈中最小值为："+stack.min());
    }
}
