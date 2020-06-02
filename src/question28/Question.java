package question28;
import DataStructure.BinaryTreeNode;
public class Question {
    public static boolean isSymmetrical(BinaryTreeNode root){
        //定义一个对应于前序遍历相对应的对称前序遍历方式，即先遍历根节点，再遍历右子节点，最后遍历左子节点。
        //可以发现对称的树，会具有相同的前序遍历序列和对称前序遍历序列。
        //特殊的全部值相等的树，因为遍历的序列都相同，但是有可能形状不是对称的，这时候需要额外考虑左右子节点null的情况。
        //需要同时进行两种遍历方法，并且使得遍历到的每个节点值对应，如果是null,则两种遍历都应该遇到null，否则就返回false
        //两种同时遍历比较，所以需要2个节点类型参数，因为这两个参数在遍历的时候并不相同。所以需要额外定义一个有2个节点参数的子函数。
        if(root==null){
            System.out.print("该树为空，默认对称");
            return  true;
        }
        else
            return isSymmetricalCore( root, root);//初始都从根节点开始。
    }
    public static boolean isSymmetricalCore(BinaryTreeNode root1,BinaryTreeNode root2){
        if(root1==null&&root2==null)//两个都遇到null，说明还是对称的
            return true;
        if(root1==null||root2==null)//如果只有1个遇到了null，说明不对称。（这个判断条件已经是在2个都不为null的前提下。）
            return  false;
        if(root1.val!=root2.val)//如果2个都不为空，且他们的值不相同，则肯定不对称。 前序遍历和对称前序遍历，都要先判断根节点的值，这一步判断其实就是先遍历根节点。
            return false;
        return isSymmetricalCore(root1.left,root2.right)&&isSymmetricalCore(root1.right,root2.left);//前序遍历中先判断左子节点，前序对称遍历先判断右子节点，最后的判断前序传入右子节点，对称传入左子节点。
    }
    public static void main(String[] args){
        BinaryTreeNode symmetricRoot=new BinaryTreeNode(8);
        symmetricRoot.left=new BinaryTreeNode(6);
        symmetricRoot.right=new BinaryTreeNode(6);
        symmetricRoot.left.left=new BinaryTreeNode(5);
        symmetricRoot.left.right=new BinaryTreeNode(7);
        symmetricRoot.right.left=new BinaryTreeNode(7);
        symmetricRoot.right.right=new BinaryTreeNode(5);
        BinaryTreeNode notSymmetricRoot=new BinaryTreeNode(8);
        notSymmetricRoot.left=new BinaryTreeNode(6);
        notSymmetricRoot.right=new BinaryTreeNode(9);
        notSymmetricRoot.left.left=new BinaryTreeNode(5);
        notSymmetricRoot.left.right=new BinaryTreeNode(7);
        notSymmetricRoot.right.left=new BinaryTreeNode(7);
        notSymmetricRoot.right.right=new BinaryTreeNode(5);
        BinaryTreeNode equalButNotSymmetricRoot=new BinaryTreeNode(7);
        equalButNotSymmetricRoot.left=new BinaryTreeNode(7);
        equalButNotSymmetricRoot.right=new BinaryTreeNode(7);
        equalButNotSymmetricRoot.left.left=new BinaryTreeNode(7);
        equalButNotSymmetricRoot.left.right=new BinaryTreeNode(7);
        equalButNotSymmetricRoot.right.left=new BinaryTreeNode(7);//少一个节点。
        if(isSymmetrical(symmetricRoot)){
            System.out.println("第一颗树是对称的");
        }
        else{
            System.out.println("第一颗树不是对称的");
        }
        if(isSymmetrical(notSymmetricRoot)){
            System.out.println("第二颗树是对称的");
        }
        else{
            System.out.println("第二颗树不是对称的");
        }
        if(isSymmetrical(equalButNotSymmetricRoot)){
            System.out.println("第三颗树是对称的");
        }
        else{
            System.out.println("第三颗树不是对称的");
        }
    }
}
