package com.github.nsgowda.recursion.others;

public class IntToBinary {

  public static int decimalToBinary(int decimalNum) {
    if (decimalNum == 0) {
      return 0;
    }
    else {
      return (decimalNum%2 + 10*decimalToBinary(decimalNum/2));
    }
  }

  public static void main(String[] args) {
    System.out.println(decimalToBinary(10));
  }
}
/**
 * 10, 0
 * 5,1
 * 2, 0
 * 1, 1
 *
 * 1010
 *
 *
 *
 *
 *
 *
 */
