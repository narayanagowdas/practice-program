package com.github.nsgowda.recursion.others;

public class Fibonacci {

    public int CalculateFibonacci(int n) {
      if(n < 2)
        return n;
      return CalculateFibonacci(n-1) + CalculateFibonacci(n-2);
    }



  public int CalculateFibonacciRecursive(int[] memoize, int n) {
    if (n < 2) return n;

    // if we have already solved this subproblem, simply return the result from the cache
    if (memoize[n] != 0) {
      return memoize[n];
    }

    memoize[n] =
        CalculateFibonacciRecursive(memoize, n - 1) +
            CalculateFibonacciRecursive(memoize, n - 2);
    return memoize[n];
  }

  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
    //    System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
    //    System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}
