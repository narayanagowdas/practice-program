package com.github.nsgowda.recursion.strings;

public class ReverseString {

  static String  reverse(String str){
    if(str.isEmpty()){
      return "";
    }
   return reverse(str.substring(1))+str.charAt(0);
  }
  public static void main(String[] args) {
    System.out.println(reverse("asdf"));

  }
}
