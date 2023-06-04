package Polynomial;
import Monomial.*;
import Scalar.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Monomial> monomials;


    public Polynomial(Collection<Monomial> monomialsCollection) {
        monomials = new TreeMap<>();
        for (Monomial m : monomialsCollection) {
            if (!m.getCoefficient().equals(new IntegerScalar(0)))
            {
                if (monomials.keySet().contains(m.getExponent()))
                    monomials.put(m.getExponent(), m.add(monomials.get(m.getExponent())));
                else
                    monomials.put(m.getExponent(),m);

            }
        }
    }

    public static Polynomial build(String input) {
        String[] splitted = input.split("\s+");
        List<Monomial> monos = new LinkedList<>();
        int exponentCounter = 0;
        for (String stringCoe : splitted) {
            if (isStringInteger(stringCoe)) {
                Scalar coef = stringToIntegerScalar(stringCoe);
                Monomial inputMonomial = new Monomial(exponentCounter, coef);
                monos.add(inputMonomial);
                exponentCounter++;
            }
            else {
                Scalar coef = stringToRational(stringCoe);
                Monomial inputMonomial = new Monomial(exponentCounter, coef);
                monos.add(exponentCounter, inputMonomial);
                exponentCounter++;
            }
        }
        Polynomial output = new Polynomial(monos);
        return output;
    }

    public Polynomial add(Polynomial p) {
        Polynomial copy = clone();
        Map<Integer, Monomial> baseMonos = copy.getTreeMap();
        Map<Integer, Monomial> inputMonos = p.getTreeMap();
        List<Monomial> output = new LinkedList<>();
        for (Map.Entry<Integer,Monomial> m : inputMonos.entrySet()) {
            int exponent = m.getKey();
            if (baseMonos.containsKey(exponent)) {
                Monomial m1 = m.getValue();
                Monomial m2 = monomials.get(exponent);
                baseMonos.replace(exponent, m1.add(m2));
            }
            else {
                baseMonos.put(exponent, m.getValue());
            }
        }
        for (Map.Entry<Integer,Monomial> m : baseMonos.entrySet()) {
            output.add(m.getValue());
        }
        return new Polynomial(output);
    }

    public Polynomial mul(Polynomial p) {
        Map<Integer, Monomial> inputMonos = p.getTreeMap();
        List<Monomial> output = new LinkedList<>();
        for (Map.Entry<Integer,Monomial> baseEntry : monomials.entrySet()) {
            for (Map.Entry<Integer,Monomial> inputEntry : inputMonos.entrySet()) {
                Monomial baseM = baseEntry.getValue();
                Monomial inputM = inputEntry.getValue();
                output.add(baseM.mul(inputM));
            }
        }
        return new Polynomial(output);
    }

    public Scalar evaluate(Scalar s) {
        Scalar output = new IntegerScalar(0);
        for (Map.Entry<Integer,Monomial> entry : monomials.entrySet()) {
            Monomial m = entry.getValue();
            output = output.add(m.evaluate(s));
        }
        return output;
    }

    public Polynomial derivative() {
        List<Monomial> output = new LinkedList<>();
        for (Map.Entry<Integer,Monomial> entry : monomials.entrySet()) {
            Monomial m = entry.getValue();
            output.add(m.derivative());
        }
        return new Polynomial(output);
    }

    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

    public String toString() {
        String output = "";
        for (Map.Entry<Integer,Monomial> entry : monomials.entrySet())
        {
            Monomial m = entry.getValue();
            output = output + m.toString();
            if (!m.toString().equals(""))
                output = output + " + ";
        }
        output = output.replace("+ -", "- ");
        output = output.replace("+  +", "+");
        return output.substring(0, output.length()-3);
    }


    public Polynomial clone() {
        List<Monomial> copy = new LinkedList<>();
        for (Map.Entry<Integer,Monomial> entry : monomials.entrySet()) {
            Monomial m = entry.getValue();
            copy.add(m);
        }
        return new Polynomial(copy);
    }

    private TreeMap<Integer, Monomial> getTreeMap(){
        return monomials;
    }
    private static boolean isStringInteger(String s) {
        return (!s.contains("/"));
    }
    private static Scalar stringToRational(String s) {
        int numerator = Integer.parseInt(s.split("/")[0]);
        int denominator = Integer.parseInt(s.split("/")[1]);
        Scalar coef = new RationalScalar(numerator, denominator);
        return coef;
    }
    private static Scalar stringToIntegerScalar(String s) {
        int number = Integer.parseInt(s);
        Scalar coef = new IntegerScalar(number);
        return coef;
    }

}
