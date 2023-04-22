public class TestScalar {
    ///////////tryffffff
    ///////ffdffdddfdf

    public static boolean add(String number1, String number2, String answer)
    {
        Scalar[] arr = ConvertToScalar(number1, number2);
        return answer.equals((arr[1].add(arr[2])).toString());
    }

    public static boolean mul(String number1, String number2, String answer)
    {
        Scalar[] arr = ConvertToScalar(number1, number2);
        return answer.equals((arr[1].mul(arr[2])).toString());
    }

    public static boolean neg(String number1, String answer)
    {
        Scalar n1 = ConvertToScalar(number1);
        return answer.equals((n1.neg()).toString());
    }

    public static boolean power(String number1, int exponent, String answer)
    {
        Scalar n1 = ConvertToScalar(number1);
        return answer.equals((n1.power(exponent)).toString());
    }

    public static boolean sign(String number1, String answer)
    {
        Scalar n1 = ConvertToScalar(number1);
        return answer.equals(String.valueOf(n1.sign()));
    }

    public static boolean equals(String number1, String number2, boolean answer)
    {
        Scalar[] arr = ConvertToScalar(number1, number2);
        if (answer) return arr[1].equals(arr[2]);
        else return !arr[1].equals(arr[2]);
    }


    private static Scalar[] ConvertToScalar(String number1, String number2)
    {
        Scalar[] arr = new Scalar[2];
        try
        {
            int num1 = Integer.parseInt(number1);
            IntegerImp n1 = new IntegerImp(num1);
            arr[0] = n1;
        }
        catch (NumberFormatException e) {
            String[] parts = number1.split("/");
            RationalImp n1 = new RationalImp(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            arr[0] = n1;
        }
        try
        {
            int num2 = Integer.parseInt(number2);
            IntegerImp n2 = new IntegerImp(num2);
            arr[1] = n2;
        }
        catch (NumberFormatException e) {
            String[] parts = number2.split("/");
            RationalImp n2 = new RationalImp(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            arr[1] = n2;
        }
        return arr;
    }

    private static Scalar ConvertToScalar(String number1)
    {
        try
        {
            int num1 = Integer.parseInt(number1);
            IntegerImp n1 = new IntegerImp(num1);
            return n1;
        }
        catch (NumberFormatException e) {
            String[] parts = number1.split("/");
            RationalImp n1 = new RationalImp(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            return n1;
        }
    }



    }
