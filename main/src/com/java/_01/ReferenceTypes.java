package com.java._01;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class ReferenceTypes {

    public static void main(String[] args) {
        String word = new String("hello");

        //header 32-bit systems (8 byte)
        //header 32-bit systems (12 byte)
        // field: byte[] | byte | int


        System.out.println(word);

        byte byteValue;
        Byte byteValueWrapper = new Byte((byte) 2);

        short shortValue;
        Short shortValueWrapper;

        int intValue;
        Integer intValueWrapper;

        long longValue;
        Long longValueWrapper;

        char charValue;
        Character charValueWrapper;

        float floatValue;
        Float floatValueWrapper;

        double doubleValue;
        Double doubleValueWrapper;

        boolean booleanValue;
        Boolean booleanValueWrapper;

        //autoboxing / unboxing
        intValue = 42;
        intValueWrapper = intValue;

        Integer a1 = 128;
        Integer a2 = 128;

        System.out.println(a1.equals(a2));
        System.out.println(a2.equals(a1));


//        Integer test1 = 120;
//        Integer test2 = 120;
//        Integer test3 = 120;
//        Integer test4 = 120;
//        System.out.println(test1 == test2);
//        System.out.println(test3 == test4);


        //immutable
        //String
        Integer immutable = 42;
        immutable += 1;

        String str = "123";
        str += "4";
        System.out.println(immutable);


        BigInteger bigInteger = BigInteger.ONE;
        BigInteger bigInteger2 = bigInteger.add(BigInteger.valueOf(Integer.MAX_VALUE))
                .multiply(BigInteger.valueOf(1000_0000));
        System.out.println(bigInteger);
        System.out.println(bigInteger2);

        MathContext mathContext = new MathContext(4, RoundingMode.DOWN);
        BigDecimal bigDecimal = BigDecimal.ONE;
        BigDecimal bigDecimal2 = bigDecimal.divide(BigDecimal.valueOf(3),mathContext);
        System.out.println(bigDecimal);
        System.out.println(bigDecimal2);

        
    }
}
