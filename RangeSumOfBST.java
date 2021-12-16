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
    // *** Implementation using class level variable. Faster than 100%.
    Integer sum;
    public int rangeSumBST(TreeNode root, int low, int high) {            
        sum = 0;        
        helper(root, low, high);
        return sum;
    }
    
    public void helper(TreeNode node, int low, int high)
    {
        if(node == null)
        {
            return;
        }
        if(node.val >= low && node.val <= high)
        {
            sum += node.val;        
            helper(node.left, low, high);        
            helper(node.right, low, high);
            return; // if i dont use this, i may end up getting bigger sums than expected cuz of == sign in the if-else clauses below.
        }
        if(node.val >= high)    
        {
            helper(node.left, low, high);   
        }            
        else if(node.val <= low)    
            helper(node.right, low, high);           
    }
    
    /* // ****** Without using class level member. Faster than 100%.******        
    public int rangeSumBST(TreeNode root, int low, int high) {            
        Integer sum = 0;        
        return helper(root, low, high, sum);        
    }
    
    public Integer helper(TreeNode node, int low, int high, Integer sum)
    {
        if(node == null)
        {
            return sum;
        }
        if(node.val >= low &&  node.val <= high)
        {
            sum += node.val;                    
            sum = helper(node.left, low, high, sum);       
            sum = helper(node.right, low, high, sum);            
            return sum;
        }
        if(node.val >= high)    
        {
            sum = helper(node.left, low, high, sum);   
        }            
        else if(node.val <= low)    
             sum = helper(node.right, low, high, sum);   
        return sum;
    }
    */
}
