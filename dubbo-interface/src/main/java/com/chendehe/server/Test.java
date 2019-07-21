package com.chendehe.server;

import java.util.Arrays;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
    nums.parallelStream().forEach(n -> {
      if (n == 3) {
        throw new RuntimeException("hahaha");
      }
      System.out.println(n);
    });
    System.out.println("End");
  }
}
