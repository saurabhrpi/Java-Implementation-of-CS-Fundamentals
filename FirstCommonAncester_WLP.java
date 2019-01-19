import java.util.*;
import java.lang.*;


class TreeNode{
    private int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    
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
    
    public int returnLevel(TreeNode n)
    {
        if(n == null)
        {
            return -1;
        }
        
        int count = 0; 
        while(n != null) 
        {
            count++;
            n = n.parent;
        }
        return count;
    }
    
    public TreeNode findCommonAncester(TreeNode first, TreeNode sec)
    {
        if(first == null || sec == null)
        {
            return null;
        }
        
        int l1 = returnLevel(first);
        int l2 = returnLevel(sec);
        
        
        int diff = l1 - l2;
        if(diff > 0)
        {
            while (diff != 0)
            {
                first = first.parent;
                diff--;
            }
        }
        else if(diff < 0)
        {
            while (diff != 0)
            {
                sec = sec.parent;
                diff++;
            }
        }
        
        TreeNode temp = null, temp2 = null;
        
        while(first != null && sec != null)
        {
            if(first == sec)
            {
                return first;
            }
            
            temp = first;
            temp2 = sec;
            first = first.parent;
            sec = sec.parent;
        }
        
        System.out.println("temp " + temp.getData());
        System.out.println("temp2 " + temp2.getData());
        
        return temp == temp2 ? temp : null;
    }
    
   
   
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1000);
        root.left = new TreeNode(148);
        root.right = new TreeNode(1780);
        root.left.parent = root;
        root.right.parent = root;
        
        
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
        root9.right = new TreeNode(1078);
        root9.right.parent = root9;
        
        TreeNode root10 = root5.right;
        root10.left = new TreeNode(160);
        root10.left.parent = root10;
        
        TreeNode root11 = root10.left;
        root11.left = new TreeNode(155);
        root11.left.parent = root11;
        
        TreeNode root12 = root11.left;
        root12.left = new TreeNode(156);
        root12.left.parent = root12;
        
        TreeNode root13 = root10.left;
        root13.right = new TreeNode(149);
        root13.right.parent = root13;
        
        TreeNode root14 = root13.right;
        root14.left = new TreeNode(165);
        root14.left.parent = root14;
        
        FirstCommonAncester fc = new FirstCommonAncester();
        
        TreeNode t = fc.findCommonAncester(root9.right, root14.left);
        
        System.out.println(t == null? null : t.getData());
    }
}
