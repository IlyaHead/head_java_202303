package _04;

public class RethrowAndRefillExceptions {

  public static void main(String[] args) throws Exception {
    lib();

  }


  public static void lib() throws Exception {
    try {
      internalMethod();
    } catch (Exception e) {
      e = null;
      e.fillInStackTrace();
      throw e;
    }
  }

  public static void internalMethod() {
    throw new IllegalArgumentException();
  }

}
