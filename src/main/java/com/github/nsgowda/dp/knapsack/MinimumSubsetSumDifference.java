/*
Problem Statement:
Given a set of positive numbers, partition the set into two subsets with a minimum difference between their subset sums.

Example 1: #
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where minimum absolute difference
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
 */
package com.github.nsgowda.dp.knapsack;

public class MinimumSubsetSumDifference {

  public int calculateMinimumSumDif(int[] num) {
    int n = num.length;
    int sum = 0;

    for (int i = 0; i < n; i++) {
      sum += num[i];
    }

    boolean[][] dp = new boolean[n][sum/2 + 1];
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }
    for (int s = 1; s <= sum/2; s++) {
      dp[0][s] = (num[0] == s) ? true : false;
    }

    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum/2; s++) {
        if (dp[i - 1][s]) {
          dp[i][s] = dp[i - 1][s];
        } else if (s >= num[i]) {
          dp[i][s] = dp[i - 1][s - num[i]];
        }
      }
    }

    int new_sum1 = 0;
    for (int i = sum/2; i >= 0; i--) {
      if (dp[n - 1][i] == true) {
        new_sum1 = i;
        break;
      }
    }
    int new_sum2 = sum - new_sum1;
    return Math.abs(new_sum1 - new_sum2);

  }

  public static void main(String[] args) {
    MinimumSubsetSumDifference ps = new MinimumSubsetSumDifference();

    int[] num = new int[] {1, 2, 3, 9};
    System.out.println("new1: " + ps.calculateMinimumSumDif(num));
    num = new int[] {1, 2, 7, 1, 5};
    System.out.println("new2: " + ps.calculateMinimumSumDif(num));
    num = new int[] {1, 3, 100, 4};
    System.out.println("new3: " + ps.calculateMinimumSumDif(num));
  }
}
