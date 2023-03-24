package com.java._01;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Arrays {

    public static void main(String[] args) {
        int[] c_style = null; // not recommend
        int[] arr = new int[10];
//        System.out.println(arr[-1]);
//        System.out.println(arr[10]);
        System.out.println(arr[0]);
        arr[0] =42;
        System.out.println(arr[0]);
        arr[0] *=2;
        System.out.println(arr[0]);

        int[] arr2 = new int[]{1,2,3,4,5};
        System.out.println(java.util.Arrays.toString(arr2));
        System.out.println(arr2.hashCode());
        arr2[0] = -1;
        System.out.println(arr2.hashCode());

        int[] arr3 = {1,2,3,4,5,6};

        int[] emptyArr1 = new int[0];
        int[] emptyArr = {};

        System.out.println(emptyArr.length);


        int[] clone = emptyArr.clone();

        System.out.println(emptyArr.equals(clone));


        Integer[] wrappers = new Integer[10];

        String toString = java.util.Arrays.toString(arr2);
        System.out.println(toString);
        System.out.println(toString.replaceAll(", ", "|"));
        System.out.println(toString.replaceAll(", ", ""));

        String toStr = IntStream.of(arr2).mapToObj(Objects::toString).collect(Collectors.joining("~"));
        System.out.println(toStr);

        Wrapper[] wrappers1 = new Wrapper[3];
        Wrapper wrapper = new Wrapper(42);
        wrappers1[0] = wrapper;

        Wrapper[] wrappersClone = wrappers1.clone();
        wrappersClone[0].field =55;

        System.out.println("Content equals = " + java.util.Arrays.equals(wrappers1, wrappersClone));

        System.out.println(wrappers1[0].field);
        System.out.println(wrappersClone[0].field);

        wrapper.field= 0;
        System.out.println(wrappers1[0].field);
        System.out.println(wrappersClone[0].field);

        /*
        * 0 1 2 3 4 5 6 7
        * 1
        * 2
        * 3
        * 4
        *
        * 3
        * 2
        * 1
        * 0 1 2 3 4 5 6 7
         */
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Multi-dimensional arrays");
        int [][] plot = new int[5][];
//        plot[0]= new int[3];
        plot[0] = new int[]{1, 2, 3};
        plot[1] = new int[]{1, 2, 3,4};
        System.out.println(plot[0][2]);
        System.out.println(plot[1][3]);

        long[][][] plot3d = {
                {
                {1, 2, 3}
                },
                {
                    {4, 5, 6}
                },
                {
                    {7, 8, 9}
                }
        };
        System.out.println(plot3d[1][0][1]);




//        System.out.println(plot[0][0]);
//        System.out.println(plot[4][2]);

        // [->1 ->2 ->3 ->4 ->5]
        //-> [1, 2, 3]
        //-> [5, 6, 3]
        //-> [5, 6, 3]
        //-> [5, 6, 3]
        //-> [5, 6, 3]
        //-> [5, 6, 3]

        Object[] objects = new Object[10];
        objects[0] = 5;
        objects[1] = 4.0;
        objects[2] = "asd";

        System.out.println(java.util.Arrays.toString(objects));

        Integer[] integers = {1, 2, 3, 4};
        String[] strings = {"123","qwe"};
        
//        strings = integers; runtime error




        // ковариантность типова
        Object[] refs = integers;
        refs[0] = "123";



        // ИНвариантность типов
        // generics

        //Контрваринтность типов
        //исключения




        if(refs instanceof String[]){
        String[] str2 = ((String[]) refs);}
        
        
        

    }

    public static class Wrapper{

        public int field;

        public Wrapper(int field) {
            this.field = field;
        }

    }
}
