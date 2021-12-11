/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {        
        return helper(node);
    }
    
    public Node helper(Node node)
    {
        if(node == null)
            return null;        
        if(node.parent == null)
        {
            return findLeftmostChildOfRight(node);
        }
        
        // done for the case when node is on lhs of its parent.
        if(node == node.parent.left)
        {
            Node lmcr = findLeftmostChildOfRight(node);
            if(lmcr != null)
                return lmcr;
            return node.parent;            
        }  
        
        // case when node is on the RHS of its parent
        if(node == node.parent.right)
        {      
            Node lmcr = findLeftmostChildOfRight(node);
            if(lmcr != null)
                return lmcr;
            Node p = node.parent;
            while(p != null && p.parent != null && p == p.parent.right)
                p = p.parent;
            return (p == null? null : p.parent);
        }
        return null;
    }
    
    public Node findLeftmostChildOfRight(Node node)
    {
        Node r = node.right, curr = null;
        while(r != null)
        {
            curr = r;
            r = r.left;
        }
        return curr;
    }
}
