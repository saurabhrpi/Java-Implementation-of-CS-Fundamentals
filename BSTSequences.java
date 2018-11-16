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
    
    public ArrayList<LinkedList<Integer>> allSequences(TreeNode node)
    {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        
        if(node == null)
        {
            result.add(new LinkedList<Integer>()); // so that the leaf nodes can get into the for loops below
            return result;
        }
        
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.getData());
        
        System.out.println("added to prefix " + node.getData());
        
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
        
        for(int i=0; i < leftSeq.size(); i++)
        {
            for(int j=0; j < rightSeq.size(); j++)
            {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                
                weaveLists(leftSeq.get(i), rightSeq.get(j), weaved, prefix);
                
                System.out.println("adding weaved = ");
                System.out.println("{ ");
                for(int k=0; k < weaved.size(); k++)
                {
                    System.out.println(weaved.get(k));   
                }
                System.out.println("} ");
                System.out.println("result before adding weaved ");
                
                for(int k=0; k < result.size(); k++)
                {
                    System.out.println("{ ");
                    for(int l=0; l < result.get(k).size(); l++)
                    {
                        System.out.println(result.get(k).get(l));   
                    }
                    System.out.println("} ");
                }
                result.addAll(weaved);
                
                System.out.println("result after adding weaved ");
                
                for(int k=0; k < result.size(); k++)
                {
                    System.out.println("{ ");
                    for(int l=0; l < result.get(k).size(); l++)
                    {
                        System.out.println(result.get(k).get(l));   
                    }
                    System.out.println("} ");
                }
            }
        }
        return result;
    }
    
    void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix)
    {
        if(first.size() == 0 || second.size() == 0)
        {
            
            System.out.println("prefix being cloned ");
            for(int i=0; i < prefix.size(); i++)
            {
                System.out.println(prefix.get(i));   
            }
            
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            
            System.out.println("adding 1st to result when sec is empty " );
            for(int i=0; i < first.size(); i++)
            {
                System.out.println(first.get(i));   
            }
            
            System.out.println("adding 2nd to result when first is empty " );
            for(int i=0; i < second.size(); i++)
            {
                System.out.println(second.get(i));   
            }
            
            // merge first with sec
            result.addAll(first);
            result.addAll(second); 
            
            results.add(result);
            
            System.out.println("results status " );
            for(int i=0; i < results.size(); i++)
            {
                System.out.println(results.get(i));   
            }
            
        }
        else
        {
            
            System.out.println("first after either lists empty check");
            for(int i=0; i < first.size(); i++)
            {
                System.out.println(first.get(i));   
            }
            
            System.out.println("second after either lists empty check");
            for(int i=0; i < second.size(); i++)
            {
                System.out.println(second.get(i));   
            }
            
            
            int headFirst = first.removeFirst();
            
            System.out.println("headfirst " + headFirst + " to be added to prefix ");
            for(int i=0; i < prefix.size(); i++)
            {
                System.out.println(prefix.get(i));   
            }
               
            
            prefix.addLast(headFirst);
            weaveLists(first, second, results, prefix);
            prefix.removeLast();
            
            System.out.println("headfirst " + headFirst + " removed from prefix ");
            for(int i=0; i < prefix.size(); i++)
            {
                System.out.println(prefix.get(i));   
            }
            
            first.addFirst(headFirst);
            
            int headSec = second.removeFirst();
            
            System.out.println("headSec " + headSec + " to be added to prefix ");
            for(int i=0; i < prefix.size(); i++)
            {
                System.out.println(prefix.get(i));   
            }
            
            prefix.addLast(headSec);
            weaveLists(first, second, results, prefix);
            prefix.removeLast();
            
            System.out.println("headSec " + headSec + " to removed from prefix ");
            for(int i=0; i < prefix.size(); i++)
            {
                System.out.println(prefix.get(i));   
            }
            
            second.addFirst(headSec);   
        }
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
