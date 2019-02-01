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
