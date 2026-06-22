# Polimorfismo

El polimorfismo es "varias formas" de hacer algo o varias formas de parametrizar un metodo  todos los metodos tienen el mismo nombre pero mas acatidad de parametros en cada metodo, a esto se llama **sobrecarga**
La palabra polimorfismo significa "muchas formas".

En Java, el polimorfismo permite que un mismo método o referencia se comporte de manera diferente dependiendo del objeto que lo utilice.

por ejemplo:
Supongamos que tenemos la clase padre
```java
class Animal {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}
```
y dos clases hijas:
```java
class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau Guau");
    }
}

class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau Miau");
    }
}
```
Entonces el programa principal es:

```java
public class Main {
    public static void main(String[] args) {

        Animal a1 = new Perro();
        Animal a2 = new Gato();

        a1.hacerSonido();
        a2.hacerSonido();
    }
}
```

Ojo siempre debe haber una **salida**

la salida en este caso es:
Guau Guau
Miau Miau

Observa que ambas variables son de tipo Animal, pero cada una ejecuta una versión diferente de hacerSonido().

Eso es polimorfismo.

## Sobrecarga

La sobrecarga ocurre cuando varios métodos tienen el mismo nombre pero diferentes parámetros.

## Tipos de Polimorfismo

1. Polimorfismo por herencia
    Cuando una clase hija redefine un método de la clase padre

2. Polimorfismo por interfaces
    Ambos implementan el mismo método, pero de manera diferente.

### Resumen

Polimorfismo: un mismo método puede comportarse de distintas formas según el objeto que lo ejecute.
Sobrescritura (Override): una clase hija redefine un método de la clase padre.
Sobrecarga (Overload): varios métodos tienen el mismo nombre pero diferentes parámetros.
La sobrecarga no necesita herencia.
La sobrescritura sí necesita herencia.
El polimorfismo se consigue principalmente mediante la sobrescritura. 