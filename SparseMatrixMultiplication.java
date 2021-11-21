class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
      // matrix multiplication rule:
      // take 1st row of the 1st matrix, transpose it, put it next to the 1st column of the next matrix 
      //and multiply every element of 1st row (1st matrix) with corresponding element of the 2nd matrix 's 
      //1st column followed by summing them up.This will give you the resulting matrix's 1,1 element. Then 
      //transponsed 1st row of 1st matrix with 2nd column of 2nd matrix similarly and this will give you 1,2 
      //element of the resulting matrix. And so on.
        
      // To implement using compress matrix method to improve space complexity.  
      // https://leetcode.com/problems/sparse-matrix-multiplication/discuss/419538/What-the-interviewer-is-expecting-when-this-problem-is-asked-in-an-interview.../609663
    }
    
    //my impl
    public int[][] myImpl(int[][] mat1, int[] mat2)
    {
        int[][] res = new int[mat1.length][mat2[0].length];
        for(int m = 0; m < mat1.length; m++)
        {
            int k = 0;
            while(k < mat2[0].length)
            {
                int prod = 0;
                for(int n = 0; n < mat2.length; n++)
                {     
                    if(mat2[n][k] != 0 && mat1[m][n] != 0)
                        prod += (mat1[m][n])*(mat2[n][k]);
                }
                res[m][k] = prod;
                k++;
            }            
        }
        return res;
    }
}
