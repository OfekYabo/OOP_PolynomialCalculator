package Scalar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ScalarTest {
    private static Scalar n0;
    private static Scalar n1_2;
    private static Scalar nm1_2;
    private static Scalar nm4_3;
    private static Scalar n1;
    private static Scalar nm1;
    private static Scalar n2;
    private static Scalar nm4;
    private static Scalar n5;
    private static Scalar n9;
    private static Scalar n100_20;
    private static Scalar n99;
    private static Scalar nm99_1;

    @BeforeAll
    static void setUp() {
        n0 = new IntegerScalar(0);
        n1_2 = new RationalScalar(1, 2);
        nm1_2 = new RationalScalar(1, -2);
        nm4_3 = new RationalScalar(4, -3);
        n1 = new IntegerScalar(1);
        nm1 = new IntegerScalar(-1);
        n2 = new IntegerScalar(2);
        nm4 = new IntegerScalar(-4);
        n5 = new IntegerScalar(5);
        n9 = new IntegerScalar(9);
        n100_20 = new RationalScalar(100, 20);
        n99 = new IntegerScalar(99);
        nm99_1 = new RationalScalar(99, -1);
    }

    //Add Tests
    @Test
    void add_n0_n99() {
        assertEquals("99", n0.add(n99).toString());
    }
    @Test
    void add_n99_n1() {
        assertEquals("100", n99.add(n1).toString());
    }
    @Test
    void add_n1_2_nm1_2() {
        assertEquals("0", n1_2.add(nm1_2).toString());
    }
    @Test
    void add_nm4_3_nm4() {
        assertEquals("-16/3", nm4_3.add(nm4).toString());
    }
    @Test
    void add_n9_nm1() {
        assertEquals("8", n9.add(nm1).toString());
    }
    @Test
    void add_n1_2_n99() {
        assertEquals("199/2", n1_2.add(n99).toString());
    }
    @Test
    void add_n2_n1_2() {
        assertEquals("5/2", n2.add(n1_2).toString());
    }

    //Mul Tests

    @Test
    void mul_n2_n1_2() { assertEquals("1", n2.mul(n1_2).toString()); }
    @Test
    void mul_n9_nm4() { assertEquals("-36", n9.mul(nm4).toString()); }
    @Test
    void mul_nm1_nm99_1() { assertEquals("99", nm1.mul(nm99_1).toString()); }
    @Test
    void mul_n99_n1_2() { assertEquals("99/2", n99.mul(n1_2).toString()); }
    @Test
    void mul_n9_nm4_3() { assertEquals("-12", n9.mul(nm4_3).toString()); }
    @Test
    void mul_nm1_2_nm4_3() { assertEquals("2/3", nm1_2.mul(nm4_3).toString()); }
    @Test
    void mul_nm4_3_n0() { assertEquals("0", nm4_3.mul(n0).toString()); }
    @Test
    void mul_n0_n9() { assertEquals("0", n0.mul(n9).toString()); }

    //Test neg



    @Test
    void neg_nm4_3() {assertEquals("4/3", nm4_3.neg().toString()); }
    @Test
    void neg_nm1_2() {assertEquals("1/2", nm1_2.neg().toString()); }
    @Test
    void neg_n100_20() {assertEquals("-5", n100_20.neg().toString()); }
    @Test
    void neg_nm1() {assertEquals("1", nm1.neg().toString()); }
    @Test
    void neg_n1() {assertEquals("-1", n1.neg().toString()); }

    // Test power

    @Test
    void power_n9__2() {assertEquals("81", n9.power(2).toString()); }
    @Test
    void power_nm1_2__4() {assertEquals("1/16", nm1_2.power(4).toString()); }

    @Test
    void power_n5__9() {assertEquals("1953125", n5.power(9).toString()); }
    @Test
    void power_n99__0() {assertEquals("1", n99.power(0).toString()); }
    @Test
    void power_n1_2__1() {assertEquals("1/2", n1_2.power(1).toString()); }


    // Test sign
    @Test
    void sign_nm1_2() {assertEquals(-1, nm1_2.sign()); }
    @Test
    void sign_n100_20() {assertEquals(1, n100_20.sign()); }
    @Test
    void sign_nm4() {assertEquals(-1, nm4.sign()); }
    @Test
    void sign_n2() {assertEquals(1, n2.sign()); }
    @Test
    void sign_n0() {assertEquals(0, n0.sign()); }

    //Test equals


    @Test
    void testEquals_n100_20_n5() {assertEquals(n100_20, n5);}
    @Test
    void testEquals_n5_n100_20() {assertEquals(n5, n100_20);}
    @Test
    void testEquals_n99_nm99_1() {assertNotEquals(n99, nm99_1);}



    // Test toString
    @Test
    void test_n1_2toString() {assertEquals("1/2", n1_2.toString());}
    @Test
    void test_nm1_2toString() {assertEquals("-1/2", nm1_2.toString());}
    @Test
    void test_n99_toString() {assertEquals("99", n99.toString());}
    @Test
    void test_n100_20toString() {assertEquals("5", n100_20.toString());}
    @Test
    void test_nm99_1toString() { assertEquals("-99", nm99_1.toString());}
}