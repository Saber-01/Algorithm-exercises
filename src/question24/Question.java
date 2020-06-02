package question24;
import DataStructure.ListNode;
public class Question {
    public static ListNode reverseList(ListNode head){
        if(head==null){
            System.out.print("输入的链表为空");
            return  null;
        }
        ListNode curPoint=head;//遍历的当前节点
        ListNode prePoint=null;//遍历的前一个节点，用于赋值next
        ListNode nextPoint=head;//当前节点之后的节点，为了不让反转过程，丢失下一个节点。
        while(curPoint!=null){
            nextPoint=curPoint.next;//先将下个节点的位置保存
            curPoint.next=prePoint;//对当前节点next进行转向。
            prePoint=curPoint;//移动pre指针。
            curPoint=nextPoint;//移动当前指针。
        }
        head=prePoint;
        return  head;
    }
    public static ListNode recursion(ListNode head){
        if(head==null){
            System.out.print("输入的链表为空");
            return  null;
        }
         return  recursionCore(head);
    }
    public static ListNode recursionCore(ListNode head){
        if(head.next==null){//只有1个节点。
            return head;
        }
        ListNode result=recursionCore(head.next);//假设后面n-1是已经是翻转好的，那么增加一个新的节点以后。
        head.next.next=head;//只需要将后面翻转后的第一个节点的下一个节点成员赋值为这个当前节点head.
        head.next=null;//因为要为后面新节点服务，所以每一步都要把null尾巴加上，使其成为一个新的翻转好的n个节点队列，方便n+1节点的操作。
        return result;
    }
    public static void printListNode(ListNode head){
        while(head!=null){
            System.out.print(" "+head.value);
            head=head.next;
        }
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        //ListNode result=reverseList(head);
        ListNode result2=recursion(head);
        printListNode(result2);
       // printListNode(result);
    }
}
