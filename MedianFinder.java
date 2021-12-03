class MedianFinder {
    // O(log(N)) : Final approach
    PriorityQueue<Integer> small = new PriorityQueue<Integer>(Collections.reverseOrder()); // to store the lower half in descending order.
    PriorityQueue<Integer> large = new PriorityQueue<Integer>(); // to store the upper half in ascending order.    
    boolean even = true; // refers to the existing count of elements.
    public MedianFinder() {           
       
    }
    public void addNum(int num) {        
       if(even) // that means num is at the odd numbered index.
       {
          large.offer(num); // make sure whatever is added to small is the smallest from large after //adding num.
          small.offer(large.poll()); // we're adding odd numbered index to small.
       }
       else
       {
           small.offer(num);
           large.offer(small.poll()); 
       }
       even = !even; // flip 
    }
    public double findMedian(){
        if(!even)
            return small.peek(); // since out of small and large, small has odd numbered elements.
        return (small.peek() + large.peek())/2.0;
    }
  
    // **** Other approaches ****
    
    /*
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int _val)
        {
            val = _val;
        }
        TreeNode()
        {
            
        }
    }
    int size;
    TreeNode root;
    int[] nums;    
    
    public MedianFinder() {           
       // O(log(n)) approach ends
       // ** O(n) approach starts 
       // not good enough 
       //nums = new int[0];        
      // ** O(n) approach ends 
    }
    
    public void addNum(int num) {       
        /* // **** O(n) approach starts **** 
        if(nums.length == 0)
        {
            nums = new int[1];
            nums[0] = num;
        }           
        else
        {
            int[] nums2 = new int[nums.length];
            for(int i = 0; i < nums2.length; i++)
            {
                nums2[i] = nums[i];
            }
            nums = new int[nums2.length + 1];            
            
            for(int i = 0; i < nums.length; i++)
            {
                if(i < nums2.length)
                    nums[i] = nums2[i];
                else
                    nums[i] = Integer.MAX_VALUE;
            }             
            
            for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] > num)
                {                   
                   for(int j = nums.length - 1; j > i;j--)
                   {
                       nums[j] = nums[j-1];
                   }
                   nums[i] = num;               
                   break; 
                }                
            }
            if(nums[nums.length - 1] == Integer.MAX_VALUE)
                nums[nums.length - 1] = num;
                // **** O(n) approach ends **** 
            */    
            //System.out.println("printing arr at the end of add ");
            //for(int x : nums)
             //   System.out.println(x);
        //}        
        
        // ***** Brute Force starts *****    
        //nums.add(num);        
        // ***** Brute Force ends *****    
        
        /* // My Implementation attempt starts ***
        size++;
        System.out.println("adding num ");
        root = fitNodeIntoTree(root,new TreeNode(num)); 
        System.out.println("num added ");
        int height = 0;
        int lHeight = checkHeight(root.left, height);
        System.out.println("lHeight " + lHeight);
        int rHeight = checkHeight(root.right, height);        
        System.out.println("rHeight " + rHeight);
        
        int heightDiff = rHeight - lHeight;
        if((heightDiff > 1) || (heightDiff < 0))
            root = reArrangeTree(root, heightDiff);
        //System.out.println("Start printing the tree");
        //printTree(root,0);
        //System.out.println("End of printing of tree");        
        // My Implementation attempt ends ***
        */
    //}
    /*
    public double findMedian() 
    {
        
        // O(N) approach starts 
        /*
        if(nums.length % 2 != 0)
            return nums[nums.length/2];        
        return (nums[(nums.length/2) - 1] + nums[nums.length/2])/2.0;
        // O(N) approach ends
        */
        // ***** Brute Force starts *****
        /*
        int[] numsArr = new int[nums.size()];
        for(int i = 0 ; i < numsArr.length; i++)
        {
            numsArr[i] = nums.get(i);
        }
        Arrays.sort(numsArr);
        
        if(nums.size() % 2 != 0)
            return numsArr[numsArr.length/2];
        return (numsArr[(numsArr.length/2) - 1] + numsArr[numsArr.length/2])/2.0;
        // ***** Brute Force ends *****        
        */        
        
        // ************ My Implementation attempt starts ************
        /*
        if(size % 2 != 0)
            return root.val;
        return (root.val + root.right.val)/2.0;
        */
        // ************ My Implementation attempt ends ************    
    //}
    
    //*************** My Implementation attempt starts ***************
    public int checkHeight(TreeNode root, int height)
    {
        if(root == null)
            return height;
        height++;
        System.out.println("node passed " + root.val);
        int lHeight = checkHeight(root.left, height);
        int rHeight = checkHeight(root.right, height);
        return Math.max(lHeight, rHeight);
    }
    
    public TreeNode reArrangeTree(TreeNode root, int heightDiff)
    {        
       if(heightDiff > 0)
       {         
           TreeNode temp = root.right;
           root.right = null;
           return fitNodeIntoTree(temp, root);           
       }
       TreeNode temp = root.left;
       root.left = null;
       return fitNodeIntoTree(temp, root); 
    }
    
    public void printTree(TreeNode root, int space)
    {
        if(root == null)
            return;
        int x = 0;
        if(space >= 0)
        {    
            System.out.print(root.val);
            while(x < space)
            {
                System.out.print(" ");    
                x++;
            }   
            System.out.println(" ");    
        }
        else
        {                    
            while(x > space)
            {
                System.out.print(" ");    
                x--;
            }
            System.out.println(root.val);
        }        
        printTree(root.left, space + 2);
        printTree(root.right, space - 2);
    }
    
    public TreeNode fitNodeIntoTree(TreeNode root, TreeNode n)
    {       
        if(root == null)
        {
            //root = new TreeNode(num);
            System.out.println("returning when root is found to be null " + n.val);
            root = n;
            return root;
        }        
        if(n.val < root.val)
        {
            System.out.println("going into left");
            root.left = fitNodeIntoTree(root.left, n);            
        }
        else 
        {
            System.out.println("going into right");
            root.right = fitNodeIntoTree(root.right, n);            
        }
        System.out.println("returning at the end of method " + root.val);
        return root;
    }   
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
