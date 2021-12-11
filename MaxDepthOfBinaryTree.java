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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return maxDepth(root, 0);            
    }
    
    public int maxDepth(TreeNode root, int height)
    {
        if(root == null)
            return 0;
        height++;
        int lHeight = maxDepth(root.left, height);
        int rHeight = maxDepth(root.right, height);
        return Math.max(height, Math.max(lHeight, rHeight));
    }
}
