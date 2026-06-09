# POO

## Que es un objeto?

Un objeto es algo, un entidad del mundo real dentro de un programa que posee:

### ATRIBUTOS

Son caracteristicas o datos del objeto describen al objeto

Ejm:

objeto Persona

|Ambito   |Tipo de dato   |Dato   |Valor|
|---------|---------------|-------|-----|
|public   |double         |peso   |60   |

### METODOS

Definen lo que el objeto puede hacer, son acciones o comportamientos del objeto

----------------------------------------------------------------------------------------------

## UML

Los diagramas de UML son un diagrama universal en el cual permiten visualizar cómo están organizadas las clases, los objetos y las interacciones dentro de un sistema antes de programarlo
Hay varios tipos de diagramas como:

1. Class
2. Use case
3. State machine
4. Sequence
5. Objects
6. Activities

### QUE ES UML:Use Case?

Describe qué puede hacer el usuario en el sistema.DEscribe ademas un proceso de negocio,y para saber como interactua el sistema
Sirve para identificar funcionalidades.
Generalmente se desarrollan en la estapa inicial de desarrrolllo y las personas a menudo aplican el modelado de casos de uso para los siguientes propositos:

* Especificar el contexto de un sistema
* Capturar los requisitos de un sistema
* Validar una arquitectura de sistemas
* Impulsar la implementacion y generar casos de prueba desarrollado por analistas junto con expertos en el dominio

En estos diagramas hay cuatro partes fundamentales

1. **Actor**
   Un actor representa una persona, sistema o entidad que interactúa con el sistema.
   Se dibuja como un **muñeco**.

2. **Caso de Uso**
   Representa una funcionalidad. Siempre hay que describirlo (con un verbo si es posible) rigurosamente en las elipses siempre preguntando "Para que" para posteriormente podamos hacer el diagrama de clase de forma mas adecuada.
   //En pocas siempre pon full contexto
   Se dibuja como una **elipse**.

3. **Limite del sistema**
   Es un rectángulo que contiene todos los casos de uso.Tambien llamdo dominio. Se representa con un rectangulo abarcando todo el diagrama, todo lo que esta dentro del rectangulo pertenece al sistema.

4. **Relacion de Asociacion**
   Une un actor con un caso de uso.
   principalemente tienen estas formas las lineas de asociaicon:
   _____________>      //flecha normal
   <------------       siempre con la palabra < include >  //esta elige Y tambien esta de aca
   ------------->      siempre con la palabra < extense >  //si quieres la elige o si quiere elige otra
   
//mas especificaciones en las hojas de apuntes


