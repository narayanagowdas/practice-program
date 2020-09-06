package com.github.nsgowda.recursion.arrays;

public class TwoDimensionalArrayLength {

  public static void main(String[] args) {

    int [][] arr = new int[5][];
     arr[0] = new int[3];
     arr[1] = new int[4];

    System.out.println("row count: "+ arr.length);
    System.out.println("1st column count: "+ arr[0].length);
    System.out.println("2nd column count: "+ arr[1].length);
  }
}
