import java.util.*;
import java.lang.*;

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    
    TreeNode()
    {
        
    }
    
    TreeNode(int data)
    {
        this.data = data;
    }
    
}

class Tree{
    
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
    
     // DFS : runtime : N. space: N + logN.   recursion adds to space.
    
    public ArrayList<LinkedList<TreeNode>> createLists(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        
        ArrayList<LinkedList<TreeNode>> al = new ArrayList<LinkedList<TreeNode>>();
        
        int level = 0;
        
        addNodesAtSameLevel(al, root, level);
        
        return al;
    }
    
    public void addNodesAtSameLevel(ArrayList<LinkedList<TreeNode>> al, TreeNode root, int level)
    {
        if(root != null)
        {
           LinkedList<TreeNode> l;
           
           if(al.size() == level)
           {
                l = new LinkedList<TreeNode>();     
                al.add(l);
           }
           else
           {
               l = al.get(level);
           }
           
           l.add(root);
           
           addNodesAtSameLevel(al, root.left, level + 1);
           addNodesAtSameLevel(al, root.right, level + 1);
        }
    }
   
     //BFS : runtime efficiency : N + logN. space : N.

     public ArrayList<LinkedList<TreeNode>> createListsBFS(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        
        LinkedList<TreeNode> l = new LinkedList<TreeNode>();
        
        ArrayList<LinkedList<TreeNode>> al = new ArrayList<LinkedList<TreeNode>>();
        
        if(root != null)
        {
            l.add(root);
        }
        
        while(l.size() > 0)
        {
            al.add(l);
            
            LinkedList<TreeNode> parents = l;
            
            l = new LinkedList<TreeNode>();
            
            for(int i=0; i < parents.size(); i++)
            {
                if(parents.get(i).left != null)
                {
                    l.add(parents.get(i).left);
                }
                
                if(parents.get(i).right != null)
                {
                    l.add(parents.get(i).right);
                }
            }
        }
        
        return al;
    }	

    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(140);
        root.right = new TreeNode(178);
        
        TreeNode root2 = root.left;
        root2.left = new TreeNode(1400);
        root2.right = new TreeNode(1708);
        
        TreeNode root3 = root.right;
        root3.left = new TreeNode(10);
        root3.right = new TreeNode(708);
        
        //Tree t = new Tree();
        
        //t.printTree(root, 0);
        
        ListOfDepths ld = new ListOfDepths();
        
        ArrayList<LinkedList<TreeNode>> al = ld.createList(root);
        
        if(al != null)
        {
            for(int i=0; i < al.size(); i++)
            {
                LinkedList<TreeNode> ll = al.get(i);
                for(int j=0; j < ll.size(); j++)
                {
                    System.out.println("printing linkedlist " + i);
                    System.out.println(ll.get(j).data);   
                }
            }   
        }
    }

}
