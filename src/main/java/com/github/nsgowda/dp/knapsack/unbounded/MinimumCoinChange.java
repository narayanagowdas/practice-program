/**
 * Given an infinite supply of 'n' coin denominations and a total money amount, we are asked to find
 * the minimum number of coins needed to make up that amount.
 *
 * <p>Example 1:
 *
 * <p>Denominations: {1,2,3} Total amount: 5 Output: 2 Explanation: We need minimum of two coins
 * {2,3} to make a total of '5' Example 2:
 *
 * <p>Denominations: {1,2,3} Total amount: 11 Output: 4 Explanation: We need minimum four coins
 * {2,3,3,3} to make a total of '11'
 */
package com.github.nsgowda.dp.knapsack.unbounded;

/**
 * for each coin 'c' create a new set which includes one quantity of coin 'c' if it does not exceed
 * 'T', and recursively call to process all coins create a new set without coin 'c', and recursively
 * call to process the remaining coins return the count of coins from the above two sets with a
 * smaller number of coins
 */
public class MinimumCoinChange {

  public static int minimumCoins(int[] denominations, int total) {
    int n = denominations.length;
    if (total == 0) {
      return 0;
    } else if (n == 0) {
      return -1;
    }
    int dp[][] = new int[n][total + 1];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= total; j++) {
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    for (int d = 0; d < n; d++) {
      dp[d][0] = 0;
    }
    for (int d = 0; d < n; d++) {
      for (int t = 1; t <= total; t++) {

        if (d > 0) {
          dp[d][t] = dp[d - 1][t]; // exclude
        }

        if (t >= denominations[d]) {
          if (dp[d][t - denominations[d]] != Integer.MAX_VALUE) {
            dp[d][t] = Math.min(dp[d][t], dp[d][t - denominations[d]] + 1); // include
          }
        }
      }
    }
    return dp[n - 1][total] == Integer.MAX_VALUE ? -1 : dp[n - 1][total];
  }

  public static void main(String[] args) {
    MinimumCoinChange cc = new MinimumCoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.minimumCoins(denominations, 5));
    System.out.println(cc.minimumCoins(denominations, 11));
    System.out.println(cc.minimumCoins(denominations, 7));
    denominations = new int[] {3, 5};
    System.out.println(cc.minimumCoins(denominations, 7));
  }
}
