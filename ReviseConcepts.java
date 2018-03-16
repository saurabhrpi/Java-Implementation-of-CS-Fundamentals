public class PermutationChecker {
    public boolean check(string s1, string s2)
    {
        if(s1.length() != s2.length())
        {
            System.out.println("The strings dont match in length.");
            return false;
        }
        
    	 HeapSort hs = new HeapSort();
    	 s1 = hs.sort(s1);
    	 s2 = hs.sort(s2);  
    	 
    	for(int i=0; i < s1.length(); i++)
    	{
    	    if(s1.charAt(i) != s2.charAt(i))
    	    {
    	        return false;
    	    }
    	}
    	return true;
    }
    public static void main(string args[]) 
    {
        string s1 = 'abrakadabra';
        string s2 = 'dabrakaabra';
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
 public string sort(string str)
    {
        if(str == null or str.length() == 0)
        {
            return "Invalid String";
        }
        char[] ch = str.toCharArray();	
        for(int i = n/2 - 1; i >= 0; i--)
        {
            heapify(ch, i);    
        }
        
    }
 public void heapify(char[] ch, int i) 	
    {
	int largest = i;
	int left = 2*i + 1;
	int right = 2*i + 2;
	if(i < ch.length && ch[i] < ch[left])
	{
		largest = left;
	}
	 
	if(i < ch.length && ch[largest] < ch[right])
	{
		largest = right;
	}
	 
	if(largest != i)
	{
		int swap = ch[largest];
		ch[largest] = ch[i];
		ch[i] = swap;
		heapify(ch, largest);
	}
    }	
}
