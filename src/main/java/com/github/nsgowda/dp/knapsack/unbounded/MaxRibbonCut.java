/**
 * We are given a ribbon of length 'n' and a set of possible ribbon lengths. Now we need to cut the
 * ribbon into the maximum number of pieces that comply with the above-mentioned possible lengths.
 * Write a method that will return the count of pieces.
 *
 * <p>Example 1:
 *
 * <p>n: 5 Ribbon Lengths: {2,3,5} Output: 2 Explanation: Ribbon pieces will be {2,3}. Example 2:
 *
 * <p>n: 7 Ribbon Lengths: {2,3} Output: 3 Explanation: Ribbon pieces will be {2,2,3}. Example 3:
 *
 * <p>n: 13 Ribbon Lengths: {3,5,7} Output: 3 Explanation: Ribbon pieces will be {3,3,7}.
 */
package com.github.nsgowda.dp.knapsack.unbounded;

/**
 * for each length 'l' create a new set which includes one quantity of length 'l' if it does not
 * exceed 'n', and recursively call to process all lengths create a new set without length 'l', and
 * recursively call to process the remaining lengths return the number of pieces from the above two
 * sets with a higher number of pieces
 */
public class MaxRibbonCut {
  public int countRibbonPieces(int[] ribbonLengths, int total) {
    int n = ribbonLengths.length;
    int[][] dp = new int[n][total + 1];

    for (int i = 0; i < n; i++) for (int j = 0; j <= total; j++) dp[i][j] = Integer.MIN_VALUE;

    // populate the total=0 columns, as we don't need any ribbon to make zero total
    for (int i = 0; i < n; i++) dp[i][0] = 0;

    for (int i = 0; i < n; i++) {
      for (int t = 1; t <= total; t++) {
        if (i > 0) // exclude the ribbon
        dp[i][t] = dp[i - 1][t];
        // include the ribbon and check if the remaining length can be cut into available lengths
        if (t >= ribbonLengths[i] && dp[i][t - ribbonLengths[i]] != Integer.MIN_VALUE)
          dp[i][t] = Math.max(dp[i][t], dp[i][t - ribbonLengths[i]] + 1);
      }
    }

    // total combinations will be at the bottom-right corner, return '-1' if cutting is not possible
    return (dp[n - 1][total] == Integer.MIN_VALUE ? -1 : dp[n - 1][total]);
  }

  public static void main(String[] args) {
    MaxRibbonCut cr = new MaxRibbonCut();
    int[] ribbonLengths = {2, 3, 5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
    ribbonLengths = new int[] {2, 3};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    ribbonLengths = new int[] {5, 3, 7};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
    ribbonLengths = new int[] {3, 5};
    System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
  }
}
