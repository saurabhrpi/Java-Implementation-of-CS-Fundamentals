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
       //printTree(node);
       if(node == null)
           return null;
        if(node.right != null)
            return traverse(node.right);
        if(node.parent == null)
            return null;                
        return findCorrectParent(node.parent, node);
    }    
    
    public Node findCorrectParent(Node parent, Node node)
    {
        while(parent.parent != null)
        {
            if(parent.val > node.val)
                return parent;
            parent = parent.parent;
        }
        return parent.val > node.val? parent : null;
    }
    
    public void printTree(Node node)
    {
        while(node.parent != null)
            node = node.parent;
        Queue<Node> queue = new LinkedList<>();
        int size = 0;
        queue.offer(node);        
        while(!queue.isEmpty())
        {
            size = queue.size();
            for(int i = 0; i < size; i++)
            {
                Node n = queue.poll();                
                System.out.println("processing root =" + n.val);
                if(n.left != null)
                {
                    System.out.println("added left = " + n.left.val);
                    queue.offer(n.left);
                }
                if(n.right != null)
                {
                    System.out.println("added right = " + n.right.val);
                    queue.offer(n.right);
                }
            }
        }
    }
    
    public Node traverse(Node node)
    {
        if(node == null)
            return null;
        if(node.left != null)
            return traverse(node.left);
        return node;
    }
}
