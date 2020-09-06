/**
 * Given the weights and profits of 'N' items, we are asked to put these items in a knapsack which
 * has a capacity 'C'. The goal is to get the maximum profit from the items in the knapsack. The
 * only difference between the 0/1 Knapsack problem and this problem is that we are allowed to use
 * an unlimited quantity of an item.
 *
 * <p>Let's take the example of Merry, who wants to carry some fruits in the knapsack to get maximum
 * profit. Here are the weights and profits of the fruits:
 *
 * <p>Items: { Apple, Orange, Melon } Weights: { 1, 2, 3 } Profits: { 15, 20, 50 } Knapsack
 * capacity: 5
 *
 * <p>Let's try to put different combinations of fruits in the knapsack, such that their total
 * weight is not more than 5.
 *
 * <p>5 Apples (total weight 5) => 75 profit 1 Apple + 2 Oranges (total weight 5) => 55 profit 2
 * Apples + 1 Melon (total weight 5) => 80 profit 1 Orange + 1 Melon (total weight 5) => 70 profit
 *
 * <p>This shows that 2 apples + 1 melon is the best combination, as it gives us the maximum profit
 * and the total weight does not exceed the capacity.
 */
package com.github.nsgowda.dp.knapsack.unbounded;

/**
 * for each item 'i' create a new set which includes one quantity of item 'i' if it does not *
 * exceed the capacity, and recursively call to process all items create a new set without item 'i',
 * and recursively process the remaining items return the set from the above two sets with higher
 * profit
 */
public class MaxProfit {

  public int solveKnapsack(int[] profit, int[] weights, int capacity) {

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
    MaxProfit ks = new MaxProfit();
    int[] profits = {15, 20, 50};
    int[] weights = {1, 2, 3};
    System.out.println(ks.solveKnapsack(profits, weights, 5));
    //    System.out.println(ks.solveKnapsack(profits, weights, 6));
  }
}
