package Calculator;

public class IntegerScalar implements Scalar{

    public final int Number;

    protected IntegerScalar(int number) {
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
        while (0 < exponent){
            base *= base;
            exponent--;
        }
        Scalar ans = new IntegerScalar(base);
        return ans;
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
            return this.toString() == ((Scalar)o).toString();
        }
        return false;
    }
}
