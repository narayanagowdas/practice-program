/*
Given an infinite supply of 'n' coin denominations and a total money amount, we are asked to find the total number of distinct ways to make up that amount.

Example:

Denominations: {1,2,3}
Total amount: 5
Output: 5
Explanation: There are five ways to make the change for '5', here are those ways:
  1. {1,1,1,1,1}
  2. {1,1,1,2}
  3. {1,2,2}
  4. {1,1,3}
  5. {2,3}
 */
package com.github.nsgowda.dp.knapsack.unbounded;
/*
for each coin 'c'
  create a new set which includes one quantity of coin 'c' if it does not exceed 'T', and
     recursively call to process all coins
  create a new set without coin 'c', and recursively call to process the remaining coins
return the count of sets who have a sum equal to 'T'
 */

public class CoinChange {

  public static int findNumberOfWays(int[] denominations, int total) {
    int n = denominations.length;
    if (total == 0) {
      return 0;
    } else if (n == 0) {
      return -1;
    }
    int dp[][] = new int[n][total + 1];

    for (int d = 0; d < n; d++) {
      dp[d][0] = 1;
    }
    for (int d = 0; d < n; d++) {
      for (int t = 1; t <= total; t++) {
        int v1 = 0;
        int v2 = 0;
        if (t >= denominations[d]) {
          v1 = dp[d][t - denominations[d]];
        }
        if (d > 0) {
          v2 = dp[d - 1][t];
        }

        dp[d][t] = v1 + v2;
      }
    }
    return dp[n - 1][total];
  }

  public static int countChange(int[] denominations, int total) {
    int n = denominations.length;
    int[][] dp = new int[n][total + 1];

    // populate the total=0 columns, as we will always have an empty set for zero toal
    for (int i = 0; i < n; i++) dp[i][0] = 1;

    // process all sub-arrays for all capacities
    for (int i = 0; i < n; i++) {
      for (int t = 1; t <= total; t++) {
        if (i > 0) dp[i][t] = dp[i - 1][t];
        if (t >= denominations[i]) dp[i][t] += dp[i][t - denominations[i]];
      }
    }

    // total combinations will be at the bottom-right corner.
    return dp[n - 1][total];
  }

  public static void main(String[] args) {
    int[] denominations = {1, 2, 3};
    System.out.println(" Total number of ways: " + findNumberOfWays(denominations, 5));
    System.out.println(" Total number of ways: " + countChange(denominations, 5));
  }
}
