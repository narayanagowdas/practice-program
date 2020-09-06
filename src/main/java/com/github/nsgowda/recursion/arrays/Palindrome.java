package com.github.nsgowda.recursion.arrays;

public class Palindrome {
  public static Object palindrome(char[] array, int idx) {

    if(array.length-1-idx <= 1){
      return true;
    } else if(array[idx] != array[array.length-1-idx]) {
      return false;
    } else {
      return palindrome(array, idx+=1);
    }

  }

  public static void main(String[] args) {
    char[] arr = {'a','b','c','b','a'};
    System.out.println(palindrome(arr,0));

  }
}
