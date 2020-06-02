package question25;
import DataStructure.ListNode;
public class RecursionSolution {
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(" "+head.value);
            head=head.next;
        }
    }
    //递归解法。判断玩2个链表的头节点后，将一个节点连接后，剩下的链表也是排序的，对他们的合并过程，又和之前步骤一样。
    //递归的关键就是，要思考递归算法的含义是什么。这个函数主要是做什么。这里的递归就是判断2个剩下链表的头结点哪个是下一个需要连接的节点，并且返回这个节点。
    //所以层层递归。直到遇到其中一个链表为空的情况，则将另一个链表的头结点当做下一个节点，进行返回。层层返回，最终每个节点都串联上。返回最初的第一个头结点。
    public static ListNode merge(ListNode head1,ListNode head2){
        if(head1==null)
            return  head2;
        if(head2==null)
            return  head1;
        ListNode head=new ListNode();
        if(head1.value<=head2.value){
            head=head1;//确定了这个点以后，就赋值，用于返回给上一层的next赋值。
            head.next=merge(head1.next,head2);//下一步的子问题，就是少了一个节点的链表和完整链表的问题。
        }
        else{
            head=head2;
            head.next=merge(head1,head2.next);//同上、
        }
        return  head;
    }
    public static void main(String[] args){
        ListNode head1=new ListNode(1);
        head1.next=new ListNode(3);
        head1.next.next=new ListNode(5);
        head1.next.next.next=new ListNode(7);
        ListNode head2=new ListNode(2);
        head2.next=new ListNode(4);
        head2.next.next=new ListNode(6);
        head2.next.next.next=new ListNode(8);
        ListNode head=merge(head1,head2);
        printList(head);
    }
}
