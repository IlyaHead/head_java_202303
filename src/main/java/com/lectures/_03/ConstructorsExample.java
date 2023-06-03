package com.lectures._03;

public class ConstructorsExample {

  public static void main(String[] args) {
//    C withParam = new C(100);
    C noParam = new C();
//    System.out.println(withParam);
    System.out.println(noParam);
//    try {
//      System.out.println(D.staticField);
//    } catch (Throwable ex){
//      System.out.println("Error caught");
//    }
  }
}

class E {

  public static int staticField = 42;

  static {
    staticField = 80;
  }

  public int field = 55;

  {
    field = 77;
  }

  public E() {
    field = 66;
  }

  public static void main(String[] args) {
    new E();
    System.out.println(E.staticField);
//    static field = 80
    System.out.println(new E().field);
//    field = 66
    E ref1 = new E();
    E ref2 = new E();
    E ref3 = new E();

    ref1.getField();
    ref2.getField();
    ref3.getField();

    //[HEADER][FIELDS - 4 bytes]
    //[HEADER][FIELDS - 4 bytes]
    //[HEADER][FIELDS - 4 bytes]

    Long longVal = 555L;
  }

  public int getField() {
    return field;
  }
}

class C {

  {
    System.out.println("1 = " + this.field);
  }

  private int field;

  {
    System.out.println("2 = " + field);
    field = -1;
  }

  public C(int field) {
    System.out.println("with Param ctor");
    this.field = field;
  }

  public C() {
    this(42);
    System.out.println("No param ctor");
  }

  {
    System.out.println("3 = " + field);
  }

  @Override
  public String toString() {
    return "C{" +
        "field=" + field +
        '}';
  }
}

class D {

  static {
    System.out.println("Static#1 = " + D.staticField);
  }

  public static int staticField = 42;

  static {
    System.out.println("Static#2 = " + staticField);
    System.out.println(1 / 0);
  }
}