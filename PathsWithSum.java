import java.util.*;
import java.lang.*;

class TreeNode{
    int d;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int d)
    {
        this.d = d;
    }
    
}

public class PathsWithSum{
    
    public int countPathsWithSum(TreeNode root, int targetSum)
    {
        /*
        if(root == null)
        {
            return 0;
        }
        
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
        
        int pathsFromLeft = countPathsWithSum(root.left, targetSum);
        int pathsFromRight = countPathsWithSum(root.right, targetSum);
        
        return pathsFromRoot + pathsFromLeft + pathsFromRight;
        */
        
        // Using hash table
         return countPathsWithSumHashT(root, targetSum, new HashMap<Integer, Integer>(), 0);
         
    }
    
    public int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum)
    {
        if(node == null)
        {
            return 0;
        }
        
        currentSum += node.d;
        
        int totalPaths = 0;
        
        if(targetSum == currentSum)
        {
            totalPaths++;
        }
        
        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
        
        return totalPaths;
    }

    
    public int countPathsWithSumHashT(TreeNode node, int targetSum, HashMap<Integer, Integer> pathCount, int runningSum)
    {
       if(node == null)
       {
           return 0;
       }
       
       runningSum += node.d;
       
       int sum = runningSum - targetSum; // can't do targetSum - runningSum here bcoz the only way runningSum will increase is by going down.
       
       int paths = pathCount.getOrDefault(sum, 0);
       
       if(runningSum == targetSum)
       {
           paths++;
       }
       
       incrementHashTable(pathCount, runningSum, 1);
       paths += countPathsWithSumHashT(node.left, targetSum, pathCount, runningSum);
       paths += countPathsWithSumHashT(node.right, targetSum, pathCount, runningSum);
       incrementHashTable(pathCount, runningSum, -1);
       
       return paths;
    }
    
    public void incrementHashTable(HashMap<Integer, Integer> pathCount, int runningSum, int delta)
    {
        int newCount = pathCount.getOrDefault(runningSum,0) + delta;
        
        if(newCount == 0)
        {
            pathCount.remove(runningSum);
        }
        else
        {
            pathCount.put(runningSum, newCount);
        }
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(-12);
        root.right = new TreeNode(-22);
        
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(18);
        
        PathsWithSum pws = new PathsWithSum();
        System.out.println("count " +  pws.countPathsWithSum(root, 3));
    }
    
}
