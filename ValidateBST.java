import java.util.*;
import java.lang.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
}

public class ValidateBST{
    
    // Assuming distinct values at each node of tree
    // In order traversal
    
    int index = 0;
    
    public boolean validate(TreeNode root, int size)
    {
        int[] array = new int[size];
        copyArray(root, array);
        
        for(int i=0; i < array.length - 1; i++)
        {
            if(array[i] > array[i + 1])
            {
                return false;
            }
        }
        return true;
    }
    
    public void copyArray(TreeNode root, int[] array)
    {
        if(root == null)
        {
            return;
        }
        
        copyArray(root.left, array);
        
        array[index] = root.data;
        
        index++;
        
        copyArray(root.right, array);
    }
    
    // Approach #2 : Better than above. No need of array.
    
    Integer last = null;
    
    public boolean validate(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }
        
        if(!validate(root.left))
        {
            return false;
        }
        else if(root.data < last)
        {
            return false;
        }
        
        last = root.data;
        
        if(!validate(root.right))
        {
            return false;
        }
        
        return true;
    }
    
    // Approach #3 : 
    
    // We do not have min and max for root since root alone is always a BST.
    // Thumb rule : If branching left, update max. If branching right, update min.
    // O(N) time, O(logN) space
    
    
    public boolean checkBST(TreeNode root)
    {
        return checkBST(root, null, null);
    }
    
    public boolean checkBST(TreeNode root, Integer min, Integer max)
    {
        if(root == null) // null is always a BST.
        {
            return true;
        }
        
        // 1st clause for right subtree, 2nd for left.
        if((min != null && root.data <= min) || (max != null && root.data > max))
        {
            return false;
        }
        
        if(!checkBST(root.left,min, root.data) || !checkBST(root.right, root.data, max))
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
