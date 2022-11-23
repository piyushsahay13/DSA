//Using Unbounded knapsack problem


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

class Solution{
    public int cutRod(int price[], int n) {
        /*Price = val 
          arr created using size ie n
          
          */
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        /*found max profit since using repeated elements then used unbounded knapsack*/
        return unboundedKnapsack(price,arr,n);
    }
    public int unboundedKnapsack(int val[],int arr[],int n){
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 ||j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(arr[i-1]<=j)
                              /*Not Selected element, Selected element can be used again hence dp[i][j-arr[i-1]] and not dp[i-1][j-arr[i-1]]*/
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i][j-arr[i-1]]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][n];
    }
}
