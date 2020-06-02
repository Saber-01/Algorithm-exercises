package question36;

import DataStructure.BinaryTreeNode;

public class Question {
    //分析问题，二叉搜索树的中序遍历打印出的序列即为从小到大的顺序。所以遍历思路可以参考中序遍历
    //首先从根节点分析，这个节点R先不放入链表中，因为它一般不是链表的第一个值
    //注意到最后的链表中，这个根节点的左边连接的是左子树转化后的顺序链表，而右边连接的是右子树转化后的顺序链表。
    //那么当我们中序遍历思想处理节点时，递归函数先将其左子树的序列转化完毕，为了让当前节点加入到链表中，
    //需要将当前链表的最后一个节点的next赋值为当前节点，这样左子树连接完毕，当前节点也加入到了序列当中。
    //现在当前链表的最后一个节点变为了这个根节点，而接下来只要递归遍历它的右子树，因为遍历过程节点都是往链表最后添加的
    //所以自然的右子树的链表会连接在当前链表的最后一个节点上。这样一个转化过程就结束了。
    //显然，可以发现我们递归传递的参数不仅仅是遍历到的节点， 还需要传入当前链表最后一个节点的值，方便连接。
    public static BinaryTreeNode convert(BinaryTreeNode root){
        if(root==null){
            System.out.print("输入的树为空");
            return null;
        }
        BinaryTreeNode lastListNode=null;//链表最后一个节点初始为null
        BinaryTreeNode endNode=convertCore(root,lastListNode);
        BinaryTreeNode curNode=endNode;
        while(curNode!=null&&curNode.left!=null){
            curNode=curNode.left;//往前遍历，
        }
        return  curNode;
    }
    public static BinaryTreeNode convertCore(BinaryTreeNode root,BinaryTreeNode lastListNode){
        if(root.left!=null){//有左子树
            lastListNode=convertCore(root.left,lastListNode);//最后链表点更新。为左序列转化完成的最后一个节点。
        }
        root.left=lastListNode;
        if(lastListNode!=null)//需要排除链表的第一个节点的情况。
            lastListNode.right=root;
        lastListNode=root;//链表最后一个值，在节点加入后要更新为当前。
        if(root.right!=null){//有右子树就进行递归，因为算法开始就是从传入的最后一个节点开始，所以右子树排列的链表自动会和该节点连接上。
            lastListNode=convertCore(root.right,lastListNode);
        }
        return  lastListNode;//经过左子树和节点，已经右子树处理后，当前树已经转换完毕，返回链表最后一个节点。
    }
    public static void print(BinaryTreeNode head){
        System.out.print("正序输出");
        System.out.print(" "+head.val);
        while (head.right!=null){
            System.out.print(" "+head.val);
            head=head.right;
        }
        System.out.println();
        System.out.print("倒序输出");
        while(head!=null){
            System.out.print(" "+head.val);
            head=head.left;
        }
    }
    public static void main(String[] args){
        BinaryTreeNode root=new BinaryTreeNode(10);
        root.left=new BinaryTreeNode(6);
        root.right=new BinaryTreeNode(14);
        root.left.left=new BinaryTreeNode(4);
        root.left.right=new BinaryTreeNode(8);
        root.right.left=new BinaryTreeNode(12);
        root.right.right=new BinaryTreeNode(16);
        System.out.println("排序后的双向链表为：");
        print(convert(root));
    }
}
