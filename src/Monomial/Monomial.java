package Monomial;
import Scalar.*;

public class Monomial {
    public final int Exponent;
    public final Scalar Coefficient;

    public Monomial(int exponent, Scalar coefficient) {
        Exponent = exponent;
        Coefficient = coefficient;
    }

    public int getExponent() {
        return Exponent;
    }
    public Scalar getCoefficient() {
        return Coefficient;
    }

    public Monomial add(Monomial m) {
        if (this.Exponent != m.Exponent) { throw new IllegalArgumentException("Exponent must be equals"); }
        return new Monomial(this.Exponent, this.Coefficient.add(m.Coefficient));
    }

    public Monomial mul(Monomial m) {
        return new Monomial(this.Exponent + m.Exponent, this.Coefficient.mul(m.Coefficient));
    }

    public Scalar evaluate(Scalar s) {
        return s.power(this.Exponent).mul(this.Coefficient);
    }
    public Monomial derivative() {
        return new Monomial(this.Exponent -1, this.Coefficient.mul(new IntegerScalar(this.Exponent)));
    }
    public int sign() {
        return this.Coefficient.sign();
    }
    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }
    public String toString()
    {
        if (this.Exponent == 0) {
            return this.Coefficient.toString();
        } else if (this.Coefficient.toString().equals("0") | this.Exponent==-1) {
            return new IntegerScalar(0).toString();
        }
        String ans;
        boolean noExponent = this.Exponent == 1;
        boolean noCoeffient = this.Coefficient.toString().equals(new IntegerScalar(1).toString());
        boolean negCoeffient = this.Coefficient.toString().equals(new IntegerScalar(-1).toString());
        if(negCoeffient) {  ans = "-x"; }
        else if(!noCoeffient) { ans = this.Coefficient.toString() + "x";}
        else { ans = "x"; }
        if (!noExponent) { ans = ans + "^" + this.Exponent; }
        return ans;
    }
}
