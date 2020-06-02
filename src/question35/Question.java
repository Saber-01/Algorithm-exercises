package question35;

public class Question {
    //思考，先创建根节点的复制体head1;则head的遍历过程中，将head1一起遍历，就可以实现，next的复制，
    //而sibling的复制，可以根据head的遍历过程遇到sibling不为null的情况下，寻找curNode.sibling需要从head开始遍历
    //假设遍历了n步，则复制的链表从head1也要遍历n步，最后将这个节点赋值到curNode1.sibling中，这样时间效率非常低。
    //我们可以额外开辟一个空间，将<curNode,curNode1>的配对信息存到一个哈希表中，当遍历head时，遇到sibling指向的节点时
    //直接从哈希表中找到这个节点对应的复制链表中的值进行赋值就可以。但这样我们就需要额外的空间才存放配对信息。
    //因此，考虑主要是因为sibling的存在，sibling的随机性，导致需要从头开始遍历才能在复制链表中找到这个值。
    //但是原链表中是存放了sibling存放的节点的，加入我们将复制链表的对应点，就放在head中点的后边，即curNode.next=curNode1
    //这样处理sibling，时候，我们只要将2个点都取next，就可以在赋值链表中将sibling都处理完毕。
    //这样，我们便可以分三步骤实现，首先，head中每一个节点都复制一个节点放在自身后面，并且保证链表还是连接的。
    //第二步，即处理sibling，遇到对应的的sibling关系，将2个对应点的next存的复制链表中对应点进行连接。
    //第三步，在连接的链表中，奇数点为原链表，偶数点为复制链表，进行拆分即可。
    public  static ComplexListNode Clone(ComplexListNode head){
        if(head==null){
            System.out.println("输入的复杂链表为空");
            return null;
        }
         ComplexListNode result=CloneNodes(head);//复制表节点， 并放在对应点之后
         head=ConectSiblingNodes(head);//处理sibling关系。
         head=ReconnectNodes(head);//重新断开连接，抽取复制链表
         return  head;
    }
    public static ComplexListNode CloneNodes(ComplexListNode head){
        ComplexListNode curNode=head;
        while(curNode!=null){
            ComplexListNode temp=curNode.next;//把下一个节点存起来
            ComplexListNode headClone=new ComplexListNode(curNode.val);//创建克隆体。
            headClone.next=temp;
            curNode.next=headClone;
            curNode=temp;//移动到原链表的下一个。
        }
        return head;
    }
    public static ComplexListNode ConectSiblingNodes(ComplexListNode head){
        ComplexListNode curNode=head;
        while (curNode!=null){//需要每隔一个遍历，才可以遍历到原链表的值。
            if(curNode.sibling!=null){//只需要处理不为空的sibling
                curNode.next.sibling=curNode.sibling.next;//对应的复制链表中的点进行连接。
            }
            curNode=curNode.next.next;//移动两格。
        }
        return  head;
    }
    public static ComplexListNode ReconnectNodes(ComplexListNode head){
        ComplexListNode headClone=head.next;//复制链表的头结点在原链表头结点之后。
        ComplexListNode curNodeClone=headClone;//复制链表的当前遍历点，
        ComplexListNode curNode=head;//用于遍历
        while (curNode.next.next!=null){
            curNode.next=curNodeClone.next;//跳一格赋值
            curNode=curNode.next;//当前指针跳到下一个奇数点
            curNodeClone.next=curNode.next;//赋值链表的偶数点的下一个节点应该是下一个源节点的后面偶数节点。
            curNodeClone=curNodeClone.next;//移动复制链表的节点。
        }
        return  headClone;
    }
    public static void  print(ComplexListNode head){
        ComplexListNode curNode=head;
        System.out.println("链表中值顺序为：");
        while(curNode!=null){
            System.out.print(" "+curNode.val);
            curNode=curNode.next;
        }
        System.out.println();
        System.out.println("链表的sibling关系有");
        while(head!=null){
            if(head.sibling!=null){
                System.out.println("节点"+head.val+"的sibling为"+head.sibling.val);
            }
            head=head.next;
        }
    }
    public static void main(String[] args){
        ComplexListNode head=new ComplexListNode(1);
        head.next=new ComplexListNode(2);
        head.next.next=new ComplexListNode(3);
        head.next.next.next=new ComplexListNode(4);
        head.next.next.next.next=new ComplexListNode(5);
        head.sibling=head.next.next;
        head.next.sibling=head.next.next.next.next;
        head.next.next.next.sibling=head.next;
        head.next.next.next.next.sibling=head.next;
        ComplexListNode head1=Clone(head);
        print(head1);
    }
}
