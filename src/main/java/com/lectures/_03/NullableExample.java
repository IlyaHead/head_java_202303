package com.lectures._03;

import lombok.NonNull;

/**
 * @deprecated 1.6
 * @see String#repeat(int)
 * @author Илья
 */
public class NullableExample {

  public static void main(String[] args) {
    Integer count = null;
    if(args.length>2){
      count = 5;
    }
    System.out.println(duplicate("", count));
  }

  /**
   * Common description of the method
   *<br/>
   *<br/>
   *<br/>
   *
   * @param str String to be duplicated
   * @param count How many times we need to duplicate
   * @throws IllegalArgumentException - if count less than 1
   * @return Duplicated string
   * @see Object#toString()
   * @since 1.0
   */
  public static String duplicate(String str, @NonNull Integer count) throws IllegalArgumentException {
    if(count < 1){
      throw new IllegalArgumentException();
    }
    return str.repeat(count);
  }

}
