import java.util.*;
import java.lang.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
}

public class PathsWithSum{
    
    public int findPathsWithSum(TreeNode root, int sum)
    {
        if(root == null)
        {
            return 0;
        }
        
        int result = countPathsWithSum(root, sum, 0);
        result += findPathsWithSum(root.left, sum);
        result += findPathsWithSum(root.right, sum);
        return result;
    }
    
    public int countPathsWithSum(TreeNode node, int targetSum, int currentSum)
    {
        if(node == null)
        {
            return 0;
        }
        
        int totalPaths = 0;
        
        currentSum += node.data;
        
        if(currentSum == targetSum)
        {
            totalPaths++;
        }
        
        totalPaths += countPathsWithSum(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSum(node.right, targetSum, currentSum);
        
        return totalPaths;
    }
    
    // Approach # 2 : Using Hash maps
    
    public int countPathsHashMap(TreeNode root, int targetSum)
    {
        return countPathsHashMap(root, 0, targetSum, new HashMap<Integer, Integer>());
    }
    
    public int countPathsHashMap(TreeNode node, int runningSum, int targetSum, HashMap<Integer, Integer> ht)
    {
        if(node == null)
        {
            return 0;
        }
        
        runningSum += node.data;
        int sum = runningSum - targetSum;
        
        // look if we have a path from another node to this node such that 
        // the difference of their running sums matches the targetSum
        int totalPaths = ht.getOrDefault(sum,0); 
        
        if(runningSum == targetSum) // if the node itself has a running sum that matches the target
        {
            totalPaths++;
        }
        
        incrementHashTable(ht, runningSum, 1);
        totalPaths += countPathsHashMap(node.left, runningSum, targetSum, ht);
        totalPaths += countPathsHashMap(node.right, runningSum, targetSum, ht);
        incrementHashTable(ht, runningSum, -1);
        
        return totalPaths;
    }
    
    public void incrementHashTable(HashMap<Integer, Integer> ht, int runningSum, int delta)
    {
         // put only if there is a non-negative "value" against the key runningSum 
         
        int key = ht.getOrDefault(runningSum, 0) + delta;
        if(key == 0)
        {
            ht.remove(runningSum);
        }
        else
        {
            ht.put(runningSum, key);
        }
    }
    
    public static void main(String[] args)
    {
        
    }
}
