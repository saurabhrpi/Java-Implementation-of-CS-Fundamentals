import java.util.*;
import java.lang.*;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode next;
}

public class NextRightPtr{
 
 public void pointRight(TreeNode root)
 {
     TreeNode cur = root;
     TreeNode head = null;
     TreeNode prev = null;
     
    while(cur != null) // step down
    {
        while( cur != null) // go across
        {
            if(cur.left != null)
            {
                if(prev != null)
                {
                    prev.next = cur.left; 
                }
                else
                {
                  head = cur.left;
                }
                 prev = cur.left;
            }
             
             if(cur.right != null)
             {
                 if(prev != null)
                 {
                     prev.next = cur.right;
                 }
                 else
                 {
                     head = cur.right;
                 }
                 prev = cur.right;
             }
             cur = cur.next;
         }
         cur = head;
         head = null;
         prev = null;
    }
 }
  
}
