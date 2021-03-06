
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
  
