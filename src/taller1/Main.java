/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 *
 * @author Cristian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Lista solicitada
        var rationals = List.of(
            new Rational(1, 4),
            new Rational(1, 8),
            new Rational(3, 4),
            new Rational(7, 8)
        );
        Rational a = new Rational(3, 4);
        Rational b = new Rational(6, 2);
        System.out.println(a.minus(b));
        System.out.println("Lista");
        rationals.forEach(System.out::println);
        //Imperativo
        var unMedio = new Rational(1, 2);
        /*
        for (Rational object : rationals) {
            if(object.isLessThan(unMedio))
                System.out.println(object);
        }
        */
        
        System.out.println("\t\tLiteral 1\nMenores a "+unMedio.toString());
        //FUNCIONAL
        //Obtener todos los números racionales que sean menores a 1/2
        rationals.stream().filter(r->r.isLessThan(unMedio)).forEach(System.out::println);
        //Filtra(busca elemento por elemento menores a 1/2) e imprime
        
        System.out.println("\n\t\tLiteral 2\nSuma de racionales");
        //Sumar todos los racionales
        var acumala = new Rational(0, 1);
        var sum = rationals.stream().reduce(acumala, (x, y) -> x.plus(y));        
        System.out.println(sum.toString());
        //El metodo reduce ACUMULA la suma, mientas que X, Y representan el valor actual (acumalado) y el siguiente en el flujo (lista) respectivamente
        
        
        var mayor = new Rational(0, 1);
        //Obtener el número racional mayor
        System.out.println("\n\t\tLiteral 3\nObtener el número racional mayor");
        System.out.println(rationals.stream().reduce(mayor, (x, y) -> x.getGreater(y)));
        //El metodo reduce ACUMULA el mayor, mientas que X, Y representan el valor actual (acumalado) y el siguiente en el flujo (lista) respectivamente
        //Posteriormente se compara el elemento actual con el siguiente en la lista
        
        
        //Sumar todos numeradores y obtener los siguientes datos:
        //número de elementos,
        //la suma de los numeradores,
        //el numerador menor,
        //el mayor y el promedio
        System.out.println("\n\t\tLiteral 4");
        IntSummaryStatistics stats = rationals.stream().mapToInt(Rational::getNumerator).summaryStatistics();
        //Se hace uso de la clase IntSum que no es mas que un objeto de estado para recopilar estadísticas como: conteo, mínimo, máximo, suma y promedio
        //por ello al final de la sentencia se llama al metodo summaryStatistics el cual regresa un objeto de la clase mencionada
        System.out.println("Suma de los NUMERADORES:\t"+stats.getSum());
        //Gracias a la clase implementada se obtiene la suma
        System.out.println("Numero de elementos:\t\t"+stats.getCount());
        //Conteo de elementos sobre los que se opera
        //System.out.println("Numero de elementos:\t"+ rationals.stream().count());
        //Ya que el tamaño de no sufre cambios se puede consultar sobre la misma lista (rationals) y la funcion COUNT
        System.out.println("Menor de los NUMERADORES:\t"+stats.getMin());
        //El elemento menor
        //System.out.println("Numerador menor:\t"+rationals.stream().min((a, b) -> a.getNumerator() - b.getNumerator()));
        //Para el caso del menor ocurre algo similar a lo explicado con la funcion COUNT, se puede usar MIN pero la funcion retorna el RACIONAL que la lista es de dicho tipo
        System.out.println("Mayor de los NUMERADORES:\t"+stats.getMax());
        //El elemento mayor
        //System.out.println("Mayor de los numeradores:\t"+rationals.stream().max((a, b) -> a.getNumerator() - b.getNumerator()));
        //Para el caso del mayor ocurre algo similar a lo explicado con la funcion MIN, pero como se menciono se debe tener prseente que retorna el RACIONAL ya que la lista es de dicho tipo
        System.out.println("Promedio de los NUMERADORES:\t" + stats.getAverage());
        //Promedio de elementos sobre los que se trabaja
    }
    
}
