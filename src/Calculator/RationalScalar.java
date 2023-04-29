package Calculator;

public class RationalScalar implements Scalar {
    public final int Numerator;
    public final int Denominator;

    protected RationalScalar(int numerator, int denominator) {
       int[] arr = reduce(numerator, denominator);
       if (arr[1] < 0) {
           Denominator = -arr[1];
           Numerator = -arr[0];
       }
       else {
           Denominator = arr[1];
           Numerator = arr[0];
       }
    }

    public int getDenominator() {
        return Denominator;
    }
    public int getNumerator() {
        return Numerator;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    private int[] reduce(int numerator, int denominator) {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        int reducedNumerator = numerator / gcd;
        int reducedDenominator = denominator / gcd;
        int[] arr = {reducedNumerator, reducedDenominator};
        return arr;
    }
    public RationalScalar reduce(){
        return new RationalScalar(this.Numerator, this.Denominator);
    }
    public Scalar add(Scalar s) {
        return s.addRational(this);
    }
    public Scalar addInteger(IntegerScalar i) {
        return new RationalScalar((i.Number*this.Denominator)+this.Numerator, this.Denominator);
    }
    public Scalar addRational(RationalScalar r) {
        return new RationalScalar((r.Numerator*this.Denominator) + (r.Denominator*this.Numerator),  r.Denominator*this.Denominator);
    }
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }
    public Scalar mulInteger(IntegerScalar i) {
        return new RationalScalar(i.Number*this.Numerator, this.Denominator);
    }
    public Scalar mulRational(RationalScalar r) {
        return new RationalScalar(r.Numerator*this.Numerator, r.Denominator*this.Denominator);
    }
    public Scalar neg() {
        return new RationalScalar((-1)*this.Numerator, this.Denominator);
    }
    public Scalar power(int exponent) {
        int top = this.Numerator;
        int bottom = this.Denominator;
        int newtop = top;
        int newbottom = bottom;
        if( exponent == 0) {
            newtop = 1;
            newbottom = 1;
        }
        while (exponent>1){
            newtop = newtop * top;
            newbottom = newbottom * bottom;
            exponent--;
        }
        RationalScalar ans = new RationalScalar(newtop, newbottom);
        return ans;
    }
    public int sign() {
        int ans = 1;
        if (this.Numerator==0) ans =0;
        else if (this.Numerator<0) ans =-1;
        return ans;
    }
    public String toString() {
        if(this.Denominator == 1) return String.valueOf(this.Numerator);
        else return String.valueOf(this.Numerator)+ "/" + String.valueOf(this.Denominator);
    }
    public boolean equals(Object o) {
        if (o instanceof Scalar)
        {
            return this.toString().equals((o).toString());
        }
        return false;
    }
}
