/*
We need to find two such parttiton to get min diff of those partion
1st partition = s1
2nd Partition s2= TotalSum - s1
result s1-s2 = min
susbsituuting value 
s1 -totalsum +s1 = totalsum -2s1;
final result = totalsum-2s1
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
        int min=Integer.MAX_VALUE;
        int sum =0;
        for (int i=0;i<arr.length;i++){
            sum = sum + arr[i];
        }
        // System.out.println("Sum="+sum);
        List<Integer> res = knapsack(arr,sum,arr.length);
        // System.out.println("List="+res);
        for(int x : res){
            int diff= sum-Math.abs(2*x);
            if(diff<min)
                min = diff;
        }
        return min;
    }
    public List<Integer> knapsack(int nums[], int sum,int len){
        List<Integer> result = new ArrayList<>(); 
        boolean dp[][] = new boolean[len+1][sum+1];
        /*Initialization of 0th row and coloumn*/ 
        for(int i=0;i<len+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j] = true;
                }
            }
        }
        /*Going through each subproble to get the solution at last*/
        for(int i=1;i<len+1;i++){
            for(int j=1;j<sum+1;j++){
                if(nums[i-1]<=j)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
       /*for dp[len][] coloum  will contain all sum of subsets that can be formed from the given array that we need to put value of S1 and check in equation result- 2s1*/
        for(int i=0;i<=sum/2;i++){
            if(dp[len][i])
                result.add(i);
        }
        return result;
	} 
}
