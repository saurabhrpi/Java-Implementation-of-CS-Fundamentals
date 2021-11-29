/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // ********* My modification of Given Approach starts *********
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, new Identity(1),sb,null);
        return sb.toString();
    }
    
    class Identity{
        int value;
        public Identity(int val)
        {
            value = val;
        }
        public int getValue()
        {
            return value;
        }
        public void increment()
        {
            value++;
        }
    }
    
    public void serializeHelper(Node root, Identity id, StringBuilder sb, Integer parentId)
    {
        if(root == null) return;
        
        sb.append((char)(id.getValue() + '0')); // convert to unicode, so that a double digit can also be stored as single char.
        sb.append((char)(root.val + '0'));
        int parentVal = (parentId == null? 'N' : parentId);
        sb.append((char)(parentVal+'0'));
        parentId = id.getValue();
        for(Node n : root.children)
        {
            id.increment();
            serializeHelper(n, id, sb, parentId);
        }
    }
    
    public Node deserialize(String data)
    {
        if(data.isEmpty())
            return null;
        return deserializeHelper(data);
    }
    
    public Node deserializeHelper(String data)
    {
        HashMap<Integer, Pair<Integer,Node>> nodesAndParents = new HashMap<>();                
        for(int i=0; i < data.length(); i = i + 3)
        {            
            int id = data.charAt(i) - '0';
            int nodeVal = data.charAt(i + 1) - '0'; // reason this doesn't throw 
            //indexOutOfBoundsException is cuz i is jumping 3 values, so once i = data.length() - 3 then it will 
            //be i = data.length()
            int parentId = data.charAt(i + 2) - '0';
            Pair<Integer, Node> p = new Pair<Integer,Node>(parentId, new Node(nodeVal, new ArrayList<Node>()));                        
            nodesAndParents.put(id, p);
        }
        
        for(int i = 3; i < data.length(); i = i + 3)
        {
            int id = data.charAt(i) - '0';
            int parentId = data.charAt(i + 2) - '0';
            //System.out.println("for id " + id);
            Node p = nodesAndParents.get(parentId).getValue();
            Node n = nodesAndParents.get(id).getValue();
            p.children.add(n);
        }
        return nodesAndParents.get(1).getValue();
    }
}    
    // ********* Revision of Given Approach ends *********
    
    /*
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        //return serializeToString(root);                
        
        // ** Given Approach #1 starts**
        StringBuilder sb = new StringBuilder();
        this._serializeHelper(root, sb, new WrappableInt(1), null);
        return sb.toString();
        // **Given Approach #1 ends **
    }
    
    // ******************Given Approach #1 ******************

    class WrappableInt {
        private Integer value;
        public WrappableInt(Integer x) {
            this.value = x;
        }
        public Integer getValue() {
            return this.value;
        }
        public void increment() {
            this.value++;
        }
    }
    
    // Was searching for typedef alternatives in Java and came across fake classes
    // Mostly considered an anti-pattern but it definitely makes our code much more
    // readable!
    class DeserializedObject extends HashMap<Integer, Pair<Integer, Pair<Integer, Node>>> {}
    
    private void _serializeHelper(Node root, StringBuilder sb, WrappableInt identity, Integer parentId) {
        
        if (root == null) {
            return;
        }
        
        // Own identity
        sb.append((char) (identity.getValue() + '0'));
        
        // Actual value
        sb.append((char) (root.val + '0'));
        
        // Parent's identity
        sb.append((char) (parentId == null ? 'N' : parentId + '0'));
        
        parentId = identity.getValue();
        for (Node child : root.children) {
            identity.increment();
            this._serializeHelper(child, sb, identity, parentId);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
     
        // ** My Impl starts **
        // String[] splitValues = data.split(",");
        // return deserializeFromString(splitValues);
        // ** My Impl ends **
        
        // Apprpoach #1 starts 
        if(data.isEmpty())
            return null;
        
        return this._deserializeHelper(data);
        // Apprpoach #1 ends 
    }
    
    private Node _deserializeHelper(String data) {  
        
        // HashMap explained in the algorithm
        DeserializedObject nodesAndParents = new DeserializedObject();
        
        // Constructing the hashmap using the input string
        for (int i = 0; i < data.length(); i+=3) {
            int id = data.charAt(i) - '0';
            int orgValue = data.charAt(i + 1) - '0';
            int parentId = data.charAt(i + 2) - '0';
            Pair<Integer, Pair<Integer, Node>> node = new Pair<Integer, Pair<Integer, Node>>(orgValue,new Pair<Integer, Node>(parentId, new Node(orgValue, new ArrayList<Node>())));
            nodesAndParents.put(id, node);
        }
        
        // A second pass for tying up the proper child connections
        for (int i = 3; i < data.length(); i+=3) {
            
            // Current node
            int id = data.charAt(i) - '0';
            Node node = nodesAndParents.get(id).getValue().getValue();
            
            // Parent node
            int parentId = data.charAt(i + 2) - '0';
            Node parentNode = nodesAndParents.get(parentId).getValue().getValue();
            
            // Attach!
            parentNode.children.add(node);
        }
        
        // Return the root node.
        return nodesAndParents.get(data.charAt(0) - '0').getValue().getValue();
    }

    
    // ****************** My Implememntation Attempt ******************
    public String serializeToString(Node root)
    {
        if(root == null) return " ,";
        if(root.children.size() == 0) return String.valueOf(root.val) + ",";
        StringBuilder values = new StringBuilder();
        String val = root.val + ",:,";
        values.append(val);
        for(Node n : root.children)
        {
            String kid = serializeToString(n);
            values.append(kid);
        }
        String levelMarker = "-,";
        return values.append(levelMarker).toString();
    }
    
    
    public Node deserializeFromString(String[] data)
    {        
        if (data.length == 1 && data.matches("\\d+")) {
            new Node(Integer.parseInt(str));
        }
        Node head = null, prev = head;
        boolean endofLevel = false;
        for(String str : data)
        {
            if(str.equals(" "))   
            {
                
            }
            else if(str.equals("-"))
            {
                endofLevel = true;
            }
            else if(str.equals(":"))
            {
                
            }
            else if(str.matches("\\d+"))
            {
                Node n = new Node(Integer.parseInt(str),new ArrayList<Node>());
                if(head == null)
                {
                    //head = new Node(Integer.parseInt(str),new ArrayList<Node>());
                    head = n;
                    prev = n;
                }                    
                else if(!endofLevel)
                {                    
                    prev.children.add(n);
                }                
                else if(endofLevel)
                {
                    prev.children.get()
                }
            } 
        }        
    }
    
    public Object add(Node root)
    {               
        if(root.children.size() == 0 ) return String.valueOf(val);        
        List<Object> values = new ArrayList<>();
        for(Node n : root.children)
        {
            List<Object> kids = add(n);    
            values.add(kids);
        }       
        values.add(String.valueOf(root.val));        
        return values;        
    }   
}
*/
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
