package com.dynamo.demobazel.algo;

public class ShellSort {

  static void shell(int a[], int n) {
    /* Rearrange the array elements at n/2, n/4, ..., 1 intervals */
    for (int interval = n / 2; interval > 0; interval /= 2) {

      // insertion sort in shell interval
      for (int i = interval; i < n; i += 1) {
            /* store a[i] to the variable temp and make

the ith position empty */
        int temp = a[i];
        int j;
        for (j = i; j >= interval && a[j - interval] >
            temp; j -= interval) {
          System.out.printf("move pos [%s]=%s to pos [%s]=%s\n", j,a[j], j-interval, a[j-interval]);
          a[j] = a[j - interval];
        }

            /* put temp (the original a[i]) in its correct
position */
        System.out.printf("put %s to pos [%s]=%s\n", temp, j, a[j]);
        a[j] = temp;
        PrintArrUtil.printArr(a, a.length);
      }
    }
  }
}