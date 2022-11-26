class Solution {
    public int rob(int[] nums) {
        return countMax(nums, nums.length);
    }
    public int countMax(int arr[],int n){
        int dp[] = new int[n+1];
        /*if there is no house in that case rob done will be zero*/
        dp[0]=0;
        /*rob amount for first house*/
        dp[1]=arr[0];
        /*max amount can be provided at last elemt of array*/
        for(int i=2;i<n+1;i++) 
            dp[i] = Math.max(arr[i-1]+dp[i-2],dp[i-1]);
        return dp[n];
    }
}
