/*Get minimum coins required to get the specific amount
eg coins = [1,2,5]
    amount = 11
    o/p = 3
    exp. 5+5+1 =3 coins
    */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        Arrays.sort(coins);
        int res= unboundedknapsack(coins,amount,coins.length);
        if(res==Integer.MAX_VALUE-1)
            return -1;
        return res;
    }
    
    public int unboundedknapsack(int[] arr,int amount,int n){
        int dp[][] = new int[n+1][amount+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<amount+1;j++){
                if(j==0)
                    dp[i][j]=0;
                if(i==0)
                    dp[i][j]=Integer.MAX_VALUE-1;
            }
        }
        dp[0][0] =Integer.MAX_VALUE-1;
      /*Initializing first row to get the count of the coins required when we have coins[0] and amount 1-n*/
        for(int j=1;j<amount+1;j++){
            if(j%arr[0]==0)
                dp[1][j] = j/arr[0];
            else
                dp[1][j] = Integer.MAX_VALUE-1;
        }
        for(int i=2;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-arr[i-1]]+1);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
