package question26;
import DataStructure.BinaryTreeNode;

public class Question {
    //找到该子树的前提是，根节点相同，所以先在root1中找到root2的根节点值一样的结点。用递归遍历
    public static boolean HasSubTree(BinaryTreeNode root1,BinaryTreeNode root2){
        if(root1==null){//递归的结束是遇到了叶节点。就说明没找到。
            return  false;
        }
        if(root2==null){
            System.out.print("待判断的子树为空");
            return  false;
        }
        boolean result=false;
        if(root1.val==root2.val){//如果相等，则进行第二步具体判断。
            result= HasSubTreeCore(root1,root2);//返回具体判断的结果
        }
        if(!result){//如果这个节点不满足条件，包括值不相等和值相等但不满足第二步判断。
            result=HasSubTree(root1.left,root2);//则遍历它的左节点。将左节点当做新的子问题进行输入判断。
        }
        if(!result){//如果经过上面的左子树都没找到，则继续遍历右子树进行判断。
            result=HasSubTree(root1.right,root2);
        }
        return  result;//全部遍历后 返回结果。
    }
    //当找到和root2中根节点相同的节点时候，需要进一步判断，判断每个孩子节点是否一一对应。
    //这一步也是个递归过程，因为当节点正确时候，需要左右子树都要相同。才能判断，则可以层层往下细化，再递归。
    public static boolean HasSubTreeCore(BinaryTreeNode root1,BinaryTreeNode root2){
        boolean result=false;
        if(root2==null)//当root2没有了子节点，说明判断完毕。
            return true;
        if(root1==null)//当root2中还有子节点，但是root1中确没有，说明不符合
            return  false;
        //当两个树都还有节点时候，需要继续判断。
        if(root1.val==root2.val){//当这个节点值相同时，需要判断左右子树都满足才可以返回，
            return HasSubTreeCore(root1.left,root2.left)&&HasSubTreeCore(root1.right,root2.right);
        }
        else  //如果节点值都不相同，肯定不符合。
            return false;
    }
    public static void main(String[] args){
        BinaryTreeNode root=new BinaryTreeNode(8);
        root.left=new BinaryTreeNode(8);
        root.right=new BinaryTreeNode(7);
        root.left.left=new BinaryTreeNode(9);
        root.left.right=new BinaryTreeNode(2);
        root.left.right.left=new BinaryTreeNode(4);
        root.left.right.right=new BinaryTreeNode(7);
        BinaryTreeNode root2=new BinaryTreeNode(8);
        root2.left=new BinaryTreeNode(9);
        root2.right=new BinaryTreeNode(2);
        if(HasSubTree(root,root2)){
            System.out.print("包含该子树");
        }
        else{
            System.out.print("不包含该子树");
        }
    }
}
