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
// Leetcode problem #103.
class Solution {
    
    // O(N). Faster than 77%
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)
            return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOdd = false;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            Deque<Integer> d = new LinkedList<>();            
            for(int i = 0 ; i < size; i++)
            {
                TreeNode n = queue.poll();                
                if(!isOdd)
                    d.offer(n.val);
                else
                    d.addFirst(n.val);
                if(n.left != null)
                    queue.offer(n.left);
                if(n.right != null)
                    queue.offer(n.right);
            }            
            result.add(d);
            isOdd = !isOdd;
        }
        return result;
    }    
}
