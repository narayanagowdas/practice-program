/*
Given the weights and profits of 'N' items, we are asked to put these items in a knapsack which has a capacity 'C'. The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as we don't have multiple quantities of any item.

Let's take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5

Let's try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5:

Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit

This shows that Banana + Melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.
 */
package com.github.nsgowda.dp.knapsack;

public class MaxProfit {

  static int solveKnapsack(int[] profits, int[] weights, int capacity) {
    if (weights.length == 0 || capacity <= 0 || weights.length != profits.length) {
      return 0;
    }
    int n = weights.length;
    int[][] dp = new int[n][capacity + 1];

    for (int i = 0; i < n; i++) {
      dp[i][0] = 0;
    }
    for (int c = 1; c <= capacity; c++) {
      if (c >= weights[0]) {
        dp[0][c] = profits[0];
      }
    }

    for (int i = 1; i < n; i++) {
      for (int c = 1; c <= capacity; c++) {
        int profit1 = 0;
        int profit2 = 0;
        if (c >= weights[i]) {
          profit1 = dp[i - 1][c - weights[i]] + profits[i];
        }
        profit2 = dp[i - 1][c];

        dp[i][c] = Math.max(profit1, profit2);
      }
    }
    printElements(dp,profits,weights,capacity);
    return dp[n - 1][capacity];
  }

  public static void printElements(int[][] dp, int[] profits, int[] weights, int capacity) {
    int n = profits.length;
    System.out.print("Selected weights:");
    int totalProfit = dp[n - 1][capacity];
    for (int i = n - 1; i > 0; i--) {
      if (totalProfit != dp[i - 1][capacity]) {
        totalProfit = totalProfit - profits[i];
        capacity = capacity - weights[i];
        System.out.print(" " + weights[i]);
      }
    }
    System.out.println("");
    if (totalProfit != 0) {
      System.out.println(weights[0]);
    }

  }

  public static void main(String[] args) {

//    int[] profits = {1, 6, 10, 16};
//    int[] weights = {1, 2, 3, 5};
    int[] profits = {15, 50, 60, 90};
    int[] weights = {1, 3, 4, 5};

//    System.out.println("MaxProfit : " + solveKnapsack(profits, weights, 8));
    System.out.println("MaxProfit : " + solveKnapsack(profits, weights, 6));
  }
}
