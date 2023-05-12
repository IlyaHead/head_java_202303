package _04;

public class ExceptionInCtorExample {

  public static void main(String[] args) {
    A a = null;
    try {
      a = new A();
    } catch (HackConstrucktorEception e) {
      A ref = e.getRef();
      System.out.println("a = " + ref.getA());
      System.out.println("b = " + ref.getB());
    }
    System.out.println(a);
  }
}

class A {

  private int a;
  private int b;


  public A() {
    a = 1;
    if (true) {
      throw new HackConstrucktorEception(this);
    }
    b = 2;
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }
}

class HackConstrucktorEception extends RuntimeException {

  private A ref;

  public HackConstrucktorEception(A ref) {
    this.ref = ref;
  }

  public A getRef() {
    return ref;
  }
}
