public class URLify {
    public static void main(String args[]) {
        char [] ch = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' ',' ',' ',' '};
        int n = 13;
        URLify u = new URLify();
        u.replaceChar(ch,n);
        System.out.println(ch);
    }
    public void replaceChar(char[] c, int n){
        char swap;
        int start = n - 1;
        int end = start;
        for(;start>0;start--)
        {
            if(c[start] == ' '){
                int mark = end;
                while(mark != start){
                    swap = c[mark];
                    c[mark+2] = swap;
                    mark--;
                }
                end += 2;
                c[start] = '%';
                c[start+1] = '2';
                c[start+2] = '0';
            }
        }
    }
}
 
