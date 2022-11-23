//Corner Cases
// [1,1,1,1,1]
// 3
// [1]
// 1
// [7,9,3,8,0,2,4,8,3,9]
// 0
// [1,2,1]
// 0
// [5,2,2,7,3,7,9,0,2,3]
// 9
// [100]
// -200
// [1000]
// -1000


/*
    Reducing problem logic 
    s1 = subset 1
    s2 = subset 2
    sum(s1) - sum(s2) =target
    sum(s1) + sum(s2) =sum(arr)
    ---------------------------
    sum(s1) = (target +sum(arr))/2
*/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //Corner case when sums length is 1 target sum expected greater or less than target eg. [100] -200
        if(nums.length==1 && Math.abs(target)!=nums[0]){
            return 0;
        }
        int sum = Arrays.stream(nums).sum();
        int subSum=0;
        int result=0;
        int subSum2=0;
        /*Corner Case when target is 0 sum is odd*/
        if(target==0 && sum%2!=0){
            return result;   
        }
        /* Corner Case*/
        if (sum==target){
            result= countZero(nums,nums.length,sum);
            if(result>0)
                return result;
        }
//         System.out.println("Target="+target+" Sum="+sum);
        subSum = (target+sum)/2;
        subSum2=sum-subSum;
        if(subSum-subSum2!=target)
            return result;
        /*to count no of subset present for the given sum */
        result = knapsack(nums,nums.length,subSum);
        return result;
    }
    public int knapsack(int nums[],int len, int sum){
        int dp[][] = new int[len+1][sum+1];
        /*Initialization of 0th row and coloumn */
        for(int i=0;i<len+1;i++){
            for (int j=0;j<sum+1;j++){
                if(i==0)
                    dp[i][j] = 0;
                if(j==0)
                    dp[i][j] = 1;
            }
        }
        /* Traversing through the subproblems to get the final result*/
        for(int i=1;i<len+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
                }
            }
        return dp[len][sum];
    }
    //When target sum is 0 eg. [1,0,0,0,0] 1 o/p=16 16 combinations can form sum 1 this can also be done by making knapsack inner loop of subset problem from j=1 to j=0
    public int countZero(int nums[],int len,int sum){
        int countZero =0;
        for(int i=0;i<len;i++)
        {
            if(nums[i]==0)
                countZero++;
        }
        if (countZero == len-1)
            return (int)Math.pow(2,countZero);
        return 0;
    }
}
