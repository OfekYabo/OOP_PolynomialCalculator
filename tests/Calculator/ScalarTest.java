package Calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScalarTest {
    private static Scalar n0;
    private static Scalar n1;
    private static Scalar n2;
    private static Scalar n10;
    private static Scalar n99;
    private static Scalar n1_2;
    private static Scalar n20_10;
    private static Scalar n10_1;
    private static Scalar n2_4;
    private static Scalar nm1_2;

    @BeforeAll
    static void setUp() {
        n0 = new IntegerScalar(0);
        n1 = new IntegerScalar(1);
        n2 = new IntegerScalar(2);
        n10 = new IntegerScalar(10);
        n99 = new IntegerScalar(99);
        n1_2 = new RationalScalar(1, 2);
        n20_10 = new RationalScalar(20, 10);
        n10_1 = new RationalScalar(10, 1);
        n2_4 = new RationalScalar(2, 4);
        nm1_2 = new RationalScalar(1, -2);
    }

    @Test
    void add_n0_n99() {
        assertEquals("99", n0.add(n99).toString());
    }
    @Test
    void add_n99_n1() {
        assertEquals("100", n99.add(n1).toString());
    }
    @Test
    void add_n10_n99() {
        assertEquals("109", n10.add(n99).toString());
    }
    @Test
    void add_n2_n1_2() {
        assertEquals("5/2", n2.add(n1_2).toString());
    }
    @Test
    void add_n10_1_n99() {
        assertEquals("109", n10.add(n99).toString());
    }
    @Test
    void add_n20_10_n2() {
        assertEquals("4", n20_10.add(n2).toString());
    }
    void add_n2_4_n1_2() {
        assertEquals("1", n2_4.add(n1_2).toString());
    }

    @Test
    void mul() {
    }

    @Test
    void neg() {
    }

    @Test
    void power() {
    }

    @Test
    void sign() {
    }

    @Test
    void testEquals() {
    }
    @Test
    void test_n1_2toString() {
        assertEquals("1/2", n1_2.toString());
    }
    @Test
    void test_nm1_2toString() {
        assertEquals("-1/2", nm1_2.toString());
    }
}