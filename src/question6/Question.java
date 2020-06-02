package question6;


import java.util.Scanner;
import java.util.Stack;

public class Question {
    public static void backPrint(Node head){
        Stack s=new Stack();
        //遍历链表，每次把点放入堆栈。
        Node cur=head;
        while(cur!=null){
            s.push(cur.value);
            cur=cur.next;
        }
        while(!s.empty())
        {
            System.out.print(s.pop());
        }
    }
    public static void  backPrint2(Node head){
        if(head.next!=null)
        {
            backPrint2(head.next);
        }
        System.out.print(head.value);
    }
    public static void main(String[] args){
        System.out.print("输入链表的节点值（为整数），两节点用空格隔开，enter 结束");
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        String[] strArray=str.trim().split(" ");
        Node head=new Node(Integer.parseInt(strArray[0]),null);//定义头结点
        Node curNode=head;//定义当前节点，用于链表的赋值。初始为head
        for(int i=1;i<strArray.length;i++){//链表赋值
            Node n=new Node(Integer.parseInt(strArray[i]),null);
            curNode.next=n;
            curNode=curNode.next;
        }
        backPrint(head);
        backPrint2(head);
    }
}
