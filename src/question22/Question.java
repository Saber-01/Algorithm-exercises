package question22;
import DataStructure.ListNode;

import java.util.Scanner;
//这类题目。在一个指针不能解决问题时候，可以考虑在遍历的时候使用2个指针。
//通过每一次遍历，让指针移动的规律不同，然后通过遍历过程中两个指针的关系变化，判断是否已经达到我们想要的结果。
public class Question {
    public static int printTheKthOfTail(ListNode head,int k){
        if(head==null||k<=0){
            System.out.print("输入的链表或K有误");
            return 0;
        }
        ListNode curPoint=head;//定义一个当前指针用于遍历到末尾
        ListNode prePoint=head;//定义一个在当前指针位置前K-1个位置的指针，用于返回倒数第K个值。
        for(int i=1;i<k;i++){//注意i从1 开始数，数到k-1,因为，pre和cur只相差k-1个位置。注意这个循环有可能链表节点数不够K个的情况。
            if(curPoint.next!=null)//未到末尾。
                curPoint=curPoint.next;
            else
            {
                System.out.print("链表不够K个数");
                return 0;//如果已经实现到末尾，则提前退出
            }
        }
        while(curPoint.next!=null){
            curPoint=curPoint.next;
            prePoint=prePoint.next;
        }
        return prePoint.value;
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        System.out.print("输入倒数位置K");
        Scanner scan=new Scanner(System.in);
        int k=0;
        if(scan.hasNextInt()){
            k=scan.nextInt();
        }
        else{
            System.out.print("输入的K有误");
        }
        System.out.print("输出链表的倒数第K个节点值为："+printTheKthOfTail(head,k));
    }
}
