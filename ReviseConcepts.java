public class PermutationChecker {
    public boolean check(string s1, string s2)
    {
        if(s1.length() != s2.length())
        {
            System.out.println("The strings dont match in length.");
            return false;
        }
        
	 //call heapsort
	    
    }
    public static void main(string args[]) 
    {
        
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
