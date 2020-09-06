package com.github.nsgowda.dp.fibonacci;


import com.github.nsgowda.recursion.others.Fibonacci;

public class FibonacciTopDown {

  public int CalculateFibonacci(int n) {
    int memorize[] = new int[n + 1];
    return CalculateFibonacciRecursive(memorize, n);
  }

  public int CalculateFibonacciRecursive(int[] memoize, int n) {

    if (n < 2) {
      return n;
    }
    memoize[n] =
        CalculateFibonacciRecursive(memoize, n - 1) + CalculateFibonacciRecursive(memoize, n - 2);
    return memoize[n];
  }

  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}
