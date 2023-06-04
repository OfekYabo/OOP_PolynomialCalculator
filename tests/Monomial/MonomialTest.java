package Monomial;
import Scalar.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonomialTest {
    private static Scalar n0;
    private static Scalar n1_2;
    private static Scalar nm1_2;
    private static Scalar nm4_3;
    private static Scalar n1;
    private static Scalar n2;
    private static Scalar nm4;
    private static Scalar n5;


    private static Monomial n0__1;
    private static Monomial n1__2;
    private static Monomial n1__1;
    private static Monomial n2__0;
    private static Monomial n0__9;
    private static Monomial nm1_2__2;
    private static Monomial n1_2__2;
    private static Monomial n2__10;
    private static Monomial n5__3;
    private static Monomial nm4__4;
    private static Monomial nm4_3__3;
    private static Monomial n5__0;

    @BeforeAll
    static void setUp() {
        n0 = new IntegerScalar(0);
        n1_2 = new RationalScalar(1, 2);
        nm1_2 = new RationalScalar(1, -2);
        nm4_3 = new RationalScalar(4, -3);
        n1 = new IntegerScalar(1);
        n2 = new IntegerScalar(2);
        nm4 = new IntegerScalar(-4);
        n5 = new IntegerScalar(5);;

        n0__1 = new Monomial(1, n0);
        n0__9 = new Monomial(9, n0);
        n1__2 = new Monomial(2, n1);
        n1__1 = new Monomial(1, n1);
        n2__0 = new Monomial(0, n2);
        n5__0 = new Monomial(0, n5);
        nm4_3__3 = new Monomial(3, nm4_3);
        nm4__4 = new Monomial(4, nm4);
        n5__3 = new Monomial(3, n5);
        n2__10 = new Monomial(10, n2);
        n1_2__2 = new  Monomial(2, n1_2);
        nm1_2__2 = new  Monomial(2, nm1_2);

    }



    //Test toString
    @Test
    void test_n0__1toString() {assertEquals("0", n0__1.toString());}
    @Test
    void test_n0__9toString() {assertEquals("0", n0__9.toString());}
    @Test
    void test_n1__2toString() {assertEquals("x^2", n1__2.toString());}
    @Test
    void test_n1__1toString() {assertEquals("x", n1__1.toString());}
    @Test
    void test_n2__0toString() {assertEquals("2", n2__0.toString());}
    @Test
    void test_nm4_3__3toString() {assertEquals("-4/3x^3", nm4_3__3.toString());}
    @Test
    void test_nm4__4toString() {assertEquals("-4x^4", nm4__4.toString());}
    @Test
    void test_n5__3toString() {assertEquals("5x^3", n5__3.toString());}
    @Test
    void test_n2__10toString() {assertEquals("2x^10", n2__10.toString());}
    @Test
    void test_n1_2__2toString() {assertEquals("1/2x^2", n1_2__2.toString());}
    @Test
    void test_nm1_2__2toString() {assertEquals("-1/2x^2", nm1_2__2.toString());}
    @Test
    void test_n5__0toString() {assertEquals("5", n5__0.toString());}




    //Test sign

    @Test
    void sign_n0__1() {assertEquals(0, n0__1.sign()); }
    @Test
    void sign_n1__1() {assertEquals(1, n1__1.sign()); }
    @Test
    void sign_nm4_3__3() {assertEquals(-1, nm4_3__3.sign()); }
    @Test
    void sign_n5__3() {assertEquals(1, n5__3.sign()); }
    @Test
    void sign_n1_2__2() {assertEquals(1, n1_2__2.sign()); }
    @Test
    void sign_nm1_2__2() {assertEquals(-1, nm1_2__2.sign()); }


    //Test add

    @Test
    void n5__0__add__n2__0()  { assertEquals("7", n5__0.add(n2__0).toString()); }
    @Test
    void n0__1__add__n1__1()  { assertEquals("x", n0__1.add(n1__1).toString()); }
    @Test
    void n1_2__2__add__nm1_2__2()  { assertEquals("0", n1_2__2.add(nm1_2__2).toString()); }
    @Test
    void n5__3__add__nm4_3__3()  { assertEquals("11/3x^3", nm4_3__3.add(n5__3).toString()); }



    //Test mul
    @Test
    void n5__0__mul__n2__0()  { assertEquals("10", n5__0.mul(n2__0).toString()); }
    @Test
    void n0__1__mul__n1__1()  { assertEquals("0", n0__1.mul(n1__1).toString()); }
    @Test
    void n1_2__2__mul__nm1_2__2()  { assertEquals("-1/4x^4", n1_2__2.mul(nm1_2__2).toString()); }
    @Test
    void n5__3__mul__nm4_3__3()  { assertEquals("-20/3x^6", nm4_3__3.mul(n5__3).toString()); }
    @Test
    void n1_2__2__mul__nm4_3__3()  { assertEquals("-2/3x^5", n1_2__2.mul(nm4_3__3).toString()); }


    //Test evaluate
    @Test
    void n1_2__2__evaluate__n5()  { assertEquals("25/2", n1_2__2.evaluate(n5).toString()); }
    @Test
    void n2__0__evaluate__n5()  { assertEquals("2", n2__0.evaluate(n5).toString()); }
    @Test
    void n2__0__evaluate__nm4_3()  { assertEquals("2", n2__0.evaluate(nm4_3).toString()); }
    @Test
    void n2__10__evaluate__n2()  { assertEquals("2048", n2__10.evaluate(n2).toString()); }
    @Test
    void n5__3__evaluate__nm4()  { assertEquals("-320", n5__3.evaluate(nm4).toString()); }
    @Test
    void nm4__4__evaluate__nm4()  { assertEquals("-1024", nm4__4.evaluate(nm4).toString()); }



    //Test derivative
    @Test
    void test_n0__1_derivative() {assertEquals("0", n0__1.derivative().toString());}
    @Test
    void test_n0__9derivative() {assertEquals("0", n0__9.derivative().toString());}
    @Test
    void test_n1__2derivative() {assertEquals("2x", n1__2.derivative().toString());}
    @Test
    void test_n1__1derivative() {assertEquals("1", n1__1.derivative().toString());}
    @Test
    void test_n2__0derivative() {assertEquals("0", n2__0.derivative().toString());}
    @Test
    void test_nm4_3__3derivative() {assertEquals("-4x^2", nm4_3__3.derivative().toString());}
    @Test
    void test_nm4__4derivative() {assertEquals("-16x^3", nm4__4.derivative().toString());}
    @Test
    void test_n5__3derivative() {assertEquals("15x^2", n5__3.derivative().toString());}
    @Test
    void test_n2__10derivative() {assertEquals("20x^9", n2__10.derivative().toString());}
    @Test
    void test_n1_2__2derivative() {assertEquals("x", n1_2__2.derivative().toString());}
    @Test
    void test_nm1_2__2derivative() {assertEquals("-x", nm1_2__2.derivative().toString());}
    @Test
    void test_n5__0derivative() {assertEquals("0", n5__0.derivative().toString());}
}