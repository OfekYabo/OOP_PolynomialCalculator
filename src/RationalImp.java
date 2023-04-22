public class RationalImp extends IRational{

    protected RationalImp(int numerator, int denominator) {
        /// comment GCD before
        /// - for the first one
        super(numerator, denominator);
    }

    @Override
    public String toString() {
        if(this.Denominator == 1) return String.valueOf(this.Numerator);
        else return String.valueOf(this.Numerator)+ "/" + String.valueOf(this.Denominator);
    }

    @Override
    public IRational reduce() {
        return new RationalImp(this.Numerator, this.Denominator);
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add(this);
    }
    public Scalar add(IInteger i) {
        return new RationalImp((i.Number*this.Denominator)+this.Numerator, this.Denominator);
    }
    public Scalar add(IRational r) {
        return new RationalImp((r.Numerator*this.Denominator) + (r.Denominator*this.Numerator),  r.Denominator*this.Denominator);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul(this);
    }
    public Scalar mul(IInteger i) {
        return new RationalImp(i.Number*this.Numerator, this.Denominator);
    }
    public Scalar mul(IRational r) {
        return new RationalImp(r.Numerator*this.Numerator, r.Denominator*this.Denominator);
    }
    @Override
    public Scalar neg() {
        return new RationalImp((-1)*this.Numerator, this.Denominator);
    }

    @Override
    public Scalar power(int exponent) {
        int top = this.Numerator;
        int bottom = this.Denominator;
        while (exponent>0){
            top *= top;
            bottom *= bottom;
            exponent--;
        }
        IRational ans = new RationalImp(top, bottom);
        return ans;
    }

    @Override
    public int sign() {
        int ans = 1;
        if (this.Numerator==0) ans =0;
        else if (this.Numerator<0) ans =-1;
        return ans;
    }
}
