package com.example.dynamicbeanregistrar.bean;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class QuotationService {
  
  private final AnnotationService annotationService;
  
  private String injectName;
  
  public int getPrice() {
    return 0;
  }

}
