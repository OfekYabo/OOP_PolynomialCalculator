public class TestScalar {
    public static Scalar ConvertToScalar(String number)
    {
        int sign = 1;
        if (number.contains("-")) { sign = -1; }
        if (number.contains("/"))
        {
            String[] parts = number.split("/");
            Scalar n1 = new Rational(parseInt(parts[0], sign), parseInt(parts[1], sign));
            return n1;
        }
        else
        {
            int num1 = parseInt(number, sign);
            Scalar n1 = new Integer(num1);
            return n1;
        }
    }

    public static Monomial ConvertToMonomial(String number)
    {
        Monomial ans;
        String[] arr = number.split("x");
        if( arr.length == 1)
        {
            if (arr[0].contains("^"))
            {
                String exponent = arr[0].substring(1);
                int sign = 1;
                if (exponent.contains("-")) { sign = -1; }
                return ans = new Monomial(parseInt(exponent, sign), new Integer(1));
            }
            else
            {
                return ans = new Monomial(1, ConvertToScalar(arr[0]));
            }
        }
        else
        {
            String exponent = arr[1].substring(1);
            int sign = 1;
            if (exponent.contains("-")) { sign = -1; }
            return ans = new Monomial(parseInt(exponent, sign), ConvertToScalar(arr[0]));
        }
    }


///sign must be 1/-1
    public static int parseInt(String number, int sign) {
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            result = result * 10 + number.charAt(i) - '0';
        }
        return result * sign;
    }

///-------Scalar Function Tests--------
    public static boolean add(String number1, String number2, String answer)
    {
        Scalar n1 = ConvertToScalar(number1);
        Scalar n2 = ConvertToScalar(number2);
        return answer.equals((n1.add(n2)).toString());
    }

    public static boolean mul(String number1, String number2, String answer)
    {
        Scalar n1 = ConvertToScalar(number1);
        Scalar n2 = ConvertToScalar(number2);
        return answer.equals((n1.mul(n2)).toString());
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
        Scalar n1 = ConvertToScalar(number1);
        Scalar n2 = ConvertToScalar(number2);
        if (answer) return n1.equals(n2);
        else return !n1.equals(n2);
    }


///-------Monomial Function Tests--------





}
