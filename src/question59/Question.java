package question59;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Question {
    //时刻维护一个双向队列的左边头部一直是保存窗口中最大值的索引。
    //因此没滑动一个数，即每次遍历下一个数，
    //首先判断滑动后，队列中最大值是否被移动出窗口，即判断左边头部存储的索引是否大于i-size，
    //若小于等于，即被移出，则将队列左头部pollFirst，
    //接着要判断遍历到的array[i]在队列中存储的索引对应的数中，是否最大。
    //从队尾开始判断，将对应值小于这个遍历到的当前数的索引移出队列，进行pollLast，因为他们肯定在后面的滑动过程不需要。
    //全部移出小于的当前索引后，将这个值放入到右边队列尾部，即offerLast;
    //这样就保证了窗口移动过程中，队列左首部一直保存窗口最大值的索引。
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (num == null || num.length == 0 || size == 0) {
            return res;
        }
        Deque<Integer> deque = new LinkedList<Integer>();//注意保存的是数组的索引
        for (int i = 0; i < num.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - size)
                deque.pollFirst();
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i])
                deque.pollLast();
            deque.offerLast(i);
            if (i + 1 >= size) {
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] array = new int[] {2,3,4,2,6,2,5,1};
        int size = 3;
        ArrayList<Integer> a = maxInWindows(array,size);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i)+" ");
        }
    }
}
