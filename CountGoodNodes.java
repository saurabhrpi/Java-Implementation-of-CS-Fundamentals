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
    // LeetCode problem #1448
    // O(N). Faster than 96%. Without using class level member.
    public int goodNodes(TreeNode root) {
        return helper(root, root.val, 0);
    }
    
    public int helper(TreeNode root, int max, int count)
    {
        if(root == null)
            return count;
        if(root.val >= max)
        {            
            max = root.val;
            count++;
        }
        count = helper(root.left, max, count);
        count = helper(root.right, max, count);
        return count;
    }
    
    /*
    // O(N). Faster than 95%. Using class level member.
    int count = 0;
    public int goodNodes(TreeNode root) {                
        helper(root, root.val);
        return count;
    }
    
    public void helper(TreeNode root, int maxTillHere)
    {
        if(root == null) 
           return;
        if(root.val >= maxTillHere)
        {
            count++;
            maxTillHere = root.val;   
        }            
        helper(root.left, maxTillHere);
        helper(root.right, maxTillHere);
    }
    */
}
