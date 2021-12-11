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
    Integer biggestFixedPathVal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {        
        int max = helper(root);        
        return Math.max(max,biggestFixedPathVal);      
    }    
    
    public Integer helper(TreeNode root)
    {
        if(root == null)
            return null;        
        Integer lSum = helper(root.left); 
        Integer rSum = helper(root.right); 
        int val = root.val;
        int max = val;
        if(lSum != null && rSum != null)
        {
           max = Math.max(val, Math.max(val + lSum, val + rSum));                         
           if(lSum > max && lSum > biggestFixedPathVal)
               biggestFixedPathVal = lSum;
            if(rSum > max && rSum > biggestFixedPathVal)
                biggestFixedPathVal = rSum;
           if(val + rSum + lSum > max && val + rSum + lSum > biggestFixedPathVal)
           {          
               biggestFixedPathVal = val + rSum + lSum;
           }               
        }                                
        else if(lSum != null )
        {
            max = Math.max(val,  val + lSum);
            if(lSum > max && lSum > biggestFixedPathVal)
                biggestFixedPathVal = lSum;
        }            
        else if(rSum != null )
        {
            max = Math.max(val, val + rSum);   
            if(rSum > max && rSum > biggestFixedPathVal)
                biggestFixedPathVal = rSum;
        }     
        return max;
    }
}
