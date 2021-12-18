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
    // ******* DFS *******
    // Problem #314
    // For time complexity refer : Complexity Analysis of Appraoch #3.
    Integer minCol = null, maxCol = null;
    public List<List<Integer>> verticalOrder(TreeNode root) {                
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Map<Integer,List<Pair<Integer,Integer>>> colToRowVal = new HashMap<>();
        dfs(root, colToRowVal,0,0);
        for(int i = minCol; i <= maxCol; i++)
        {
            Collections.sort(colToRowVal.get(i),new Comparator<Pair<Integer, Integer>>(){
            @Override
              public int compare(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2)
              {
                  return p1.getKey() - p2.getKey(); // sort by p1 first, then p2.
              }
            }
            );
            List<Integer> sortByCol = new ArrayList<Integer>();
            for(Pair<Integer,Integer> p : colToRowVal.get(i))
                sortByCol.add(p.getValue());
            result.add(sortByCol);            
        }
        return result;
    }
    
    public void dfs(TreeNode root, Map<Integer,List<Pair<Integer,Integer>>> colToRowVal, int row, int col)
    {
        if(root == null)
            return;
        Pair<Integer,Integer> p = new Pair<Integer,Integer>(row,root.val);
        if(!colToRowVal.containsKey(col))
            colToRowVal.put(col, new ArrayList<>());
        colToRowVal.get(col).add(p);
        if(minCol == null || minCol > col) minCol = col;
        if(maxCol == null || maxCol < col) maxCol = col;
        dfs(root.left, colToRowVal, row + 1, col - 1);
        dfs(root.right, colToRowVal, row + 1, col + 1);
    }
    
        /* // ******* BFS *******
        public List<List<Integer>> verticalOrder(TreeNode root) {        
        List<List<Integer>> result = new LinkedList<>();     
        if(root == null)
            return result;               
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        Pair<TreeNode,Integer> pair = new Pair<>(root,0);
        queue.offer(pair);        
        Map<Integer, List<Integer>> map = new HashMap<>();
        TreeNode n = null;
        Integer minCol = null, maxCol = null; // For Approach #2
        while(!queue.isEmpty())
        {
            int size = queue.size();                        
            for(int i = 0; i < size; i++)
            {
                Pair<TreeNode,Integer> p = queue.poll();            
                n = p.getKey();
                int val = p.getValue();
                if(minCol == null || minCol > val)
                    minCol = val;
                if(maxCol == null || maxCol < val)
                    maxCol = val;
                if(!map.containsKey(val))
                {
                    map.put(val,new ArrayList<>());
                }
                map.get(val).add(n.val);// takes care of left-to-right as well as top-to-bottom sorting in the same cell.
                if(n.left != null)
                    queue.offer(new Pair<TreeNode,Integer>(n.left,val - 1));
                if(n.right != null)
                    queue.offer(new Pair<TreeNode,Integer>(n.right,val + 1));
            }            
        }
        
        // *** Approach 1 : Sort the keys. O(N*log(N))
        // List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        // Collections.sort(sortedKeys);
        //for(int i : sortedKeys)
        //    result.add(map.get(i));    
        
        // *** Approach 2 : Maintain a range. O(N)
        int i = minCol;
        for(; i <= maxCol; i++)
        {
            if(map.containsKey(i))
                result.add(map.get(i));
        }
        return result;
        }
        */                    
}
