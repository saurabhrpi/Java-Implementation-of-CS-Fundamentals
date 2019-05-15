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


public class BSTSequences{
    
    public ArrayList<LinkedList<Integer>> allSequences(TreeNode root)
    {
        ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
        
        if(root == null)
        {
            results.add(new LinkedList<Integer>());
            return results;
        }
        
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(root.data);
        
        ArrayList<LinkedList<Integer>> lseq = allSequences(root.left);
        ArrayList<LinkedList<Integer>> rseq = allSequences(root.right);
        
        for(LinkedList<Integer> l : lseq)
        {
            for(LinkedList<Integer> r : rseq)
            {
                // Need an arrayList to store the permutation combination of l and r
                ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>(); 
                
                weaveLists(l, r, result, prefix);
                results.addAll(result);
            }
        }
        return results;
    }
    
    public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> sec, ArrayList<LinkedList<Integer>> weaved, LinkedList<Integer> prefix)
    {
        if(first.size() == 0 || sec.size() == 0)
        {
            LinkedList<Integer> result = new LinkedList<Integer>();
            result.addAll(first);
            result.addAll(sec);
            weaved.add(result);
            return;
        }
        
        int f = first.removeFirst();
        prefix.addLast(f);
        weaveLists(first, sec, weaved, prefix);
        prefix.removeLast();
        first.addFirst(f);
        
        int s = sec.removeFirst();
        prefix.addLast(s);
        weaveLists(first, sec, weaved, prefix);
        prefix.removeLast();
        sec.addFirst(s);
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
        
        
        BSTSequences bs = new BSTSequences();
        
        ArrayList<LinkedList<Integer>> results = bs.allSequences(root);
        
        System.out.println("**Final answer**");
        
        for(int i=0; i < results.size(); i++)
        {
            System.out.println("{");   
            for(int j=0; j < results.get(i).size(); j++)
            {
                System.out.println(results.get(i).get(j));      
            }
            System.out.println("},");   
        }
    }
}
