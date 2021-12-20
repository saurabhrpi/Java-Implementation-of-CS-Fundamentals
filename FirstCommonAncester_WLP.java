/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

// LeetCode problem #1650
class Solution {
    // O(N). Fast and concise.
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while(a != b)
        {
            a = (a == null? q : a.parent);
            b = (b == null? p : b.parent);
        }
        return a;
    }
    /*
    // O(N). Faster than 94%.    
    public Node lowestCommonAncestor(Node p, Node q) {                             
        int pd = findInParents(p,q);
        int qd = findInParents(q,p);
        if(pd == -1)
            return q;
        else if(qd == -1)
            return p;        
        Node closer = (pd < qd?p : q);
        Node farther = (pd < qd?q : p);
        int moveUpBy = Math.abs(pd - qd);
        while(moveUpBy > 0)
        {
            farther = farther.parent;
            moveUpBy--;
        }            
        while(closer.parent != null)
        {
            closer = closer.parent;
            farther = farther.parent;            
            if(closer == farther)
                return closer;
        }        
        return closer;
    }
    
    public int findInParents(Node start, Node key)
    {
        Node temp = start;
        int count = 0;
        while(temp != null)
        {
            if(temp == key)
              return -1;  
            count++;
            temp = temp.parent;
        }
        return count;
    }
    */
    /* // O(N). 69% faster
    public Node lowestCommonAncestor(Node p, Node q) {                     
        
        int pd = findInParents(p,q);
        int qd = findInParents(q,p);
        if(pd == -1)
            return q;
        else if(qd == -1)
            return p;        
        Node closer = (pd < qd?p : q);
        Node farther = (pd < qd?q : p);
        while(closer.parent != null)
        {
            closer = closer.parent;
            if(findInParents(farther,closer) == -1)
                return closer;
        }        
        return closer;
    }
    
    public int findInParents(Node start, Node key)
    {
        Node temp = start;
        int count = 0;
        while(temp != null)
        {
            if(temp == key)
              return -1;  
            count++;
            temp = temp.parent;
        }
        return count;
    }
    */
    /*
    // *** O(N) *** 50% faster.
    public Node lowestCommonAncestor(Node p, Node q) {     
        List<Node> pathP = new ArrayList<>();
        Node temp = p;
        while(temp != null)
        {
            pathP.add(temp);
            temp = temp.parent;
        }
        temp = q;
        List<Node> pathQ = new ArrayList<>();
        while(temp != null)
        {
            pathQ.add(temp);
            temp = temp.parent;
        }
        //Node anc = q;
        int i = pathP.size() - 1, j = pathQ.size() - 1;
        while(i >= 0  && j >= 0)
        {
            if(pathP.get(i).val != pathQ.get(j).val)
            {                
                return pathP.get(i + 1);
            }         
            i--; j--;
        }
        return (pathP.size() > pathQ.size()?pathP.get(i + 1):pathQ.get(j + 1));
    }
    // // Above algorithm can also be implemented as :
    //Set<Node> set = new HashSet<Node>();
    //while(p!=null && set.add(p)) p = p.parent;
    //while(q != null && !set.contains(q)) q = q.parent;
    //return q;
    */
}
