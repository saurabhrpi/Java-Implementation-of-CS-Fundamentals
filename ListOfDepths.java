import java.util.*;
import java.lang.*;

class TreeNode {
    public int data;
    public int level;
    public TreeNode root;
    public TreeNode left;
    public TreeNode right;
    
    TreeNode()
    {
        
    }
    
    TreeNode(Node root, int data, int leftd, int rightd)
    {
        this.data = data;
        this.root = root;
        
    }
    
}

class Tree{
    
    /*
    public TreeNode createTree(int[] inp)
    {
        if(inp == null)
        {
            return null;
        }
        
        
    }
    */
    
    public void printTree(TreeNode root, int level)
    {
        if(root != null)
        {
            System.out.println("level " + level + " for node " + root.data + " begins");
            
            System.out.println("Left Child at " + (level + 1) + " is");   
            System.out.println(root.left == null ? null : root.left.data);
            
            System.out.println("Right Child at " + (level + 1) + " is");
            System.out.println(root.right == null ? null : root.right.data);
            
            System.out.println("level " + level + " for node " + root.data + " ends");
            
            level++;
            printTree(root.left,level);
            printTree(root.right,level);
        }
    }
}

public class ListOfDepths{
    
    public LinkedList<TreeNode> createList(TreeNode root, ArrayList<LinkedList> al)
    {
        if(root == null)
        {
            return root;
        }
        
        LinkedList<TreeNode> l = new LinkedList<TreeNode>();
        
        l.add(root);
        
        addNodesAtSameLevel(l, root);
        
        al.add(createList(root.left));
        al.add(createList(root.right));
        
        return al;
    }
    
    public TreeNode addNodesAtSameLevel(LinkedList<TreeNode> l, TreeNode root)
    {
        
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(100,0);
        root.left = new TreeNode(140,1);
        root.right = new TreeNode(178,1);
        root.root = null;
        
        TreeNode root = new TreeNode(100,0, 140, 178);
        
        ArrayList<LinkedList> al = new ArrayList<LinkedList>();
    }

}
