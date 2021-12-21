/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

// Leetcode problem #426
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        Node head = dfs(root);         
        Node tail = head;
        while(tail.right != null) // move ahead to the last node
            tail = tail.right;
        head.left = tail; // connect with the last node
        tail.right = head;
        return head;
    }
    
    // left pointer has been used to connect to predecessor 
    // while right pointer has been used to connect to successor.
    public Node dfs(Node root)
    {
        if(root == null) return null;         
        Node lNode = dfs(root.left);
        Node prev = null, temp = lNode;
        // move pointer to the last node returned by left subtree 
        while(temp != null)
        {
            prev = temp;
            temp = temp.right;  
        }
        if(prev != null)
        {
            prev.right = root;
            root.left = prev;   
        }        
        Node rNode = dfs(root.right); 
        prev = null; temp = rNode;
        // move pointer to the first node returned by right subtree
        while(temp != null)
        {
            prev = temp;
            temp = temp.left;
        }
        if(prev != null)
        {
            prev.left = root;
            root.right = prev;
        }
        if(lNode != null) // cuz in-order traversal has left as the first node followed by root.           
            return lNode; 
        return root;    
    }
}
