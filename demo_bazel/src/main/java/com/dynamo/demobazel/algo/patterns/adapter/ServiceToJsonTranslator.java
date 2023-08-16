package com.dynamo.demobazel.algo.patterns.adapter;

public class ServiceToJsonTranslator implements Translator {

  StringService stringService;

  public ServiceToJsonTranslator(StringService stringService) {
    this.stringService = stringService;
  }

  @Override
  public String translateToJson() {
    return jsonTranslate(stringService.doService());
  }

  private String jsonTranslate(String s) {
    return "Json translated " + s;
  }
}
