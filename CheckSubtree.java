import java.util.*;
import java.lang.*;

// Given the null nodes are represented by X, the PreOrder traversal of a tree will always yield one and only one binary tree.

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

public class CheckSubtree{
    
    // Approach #1 : O(n+m) run time as well as space.
    
    public boolean check(TreeNode t1, TreeNode t2)
    {
        if(t1 == null || t2 == null)
        {
            return false;
        }
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        generateString(t1, sb1);
        generateString(t2, sb2);
        
        return sb1.indexOf(sb2.toString()) != -1;
    }
    
    public void generateString(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            return;
        }
        
        sb.append(root.data);
        generateString(root.left, sb);
        generateString(root.right, sb);
    }
    
    public boolean check(TreeNode par, TreeNode ch)
    {
        if(par == null)
        {
            return false;
        }
        
        if(ch == null)
        { 
            return true;
        }
        
        if(matchTree(par, ch))
        {
            return true;
        }
        
        return check(par.left, ch) || check(par.right, ch);
    }
    
    // Approach #2 : O(n+km) run time. O(1) space.
    
    public boolean matchTree(TreeNode first, TreeNode sec)
    {
        if(first == null && sec == null)
        {
            return true;
        }
        
        if(first == null || sec == null)
        {
            return false;
        }
        
        if(first.getData() != sec.getData())
        {
            return false;
        }
        
        return matchTree(first.left, sec.left) && matchTree(first.right, sec.right);
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
        
        CheckSubtree fc = new CheckSubtree();

        System.out.println(fc.check(root, root3.left));
    }
}
