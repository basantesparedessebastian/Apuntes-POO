# Interfaces

Una interface es un contrato que obliga a una clase a implementar ciertos métodos.
Es como una lista de reglas que una clase debe cumplir obligatoriamente.
Miremoslo como un man que obliga si o si a hacer las cosas a una clase.

En Java, una Interfaz (Interface) es exactamente eso: un contrato o un enchufe.

Es una declaración de "QUÉ" debe hacer algo, pero no explica "CÓMO" lo debe hacer.
Define un conjunto de métodos vacíos (sin lógica) que una clase está obligada a implementar (rellenar) si decide "conectarse" a esa interfaz.

En resumen: Una interfaz es un molde de comportamientos. Si una clase firma ese contrato (usa la interfaz), está jurando que va a tener esos métodos funcionando.

## Como implementar una interface

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

### Reglas de Oro de las Interfaces (Lo que debes recordar)

* No se pueden instanciar: No puedes hacer new SonidoAnimal(). Una interfaz no es un objeto real, es solo un molde.
* Todos sus métodos son públicos y abstractos (por defecto, en versiones antiguas de Java). No tienen cuerpo.
* No tienen atributos de instancia: No puedes declarar variables normales como int edad;. Solo puedes declarar constantes (static final int EDAD = 5;).
* Una clase puede implementar muchas interfaces, separadas por coma: class Clase implements A, B, C.

## Constructor

sirve para contruir objetos, **sirve para inicializar variable y solo se ejeucta una vez**
Siempre es publico,lleva el mismo nombre de la clase
no debe haber ninguna clase sin constructor
No se puedn heredar los constructores a menos que sean con la palabra Super para llamar al constructor del padre.
hay tres tipos de constructores

1. sin parametros
2. con varios parametros
3. con un solo parametro

## Abstract que es

En Java, abstract es una palabra reservada que se usa para crear clases abstractas y métodos abstractos.
Una clase abstracta es una clase que no puede ser instanciada directamente.

## Entoooonces Pilasssss

* Usa una **Clase Abstracta** cuando quieras compartir código y atributos entre clases que son de la misma familia (Ej: Animal -> Perro, Gato).

* Usa una **Interfaz** cuando quieras definir un rol o habilidad que puede ser compartida por clases totalmente distintas (Ej: Volador -> Avion, Pajaro, Superman).
  