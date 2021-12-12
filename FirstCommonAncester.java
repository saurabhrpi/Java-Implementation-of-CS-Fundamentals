// Latest code

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // **** Given Sol. Super concise.
        // Intuition : At every node/level, return null if nothing found. 
        // Else if one node found return and pass it to the parent. If the parent's other child returns it the other node, we've found our ancestor. 
        // Else, we keep passing the first node towards the top till we reach a point where we eventually find a parent whose other child gives it the other node. 
        // Use this test case to better understand : [5,4,16,2, null, 10,28,1,3,8,14,null,null,null,null,null, null, 6,9, 21,15,12,18,19,29,null,null,null,null]. 
        // Nodes are :28, 12.       
        if(root == null || root == p || root == q)
        {            
            return root;
        }            
        TreeNode left = lowestCommonAncestor(root.left, p , q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);
        TreeNode res = right == null?left : (left == null? right : root); 
        
        return res;
    }
}    
        // *** My Impl. Faster than 100%. But unnecessary use of HashMap.
        /*
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == null)
            return q;
        if(q == null)
            return p;
        if(p.left == q || p.right == q)
            return p;
        if(p == q.right || p == q.left)
            return q;        
        List<TreeNode> path1 = new ArrayList<>();
        findPath(root, p, path1);        
        List<TreeNode> path2 = new ArrayList<>();
        findPath(root, q, path2);        
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        TreeNode val = null; // final answer                       
        for(; i >= 0; i--)
        {
            if(j >= 0)
            {
                if(path1.get(i).val != path2.get(j).val)
                {
                    val = path1.get(i + 1);   
                    return val;
                }                    
                j--;
            }            
            else
                break;
        }        
        val = (j > i?path2.get(j + 1) : path1.get(i + 1));
        return val;
        
    } 
    public boolean findPath(TreeNode root, TreeNode key, List<TreeNode> path)
    {
        if(root == null)
            return false;
        if(root == key)
        {            
            path.add(root);   
            return true;
        }            
        if(findPath(root.left, key, path) || findPath(root.right, key, path))
        {
            path.add(root);
            return true;
        }        
        return false;
    }
    */



/*// 3 yeas old code below
import java.util.*;
import java.lang.*;

class TreeNode{
    private int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data)
    {
        this.data = data;
    }
    
    public int getData()
    {
        return data;
    }
    
    public void setData(int data)
    {
        this.data = data;
    }
    
}

public class FirstCommonAncester{
    
    public TreeNode findAncesterHelp(TreeNode root, TreeNode first, TreeNode sec)
    {
        if(!covers(root, first) || !covers(root, sec))
        {
            return null;
        }
        
        //return findAncesterBook(root, first, sec);
        return findAncester(root, first, sec);
    }
     
    public boolean covers(TreeNode root, TreeNode n)
    {
        if(root == null)
        {
            return false;
        }
        
        if(root == n)
        {
            return true;
        }
        
        if(covers(root.right, n) || covers(root.left, n))
        {
            return true;
        }
        
        return false;
    }
    
    public TreeNode findAncester(TreeNode root, TreeNode first, TreeNode sec)
    {
        if(root == null)
        {
            return root;
        }
        
        if(root == first && root == sec)
        {
            return root;
        }
        
        
        TreeNode x = findAncester(root.left, first, sec);
        TreeNode y = findAncester(root.right, first, sec);
        
        if(x != null && x != first && x != sec) //Already found the ancestor. Making it efficient.
        {
            return x;
        }
        
        if(y != null && y != first && y != sec) //Already found the ancestor
        {
            return y;
        }
        
        // if both are not null and not same, then we are the ancestor
        if(x != null && y != null)
        {
            return root;   
        }
        
        // base case 
        if(root == first || root == sec)
        {
            return root;
        }

        // if one is null, other is not null then we have found one of them down the lineage
        if(x != null && y == null)
        {
            return x;
        }
        
        if(x == null && y != null)
        {
            return y;
        }   
        
        return null;
    }
    
    // Worst case : O(n^2) for a completely unbalanced tree.
    public TreeNode findAncesterBook(TreeNode root, TreeNode first, TreeNode sec)
    {
        if(root == null || root == first || root == sec)
        {
            return root;
        }
        
        boolean fIsOnLeft = covers(root.left, first); 
        boolean sIsOnLeft = covers(root.left, sec);
        
        if(fIsOnLeft != sIsOnLeft)
        {
            return root;
        }
        
        TreeNode child = fIsOnLeft == true ? root.left : root.right;
        
        return findAncesterBook(child, first, sec);
    }


    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(148);
        root.right = new TreeNode(1780);
        
        TreeNode root2 = root.left;
        root2.left = new TreeNode(100);
        root2.right = new TreeNode(200);
        
        
        TreeNode root3 = root.right;
        root3.left = new TreeNode(1100);
        root3.right = new TreeNode(2000);
        
        TreeNode root4 = root2.right;
        root4.left = new TreeNode(150);
        
        
        TreeNode root5 = root4.left;
        root5.right = new TreeNode(190);
        
        
        TreeNode root6 = root3.left;
        root6.left = new TreeNode(1050);
        
        
        TreeNode root7 = root6.left;
        root7.right = new TreeNode(1075);
        
        
        root6.right = new TreeNode(1200);
        
        
        TreeNode root8 = root7.right;
        root8.right = new TreeNode(1080);
        
        
        TreeNode root9 = root8.right;
        root9.right = new TreeNode(1078);
        
        
        TreeNode root10 = root5.right;
        root10.left = new TreeNode(160);
        
        TreeNode root11 = root10.left;
        root11.left = new TreeNode(155);
        
        TreeNode root12 = root11.left;
        root12.left = new TreeNode(156);
        
        root11.right = new TreeNode(149);
        
        TreeNode root13 = root11.right;
        root13.left = new TreeNode(165);
        
        TreeNode n = new TreeNode(500);
        
        FirstCommonAncester fc = new FirstCommonAncester();

        System.out.println(fc.findAncesterHelp(root3.left, root6.right, n).getData());
    }
}
*/
