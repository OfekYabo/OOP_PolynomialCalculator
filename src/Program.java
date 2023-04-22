public class Program {

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
}
