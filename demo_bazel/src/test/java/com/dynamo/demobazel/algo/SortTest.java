package com.dynamo.demobazel.algo;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortTest {
  int[] arr, expectedArr;

  @Before
  public void init() {
    arr = new int[]{7, 8, 9, 5, 7, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7};
    expectedArr = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 6, 7, 7, 7, 8, 9};
  }

  @Test
  public void testShellSort(){
    ShellSort.shell(arr, arr.length);
    Assert.assertArrayEquals(arr, expectedArr);
  }

  @Test
  public void testInsertionSort(){
    InsertionSort.sort(arr, arr.length);
    Assert.assertArrayEquals(arr, expectedArr);
  }

  @Test
  public void testBubbleSort(){
    BubbleSort.sort(arr, arr.length);
    Assert.assertArrayEquals(arr, expectedArr);
  }
}
