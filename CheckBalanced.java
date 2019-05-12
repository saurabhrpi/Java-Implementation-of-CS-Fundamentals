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

public class CheckBalanced{
    
    // Naive method. It's ineffecient becoz to check if a parent is balanced,
    // it will calculate the heights of kids, return it to the parent to find if parent is balanced.
    // It could have used that info to find out whether the kids themselves were balanced too.
    // O(NLogN). Every node is touched same number of times as the level it is at. 
    // Root is touched once, its kids twice and so on.

    
    public boolean isBalancedNaive(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        
        if(Math.abs(getHeightNaive(root.right) - getHeightNaive(root.left)) > 1)
        {
            return false;   
        }
        
        return (isBalancedNaive(root.left) && isBalancedNaive(root.right));
    }
    
    public int getHeightNaive(TreeNode root)
    {
        if(root == null)
        {
            return -1; // so that root alone has height 0.
        }
        
        return Math.max(getHeightNaive(root.left), getHeightNaive(root.right)) + 1;
    }
    
    // below efficient impl takes O(N) time and O(log N) space.
    
    public boolean isBalancedEff(TreeNode root)
    {
        return (getHeightEff(root) != Integer.MIN_VALUE);
    }
    
    public int getHeightEff(TreeNode root)
    {
        if(root == null)
        {
            return -1;
        }
        
	// Post Order Traversal	

        int l = getHeightEff(root.left);
        
        if(l == Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
        
        int r = getHeightEff(root.right);
        
        if(r == Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }
        
        if(Math.abs(r - l) > 1)
        {
            return Integer.MIN_VALUE;
        }
        
        return Math.max(r, l) + 1;
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(140);
        root.right = new TreeNode(178);
        
        TreeNode root2 = root.left;
        //root2.left = new TreeNode(1400);
        root2.right = new TreeNode(1708);
        
        TreeNode root3 = root.right;
        root3.left = new TreeNode(10);
        //root3.right = new TreeNode(708);
        
        TreeNode root4 = root2.right;
        root4.left = new TreeNode(150);
        
        //Tree t = new Tree();
        
        //t.printTree(root, 0);
        
        CheckBalanced cb = new CheckBalanced();
        
        if(cb.isBalancedNaive(root))
        {
            System.out.println("is balanced");
        }
        else
        {
            System.out.println("is not balanced");
        }
    }

}

