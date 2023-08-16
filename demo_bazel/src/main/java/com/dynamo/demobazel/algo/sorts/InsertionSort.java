package com.dynamo.demobazel.algo.sorts;

import com.dynamo.demobazel.algo.utils.PrintArrUtil;

public class InsertionSort {

  static void sort (int a[], int n) {
    for (int i = 1; i< n; i++) {
      int temp = a[i];
      int j;
      for (j = i; j>=1 && a[j-1] > temp; j-=1) {
        //System.out.printf("move pos [%s]=%s to pos [%s]=%s\n", j,a[j], j-1, a[j-1]);
        PrintArrUtil.printArr(a, a.length, j, j-1);
        a[j] = a[j - 1];
        PrintArrUtil.printArr(a, a.length, j, j-1);
      }
      //System.out.printf("put %s to pos [%s]=%s\n", temp, j, a[j]);
      a[j] = temp;
    }
  }
}
