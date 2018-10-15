# Introducción a la POO y programación funcional

El taller tiene como objetivo revisar la clase Rational que representa a un número racional (o fraccionario).

### Requisitos:

+ Java 11 (Se utilizan algunas funciones que son específicas de esa versión)

### Actividades

+ Crear una lista de números racionales, así:

```java
var rationals = List.of(
        new Rational(1, 4),
        new Rational(1, 8),
        new Rational(3, 4),
        new Rational(7, 8));
```
No olvide agregar la sentencia `import java.util.List`

+ Obtener todos los números racionales que sean menores a 1/2
+ Sumar todos los racionales
+ Obtener el número racional mayor
+ Sumar todos numeradores y obtener los siguientes datos: número de elementos, la suma de los numeradores, el numerador menor, el mayor y el promedio

