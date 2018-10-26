class Tree
{
    public void printTree(Node temp, int i)
    {
        if(temp != null)
        {
            System.out.println("start of level " + i);
            System.out.println(temp.data);
            
            Node left = null;
            Node right = null;
            
            if(temp.children.size() != 0)
            {
                left = temp.children.get(0);
                
                if(left != null)
                {
                    System.out.println("left child " + left.data);   
                }
                
            }    
            
            if(temp.children.size() > 1)
            {    
                right = temp.children.get(1);
                
                if(right != null)
                {
                    System.out.println("right child " + right.data);   
                }
                
            }
             
             System.out.println("end of level " + i);
             i++;
             
             if(left != null)
             {
                printTree(left, i);   
             }
             
             if(right != null)
             {
                printTree(right, i); 
             }  
        }
    }
}

public class MinimalTree{
    
    public Node minimize(int[] inp)
    {
        if(inp != null)
        {
            if(inp.length == 0)
            {
                return null;   
            }
    
            Node root = new Node(inp[inp.length/2]);
            
            if(inp.length > 1)
            {
                int[] right = Arrays.copyOfRange(inp,((inp.length)/2) + 1,inp.length);
                int[] left = Arrays.copyOfRange(inp, 0, (inp.length)/2); 
                
                Node rc = minimize(right);
                Node lc = minimize(left);
                
                root.children.add(lc);
                root.children.add(rc);
            }
            return root;
        }
        return null;        
    }
    
    public static void main(String[] args)
    {
        int[] inp = {14, 29, 37, 44, 50, 100, 110, 190, 200, 400};
        
        MinimalTree mt = new MinimalTree();
        
        Node temp = mt.minimize(inp);
        
        Tree t = new Tree();
        
        System.out.println("**********printing tree***********");
        t.printTree(temp, 0);
    }
}
	
