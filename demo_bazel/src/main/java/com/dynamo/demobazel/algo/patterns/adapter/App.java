package com.dynamo.demobazel.algo.patterns.adapter;

public class App {

  public static void main(String[] args) {
    StringService xmlService = new XMLService();
    StringService yamlService = new YAMLService();

    //1
    System.out.println(xmlService.doService());

    //2
    System.out.println(yamlService.doService());

    //3
    Translator xmlToJsonTranslator = new ServiceToJsonTranslator(xmlService);
    Translator yamlToJsonTranslator = new ServiceToJsonTranslator(xmlService);

    System.out.println(xmlToJsonTranslator.translateToJson());
    System.out.println(yamlToJsonTranslator.translateToJson());
  }

}
