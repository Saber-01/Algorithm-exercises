package question18;
import DataStructure.ListNode;

import java.util.List;

public class Question {
    public static ListNode deleteNode(ListNode head,ListNode delete){
        if(head==null||delete==null){
            System.out.print("输入节点错误");
            return null;
        }
        else if(delete.next!=null){//如果不是尾节点。
            delete.value=delete.next.value;
            delete.next=delete.next.next;
        }
        else if(head==delete){//既是头结点，又是尾结点，说明只有一个节点。
            head=null;//直接头结点为空
        }
        else{//不止一个节点，而且删除的是尾结点。
            ListNode curNode=head;
            while(curNode.next!=delete){
                curNode=curNode.next;
            }
            curNode.next=null;
        }
        return head;
    }
    public static void printListByNode(ListNode head){
        while(head!=null){
            System.out.print(head.value+" ");
            head=head.next;
        }
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode delete=head;
        printListByNode(deleteNode(head,delete));
    }
}
