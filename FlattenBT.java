import java.util.*;
import java.lang.*;

class TreeNode 
{
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data)
    {
        this.data = data;
    }
}

public class FlattenBT{
    
    private TreeNode prev = null;
    
    public void flatten(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        while(root != null)
        {
            if(root.left != null)
            {
                TreeNode left = root.left;
                while(left.right != null)
                {
                    left = left.right;
                }
                left.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(148);
        root.right = new TreeNode(1780);
        
        TreeNode root2 = root.left;
        root2.left = new TreeNode(100);
        root2.right = new TreeNode(200);
        
        (new FlattenBT()).flatten(root);
        
        TreeNode temp = root; 
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.right;
        }
    }
}
