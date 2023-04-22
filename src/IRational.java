public abstract class IRational implements Scalar {
    final int Numerator;
    final int Denominator;

    protected IRational(int numerator, int denominator) {
        Numerator = numerator;
        Denominator = denominator;

    }


    @Override
    public abstract String toString();

    public abstract IRational reduce();

    public boolean equals(Object s)
    {
        if (s instanceof IRational)
        {
            return this.Numerator == ((IRational)s).Numerator & this.Denominator == ((IRational)s).Denominator;
        }
        return false;
    }
}
