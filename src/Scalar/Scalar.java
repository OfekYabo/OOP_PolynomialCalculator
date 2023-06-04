package Scalar;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar addInteger(IntegerScalar i);
    Scalar addRational(RationalScalar r);
    Scalar mul(Scalar s);
    Scalar mulInteger(IntegerScalar i);
    Scalar mulRational(RationalScalar r);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    boolean equals(Object o);
}
