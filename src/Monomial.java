public class Monomial extends IMonomial {
    protected Monomial(int Exponent, Scalar Coefficient) {
        super(Exponent, Coefficient);
    }


    @Override
    public IMonomial add(IMonomial m) {
        if (this.Exponent != m.Exponent) { throw new IllegalArgumentException("Exponent must be equals"); }
        return new Monomial(this.Exponent, this.Coefficient.add(m.Coefficient));
    }

    @Override
    public Monomial mul(IMonomial m) {
        return new Monomial(this.Exponent + m.Exponent, this.Coefficient.mul(m.Coefficient));
    }

    @Override
    public Scalar evaluate(Scalar s) {
        return s.power(this.Exponent).mul(this.Coefficient);
    }
    @Override
    public Monomial derivative() {
        return new Monomial(this.Exponent -1, this.Coefficient.mul(new Integer(this.Exponent)));
    }
    @Override
    public int sign() {
        return this.Coefficient.sign();
    }
}
