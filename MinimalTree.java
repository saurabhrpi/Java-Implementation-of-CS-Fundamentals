import java.util.*;
import java.lang.*;

class Node {
    public int data;
    public Node left;
    public Node right;
    
    Node()
    {
        
    }
    
    Node(int data)
    {
        this.data = data;
    }
}

class Tree{
    
    public void printTree(Node root, int level)
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

public class minimalBST{
    
    public Node createMinimalBST(int[] inp, int start, int end)
    {
        if(end < start || inp == null)
        {
            return null;
        }
        
        int mid = (start + end) / 2;
        
        Node root = new Node(inp[mid]);
        
        root.left = createMinimalBST(inp, start, mid - 1);
        root.right = createMinimalBST(inp, mid + 1, end);
        
        return root;
    }
    
    public static void main(String[] args)
    {
        int[] inp = {14, 29, 37, 44, 50, 100, 110, 190, 200, 400};
        
        //int[] inp = {9, 81, 171, 200, 201};
        
        minimalBST mt = new minimalBST();
        
        Node temp = mt.createMinimalBST(inp,0, inp.length - 1);
        
        Tree t = new Tree();
        
        System.out.println("**********printing tree***********");
        t.printTree(temp, 0);
    }

}
