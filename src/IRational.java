public abstract class IRational implements Scalar {
    public final int Numerator;
    public final int Denominator;

    protected IRational(int numerator, int denominator) {
        Numerator = numerator;
        Denominator = denominator;

    }


    @Override
    public abstract String toString();

    public abstract IRational reduce();

    public boolean equals(Object o)
    {
        if (o instanceof IRational)
        {
            return this.Numerator == ((IRational)o).Numerator & this.Denominator == ((IRational)o).Denominator;
        }
        return false;
    }
}
