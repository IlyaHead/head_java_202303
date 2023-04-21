package com.java._03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassExample {

  private static final int STATIC_CONSTANT = 66;
  private final int nonSTATIC_CONSTANT = 66;

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
    System.out.println("List class = " + list.getClass());
    System.out.println(list);

    Square sqr = new Square(10){
      @Override
      public double calcPerimeter(){
        System.out.println(STATIC_CONSTANT);
        return Double.NEGATIVE_INFINITY;
      }
    };

    Rectangle rect = new Rectangle(1,2);
    GeometryShape[] shapes = {sqr, rect, new Square(20), new GeometryShape() {
      @Override
      public Number calcSquare() {
        return Double.POSITIVE_INFINITY;
      }

      @Override
      public double calcPerimeter() {
        return Double.POSITIVE_INFINITY;
      }
    }};


    System.out.println(Arrays.toString(shapes));

    Comparator<GeometryShape> comparator = new Comparator<>() {
      @Override
      public int compare(GeometryShape a, GeometryShape b) {
        return Double.compare(a.calcPerimeter(), b.calcPerimeter());
      }
    };
    System.out.println(comparator.getClass());
    System.out.println(comparator instanceof  Comparator);
    Arrays.sort(shapes, comparator);

    System.out.println(Arrays.toString(shapes));
  }

}

