/*
Problem Statement #
Given a set of positive numbers, determine if there exists a subset whose sum is equal to a given number 'S'.

Example 1: #
Input: {1, 2, 3, 7}, S=6
Output: True
The given set has a subset whose sum is '6': {1, 2, 3}
Example 2: #
Input: {1, 3, 4, 8}, S=6
Output: False
The given set does not have any subset whose sum is equal to '6'.
 */
package com.github.nsgowda.dp.knapsack;

public class SubsetSum {

  public boolean canSubsetSum(int[] num, int sum) {
    int n = num.length;
    if (sum == 0) {
      return true;
    }
    boolean[][] dp = new boolean[n][sum + 1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }
    for (int s = 1; s <= sum; s++) {
      dp[0][s] = (s == num[0]) ? true : false;
    }

    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        if (dp[i - 1][s]) {
          dp[i][s] = dp[i - 1][s];
        } else if (num[i] <= s) {
          dp[i][s] = dp[i - 1][s - num[i]];
        }
      }
    }
    return dp[n - 1][sum];
  }

  public static void main(String[] args) {
    SubsetSum ss = new SubsetSum();
    int[] num = {1, 2, 3, 7};
    System.out.println(ss.canSubsetSum(num, 6));
    num = new int[] {1, 2, 7, 1, 5};
    System.out.println(ss.canSubsetSum(num, 10));
    num = new int[] {1, 3, 4, 8};
    System.out.println(ss.canSubsetSum(num, 6));
  }
}
