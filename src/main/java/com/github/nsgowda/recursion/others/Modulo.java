package com.github.nsgowda.recursion.others;

public class Modulo {

    // Recursive function to return gcd of a and b
    static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
    }

    // Driver method
    public static void main(String[] args)
    {
      int b = 98, a = 56;
      System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));
    }
  }

