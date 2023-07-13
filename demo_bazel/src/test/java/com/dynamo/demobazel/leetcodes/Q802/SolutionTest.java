package com.dynamo.demobazel.leetcodes.Q802;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

  Solution solution;

  @Before
  public void init(){
    solution = new Solution();
  }

  @Test
  public void testCorrectSolution(){

    int[][] input = new int[][] {{1,2},{2,3},{5},{0},{5},{},{}};
    Assert.assertArrayEquals(solution.eventualSafeNodes(input).toArray(), List.of(2,4,5,6).toArray());
  }

  @Test
  public void testThrowError(){
    return;
  }

}
