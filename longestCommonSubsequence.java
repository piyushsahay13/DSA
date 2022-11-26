
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1,text2,text1.length(),text2.length());
    }
    public int lcs(String text1, String text2, int m, int n){
        int dp[][] = new int[m+1][n+1];
        /*Initialized row and coloum to 0 if any of the string size is 0 in that case no subsequene can be formed*/
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        /*tabulation to get the subcases*/
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    /*If character matches adding a count to exisitng sub case*/
                    dp[i][j] =1+dp[i-1][j-1];
                else
                    /*Two cases if not mached
                    1st string current element(i) can match to other string rest of elemnt(j-1) and vice versa whichever is max*/
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }
}
