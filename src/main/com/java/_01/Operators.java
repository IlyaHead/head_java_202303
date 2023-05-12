package _01;

public class Operators {

    public static void main(String[] args) {
//        Arity
//        unary
//        binary
//        ternary

//        Arithmetic
//        + +=
//        - -=
//        * *=
//        / /=  Divide by Integer Zero throws ArithmeticException
//        % %=

        int a = 10;
        int b = 10;

        System.out.println(a + b);
        b +=10; // b = b + 10;
//        System.out.println(a/0); java.lang.ArithmeticException: / by zero

        int x = a / 3;
        System.out.println(x);

        int c = -10;
        System.out.println(c / 3);

        System.out.println(-c);
        System.out.println(Integer.MIN_VALUE);

        // 0111 1111 - Byte.MAX_VALUE
        // 0111 1111 + 1
        // 1000 0000
        System.out.println((byte)(Byte.MAX_VALUE + 1));

        System.out.println(11 % 3);
        System.out.println(-11 % 3);
        System.out.println(11 % -3);

        System.out.println(Integer.MAX_VALUE + 100);
//        System.out.println(Math.addExact(Integer.MAX_VALUE, 100)); //java.lang.ArithmeticException: integer overflow

        // unary
        // -
        // -- decrement
        // ++ increment
        int dec = 123;
        System.out.println(--dec); // 123 122 -> 122
        System.out.println(dec--); // 122 121 -> 122
        System.out.println(dec);   // 121

        //Bitwise
        // |     |=
        // &     &=
        // ^     ^=
        // ~     ~=
        // >>    >>=
        // <<    <<=
        // >>>   >>>=

        int m = 0b0001_0010;
        //        0001_0010
        //  |     0101_0001
        //        0101_0011

        // &      0001_0010

        //        0001_0010
        // << 2
        //        0100_1000

        //        1000_0000 -128
        // >> 2
        //        0100_0000 32

        //        1000_0000 -128
        // >> 1   1100_0000
        //        1110_0000

        System.out.println();

        // Comparison
        // <
        // <=
        // >
        // >=
        // == don't use with doubles
        // !=
        double y = 0.1;
        y += 0.1;
        y += 0.1;
        System.out.println(y == 0.3); // incorrect
        System.out.println(y);

        double eps = 0.00001;
        System.out.println(Math.abs(y - 0.3) < eps); //correct way

        //logical
        // ||       |       |=
        // &&       &       &=
        // !                !=
        // ^                ^=

//        System.out.println(_true() || _false()); //  short-circuit
//        System.out.println(_false() && _true()); //  short-circuit
//        System.out.println(_true()| _false()); //

        // ? condition result1:result2

        int userInput = 3;
        System.out.println(userInput < 4 ? "not enough data" : "Result = ...");


        Long longValue = 5L;
        if (longValue instanceof Number){
            System.out.println("Yes it is a number");
        }

        // []
        int [] arr = new int [10];
        arr[0] = 3;
        System.out.println(arr[0]);


        System.out.println((5 % 2 + (-3 % 1)) >>3);
    }

    public static boolean _true(){
        System.out.println("Called true");
        return true;
    }

    public static boolean _false(){
        System.out.println("Called false");
        return false;
    }


}
