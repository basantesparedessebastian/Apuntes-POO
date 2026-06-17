# Interfaces

Una interface es un contrato que obliga a una clase a implementar ciertos métodos.
Es como una lista de reglas que una clase debe cumplir obligatoriamente.
Miremoslo como un man que obliga si o si a hacer las cosas a una clase.

### Como implementar una interface 

Interface

```java
public interface Volador {
    void volar();
}
```

clase que va a implementar esta interface

```java
public class Avion implements Volador {

    @Override
    public void volar() {
        System.out.println("El avión está volando");
    }
}
```
yo puedo instanciar una clase
no puedo instanciar un a interface NO SIRVN PARA INSTANCIAR solo sirve para dar ordenes

## Controuctor

sirve para contruir objetos sirve para inicializar varaible y solo se ejeucta una vez
Siempre es publico,lleva el mismo nombre de la clase 
no debe haber ninguna clase sin constructor

## Abstrat que es 

En Java, abstract es una palabra reservada que se usa para crear clases abstractas y métodos abstractos.
Una clase abstracta es una clase que no puede ser instanciada directamente.
