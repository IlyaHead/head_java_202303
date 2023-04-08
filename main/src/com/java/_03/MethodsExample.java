package com.java._03;

import java.util.Objects;
import java.util.Optional;

public class MethodsExample {

  public static void main(String[] args) {
    for (String username: getUsernames()
    ) {
      System.out.println(username);
    }

   getUsernamesJava8().ifPresent(users -> {
     for (String username : users){
       System.out.println(username);
     }
   });

  }

  // a == b -> 0
  // a > b -> 1
  // a < b -> -1
  public static int compare(Integer a, Integer b){
    Objects.requireNonNull(a,"First arg of comparison shouldn't be null");
    Objects.requireNonNull(b,"Second arg of comparison shouldn't be null");
    return a.equals(b) ? 0 : a > b ? 1 : -1;
  }
  
  
  
  private static String[] getUsernames(){
    //
//    return new String[]{"user1","user2"};
//    return null; wring, better to use arrays/ collections
    return new String[0];
  }

  private static Optional<String[]> getUsernamesJava8(){
    return Optional.empty();
  }

  public static void hellFromMethodsExample(){
    System.out.println("hello");
  };

  private static String hellFromMethodsExample(int a) throws IllegalAccessError{
    System.out.println("hello");
    return null;
  };

  /*
    [specifiers] returnType methodName([paramType1 paramName1, ...]) [throws throwableList]{
      // method body
    }


      signature:
        methodName(int, int, String)

      specifiers:
        public
        protected
        package-visible
        private
        final
        static
        abstract
        synchronized
        strictfp
        native
   */

  public void overloadingExample(){
    String s1 = String.valueOf('1');
    String s2 = String.valueOf(true);
    String s3 = String.valueOf("1");
  }

}
