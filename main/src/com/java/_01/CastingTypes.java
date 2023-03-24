package com.java._01;

public class CastingTypes {

    public static void main(String[] args) {
        long longValue =42;

        //...
        longValue *=1000000000000L;
        //00000000000000000000000000000101_01010010101010101010101001010101;
        //                                  01010010101010101010101001010101;

        int intValue = ((int) longValue);

        double doubleValue = 111111111111111111111111111111111111111111111111111111111111111111111.01232323232d;
        float floatValue = ((float) doubleValue);
        System.out.println(floatValue);

        intValue = ((int) doubleValue);
        System.out.println(intValue);

        // floating point troubles
        int intValue1 = 123456789;
        int intValue2 = 999999999;

        float floatValue1 = intValue1;
        float floatValue2 = intValue2;

        System.out.println(floatValue1);
        System.out.println(floatValue2);


        long longValue1 = 1234567891234L;
        long longValue2 = 123456789123456789L;

        double doubleValue1 = longValue1;
        double doubleValue2 = longValue2;

        System.out.println(doubleValue1);
        System.out.println(doubleValue2);

//        intValue = 100_000_000_000L;

        double result = intValue * floatValue + doubleValue /longValue;
//        Хотя бы один из операндов double => double
//        Хотя бы один из операндов float => float
//        Хотя бы один из операндов long => long
//        Иначе => int

        byte byteValue1 = 50;
        byte byteValue2 = ((byte) (byteValue1 * ((byte) 2)));

        test();
    }

    public static void test(){
        byte a = 1;
        byte b = 2;
        System.out.println(a + b);

        boolean c = true;
        boolean d = false;
        System.out.println(c || d);
    }
}
