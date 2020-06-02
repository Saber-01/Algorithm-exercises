package question37;

import DataStructure.BinaryTreeNode;
import question32.Sub1Question;
import question32.Sub1Question.*;
public class Question {
    //为了使的反序列化唯一且在输入第一个字符串时候就可以开始反序列化，我们选择前序遍历，
    //并且为了满足唯一，将NULL指针也加入打遍历的序列中。
    //遇到null时，打印出$符号代替。
    public static StringBuffer Serialize(BinaryTreeNode root){
        if(root==null){
            System.out.print("树为空");
            return  null;
        }
        StringBuffer order=new StringBuffer();//用于动态添加字符。
        order=SerializeCore(root,order);
        return order;
    }
    public static StringBuffer SerializeCore(BinaryTreeNode root, StringBuffer order){
        if(root==null){//遇到当前节点为空，
            order.append('$');
            return  order;
        }
        order.append(root.val);
        order=SerializeCore(root.left,order);
        order=SerializeCore(root.right,order);
        return  order;
    }

    //反序列化。顺序读取序列值，第一个即为根节点，它的左子树的根节点为剩下序列的第一个。所以为了递归，每次处理完序列第一个节点，要删除第一个节点。
    //而当处理完当前节点的左子树时，序列剩下的序列的第一个节点正好就是右子树的根节点。满足前序遍历思想。
    //所以只要遍历的时候，维护好order就可以。同时，遍历到的时，需要把字符转换为整数，再创建节点。
    public static BinaryTreeNode Deserialize(StringBuffer order){
        if(order==null||order.length()==0){
            System.out.print("序列为空，无法重建二叉树");
            return  null;
        }
        BinaryTreeNode root=DeserializeCore(order);
        return  root;
    }
    public static BinaryTreeNode DeserializeCore(StringBuffer order){
        char c=order.charAt(0);//先存
        order.deleteCharAt(0);//遍历一个删除一个
        if(c=='$'){//遇到null转义符
            return null;
        }
        BinaryTreeNode curNode=new BinaryTreeNode(c-48);
        curNode.left=DeserializeCore(order);
        curNode.right=DeserializeCore(order);
        return  curNode;
    }

    public static void printStringBuffer(StringBuffer order){
        if(order==null)
            return;
        for(int i=0;i<order.length();i++){
            System.out.print(" "+order.charAt(i));
        }
    }
    public static void main(String[] args){
        BinaryTreeNode root =new BinaryTreeNode(1);
        root.left=new BinaryTreeNode(2);
        root.right=new BinaryTreeNode(3);
        root.left.left=new BinaryTreeNode(4);
        root.right.left=new BinaryTreeNode(5);
        root.right.right=new BinaryTreeNode(6);
        StringBuffer order=Serialize(root);
        printStringBuffer(order);
        BinaryTreeNode root1=Deserialize(order);
        System.out.println();
        Sub1Question.printFromTopToBottomLn(root1);
    }
}
