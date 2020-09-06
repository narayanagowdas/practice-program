/**
 * Problem Statement # Given a rod of length 'n', we are asked to cut the rod and sell the pieces in
 * a way that will maximize the profit. We are also given the price of every piece of length 'i'
 * where '1 <= i <= n'.
 *
 * <p>Example:
 *
 * <p>Lengths: [1, 2, 3, 4, 5] Prices: [2, 6, 7, 10, 13] Rod Length: 5
 *
 * <p>Let's try different combinations of cutting the rod:
 *
 * <p>Five pieces of length 1 => 10 price Two pieces of length 2 and one piece of length 1 => 14
 * price One piece of length 3 and two pieces of length 1 => 11 price One piece of length 3 and one
 * piece of length 2 => 13 price One piece of length 4 and one piece of length 1 => 12 price One
 * piece of length 5 => 13 price
 *
 * <p>This shows that we get the maximum price (14) by cutting the rod into two pieces of length '2'
 * and one piece of length '1'.
 */
package com.github.nsgowda.dp.knapsack.unbounded;

/*
for each rod length 'i'
  create a new set which includes one quantity of length 'i', and recursively process
      all rod lengths for the remaining length
  create a new set without rod length 'i', and recursively process for remaining rod lengths
return the set from the above two sets with a higher sales price.
 */

public class RodCut {

  public int solveRodCutting(int[] weights, int[] profit, int capacity) {

    if (weights.length != profit.length || capacity == 0 || profit.length == 0) {
      return 0;
    }

    int dp[][] = new int[weights.length][capacity + 1];

    for (int i = 0; i < weights.length; i++) {
      dp[i][0] = 0;
    }

    for (int i = 0; i < weights.length; i++) {
      for (int c = 1; c <= capacity; c++) {
        int max1 = 0;
        int max2 = 0;
        if (weights[i] <= c) {
          max1 = dp[i][c - weights[i]] + profit[i];
        }
        if (i > 0) {
          max2 = dp[i - 1][c];
        }
        dp[i][c] = Math.max(max1, max2);
      }
    }
    return dp[weights.length - 1][capacity];
  }

  public static void main(String[] args) {
    RodCut rc = new RodCut();
    int[] lengths = {1, 2, 3, 4, 5};
    int[] prices = {2, 6, 7, 10, 13};
    int maxProfit = rc.solveRodCutting(lengths, prices, 5);
    System.out.println(maxProfit);
  }
}
