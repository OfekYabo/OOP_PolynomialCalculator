public abstract class IInteger implements Scalar {
    final int Number;

    protected IInteger(int number) {
        Number = number;
    }

    @Override
    public abstract String toString();

    public boolean equals(Object s)
    {
        if (s instanceof IInteger)
        {
            return this.Number == ((IInteger)s).Number;
        }
        return false;
    }
}
