/*
Leet Code https://leetcode.com/problems/sqrtx/
Use Binary Search to find the sqrt of the given number 
eq num =9 will have it's sqrt in between 1-9
1,2,3,4,5,6,7,8,9
and for Non -perfect square at last mid and high will become same
eq 12
low=1 high=12 mid=6
low=1 high=6 mid=3
low=3 high=6 mid=4
low=3 high=4 mid=3
3
*/

class Sqrt {
    public static void main(String[] args) {
    
        int num = 0;
        int res = mySqrt(num);
    }
    public static int mySqrt(int x) {
          if(x==1)
              return 1;
          int low=1; //
          int high=x;
          int mid=0;
          while(low<high){
               mid = (low+high)/2;
              // System.out.println("low="+low+" high="+high+" mid="+mid);
              if(x/mid == mid)
                  return mid;
              else if(x/mid<mid){
                  high = mid;
              }
              else{
                  if(mid == low) //Condiition for non perfect square
                      return mid;
                  low = mid;

              }
          }
          return mid;
          // System.out.println(mid);
      }
}
