package taller1;

import java.util.Arrays;
import java.util.List;

public class Rational {
    public static Rational ZERO = new Rational(0, 1);

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
    
    public static void main(String[] args) {
        var rationals = List.of(
            new Rational(1, 4),
            new Rational(1, 8),
            new Rational(3, 4),
            new Rational(7, 8)
        );
        
        //Imperativo
        var unMedio = new Rational(1, 2);
        for (Rational object : rationals) {
            if(object.isLessThan(unMedio))
                System.out.println(object);
        }
        
        //FUNCIONAL
        //Obtener todos los números racionales que sean menores a 1/2
        rationals.stream().filter(r->r.isLessThan(unMedio)).forEach(System.out::println);
        //Filtra(busca menor) e imprime
        
        System.out.println("");
        //Sumar todos los racionales
        var suma = new Rational(0, 1);
        rationals.stream().map(r->r.plus(suma)).forEach(System.out::println);
        
        //int sum = rationals.stream().reduce(0, (a, b) -> a + b);
        
        //Obtener el número racional mayor
        
        //Sumar todos numeradores y obtener los siguientes datos: número de elementos, la suma de los numeradores, el numerador menor, el mayor y el promedio
        
        
        //int [] array = {23,43,56,97,32};
        // Establecer el valor de inicio. El resultado será el valor de inicio + la suma de la matriz.
        //int startValue = 0;
        //int sum = Arrays.stream(array).reduce(startValue, (x, y) -> x + y);
        //System.out.println (sum);
        //sum = Arrays.stream (array) .reduce (startValue, Integer :: sum);
        //System.out.println (sum);
        
    }
}

