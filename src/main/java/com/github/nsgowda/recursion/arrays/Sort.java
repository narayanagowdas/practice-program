package com.github.nsgowda.recursion.arrays;

import java.util.Arrays;

public class Sort {

  public static void sortArray(int[] array, int n) {
    if (n == 0) {
      return;
    } else {
      for (int i = 0; i < n-1; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i);
        }
      }
      sortArray(array, n-1);
    }
    System.out.print("Sorted Array:" + Arrays.toString(array));
  }

  private static void swap(int[] arr, int index) {
    int temp = arr[index];
    arr[index] = arr[index + 1];
    arr[index + 1] = temp;
  }

  public static void main(String[] args) {
    int [] array= {3,4,2,1,5};
    sortArray(array,array.length);
  }
}
