/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans;
    TreeNode target;
    int k;            
    
    // *** Given Sol. O(N). 98% faster. 
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new LinkedList<>();
        this.target = target;
        this.k = k;
        dfs(root); // focuses on whether target is present in a subtree, while sub_tree focuses on whether the distance in the passed subtree is equal to k.
        return ans;
    }
    
    // If target is not present anywhere in your subtree, return -1. Once we find target, call subtree_add for it and return the 1 + distance of target to this node. 
    // If we find target somewhere in our left(or right) subtree, check if our other subtree has it by calling subtree_add.
    // We'll recheck this other subtree even if it earlier returned -1 for us cuz this time we're looking for distance.
    public int dfs(TreeNode node) 
    {
        if(node == null)
        {
            return -1;            
        }
        else if (node == target)
        {
            System.out.println("calling for " + (node == null?"isNull" : node.val));
            subtree_add(node,0); // traverse target's both right and left subtrees.
            return 1; // return 1 since this is = target. 
        }
        else
        {        
            System.out.println("L after calling for " + (node.left == null?"isNull" : node.left.val) + " is " );            
            // L (or R) represents distance in a subtree from target (starting from parent = 1,  grandparent = 2, sibling = 2..) 
            int L = dfs(node.left);
            System.out.println("L = " + L);
            System.out.println("R after calling for " + (node.right == null?"isNull" : node.right.val) + " is ");
            int R = dfs(node.right);     
            System.out.println("R = " + R);
            
            if(L != -1) // L and R can have values other than 1 or -1. because we're returning L + 1 and R + 1 in the code below. They're expected to increase till k. L >= 1 means we're going on a path whose one end is target.
            {
                if(L == k)
                {
                    ans.add(node.val);
                    System.out.println("added inside L == k " + node.val);   
                }                    
                System.out.println("calling for " + (node.right == null?"isNull" : node.right.val) + " with L= " + (L + 1));
                subtree_add(node.right, L + 1);
                System.out.println("returning " + (L + 1));
                return L + 1;
            }
            else if(R != -1)
            {
                if(R == k)
                {
                    System.out.println("added inside R == k " + node.val); 
                    ans.add(node.val);
                }                    
                System.out.println("calling for " + (node.left == null?"isNull" : node.left.val) + " with R= " + (R + 1));
                subtree_add(node.left, R + 1);
                System.out.println("returning " + (R + 1));
                return R + 1;
            }
            else
                return -1;
        }        
    }
    
    
    public void subtree_add(TreeNode node, int dist)
    {
        if(node == null) return;
        if(dist == k)
        {
            System.out.println("adding inside subtree_add " + (node == null?"isNull" : node.val));
            ans.add(node.val);
        }            
        else
        {
            System.out.println("calling for " + (node.left == null?"left isNull" : node.left.val) + " and passing dist= " + (dist + 1));
            subtree_add(node.left, dist + 1);
            System.out.println("calling for " + (node.right == null?"right isNull" : node.right.val)  + " and passing dist= " + (dist + 1));
            subtree_add(node.right, dist + 1);
        }
    }

}
    /*** Given approach #1. O(N). 80% faster.
    Map<Integer, TreeNode> childToParent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      childToParent = new HashMap<>();  
      linkWithParent(root, null);        
      Queue<TreeNode> queue = new LinkedList<>();
      Set<TreeNode> seen = new HashSet<>();
      queue.offer(null);
      queue.offer(target);      
      seen.add(target);
      List<Integer> result = new ArrayList<>();  
      if(k == 0)
      {
         result.add(target.val);
         return result; 
      }
      int dist = 0;// if i move target to the front of the queue before null above, then this will have to be changed to 1.
      while(!queue.isEmpty())
      {
         TreeNode n = queue.poll();
         if(n == null)
         {
             if(dist == k)
             {                 
                 while(!queue.isEmpty())
                 {
                    TreeNode q = queue.poll(); 
                    if(q != null) 
                        result.add(q.val);                    
                 }
                 return result; 
             }
             else
             {
                 queue.offer(null);
                 dist++;
             }
         }
         else
         {
             if(!seen.contains(n.left) && n.left != null)
             {
                 seen.add(n.left);
                 queue.offer(n.left);
             }
             if(!seen.contains(n.right) && n.right != null)
             {
                 seen.add(n.right);
                 queue.offer(n.right);
             }
             TreeNode parent = childToParent.get(n.val);
             if(!seen.contains(parent) && parent != null)
             {
                 seen.add(parent);
                 queue.offer(parent);
             }             
         }
      }
      return result; 
    }
      
      
     public void linkWithParent(TreeNode node, TreeNode parent)
     {
         if(node != null)
         {
             childToParent.put(node.val,parent);
             linkWithParent(node.left, node);
             linkWithParent(node.right, node);
         }
     }
*/
