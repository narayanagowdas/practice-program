/*
Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number 'S'.

Example 1: #
Input: {1, 1, 2, 3}, S=4
Output: 3
The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
Note that we have two similar sets {1, 3}, because we have two '1' in our input.
Example 2: #
Input: {1, 2, 7, 1, 5}, S=9
Output: 3
The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
 */

package com.github.nsgowda.dp.knapsack;

public class CountOfSubsetSum {

  public int countNumberOfSubsetSum(int[] num, int sum) {

    int n = num.length;
    int total = 0;
    for (int i = 0; i < n; i++) {
      total += num[i];
    }
    if (sum > total) {
      return -1;
    }
    int dp[][] = new int[n][sum + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = 1;
    }
    for (int s = 1; s <= sum; s++) {
      dp[0][s] = s == num[0] ? 1 : 0;
    }

    for( int i = 1; i < n; i++){
      for( int s = 1; s <= sum; s++){
        int s1=0;
        if(num[i]<=s){
         s1= dp[i-1][s-num[i]];
          }
        int s2= dp[i-1][s];

        dp[i][s]=s1+s2;
      }

    }
    return dp[n-1][sum];
  }

  public static void main(String[] args) {
    CountOfSubsetSum ss = new CountOfSubsetSum();
    int[] num = {1, 1, 2, 3};
    System.out.println(ss.countNumberOfSubsetSum(num, 4));
    num = new int[]{1, 2, 7, 1, 5};
    System.out.println(ss.countNumberOfSubsetSum(num, 9));
  }
}
