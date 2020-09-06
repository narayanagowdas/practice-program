package com.github.nsgowda.dp.fibonacci;

import com.github.nsgowda.recursion.others.Fibonacci;

public class FibonacciBottomUp_Tabulation {

  public int CalculateFibonacci(int n) {
    int fb[] = new int[n + 1];

    fb[0]=0;
    fb[1]=1;
    for(int i=2;i<=n;i++){
      fb[i] = fb[i-1]+fb[i-2];
    }
    return fb[n];
  }

  public static void main(String[] args) {
    Fibonacci fib = new Fibonacci();
    System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
        System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
        System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
  }
}
