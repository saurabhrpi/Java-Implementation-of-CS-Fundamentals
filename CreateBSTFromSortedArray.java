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
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }
    
    // At every level we only care about creating the node for middle of the range passed.
    // This also takes care of height balancing.
    public TreeNode createBST(int[] nums, int left, int right)
    {
        // when we dont have a child node
        if(left > right)
        {
            System.out.println("returning null for left = " + left + " and right = " + right);
            return null;
        }
        
        // when we reach the leaf node             
        if(left == right)
        {
            System.out.println("returning nums[left] = " + nums[left] + " for left/right = " + left);
            return new TreeNode(nums[left]);
        }
            
        
        int mid = (left + right)/2;
        System.out.println("mid = " + mid +" for left = " + left + " and right = " + right);
        TreeNode root = new TreeNode(nums[mid]);
        System.out.println("created root node at " + nums[mid]);
        root.left = createBST(nums,left,mid - 1);
        System.out.println("returning back from left = " + (root.left == null?null :root.left.val));
        root.right = createBST(nums,mid + 1, right);
        System.out.println("returning back from right = " + (root.right == null?null :root.right.val));
        System.out.println("returning root = " + root.val);
        return root;
    }
}
