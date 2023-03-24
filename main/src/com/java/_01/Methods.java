package com.java._01;

import static java.lang.Math.abs;
import static java.lang.Math.atan;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;

public class Methods {

  public static void main(String[] args) {
    double value = 1.3;
    double result = sqrt(value) * abs(value) / atan(value) * PI;

//        int a = 1;
//        int b = 2;
//        int result = compare(a, b/*arguments*/);
//        System.out.println("Result of comparison = " + result);
//        System.out.println(a);

//        String str = "abc";
//        String newStr = modifyString(str);
//        System.out.println("Outside method: " + str);
//        System.out.println("Outside method: " + newStr);

//        String[] str = {"abc"};
//        String[] str2 = str;
//
//        System.out.println(str = str2);
//
//
//        modifyString(str);
//        System.out.println(str[0]);
    Wrapper obj = new Wrapper();
    obj.field = 42;

    modify(obj);
    System.out.println("Outside " + obj.field);
  }

  static class Wrapper {

    int field;
  }

  public static void modify(Wrapper wrapper) {
    System.out.println("Before = " + wrapper.field);
    wrapper.field++;
    System.out.println("After = " + wrapper.field);
  }

  public static void modifyString(String[] arr) {
    System.out.println("Inside method before: " + arr[0]);
    arr[0] += "!";
    System.out.println("Inside method after: " + arr[0]);
  }

//    public static String modifyString(String inputString) {
//        System.out.println("Inside method " + inputString);
//        inputString += "!";
//        System.out.println("Inside method " + inputString);
//        return inputString;
//    }

  //a == b -> 0
  //a > b -> 1
  //a < b -> -1
  //method signature: name + list of params
  // compare (int,int)

  public static int compare(int a, int b/*params*/) {
    a += 1;

    if (a == b) {
      return 0;
    } else {
      if (a > b) {
        return 1;
      } else {
        return -1;
      }
    }
  }

  public static int compare(long a, long b) {
    return Long.compare(a, b);
  }
}
