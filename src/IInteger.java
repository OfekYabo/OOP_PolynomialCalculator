public abstract class IInteger implements Scalar {
    public final int Number;

    protected IInteger(int number) {
        Number = number;
    }

    @Override
    public abstract String toString();

    public boolean equals(Object o)
    {
        if (o instanceof IInteger)
        {
            return this.Number == ((IInteger)o).Number;
        }
        return false;
    }
}
