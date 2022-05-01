/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;                
        if(helper(root) == -1)
            return false;
        return true;
    }
    
    /*
                     1
                2          5
             3     6
          4    9
    */
    
    public int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        int height = 1; // node contributes 1 to the height which represents height of the entire tree starting with this node.        
        int lHeight = helper(root.left);
        System.out.println("returning from left of root = " + root.val + ", lHeight = " + lHeight);
        int rHeight = helper(root.right);
        System.out.println("returning from right of root = " + root.val + ", rHeight = " + rHeight);
        if(lHeight == -1 || rHeight == -1) // if any child is unbalanced, no need to calculate any further and propogate it up the tree. 
            return -1;   
        if(Math.abs(lHeight - rHeight) > 1)
        {            
            return -1;   
        }     
        System.out.print("for root = " + root.val);
        System.out.println(" From height " + height + " lHeight " + lHeight + ", rHeight " + rHeight + ", returning max of height + lHeight " + (height + lHeight) + ", and height + rHeight " + (height + rHeight));
        return Math.max(height + lHeight,height + rHeight);                         
    }   
}
