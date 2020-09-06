/*
Problem Statement #
Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.

Example 1: #
Input: {1, 2, 3, 4}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
Example 2: #
Input: {1, 1, 3, 4, 7}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
Example 3: #
Input: {2, 3, 4, 6}
Output: False
Explanation: The given set cannot be partitioned into two subsets with equal sum.
 */
package com.github.nsgowda.dp.knapsack;

public class EqualSubsetSumPartition {

  public boolean canPartition(int[] num) {
    int n = num.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += num[i];
    }
    if (sum % 2 != 0) return false;
    sum /= 2;
    boolean dp[][] = new boolean[n][sum + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }

    for (int s = 1; s <= sum; s++) {
      dp[0][s] = num[0] == s ? true : false ;
    }

    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        {
          if (dp[i - 1][s]) {
            dp[i][s] = dp[i - 1][s];
          } else if (num[i] <= s) {
            dp[i][s] = dp[i - 1][s - num[i]];
          }
        }
      }
    }
    return dp[n-1][sum];
  }

  public static void main(String[] args) {
    EqualSubsetSumPartition ps = new EqualSubsetSumPartition();
    int[] num = {1, 2, 3, 4};
    System.out.println(ps.canPartition(num));
    num = new int[] {1, 1, 3, 4, 7};
    System.out.println(ps.canPartition(num));
    num = new int[] {2, 3, 4, 6};
    System.out.println(ps.canPartition(num));
  }
}
