import java.lang.*;
import java.util.*;

class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    
    public TreeNode(int data)
    {
        this.data = data;
    }
}


public class Successor{
    
    public TreeNode findSucc(TreeNode node)
    {
        if(node == null)
        {
            return null;
        }
        
        if(node.right != null)
        {
            TreeNode prev = null;
            TreeNode temp = node.right;
            while(temp != null)
            {
                prev = temp;
                temp = temp.left;
            }
            return prev;
        }
        
        while(node.parent != null)
        {
            if(node == node.parent.left)
            {
                return node.parent;
            }
            node = node.parent;
        }
        
        return null;
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(148);
        root.right = new TreeNode(1780);
        
        TreeNode root2 = root.left;
        root2.left = new TreeNode(100);
        root2.right = new TreeNode(200);
        root2.left.parent = root2;
        root2.right.parent = root2;
        
        TreeNode root3 = root.right;
        root3.left = new TreeNode(1100);
        root3.right = new TreeNode(2000);
        root3.left.parent = root3;
        root3.right.parent = root3;
        
        TreeNode root4 = root2.right;
        root4.left = new TreeNode(150);
        root4.left.parent = root4;
        
        TreeNode root5 = root4.left;
        root5.right = new TreeNode(190);
        root5.right.parent = root5;
        
        TreeNode root6 = root3.left;
        root6.left = new TreeNode(1050);
        root6.left.parent = root6;
        
        TreeNode root7 = root6.left;
        root7.right = new TreeNode(1075);
        root7.right.parent = root7;
        
        root6.right = new TreeNode(1200);
        root6.right.parent = root6;
        
        TreeNode root8 = root7.right;
        root8.right = new TreeNode(1080);
        root8.right.parent = root8;
        
        TreeNode root9 = root8.right;
        root9.right = new TreeNode(1085);
        root9.right.parent = root9;
        
        TreeNode root10 = root5.right;
        root10.left = new TreeNode(160);
        root10.left.parent = root10;
        
        TreeNode root11 = root10.left;
        root11.left = new TreeNode(155);
        root11.left.parent = root11;
        
        TreeNode root12 = root11.left;
        root12.left = new TreeNode(151);
        root12.left.parent = root12;
        
        //Tree t = new Tree();
        
        //t.printTree(root, 0);
        
        Successor s = new Successor();
        
        System.out.println(s.findSucc(root4.left).data);
    }

}
