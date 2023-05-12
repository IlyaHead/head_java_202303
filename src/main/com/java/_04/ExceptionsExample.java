package _04;

import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;
import lombok.SneakyThrows;

public class ExceptionsExample {

  public static void main(String[] args) {
    System.out.println("main: enter");
    noThrowsMethod();
    System.out.println("main: exit");
    sneaky();
  }

  public static void multiCatch(){
    try {
      System.out.println("method: enter");
      if (ThreadLocalRandom.current().nextBoolean()) {
        throw new SQLException();
      } else {
        throw new IllegalArgumentException("username");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e){
      e.printStackTrace();
    }
  }

  public static void noThrowsMethod() {
    System.out.println("noThrowsMethod: enter");
    try {
      method();
      System.out.println("After method");
      System.out.println(0 / 0);
      throw new Throwable();
    } catch (IllegalArgumentException ex) {
      System.out.println("Caught an IllegalArgument exception: " + ex);
    } catch (RuntimeException ex) {
      System.out.println("Caught a Runtime exception: " + ex);
    } catch (Exception ex) {
      System.out.println("Caught an exception: " + ex);
    } catch (Throwable ex) {
      System.out.println("Caught a Throwable exception: " + ex);
    }
    System.out.println("noThrowsMethod: exit");
  }

  /**
   * @throws SQLException             fghdfth
   * @throws IllegalArgumentException hdfghdf
   */
  public static void method() throws SQLException, IllegalArgumentException {
    System.out.println("method: enter");
    if (ThreadLocalRandom.current().nextBoolean()) {
      throw new SQLException();
    } else {
      throw new IllegalArgumentException("username");
    }
//    System.out.println("method: exit");
  }


  @SneakyThrows
  public static void sneaky(){
    throw new Exception();
  }
}
