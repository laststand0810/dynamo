package com.dynamo.demobazel.leetcodes.Q802;

import java.util.List;
import java.util.stream.Collectors;
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

    int[][] input = new int[][] {{1,2},{2,3},{5},{0},{6},{},{}};
    Assert.assertArrayEquals(solution.eventualSafeNodes(input).toArray(), List.of(2,4,5,6).toArray());
  }

  @Test
  public void testThrowError(){
    String str = "fadfadsf";
    String s = str.chars()
        .mapToObj(c -> (char) c)
        .map(Character::toLowerCase)
        .filter(c -> !Character.isWhitespace(c))
        .map(String::valueOf)
        .collect(Collectors.joining());

    Assert.assertEquals(s, str);


  }

}
