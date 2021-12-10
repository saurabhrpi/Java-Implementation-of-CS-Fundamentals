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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<>();
        TreeNode temp = root;
        List<TreeNode> nodes = new ArrayList();
        List<Integer> vals = new ArrayList();
        nodes.add(temp);        
        List<TreeNode> l = new ArrayList<>();
        while(nodes.size() > 0)
        {               
            for(int i = 0; i < nodes.size(); i++)
            {                
                if(nodes.get(i) != null)
                {
                    if(nodes.get(i).left != null)
                        l.add(nodes.get(i).left);
                    if(nodes.get(i).right != null)
                        l.add(nodes.get(i).right);   
                    vals.add(nodes.get(i).val);            
                }            
            }
            if(vals.size() > 0)
            {
                result.add(vals);
                vals = new ArrayList<>();
            }                
            nodes = new ArrayList<>(l); // nodes now point to TreeNodes of next level
            l = new ArrayList<>();
        }
        return result;
    }
}
