package Scalar;

public class IntegerScalar implements Scalar {

    public final int Number;

    public IntegerScalar(int number) {
        Number = number;
    }
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }
    public Scalar addInteger(IntegerScalar i) {
        return new IntegerScalar( i.Number + this.Number);
    }
    @Override
    public Scalar addRational(RationalScalar r) {
        return r.addInteger(this);
    }
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }
    public Scalar mulInteger(IntegerScalar i) {
        return new IntegerScalar(i.Number * this.Number);
    }
    @Override
    public Scalar mulRational(RationalScalar r) {
        return r.mulInteger(this);
    }

    public Scalar neg() {
        return new IntegerScalar(this.Number*(-1));
    }
    public Scalar power(int exponent) {
        int base = this.Number;
        int ans = base;
        if( exponent == 0) {
            ans = 1;
        }
        while (1 < exponent){
            ans = ans *base;
            exponent--;
        }
        Scalar result = new IntegerScalar(ans);
        return result;
    }
    public int sign() {
        int ans = 1;
        if (this.Number==0) ans =0;
        else if (this.Number<0) ans =-1;
        return ans;
    }
    public String toString(){
        return String.valueOf(this.Number);
    }
    public boolean equals(Object o) {
        if (o instanceof Scalar)
        {
            return this.toString().equals((o).toString());
        }
        return false;
    }
}
