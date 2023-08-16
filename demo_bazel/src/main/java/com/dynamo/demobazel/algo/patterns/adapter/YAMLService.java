package com.dynamo.demobazel.algo.patterns.adapter;

public class YAMLService implements StringService{

  @Override
  public String doService() {
    return "YAML String";
  }
}
