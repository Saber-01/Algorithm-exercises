package question22;
import DataStructure.ListNode;

public class SubQuestion {
    public static int printCenter(ListNode head){
        if(head==null){
            System.out.print("输入的链表为空");
            return 0;
        }
        ListNode curPoint= head;//定义一个遍历整个链表的节点。
        ListNode prePoint=head;//定义一个跟随移动的节点，当遍历完，将停在中间。
        while(curPoint.next!=null&&curPoint.next.next!=null){//还未到倒数第一个或第二个点。
            curPoint=curPoint.next.next;//第一个指针跳两格。
            prePoint=prePoint.next;//第二个指针跳一格。
        }
        return prePoint.value;
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        System.out.print("输出链表的中间节点值为："+printCenter(head));
    }
}
