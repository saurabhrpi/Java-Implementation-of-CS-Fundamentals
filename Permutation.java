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

/*
public class Permutation{
    public boolean isAperm(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
	HeapSort hs = new HeapSort();
	
	int[] s1arr = new int[s1.length()];	
	int[] s2arr = new int[s2.length()];
	
	for(int i = 0;i < s1.length(); i++)
	{
		s1arr[i] = s1.charAt(i);
		s2arr[i] = s2.charAt(i);
	}

         hs.sort(s1arr);
         hs.sort(s2arr);
        
	char c,d;
	s1 = ""; 
	s2 = "";
	for(int i = 0; i < s1arr.length; i++)
	{
		c = (char)s1arr[i];
		s1 = s1 + c;
		d = (char)s2arr[i];
		s2 = s2 + d;
	}

        for(int i = 0; i < s1.length(); i++)
        {
            if(s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
    String s1 = "becdkol";
    String s2 = "dalkocb";
    if((s1 != null && s1.length() > 0) && (s2 != null && s2.length() > 0))
        {
            Permutation p = new Permutation();
            if(p.isAperm(s1,s2)){
                System.out.println("Stringsa re a permutation of each other");
            }
            else{
                System.out.println("Stringsa re not a permutation of each other");
            }
        }
    else
        {
            System.out.println("One or more of the string inputs were found to be null or empty");
        }
    }

}

*/
  
