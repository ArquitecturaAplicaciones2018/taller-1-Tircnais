package taller1;

import java.util.List;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Rational {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        int mcd = mcd(numerator, denominator);
        this.numerator = numerator / mcd;
        setDenominator(denominator / mcd);
    }

    public boolean isLessThan(Rational other) {
        return numerator * other.getDenominator() < other.getNumerator() * denominator;
    }

    public Rational getGreater(Rational other) {
        return this.isLessThan(other) ? other : this;
    }

    public Rational plus(Rational other) {
        return new Rational(numerator * other.getDenominator() + other.getNumerator() * denominator,
                denominator * other.getDenominator());
    }

    public Rational minus(Rational other) {
        return plus(other.negate());
    }

    public Rational times(Rational other) {
        return new Rational(numerator * other.getNumerator(),
                denominator * other.getDenominator());
    }

    public Rational divides(Rational other) {
        return new Rational(numerator * other.getDenominator(),
                denominator * other.getNumerator());
    }


    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public final void setDenominator(int denominator) {
        if(denominator != 0) {
            this.denominator = denominator;
        } else {
            throw new IllegalArgumentException("The denominator can not be 0");
        }
    }

    private int mcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return mcd(b, a % b);
        }
    }

    private Rational negate() {
        return new Rational(-1 * numerator, denominator);
    }

    @Override
    public String toString() {
        var output = denominator == 1 ? String.valueOf(numerator) : String.format("%d/%d", numerator, denominator);
        return output;
    }
    
}
