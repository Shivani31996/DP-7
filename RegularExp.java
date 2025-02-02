// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*Approach - DP
 * 1 - Tabulation method - row side string S and column side string p
 * 2 - If character in S and P is not a * then that means it is a character or a . so we can take value in its upper left diagonal.
 * If character is a *, then take the zero case value which is 2 steps back in the same row. Then check if the character
 * before the star is the same. IF yes, then do the OR operation on 0 case (2 steps back in the same row) and 1 case(same column above row.)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for(int j = 1; j<=n; j++)
        {
            if(p.charAt(j-1) == '*')
            {
                dp[0][j] = dp[0][j-2];
            }
        }
        
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(p.charAt(j-1) != '*')
                {
                    if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
                else
                {
                    dp[i][j] = dp[i][j-2];
                    if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')
                    {
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}