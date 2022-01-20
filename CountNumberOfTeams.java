// Leetcode Problem 1395
class Solution {
    // Intuition : Take total of smaller nos. from left and multiply it with
    // all greater ones on the right. Vice versa for greater on the left. 
    public int numTeams(int[] rating) {        
        int res = 0;     
        for(int i = 1; i < rating.length - 1; i++)
        {
            int less[] = new int[2], greater[] = new int[2];
            for(int j = 0; j < rating.length; j++)
            {
                if(rating[j] > rating[i])
                {
                    ++less[j > i? 1 : 0];   
                    // System.out.println("For rating[j] > rating[i]");
                    // System.out.println("for i = " + i + " j = " + j + (i > j?(" less[0] is increased by 1 " + less[0]) : (" less[1] is increased by 1 " + less[1])));
                }
                else if(rating[i] > rating[j])
                {
                    ++greater[i > j ? 0 : 1];      
                    // System.out.println("For rating[i] > rating[j]");
                    // System.out.println("for i = " + i + " j = " + j + (i > j?(" greater[0] is increased by 1 " + greater[0]) : (" greater[1] is increased by 1 " + greater[1])));
                }
            }
            // System.out.println("less[0] " + less[0]);
            // System.out.println("greater[1] " + greater[1]);
            // System.out.println("greater[0] " + greater[0]);
            // System.out.println("less[1] " + less[1]);
            res += less[0] * greater[1] + greater[0] * less[1];;
        }
        return res;
        
        // 4, 10, 5, 1, 11, 13
        // 5, 1, 13, 10, 4, 11
    }    
}
