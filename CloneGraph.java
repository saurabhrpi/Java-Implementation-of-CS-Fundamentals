/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// Leetcode problem #133
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Map<Integer,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();        
        queue.offer(node);        
        map.put(node.val, new Node(node.val));          
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                //System.out.println("*********Start of outer iteration*********");                 
                Node processing = queue.poll();
                //System.out.println("polled, processing = " + processing.val); 
                Node cl = map.get(processing.val);            
                for(int j = 0; j < processing.neighbors.size(); j++)
                {
                    //System.out.println("*********Start of inner iteration*********"); 
                    int val = processing.neighbors.get(j).val;                    
                    Node newN = null;
                    if(!map.containsKey(val))
                    {
                        //System.out.println("adding key = " + val + " to the map and queue");
                        queue.offer(processing.neighbors.get(j));                    
                        newN = new Node(val);
                        map.put(val, newN);                                                                       
                        //System.out.println("added " + val + " to the neighbors list of cl = " + cl.val);
                    }    
                    else  // when the neighbor already exists in the 
                    {
                        //System.out.println("passing existing key = " + val + " to the map to get its node");                                 
                        newN = map.get(val);                        
                    }                        
                    //System.out.println("adding neighbor = " + newN.val + " as neighbor to cl = " + cl.val); 
                    cl.neighbors.add(newN);
                    //System.out.println("neighbors of cl=" + cl.val + " are "); 
                    // for(int k = 0; k < cl.neighbors.size();k++)
                    // {
                    //     System.out.println("neighbor" + (k + 1) + ": " + cl.neighbors.get(k).val); 
                    // }
                }                    
            }
        }        
        return map.get(node.val);       
    }
}
