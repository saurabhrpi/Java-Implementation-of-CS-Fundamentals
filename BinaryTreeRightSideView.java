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
    // Best Solution. Recursive BFS. 100% faster.
    public List<Integer> rightSideView(TreeNode root) {        
        List<Integer> result = new LinkedList<>();
        helper(root, result, 0);
        return result;
    }
    public void helper(TreeNode root, List<Integer> result, int level)
    {
        if(root == null)
            return;        
        if(level == result.size())
            result.add(root.val);
        // make sure right is passed before left
        // as our condition to add to result is based on that.
        helper(root.right, result, level + 1);
        helper(root.left, result, level + 1);
    }
}


        /*
        // Second attempt using queue. Same runtime efficiency.
        public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();        
        Queue<TreeNode> tracker = new LinkedList<TreeNode>();        
        tracker.offer(root);        
        int size = 0;        
        while(!tracker.isEmpty())
        {
            size = tracker.size();            
            for(int i = 0; i < size; i++)
            {   
                TreeNode n = tracker.poll();
                if(i == size - 1)
                    result.add(n.val);                
                if(n.left != null)
                    tracker.offer(n.left);
                if(n.right != null)
                    tracker.offer(n.right);                            
            }            
        }
        return result;        
    }
        
        // ** First attempt. Faster than 6%. O(N) where N is the number of nodes.
        public List<Integer> rightSideView(TreeNode root) {
            if(root == null) return new ArrayList<Integer>();
            List<Integer> result = new ArrayList<Integer>();        
            List<TreeNode> tracker = new LinkedList<TreeNode>();        
            tracker.add(root);
            int i = 0;
            while(tracker.size() > 0)
            {
                List<TreeNode> l = new LinkedList<TreeNode>();
                i = tracker.size() - 1;
                result.add(tracker.get(i).val);            
                for(TreeNode n : tracker)
                {
                    if(n.left != null)
                        l.add(n.left);
                    if(n.right != null)
                        l.add(n.right);                                
                }
                tracker = new LinkedList<>(l);            
            }
            return result;        
      }
        */        
