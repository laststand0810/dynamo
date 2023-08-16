package com.dynamo.demobazel.algo.utils;

public class PrintArrUtil {
  public static void printArr(int a[], int n) /* function to print the array elements */ {
    int i;
    for (i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
  public static void printArr(int a[], int n, int pos1, int pos2) /* function to print the array elements */ {
    int i;
    for (i = 0; i < n; i++) {
      if (i == pos1 || i == pos2) {
        System.out.print("[" + a[i] + "] ");
      } else {
        System.out.print(a[i] + " ");
      }
    }
    System.out.println();
  }
}
