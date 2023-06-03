package com.lectures._03;

import java.util.concurrent.TimeUnit;

public class FinalizeExample {

  public static void main(String[] args) throws InterruptedException {
    FinalizeableClass ref = new FinalizeableClass(1);
    ref =null;

    new FinalizeableClass(2);

    System.out.println("Before");
    System.gc();
    System.out.println("After");

    System.out.println("From main: " + Thread.currentThread());

//    long start = System.currentTimeMillis();
//    long a = Long.MIN_VALUE;
//    while(a != Long.MAX_VALUE){
//      a++;
//    }
//    long finish = System.currentTimeMillis();
//
//    System.out.println((finish - start) / 10000);
    TimeUnit.SECONDS.sleep(10);
    System.out.println(FinalizeableClass.zombie[0].id);
    System.out.println(FinalizeableClass.zombie[1].id);
    System.out.println("Main thread finished");
  }

}

class FinalizeableClass{

  static FinalizeableClass[] zombie = new FinalizeableClass[2];

  final int id;


  public FinalizeableClass(int id) {
    this.id= id;
    System.out.println("Ctor of FinalizeableClass");
  }

  @Override
  protected void finalize(){
    System.out.println("Finalize invoked: " + id);
    System.out.println("From Finalize: " + Thread.currentThread());

    zombie[id - 1] = this;
  }
}