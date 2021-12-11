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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isValidBST(root, null, null);
    }
    
    public boolean isValidBST(TreeNode root, Integer lLimit, Integer uLimit)
    {
        if(root == null)
            return true;        
        if(root.left != null)
        {            
            if(root.left.val >= root.val)
                return false;
            if(lLimit != null && root.left.val <= lLimit)
                return false;
        }            
        if(root.right != null)
        {            
            if(root.right.val <= root.val)
                return false;
            if(uLimit != null && root.right.val >= uLimit)
                return false;
        }            
        if(!isValidBST(root.left, lLimit, root.val) || !isValidBST(root.right, root.val, uLimit))
            return false;
        return true;
    }
}
