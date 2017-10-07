public class CompressString {
    public void compressIt(StringBuilder sb){
	    int[] ind = new int[sb.length()];
	    int j = 0;
	    ind[j] = 1;
	    char[] ch = new char[sb.length()];
	    ch[j] = sb.charAt(j);
	    for(int i=0; i < sb.length() - 1; i++){
	        if(sb.charAt(i) == sb.charAt(i+1)){
	            ind[j]++;        
	        }
	        else{
	            j++;
	            ind[j] = 1;
	            ch[j] = sb.charAt(i+1);
	        }
	    }
	    
	    // Reusing the stringbuilder since recreating it would be even slower.
	    // https://codereview.stackexchange.com/a/7637
	    
	    sb = sb.delete(0,sb.length()); 
	    
	    for(int i=0; i < ind.length; i++){
	        if(ch[i] != '\u0000' && ind[i] > 0){
	            sb.append(ch[i]);
	            sb.append(ind[i]);
	        }
	    }
    }    
    
    public static void main(String args[]) {
        String inp = "aaabbccccaae";
        StringBuilder sb = new StringBuilder(inp);
        CompressString c = new CompressString();
        c.compressIt(sb);
    	if(sb.length() >= inp.length()){
    	    System.out.println("Compression was not effective. Here is the original string " + inp);
    	}
    	else{
    	    System.out.println("Compression successful. Here is the new string " + sb);
    	}
    }
}

 
 
