# Herencia e Interfaces

a traves del diagrama de clase se puede llegar a comprender que es la Herencia y una interfaz

## Herencia

La herencia permite que una clase adquiera los atributos y métodos de otra clase.

Se utiliza cuando existe una relación "es un".

Por ejemplo:

Un Estudiante es una Persona.
Un Profesor es una Persona.
Un Perro es un Animal.

Ejemplo de codigo
**Clase padre**

```java
public class Persona {

    String nombre;
    int edad;

    public void saludar() {
        System.out.println("Hola");
    }
}

```

**Clase Hija astetic**

```java

public class Estudiante extends Persona {
      String carrera;

      public void estudiar() {
        System.out.println("Estudiando");
    }
}

```
aqui damos a entender un ejemplo claro de lo que es herencia y como usarla correctamente, sirve principalmente para reutilizar codigo y no escribirlo de nuevo
