/*
Given a set of positive numbers (non zero) and a target sum 'S'. Each number should be assigned either a '+' or '-' sign. We need to find out total ways to assign symbols to make the sum of numbers equal to target 'S'.

Example 1: #
Input: {1, 1, 2, 3}, S=1
Output: 3
Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
Example 2: #
Input: {1, 2, 7, 1}, S=9
Output: 2
Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}
 */

/*
We are asked to find two subsets of the given numbers whose difference is equal to the given target 'S'. Take the first example above. As we saw, one solution is {+1-1-2+3}. So, the two subsets we are asked to find are {1, 3} & {1, 2} because,

    (1 + 3) - (1 + 2 ) = 1
Now, let's say 'Sum(s1)' denotes the total sum of set 's1', and 'Sum(s2)' denotes the total sum of set 's2'. So the required equation is:

    Sum(s1) - Sum(s2) = S
This equation can be reduced to the subset sum problem. Let's assume that 'Sum(num)' denotes the total sum of all the numbers, therefore:

    Sum(s1) + Sum(s2) = Sum(num)
Let's add the above two equations:

    => Sum(s1) - Sum(s2) + Sum(s1) + Sum(s2) = S + Sum(num)
    => 2 * Sum(s1) =  S + Sum(num)
    => Sum(s1) = (S + Sum(num)) / 2
This essentially converts our problem to: "Find count of subsets of the given numbers whose sum is equal to",

    => (S + Sum(num)) / 2
 */

package com.github.nsgowda.dp.knapsack;

public class


TargetSum {

  public int findTargetSubsets(int[] num, int s) {
    int totalSum = 0;
    for (int n : num) totalSum += n;

    // if 's + totalSum' is odd, we can't find a subset with sum equal to '(s + totalSum) / 2'
    if (totalSum < s || (s + totalSum) % 2 == 1) return 0;

    return countNumberOfSubsetSum(num, (s + totalSum) / 2);
  }

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

    for (int i = 1; i < n; i++) {
      for (int s = 1; s <= sum; s++) {
        int s1 = 0;
        if (num[i] <= s) {
          s1 = dp[i - 1][s - num[i]];
        }
        int s2 = dp[i - 1][s];

        dp[i][s] = s1 + s2;
      }
    }
    return dp[n - 1][sum];
  }

  public static void main(String[] args) {
    TargetSum ss = new TargetSum();
    int[] num = {1, 1, 2, 3};
    System.out.println(ss.findTargetSubsets(num, 1));
    num = new int[] {1, 2, 7, 1};
    System.out.println(ss.findTargetSubsets(num, 9));
  }
}
