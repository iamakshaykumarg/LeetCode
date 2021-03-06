/*

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^

*/

class Solution {
    public int numDistinct(String s, String t) {
        
        int len1 = s.length();
        int len2 = t.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for(int i=0;i<=len1;i++)
            dp[i][0]=1;
        
        for(int i=1;i<=len1;i++){
            
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[len1][len2];
    }
}
