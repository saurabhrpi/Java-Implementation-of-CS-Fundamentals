public class PermutationChecker {
    public boolean check(String s1, String s2)
    {
        if(s1.length() != s2.length())
        {
            System.out.println("The strings dont match in length.");
            return false;
        }
        
    	 HeapSort hs = new HeapSort();
    	 char[] ch = s1.toCharArray();
    	 
    	 int[] out = hs.sort();
    	 ch = new char[out.length];
    	 for(i=0; i<out.length; i++)
    	 {
    	     ch[i] = (char)out[i];
    	 }
    	 
    	 System.out.println("s1 :" + s1);
    	 /*
    	 s2 = hs.sort(s2);  
    	 
    	 System.out.println("s1 :" + s1);
    	 System.out.println("s2 :" + s2);
    	 
    	for(int i=0; i < s1.length(); i++)
    	{
    	    if(s1.charAt(i) != s2.charAt(i))
    	    {
    	        return false;
    	    }
    	}
    	*/
    	return true;
    }
    public static void main(String args[]) 
    {
        String s1 = "abrakadabra";
        String s2 = "dabrakaabra";
        PermutationChecker pc = new PermutationChecker();
        if(!pc.check(s1,s2))
        {
            System.out.println("The strings are not a permutation of each other.");
        }
        else
        {
            System.out.println("The strings are indeed a permutation of each other.");
        }
    }
}

class HeapSort{
 public int[] sort(int[] input)
    {
        if(input == null || input.length == 0)
        {
            return "Invalid input";
        }
        
        int n = input.length;
        
        for(int i = n/2 - 1; i >= 0; i--)
        {
            heapify(input, n, i);     // first round to get the nth element in the right place
        }
        
        // rest of the rounds simply exclude and call heapify again
        
        for(int i = n - 1; i >= 0; i--)
        {
            int swap = input[0];
            input[0] = input[i];
            input[i] = swap;
            
            heapify(input, i, 0);     // n is used to exclude the last node
        }
        
        //String ret = new String(input);
        return input;
    }
 public void heapify(int[] input, int n, int i) 	
    {
    	int largest = i;
    	int left = 2*i + 1;
    	int right = 2*i + 2;
    	if(left < input.length && input[i] < input[left])
    	{
    		largest = left;
    	}
    	 
    	if(right < input.length && input[largest] < input[right])
    	{
    		largest = right;
    	}
    	 
    	if(largest != i)
    	{
    		int swap = input[largest]; // int ensures to process to both chars and int
    		input[largest] = input[i];
    		input[i] = swap;
    		heapify(input, n, largest);
    	}
    }	
}
