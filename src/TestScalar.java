public class TestScalar {
    ///


///-------Scalar Function Tests--------
    public static boolean add(String number1, String number2, String answer)
    {
        Scalar n1 = Program.ConvertToScalar(number1);
        Scalar n2 = Program.ConvertToScalar(number2);
        return answer.equals((n1.add(n2)).toString());
    }

    public static boolean mul(String number1, String number2, String answer)
    {
        Scalar n1 = Program.ConvertToScalar(number1);
        Scalar n2 = Program.ConvertToScalar(number2);
        return answer.equals((n1.mul(n2)).toString());
    }

    public static boolean neg(String number1, String answer)
    {
        Scalar n1 = Program.ConvertToScalar(number1);
        return answer.equals((n1.neg()).toString());
    }

    public static boolean power(String number1, int exponent, String answer)
    {
        Scalar n1 = Program.ConvertToScalar(number1);
        return answer.equals((n1.power(exponent)).toString());
    }

    public static boolean sign(String number1, String answer)
    {
        Scalar n1 = Program.ConvertToScalar(number1);
        return answer.equals(String.valueOf(n1.sign()));
    }

    public static boolean equals(String number1, String number2, boolean answer)
    {
        Scalar n1 = Program.ConvertToScalar(number1);
        Scalar n2 = Program.ConvertToScalar(number2);
        if (answer) return n1.equals(n2);
        else return !n1.equals(n2);
    }


///-------Monomial Function Tests--------





}
