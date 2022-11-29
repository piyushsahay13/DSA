/*
https://leetcode.com/problems/delete-operation-for-two-strings/
Minimum elemts to be removed from strings1 to get String2 as the result
str1: sea
str2: eat
o/p = 2
1 deletion 
1 insertion
------------------------------------
Refducing problem
Counting LCS = 2
Since 2 elements are common in both that does not need to be removed from 1 
only len(str1) - lcs need to be removed ie s
for Str2 = len(str2) -lcs need s to be added to str1 ie t
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int m= word1.length();
        int n= word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return (m+n-2*dp[m][n]);
    }
}
