package Calculator;

public abstract class IMonomial {
    public final int Exponent;
    public final Scalar Coefficient;

    public IMonomial(int exponent, Scalar coefficient) {
        Exponent = exponent;
        Coefficient = coefficient;
    }

    public abstract IMonomial add(IMonomial m);
    public abstract IMonomial mul(IMonomial m);
    public abstract Scalar evaluate(Scalar s);
    public abstract IMonomial derivative();
    public abstract int sign();
    public boolean equals(Object o)
    {
        if (o instanceof IMonomial)
        {
            return this.Exponent == ((IMonomial) o).Exponent & this.Coefficient.equals((IMonomial)((IMonomial) o).Coefficient);
        }
        return false;
    }
    public String toString()
    {
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
