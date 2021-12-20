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
// Leetcode problem #124
class Solution {
    // O(N). Faster than 100%.
    int maxSum = 0;
    public int diameterOfBinaryTree(TreeNode root) {        
      return Math.max(helper(root) - 1,maxSum);  // reduce 1 cuz root also returns 1 anticipating an edge above.
    }
    
    public int helper(TreeNode root)
    {
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right;
        if(maxSum < sum)
            maxSum = sum;
        return Math.max(left, right) + 1; // return 1 since the node invoking this call is not null.
    }    
}
