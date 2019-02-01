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

class Result{
    TreeNode res;
    boolean ancester = false;
    
    Result(TreeNode res, boolean ancester)
    {
        this.res = res;
        this.ancester = ancester;
    }
}

public class MostEffFirstCommonAncester{ 
    
    public Result findCommonAncester(TreeNode root, TreeNode first, TreeNode sec)
    {
        if(root == null)
        {
            return null;
        }
        
        if(root == first && root == sec)
        {
            return new Result(root, true);
        }
        
        Result x = findCommonAncester(root.left, first, sec);
        
        if(x != null && x.ancester)  // Found ancester. Being efficient.
        {
            return x;
        }
        
        Result y = findCommonAncester(root.right, first, sec);
        
        if(y != null && y.ancester)
        {
            return y;
        }
        
        if(x != null && y != null)
        {
            return new Result(root, true);
        }
        
        
        if(root == first || root == sec)  // subtree case
        {
            boolean ancester = (x != null) || (y != null);  // if both are null that means one is not in the tree itself.
            return new Result(root, ancester);
        }
        
        return x == null? y : x ;
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
        
        MostEffFirstCommonAncester fc = new MostEffFirstCommonAncester();

        //System.out.println(fc.findAncesterHelp(root3.left, root6.right, n).getData());
        
        Result result = fc.findCommonAncester(root3.left, root8.right, n);
        
        if(result.ancester)
        {
            System.out.println(result.res.getData());   
        }
    }
}
