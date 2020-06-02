package question23;
import  DataStructure.ListNode;
public class Question {
    public static ListNode entranceOfRing(ListNode head){
        //首先要确定链表是否存在环，通过两个指针，同起点，一个指针走快点，另一个走慢点，速度差距1格(这样不会存在越过的情况)
        //如果两个环相遇，则存在环，并且相遇的点一定在环内部。
        if(head==null){
            System.out.print("链表为空");
            return null;
        }
        ListNode curPoint=head;//初始两指针同起点。
        ListNode prePoint=head;
        boolean haveRing=false;
        while(curPoint.next!=null&&curPoint.next.next!=null){//如果没到末尾或倒数第二个点。就继续遍历。
            curPoint=curPoint.next.next;//移动2格
            prePoint=prePoint.next;//移动一格
            if(curPoint==prePoint){//如果相遇,则有环，并打断循环。
                haveRing=true;
                break;
            }
        }
        if(!haveRing){//如果没环
            System.out.print("输入的链表没有环");
            return null;
        }
        //确定有环以后，要确定环含有几个节点。因为当前节点在环里，所以可以继续移动curpoint，知道再次相遇这个节点。看移动了几次就是节点数
        int count=0;//初始个数为0
        while(1==1){
            curPoint=curPoint.next;
            count++;
            if(curPoint==prePoint){//再次相遇时候，打断循环。
                break;
            }
        }
        //知道环有n个节点后，只要定义两个节点，让它们初始相距n-1距离，则同速移动，直到下次两次相遇就是环的起点。
        prePoint=curPoint=head;
        for(int i=1;i<=count;i++){//让他们相距count-1个距离，则第一个点要移动count个距离，所以去小于等于。
            curPoint=curPoint.next;
        }
        while(curPoint!=prePoint){//相等即相遇
            curPoint=curPoint.next;
            prePoint=prePoint.next;
        }
        return curPoint;
    }
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next=head.next.next;//设置环
        ListNode point=entranceOfRing(head);
        if(point!=null)
        System.out.print("环的入口点值为："+point.value);
    }
}
