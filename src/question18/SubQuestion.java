package question18;
import DataStructure.ListNode;
public class SubQuestion {
    public static void printListNode(ListNode head){
        if(head==null){
            System.out.print("链表为空");
        }
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }
    }
    public static ListNode DeleteDuplication(ListNode head){
        if(head==null){
            System.out.print("输入的链表为空");
            return null;
        }
        else {
            ListNode curNode = head;//定义当前遍历节点从头结点开始。
            ListNode preNode = null;//定义一个当前节点的前一节点，用于赋值使得删除后的链表还是连续的。
            while (curNode!=null&&curNode.next != null) {//遍历到倒数第二个节点，因为倒数第一个节点没有后面节点不需要考虑。
                if (curNode.value==curNode.next.value){//遇到相等了,就要判断后面的还有没有相等的。
                    int value=curNode.value;//把这个值记录下来用于后面的比较
                    while(curNode!=null&&curNode.value==value){
                        curNode=curNode.next;
                    }
                    if(preNode==null){//如果头结点就开始重复了，应该做的是重新赋值head
                        head=curNode;
                    }
                    else{//如果是后面遇到的重复。直接赋值preNode就行了
                        preNode.next=curNode;
                    }
                }
                else{//没有遇到相等,preNode和curNode就都往后移动一位。
                    preNode=curNode;
                    curNode=curNode.next;
                }
            }
            return head;
        }
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(4);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(4);

        printListNode(DeleteDuplication(head));
    }
}
