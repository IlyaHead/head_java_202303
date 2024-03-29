package com.lectures._03;

import java.util.Arrays;
import java.util.Comparator;

public class InterfaceExample {

  public static void main(String[] args) {
    System.out.println(FixFields4_4.Account);

    Movable movable = new Square(10);

    Square square = (Square) movable;
    Movable2 movable2 = square;
    movable = (Movable) movable2;

    System.out.println(movable.getStr());

    if (square instanceof Movable) {
      System.out.println("Yes, it is Movable!");
    }

    Square sqr = new Square(10);
    Rectangle rect = new Rectangle(1, 2);
    GeometryShape[] shape = {sqr, rect, new Square(20)};


    class ShapeComparator implements Comparator<GeometryShape>{

      int field;

      @Override
      public int compare(GeometryShape a, GeometryShape b){
        System.out.println("Called compare");
        return Double.compare(a.calcPerimeter(),b.calcPerimeter());
      }
    }

    System.out.println(Arrays.toString(shape));

    Arrays.sort(shape, new ShapeComparator());

    System.out.println(Arrays.toString(shape));

  }
}

interface Movable {

  int DELTA = 10;

  Point2d move(Point2d point);

  Point2d move(int diffX, int diffY);

  String getStr();

  class A{

  }
}

interface Movable2 {

  int DELTA = 10;

  Point2d move(Point2d point);

  Point2d move(int diffX, int diffY);


}

interface FixFields4_4 {

  int Account = 1;
  int SourceID = 43;

}

interface ProgramConstants {


  int const_1 = 42;
  int const_2 = 42;
  int const_3 = 42;
}
