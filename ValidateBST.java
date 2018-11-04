import java.lang.*;
import java.util.*;

class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int data)
    {
        this.data = data;
    }
}

public class ValidateBST{
    
    Integer val;
    
    // in place
    public boolean isBSTInOrderTrav(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        
        if(!isBSTInOrderTrav(root.left))
        {
            return false;
        }
        
        if(val != null && root.data <= val)
        {
            return false;
        }
        
        val = root.data;
        
        if(!isBSTInOrderTrav(root.right))
        {
            return false;
        }
        
        return true;
    }
    
    public boolean isBSTRecHelper(TreeNode root)
    {
        return isBSTRec(root, null, null);
    }
    
    public boolean isBSTRec(TreeNode root, Integer min, Integer max)
    {
        if(root == null)
        {
            return true;
        }
        
        if(!isBSTRec(root.left, min, root.data) || !isBSTRec(root.right, root.data, max))
        {
            return false;
        }
        
        if(min != null && root.data < min || max != null && root.data > max)
        {
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(148);
        root.right = new TreeNode(1780);
        
        TreeNode root2 = root.left;
        root2.left = new TreeNode(100);
        root2.right = new TreeNode(200);
        
        TreeNode root3 = root.right;
        root3.left = new TreeNode(1100);
        root3.right = new TreeNode(2000);
        
        TreeNode root4 = root2.right;
        root4.left = new TreeNode(150);
        
        TreeNode root5 = root4.left;
        root5.right = new TreeNode(190);
        
        TreeNode root6 = root3.left;
        root6.left = new TreeNode(1050);
        
        TreeNode root7 = root6.left;
        root7.right = new TreeNode(1781);
        
        root6.right = new TreeNode(1779);
        
        //Tree t = new Tree();
        
        //t.printTree(root, 0);
        
        ValidateBST vb = new ValidateBST();
        
        if(vb.isBSTRecHelper(root))
        {
            System.out.println("is BST");
        }
        else
        {
            System.out.println("is not BST");
        }
    }

}
