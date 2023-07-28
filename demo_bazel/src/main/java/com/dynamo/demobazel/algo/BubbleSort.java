package com.dynamo.demobazel.algo;

public class BubbleSort {

  static void sort(int a[], int n) {
    int i,j, swapper;
    for (i=0; i<n; i++) {
      swapper = 0;
      for (j=0; j<n-i; j++) {
        if (a[swapper]>a[j]) {
          PrintArrUtil.printArr(a, a.length, swapper, j);
          swap(a, swapper, j);
        }
        swapper = j;

      }
    }
  }

  static void swap(int a[], int pos1, int pos2) {
    int temp = a[pos1];
    a[pos1] = a[pos2];
    a[pos2] = temp;
  }

}
