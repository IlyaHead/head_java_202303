package com.lectures._02;

import com.lectures._03.FieldsExample;

public class FieldsExampleChild extends FieldsExample {

  public static void main(String[] args) {
    System.out.println(protectedStaticValue);
  }
  private void method(){
    FieldsExample ref = new FieldsExample();
    System.out.println(this.protectedValue);
  }
}
