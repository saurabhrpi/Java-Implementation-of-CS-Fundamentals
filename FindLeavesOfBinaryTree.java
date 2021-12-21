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
// LeetCode problem : 366
class Solution {
    // O(N). Faster than 100%. When removal of leaves is not allowed :
    public List<List<Integer>> findLeaves(TreeNode root) {
         List<List<Integer>> result = new LinkedList<>();
         result.add(new LinkedList<Integer>());   
         dfs(root, result);
         return result;
    }
    
    public int dfs(TreeNode root, List<List<Integer>> result)
    {
        if(root == null)
            return -1;        
         int leftsDistFromLeaf = dfs(root.left, result) + 1;
         int rightsDistFromLeaf = dfs(root.right, result) + 1;        
         int distFromLeaf = Math.max(leftsDistFromLeaf, rightsDistFromLeaf);
         if(result.size() <= distFromLeaf)
            result.add(new LinkedList<>());
         result.get(distFromLeaf).add(root.val);
         return distFromLeaf;        
    }
    
    /*
    // When removal of leaves from the tree is allowed : O((log(N))^2). Faster than N.
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();            
        List<Integer> leaves = new ArrayList<>();            
        while(toProcessNodes(root, leaves) != 0) // always pass root
        {      
            result.add(leaves);
            leaves = new ArrayList<>();
        }        
        result.add(leaves);
        return result;
    }
    
    public int toProcessNodes(TreeNode root, List<Integer> leaves)
    {
        if(root == null)
            return -1; // no question of processing since we're a null node.
        int left = toProcessNodes(root.left, leaves);
        int right = toProcessNodes(root.right, leaves);
        if(left == -1 && right == -1)
        {            
            leaves.add(root.val);
            return 0; // nothing more to process.            
        }
        if(left == 0)
        {            
            root.left = null;
        }            
        if(right == 0)
        {         
            root.right = null;
        }                    
        return 1; // atleast 1 remains to be processed which is this node.
    }
    */
}
