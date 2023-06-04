package Polynomial;

import Monomial.Monomial;
import Scalar.IntegerScalar;
import Scalar.RationalScalar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    private static Polynomial n1_1_1_1_1;
    private static Polynomial n0_0_0_0_m4__3;
    private static Polynomial n5;
    private static Polynomial n1_m1_1_m1_1;
    private static Polynomial n10__m2;
    private static Polynomial n1__2_m1__2;
    private static Polynomial nm2_2;
    private static Monomial mm5;
    private static IntegerScalar sm5;
    private static IntegerScalar s10;
    private static RationalScalar sm1;
    private static RationalScalar sm1__2;
    private static RationalScalar s1;

    @BeforeAll
    static void setUp() {
        n1_1_1_1_1 = Polynomial.build("1 1 1 1 1");
        n0_0_0_0_m4__3 = Polynomial.build("0 0 0 0 -4/3");
        n1_m1_1_m1_1 = Polynomial.build("1 -1 1 -1 1");
        nm2_2= Polynomial.build("-2 2");
        n1__2_m1__2= Polynomial.build("1/2 1/-2");
        n5 = Polynomial.build("5");
        n10__m2 = Polynomial.build("10/-2");
        sm5 = new IntegerScalar(-5);
        s10 = new IntegerScalar(10);
        sm1 = new RationalScalar(10, -10);
        s1 = new RationalScalar(10, 10);
        sm1__2 = new RationalScalar(1, -2);
        mm5 = new Monomial(0, sm5);
    }


    //Test toString
    @Test
    void n1_1_1_1_1___testToString() {assertEquals("1 + x + x^2 + x^3 + x^4", n1_1_1_1_1.toString());}
    @Test
    void n1_m1_1_m1_1___testToString() {assertEquals("1 - x + x^2 - x^3 + x^4", n1_m1_1_m1_1.toString());}
    @Test
    void n0_0_0_0_m4__3___testToString() {assertEquals("-4/3x^4", n0_0_0_0_m4__3.toString());}
    @Test
    void nm2_2___testToString() {assertEquals("-2 + 2x", nm2_2.toString());}
    @Test
    void n1__2_m1__2___testToString() {assertEquals("1/2 - 1/2x", n1__2_m1__2.toString());}
    @Test
    void n5___testToString() {assertEquals("5", n5.toString());}
    @Test
    void n10__m2___testToString() {assertEquals("-5", n10__m2.toString());}



    //Test Equals
    @Test
    void n10__m2___testEquals___m5() {assertEquals(n10__m2, sm5);}
    @Test
    void n10__m2___testEquals___mm5() {assertEquals(n10__m2, mm5);}
    @Test
    void n10__m2___testEquals___n5() {assertNotEquals(n10__m2, n5);}
    @Test
    void n1_1_1_1_1___testEquals___n1_m1_1_m1_1() {assertNotEquals(n1_1_1_1_1, n1_m1_1_m1_1);}



    //Test Evaluate
    @Test
    void n1_1_1_1_1___testEvaluate___sm1__2() {assertEquals("11/16", n1_1_1_1_1.evaluate(sm1__2).toString());}
    @Test
    void n0_0_0_0_m4__3___testEvaluate___s10() {assertEquals("-40000/3", n0_0_0_0_m4__3.evaluate(s10).toString());}
    @Test
    void n1_m1_1_m1_1___testEvaluate___s1() {assertEquals("1", n1_m1_1_m1_1.evaluate(s1).toString());}
    @Test
    void n1_m1_1_m1_1___testEvaluate___sm1() {assertEquals("5", n1_m1_1_m1_1.evaluate(sm1).toString());}
    @Test
    void nm2_2___testEvaluate___sm5() {assertEquals("-12", nm2_2.evaluate(sm5).toString());}
    @Test
    void n1__2_m1__2___testEvaluate___s10() {assertEquals("-9/2", n1__2_m1__2.evaluate(s10).toString());}
    @Test
    void n5___testEvaluate___s10() {assertEquals("5", n5.evaluate(s10).toString());}
    @Test
    void n10__m2___testEvaluate___sm1__2() {assertEquals("-5", n10__m2.evaluate(sm1__2).toString());}



    //Test Derivative

    @Test
    void n1_1_1_1_1___testDerivative() {assertEquals("1 + 2x + 3x^2 + 4x^3", n1_1_1_1_1.derivative().toString());}
    @Test
    void n0_0_0_0_m4__3___testDerivative() {assertEquals("-16/3x^3", n0_0_0_0_m4__3.derivative().toString());}
    @Test
    void n1_m1_1_m1_1___testDerivative() {assertEquals("-1 + 2x - 3x^2 + 4x^3", n1_m1_1_m1_1 .derivative().toString());}
    @Test
    void nm2_2___testDerivative() {assertEquals("2", nm2_2.derivative().toString());}
    @Test
    void n1__2_m1__2___testDerivative() {assertEquals("-1/2", n1__2_m1__2.derivative().toString());}


    //Test Add
    @Test
    void n1_1_1_1_1___testAdd___n1_m1_1_m1_1() {assertEquals("2 + 2x^2 + 2x^4", n1_1_1_1_1.add(n1_m1_1_m1_1).toString());}
    @Test
    void n1_1_1_1_1___testAdd___n10__m2() {assertEquals("-4 + x + x^2 + x^3 + x^4", n1_1_1_1_1.add(n10__m2).toString());}
    @Test
    void nm2_2___testAdd___n1__2_m1__2() {assertEquals("-3/2 + 3/2x", nm2_2.add(n1__2_m1__2).toString());}
    @Test
    void nm2_2___testAdd___n0_0_0_0_m4__3() {assertEquals("-2 + 2x - 4/3x^4", nm2_2.add(n0_0_0_0_m4__3).toString());}




    //Test Mul

    @Test
    void n1_m1_1_m1_1___testMul___n0_0_0_0_m4__3() {assertEquals("-4/3x^4 + 4/3x^5 - 4/3x^6 + 4/3x^7 - 4/3x^8", n1_m1_1_m1_1.mul(n0_0_0_0_m4__3).toString());}
    @Test
    void n0_0_0_0_m4__3___testMul___n0_0_0_0_m4__3() {assertEquals("16/9x^8", n0_0_0_0_m4__3.mul(n0_0_0_0_m4__3).toString());}
    @Test
    void nm2_2___testMul___nm2_2() {assertEquals("4 - 8x + 4x^2", nm2_2.mul(nm2_2).toString());}
    @Test
    void n1__2_m1__2___testMul___n1__2_m1__2() {assertEquals("1/4 - 1/2x + 1/4x^2", n1__2_m1__2.mul(n1__2_m1__2).toString());}




    ///Test Clone
    @Test
    void n1_1_1_1_1___testClone() {assertEquals(n1_1_1_1_1, n1_1_1_1_1.clone());}
    @Test
    void n0_0_0_0_m4__3___testClone() {assertEquals(n0_0_0_0_m4__3, n0_0_0_0_m4__3.clone());}
    @Test
    void n1_m1_1_m1_1___testClone() {assertEquals(n1_m1_1_m1_1, n1_m1_1_m1_1.clone());}
    @Test
    void nm2_2___testClone() {assertEquals(nm2_2, nm2_2.clone());}
    @Test
    void n1__2_m1__2___testClone() {assertEquals(n1__2_m1__2, n1__2_m1__2.clone());}
    @Test
    void n5___testClone() {assertEquals(n5, n5.clone());}
    @Test
    void n10__m2___testClone() {assertEquals(n10__m2, n10__m2.clone());}
}