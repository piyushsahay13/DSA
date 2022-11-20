/*
Implementation of Kadane Algorithm Implementation

Leet Code https://leetcode.com/problems/maximum-subarray/

*/
class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxl=0;
        int maxg= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(maxl+nums[i]<nums[i])
                maxl=nums[i];
            else
                maxl=maxl+nums[i];
            maxg= Math.max(maxl,maxg);
        }
        return maxg;
    }
}
