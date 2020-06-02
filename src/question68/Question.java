package question68;

import DataStructure.BinaryTreeNode;
import java.util.ArrayList;
public class Question {
    public static BinaryTreeNode getLastCommonParent(BinaryTreeNode root,BinaryTreeNode root1,BinaryTreeNode root2) {
        if (root1 == null || root2 == null || root == null) {
            return  null;
        }
        ArrayList<BinaryTreeNode> path1 = new ArrayList<>(); //因为是类，所以相当于引用传递，
        getPathOfBinaryTreeNode(root,root1,path1);
        ArrayList<BinaryTreeNode> path2 = new ArrayList<>();
        getPathOfBinaryTreeNode(root,root2,path2);//所以会得到遍历路劲。
        BinaryTreeNode result = null;
        int curPoint = 0;
        while (curPoint < path1.size() && curPoint < path2.size()) {
            if (path1.get(curPoint) == path2.get(curPoint))
                result =path1.get(curPoint);
            curPoint ++ ;
        }
        return  result;
    }
    public static boolean getPathOfBinaryTreeNode
            (BinaryTreeNode root, BinaryTreeNode node ,ArrayList<BinaryTreeNode> path) {
        boolean isFind = false; //标记是否找到
        path.add(root); //遍历一个就添加到路劲中
        if (root == node) //递归结束条件
            return true ;
        if (root.left != null)
            isFind = getPathOfBinaryTreeNode(root.left,node,path);//判断左子树中是否找到
        if (!isFind && root.right != null)
            isFind = getPathOfBinaryTreeNode(root.right,node,path); //当左子树中没找到，才遍历右子树
        if (!isFind)
            path.remove(path.size() - 1);//移除最后一个。
        return isFind;
    }
    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(0);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);
        root.left.left.left = new BinaryTreeNode(5);
        root.left.left.right = new BinaryTreeNode(6);
        root.left.right.left = new BinaryTreeNode(7);
        root.left.right.right = new BinaryTreeNode(8);
        System.out.println(getLastCommonParent(root,root.left.left.right,root.left.left.left).val);
    }
}
