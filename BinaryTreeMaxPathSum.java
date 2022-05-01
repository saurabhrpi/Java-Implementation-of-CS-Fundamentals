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
    int maxValue;
    public int maxPathSum(TreeNode root) {        
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }    
    
    // clean and concise
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        System.out.println("maxvalue set to " + maxValue);
        System.out.println("returning " + (Math.max(left, right) + node.val));
        // root can only be summed with one of the children
        return Math.max(left, right) + node.val; 
    }
}
