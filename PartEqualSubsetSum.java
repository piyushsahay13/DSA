class Solution {
    public boolean canPartition(int[] nums) {
      
        /*
          If the array is equal sum partiiton then sum of two partition will be equal that means sum of array will be even 
          if Sum is even then we can apply knapsack to find the susbset (if one subset ie. sum/2 found other will be present) 
        */
        int sum=0;
        boolean result =false;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if(sum%2!=0)
            return result;
        else{
            result = knapsack(nums,sum/2,nums.length);   
        }
        return result;
    }
  
   /*1/0 KnapSack Implemention*/
    public boolean knapsack(int[] nums,int W, int N) {
        boolean dp[][] = new boolean[N+1][W+1];
        for(int i=0;i<N+1;i++) {
            for(int j=0;j<W+1;j++) {
                if(i==0)
                    dp[i][j] = false;
                if(j==0)
                    dp[i][j] = true;
            }
        }
        for(int i=1;i<N+1;i++) {
            for(int j=1;j<W+1;j++) {
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
}
