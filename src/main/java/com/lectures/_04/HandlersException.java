package com.lectures._04;

import java.io.FileNotFoundException;
import java.lang.Thread.UncaughtExceptionHandler;

public class HandlersException {

  public static void main(String[] args) throws FileNotFoundException {
    Thread main = Thread.currentThread();
    Thread.UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {
      @Override
      public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Received unhandled exception " + e + " from thread " + t);
      }
    };
    main.setUncaughtExceptionHandler(handler);

    throwableMethod();

  }

  public static void throwableMethod(){
    throw new RuntimeException();
  }



}

