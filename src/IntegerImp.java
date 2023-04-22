public class IntegerImp extends IInteger {

    IntegerImp(int number)
    {
        super(number);
    }
    @Override
    public String toString(){
        return String.valueOf(this.Number);
    }

    @Override
    public Scalar add(Scalar s) {
        return s.add(this);
    }
    public Scalar add(IInteger s) {
        return new IntegerImp( s.Number+this.Number);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mul(this);
    }
    public Scalar mul(IInteger i) {
        return new IntegerImp(i.Number * this.Number);
    }

    @Override
    public Scalar neg() {
        return new IntegerImp(this.Number*(-1));
    }

    @Override
    public Scalar power(int exponent) {
        int base = this.Number;
        while (exponent>0){
            base *=base;
            exponent--;
        }
        IntegerImp ans = new IntegerImp(base);
        return ans;
    }

    @Override
    public int sign() {
        int ans = 1;
        if (this.Number==0) ans =0;
        else if (this.Number<0) ans =-1;
        return ans;
    }
}
