package com.lectures._03;

public class OverrideExample {


  public static void main(String[] args) {
//    I ref = new O();  // [HEADER | class-pointer to O]
//    ref.sayHello();   // dynamic binding

    Z ref = new U();

    Number number = ref.getNumber();
    System.out.println(number);

    //  Single responsibility
    //  Open-closed principle
    //  Liskov substitution <=
    //  Interface segregation
    //  Dependency inversion

    U childRef = new U();
    Double doubleRef = (Double) number;
    System.out.println(doubleRef);
  }
}

class I {

  protected int field;

  public I(int field) {
    this.field = field;
  }

  public void sayHello() {
    System.out.println("Hello from I");
  }

}

class O extends I {

  protected int field2 = 55;

  public O() {
    super(33);
  }

  @Override
  public void sayHello() {
    System.out.println("Hello from 0");
  }

  public void sayGoodBye() {
    System.out.println("Good bye from O" + field);
  }

}

class Z {
  public Number getNumber(){
    return 5;
  }
}

class U extends Z{

  @Override
  public Double getNumber() {
    return 5.5;
  }
}

class J extends Z{

  @Override
  public Integer getNumber() {
    return 6;
  }
}