package com.lectures._03;

import java.util.Iterator;
import java.util.List;

public class IterableExample {

  public static void main(String[] args) {
//    Iterable<Integer> iterable = List.of(1,2,3,4,5);
//    Iterator<Integer> iterator = iterable.iterator();
//    while (iterator.hasNext()){
//      System.out.println(iterator.next());
//    }
//    System.out.println("Iteration completed!");

    DynamicArray array = new DynamicArray();
    array.add(1);
    array.add(2);
    array.add(3);
    for (Object integer : array) {
      System.out.println(integer);
    }
    System.out.println("Iteration completed!");

    Iterator iter1 = array.iterator();
    Iterator iter2 = array.iterator();

    System.out.println(iter1.next());

    iter2.next();
    System.out.println(iter2.next());

    array.clean();
    iter1.next();

  }

}
