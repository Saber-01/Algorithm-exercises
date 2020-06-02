package question41;

import java.util.PriorityQueue;
import java.util.Comparator;
public class DynamicArray {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b-a;
        }
    });
    public void Insert(Integer value){
        if(((minHeap.size()+maxHeap.size())&1) == 0){//当数据流个数是偶数时，将下一个数放入到右边的最小堆，
            if(!maxHeap.isEmpty()&&maxHeap.peek()>value){//加入时，如果这个值比左边最大堆的最大值要小，说明，需要调整。
                int maxNumber=maxHeap.poll();//左边最大堆弹出最大的元素。
                maxHeap.offer(value);//将当前值加入到左边最大堆
                minHeap.offer(maxNumber);//将保存的左边的最大值存入右边的最小堆。
            }
            else
                minHeap.offer(value);//如果左边为空，或者左边最大堆所有数都比这个值小，那么直接加入到最小堆即可。
        }
        else{//如果是奇数个，则下一个加入到左边最大堆,要保证加入到最大堆的值肯定比右边的最小堆的值都要小。
            if(!minHeap.isEmpty()&&minHeap.peek()<value){
                int minNumber=minHeap.poll();
                minHeap.offer(value);//把最小值弹出后，放入当前值，确保加入到左边的是右边中的最小值。
                maxHeap.offer(minNumber);
            }
            else
                maxHeap.offer(value);
        }
    }

    public Double GetMedian(){
        if(minHeap.size()+maxHeap.size()==0){
            throw new RuntimeException();
        }
        double median;
        if(((minHeap.size()+maxHeap.size())&1)==0){//偶数
            median=(maxHeap.peek()+minHeap.peek())/2.0;
        }
        else
            median= minHeap.peek();
        return  median;
    }
}
