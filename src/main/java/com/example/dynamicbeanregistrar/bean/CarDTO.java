package com.example.dynamicbeanregistrar.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter @Setter
public class CarDTO {
  
  private String name;
  private String price;
  private String cc;

}
