package question25;
import DataStructure.ListNode;
public class Question {
    public static ListNode merge(ListNode head1,ListNode head2){
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;//以下的情况就只剩2个链表都非空时。
        ListNode head=new ListNode();
        if(head1.value<=head2.value){
            head=head1;
            head1=head1.next;//头结点用完以后要移动一位
        }
        else{
            head=head2;
            head2=head2.next;//头结点用完以后，要移动一位方便下次比较。
        }
        //定义头结点以后，要定义一个当前节点
        ListNode curNode=head;//初始指向我们确定好的头结点。
        while(head1!=null&&head2!=null){//如果有个链表遍历完，就停止，所以只有都不为空时循环才继续。
            if(head1.value<=head2.value){//判断出下一个节点应该在head1中。
                curNode.next=head1;//首先将当前节点下一个指向这个节点。
                curNode=curNode.next;//当前节点更新到下一个节点上去。
                head1=head1.next;//head1中这个节点被连接了，所以要移动到下一个节点进行接下来的比较。
            }
            else{//下个节点在head2中
                curNode.next=head2;
                curNode=curNode.next;
                head2=head2.next;
            }
        }
        if(head1==null){//当head1遍历玩，说明接下来只要连上head2剩下部分就行了
            curNode.next=head2;
        }
        else{//同上
            curNode.next=head1;
        }
        return  head;//返回最初定义的头结点、
    }
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(" "+head.value);
            head=head.next;
        }
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
