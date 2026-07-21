# GUI (Interfaz grafica de Usuario)

En java no es taaan buena la interfaz grafica

Es un sistema que permite a los usuarios interactuar con dispositivos electrónicos (como computadoras, teléfonos inteligentes o tabletas) a través de elementos visuales, en lugar de tener que escribir comandos de texto.

Los componentes principales de una GUI suelen incluir:
Iconos: Pequeñas imágenes que representan archivos, carpetas, aplicaciones o funciones.
Ventanas: Áreas rectangulares en la pantalla que muestran el contenido de una aplicación o documento.
Menús: Listas desplegables o barras con opciones y comandos disponibles.
Botones: Elementos gráficos en los que se puede hacer clic (o tocar) para ejecutar una acción.
Puntero: Un indicador visual (como una flecha) que se mueve con el ratón, trackpad o dedo para seleccionar elementos.

Diferencia con la CLI:

Antes de la popularización de las GUI, los usuarios interactuaban con las computadoras principalmente a través de una CLI (Command Line Interface o Interfaz de Línea de Comandos), donde era necesario memorizar y escribir comandos de texto exactos para realizar cualquier tarea. La GUI revolucionó la informática al hacerla mucho más intuitiva, visual y accesible para el público general.

## Componentes de una GUI

| Componente    | Clase          |
| ------------- | -------------- |
| Ventana       | JFrame         |
| Texto         | JLabel         |
| Botón         | JButton        |
| Caja de texto | JTextField     |
| Área grande   | JTextArea      |
| Contraseña    | JPasswordField |
| Lista         | JList          |
| Tabla         | JTable         |
| Panel         | JPanel         |
| Menú          | JMenuBar       |

## Elementos de una GUI (en java Swing)

## que es Renderizar??

Renderizar significa:
Dibujar en pantalla lo que existe en memoria.
O también:
Convertir datos en una imagen visible para el usuario.

## LAYAUTS

## ¿Qué son los Layouts y cómo se usan en una GUI?

En el contexto del diseño de Interfaces Gráficas de Usuario (GUI), desarrollo web y aplicaciones, un **Layout** (o **Diseño / Maquetación**) es la estructura fundamental que organiza y distribuye los elementos visuales (texto, imágenes, botones, menús) en una pantalla.

Piensa en el layout como los planos de una casa: define dónde van las paredes (contenedores), las puertas (navegación) y los muebles (contenido) para que la "casa" sea funcional, cómoda y estética.

---

## ¿Cómo se usan los Layouts?

El uso de los layouts se divide en dos fases principales: **Diseño** y **Programación**.

### 1. En la fase de Diseño (UX/UI)

Los diseñadores usan los layouts para guiar el ojo del usuario y establecer una jerarquía visual. Se utilizan basándose en principios clave:

* **Retículas (Grids):** Se usa una cuadrícula invisible para alinear elementos y mantener la consistencia.
* **Espaciado (Whitespace):** Se deja "aire" entre elementos para que la interfaz no se sienta abrumadora.
* **Responsividad (Responsive Design):** Se diseñan layouts que se adaptan. Por ejemplo, un layout de 3 columnas en una PC puede convertirse en un layout de 1 columna en un teléfono móvil.

### 2. En la fase de Programación (Desarrollo GUI)

Los desarrolladores traducen esos diseños a código utilizando **Gestores de Layout** (Layout Managers). En lugar de decir "pon este botón en el píxel X=50, Y=100" (lo cual es rígido), el programador usa reglas lógicas:

* *Ejemplo:* "Pon este botón *debajo* del texto y *al lado* de la imagen".
* El motor de la GUI calcula automáticamente las posiciones y tamaños según el tamaño de la ventana.

---

## Ejemplos de la vida real

1. **Layout de una App Bancaria (Móvil):**
    * *Arriba:* Barra superior con el saldo y foto de perfil.
    * *Centro:* Lista desplazable (scroll) con tarjetas de movimientos bancarios.
    * *Abajo:* Barra de navegación fija con 4 iconos (Inicio, Transferir, Tarjetas, Perfil).
  
2. **Layout de un Editor de Código como VS Code (Escritorio):**
    * *Izquierda:* Panel estrecho con el explorador de archivos.
    * *Centro:* Área principal grande para escribir código.
    * *Derecha:* Panel opcional para extensiones o terminal.
    * *Arriba:* Menú de pestañas y barra de herramientas.

---

## Tabla Completa y Detallada de Tipos de Layout

A continuación, se presenta una tabla que abarca tanto los **Patrones de Diseño Visual** (cómo se ve y se organiza la información) como los **Gestores de Layout Técnicos** (cómo se programan en frameworks de GUI y CSS).

| Nombre del Layout | Categoría | Descripción Detallada | Casos de Uso Ideales | Ejemplo Práctico |
| :--- | :--- | :--- | :--- | :--- |
| **Single Column** (Una sola columna) | Patrón Visual / Web | Todos los elementos se apilan verticalmente en una sola columna central. Es el estándar "Mobile-First". | Lectura continua, blogs, landing pages móviles, artículos. | La vista de un artículo en el móvil de *The New York Times* o un feed de Twitter/X. |
| **Multi-Column / Split** (Múltiples columnas) | Patrón Visual / Web | La pantalla se divide en 2 o más columnas verticales. Puede ser simétrico o asimétrico. | Dashboards, comparaciones de productos, documentos con notas al margen. | Un dashboard de analíticas con gráficos a la izquierda y tablas de datos a la derecha. |
| **Grid Layout** (Cuadrícula) | Patrón Visual / Web / CSS | Organiza el contenido en filas y columnas estrictas (como una tabla, pero flexible). | Galerías de imágenes, catálogos de e-commerce, iconos de apps en el móvil. | La pantalla de inicio de iOS (iconos en cuadrícula) o el catálogo de productos de Amazon. |
| **Holy Grail** (El Santo Grial) | Patrón Visual / Web Clásico | Layout clásico de 3 columnas con encabezado (header) y pie de página (footer). La columna central es el contenido, las laterales son navegación/ads. | Sitios web corporativos, portales de noticias, foros antiguos. | La estructura clásica de Wikipedia o portales de noticias con menús laterales. |
| **Card / Masonry** (Tarjetas / Mampostería) | Patrón Visual / Web | El contenido se agrupa en "tarjetas" (rectángulos con sombra/borde). En *Masonry*, las tarjetas tienen alturas variables y se encajan como un puzzle. | Redes sociales, portfolios, Pinterest, feeds de noticias modernas. | El feed de LinkedIn, los "Pines" en Pinterest, o las tarjetas de Netflix. |
| **F-Pattern / Z-Pattern** | Patrón Visual / UX | Basado en cómo escanea el ojo humano. **F-pattern** para mucho texto (escaneo horizontal arriba, vertical abajo). **Z-pattern** para poco texto (diagonal). | Landing pages, páginas de captura de leads, formularios de login. | Una página de inicio de sesión (Logo arriba izq -> Botón login arriba der -> Formulario en medio -> Botón abajo). |
| **Linear / Box Layout** (Lineal) | Gestor Técnico (GUI) | Los elementos se colocan en una sola línea, ya sea horizontalmente (Row) o verticalmente (Column). Muy común en Java, Qt, Android. | Formularios simples, barras de herramientas, listas básicas. | Un formulario de "Nombre" y "Apellido" uno debajo del otro (Linear Vertical). |
| **Stack / Flex Layout** (Pila / Flexbox) | Gestor Técnico (CSS / Flutter) | Apila elementos y permite que se expandan, contraigan o se alineen dinámicamente según el espacio disponible. | Interfaces responsivas, menús de navegación, alineación compleja de ítems. | Una barra de búsqueda donde el input se expande para llenar el espacio y el botón se queda a la derecha (Flexbox). |
| **Constraint Layout** (Restricciones) | Gestor Técnico (Android / iOS) | Los elementos se posicionan basándose en "restricciones" o relaciones con otros elementos o con los bordes de la pantalla (ej. "el botón B está a 10px del botón A"). | Interfaces móviles complejas, apps nativas de Android (ConstraintLayout) o iOS (AutoLayout). | Un reproductor de música donde los botones de Play/Pausa siempre están centrados respecto a la pantalla, sin importar el tamaño del móvil. |
| **Border / Dock Layout** (Borde / Anclaje) | Gestor Técnico (GUI Escritorio) | Divide el contenedor en 5 regiones: Norte (Arriba), Sur (Abajo), Este (Derecha), Oeste (Izquierda) y Centro. El centro siempre se expande. | Aplicaciones de escritorio complejas, IDEs, editores de video/foto. | Adobe Photoshop o VS Code: Menú arriba (Norte), Panel de capas a la derecha (Este), Editor en el medio (Centro). |
| **Relative Layout** (Relativo) | Gestor Técnico (GUI) | Los elementos se posicionan en relación con el contenedor padre o en relación con otros elementos hermanos (ej. "debajo de", "a la derecha de"). | Interfaces donde la posición absoluta no importa, pero la relación entre elementos sí. | Un chat de WhatsApp donde la burbuja del mensaje se ajusta al tamaño del texto y el "visto" se pega a la esquina inferior derecha de la burbuja. |
| **Frame / Absolute Layout** (Marco / Absoluto) | Gestor Técnico (GUI) | Los elementos se colocan en coordenadas exactas (X, Y) con tamaños fijos. No se adaptan automáticamente. | Juegos 2D, interfaces muy específicas con diseño fijo, pop-ups pequeños. | Un menú de videojuego retro donde los botones están "pintados" en coordenadas exactas de la pantalla. |

---

## Resumen para elegir un Layout

Si estás diseñando (UX/UI), piensa en patrones visuales (Grid, Card, F-Pattern) para asegurar que la información sea fácil de consumir.

Si estás programando una GUI, piensa en gestores técnicos (Flexbox, Constraint, Border) para asegurar que tu interfaz no se "rompa" cuando el usuario cambie el tamaño de la ventana o use un dispositivo diferente.

### Sin layout (Posicionamiento Absoluto / Null Layout)

Consiste en darle coordenadas exactas (X, Y) y tamaños fijos (Ancho, Alto) a cada elemento. Es como pegar componentes en un papel con cinta adhesiva.

**Cómo se ve:** boton.setBounds(50, 100, 80, 30);
El gran problema: Es extremadamente rígido. Si el usuario hace la ventana más pequeña, los botones de la derecha desaparecerán de la vista. Si la hace más grande, quedarán enormes espacios vacíos. Además, si ejecutas el programa en un sistema operativo distinto (Windows vs Mac) o con una resolución de pantalla diferente, las fuentes se renderizan un poco más grandes o pequeñas, y los textos se cortarán o se montarán unos sobre otros.

**Cuándo usarlo:** Prácticamente nunca en aplicaciones profesionales. Solo se justifica en pequeños prototipos rápidos, editores visuales muy específicos (como un editor de fotos) o juegos, donde la posición fija es intencional.

### Con layout (Posicionamiento Relativo / Gestores de Diseño)

Consiste en delegarle la matemática de las posiciones a un administrador. Tú solo defines las "reglas" (ej. "este botón va arriba", "estos van en fila", "este ocupa todo el espacio libre") y el layout calcula los píxeles por ti. Es como tener un organizador inteligente que reacomoda los muebles si la habitación cambia de tamaño.

**Cómo se ve:** panel.add(boton, BorderLayout.NORTH);
La gran ventaja: Es "Responsivo" (Responsive). Si el usuario agranda la ventana, los elementos se estiran o reacomordan automáticamente para llenar el nuevo espacio de forma estética. Si la achica, los elementos se comprimen o pasan a una siguiente línea (como en FlowLayout) sin desaparecer. Garantiza que tu aplicación se vea bien en monitores 4K, en pantallas pequeñas o en diferentes sistemas operativos.

**Cuándo usarlo:** Siempre. Es el estándar de la industria para crear interfaces gráficas robustas, accesibles y mantenibles.

### Que es un borderlayout??

Es el diseño por defecto de los JFrame en Java. Divide la ventana en 5 regiones: NORTH (arriba), SOUTH (abajo), EAST (derecha), WEST (izquierda) y CENTER (centro).

Detalle clave: Si pones un botón en el Norte, tomará todo el ancho de la ventana pero solo la altura necesaria. El Centro es el más hambriento: tomará todo el espacio que dejen libre los otros cuatro.

### Que es un floowlayout ??

Es el diseño más sencillo. Coloca los componentes uno detrás de otro, como las palabras en un párrafo.

Detalle clave: Por defecto, los centra. Si redimensionas (achicas) la ventana, los elementos que no quepan "saltarán" a la siguiente línea automáticamente. Ideal para barras de botones.

### quee es gridlayout ??

Fuerza a que todos los componentes tengan exactamente el mismo tamaño. Le dices "quiero 3 filas y 2 columnas" y te hará una cuadrícula perfecta.

Detalle clave: Si agregas 7 botones a una cuadrícula de 3x2 (6 espacios), el GridLayout automáticamente creará una nueva fila para acomodar el séptimo botón, reajustando todo.

### Que es Boxlayout

Permite apilar elementos ya sea verticalmente (eje Y) u horizontalmente (eje X), pero a diferencia del GridLayout, no fuerza a que tengan el mismo tamaño.

Detalle clave: Es muy útil para hacer formularios verticales (Etiqueta, abajo el campo de texto, abajo otro botón) respetando el tamaño natural de cada elemento.

// hacerme una tabla asteetic hasta con ejemplo

## Relación entre GUI, Layout y Renderizado

Para entender cómo se dibuja una aplicación, imagina una obra de teatro:

GUI (Interfaz Gráfica de Usuario): Son los actores y el guion. Los botones, ventanas, campos de texto. Es lo que el usuario ve y con lo que interactúa.
Layout (Diseño): Es la dirección de escena. Le dice al botón dónde pararse y qué espacio ocupar en el escenario.
Renderizado (Rendering): Es la iluminación y el telón. Es el proceso físico (hecho por la tarjeta gráfica y el sistema operativo) de dibujar los píxeles en la pantalla basándose en las posiciones que dictó el Layout para la GUI.
El flujo es: Tú creas la GUI -> El Layout calcula las coordenadas (X, Y, Ancho, Alto) -> El motor de Renderizado dibuja esos píxeles en tu monitor.

## Que es Splash ??

Un Splash Screen (Pantalla de Bienvenida) es la primera imagen que ves al abrir un programa pesado (como Photoshop o un videojuego).

¿Para qué sirve? Mientras el programa carga cosas pesadas en memoria en segundo plano (conectar a bases de datos, cargar librerías), muestra una imagen atractiva para que el usuario no piense que el programa se ha freezeado o roto. Da una sensación de "carga profesional".

## que es un DTO ??

Es una caja de cartón. Un DTO es una clase simple (solo con atributos, getters y setters) que sirve únicamente para transportar datos de un lado a otro.

Ejemplo: Un UsuarioDTO que contiene nombre, correo y edad. No tiene lógica, solo guarda datos para moverlos entre la base de datos y la interfaz.

### que es un datafile y como se relaciona con los DTO??

Un DataFile (Archivo de datos) es el origen físico de la información (un .txt, .csv, .json o la base de datos misma).

Relación: Cuando el DAC lee un DataFile (por ejemplo, un archivo JSON), toma esos datos sueltos y los "empaqueta" en un DTO para que el resto del programa pueda manipularlos fácilmente como objetos de Java.

## que es BL (Business logic) ???

Es el cerebro de la operación. Aquí van las reglas de negocio.

Ejemplo: Si el usuario quiere retirar dinero, el BL verifica que no se exceda del límite diario y que tenga saldo. Si todo cumple las reglas, el BL le ordena al DAC que guarde el cambio en la base de datos.

## Que es un DAC (Data Access Component ) ??

Es el almacenero. Es la capa encargada de hablar con la base de datos (o archivos).

Su único trabajo es ejecutar consultas SQL (SELECT, INSERT) y devolver los resultados empaquetados en DTOs. La interfaz gráfica nunca debe hablar con la base de datos directamente, siempre pasa por el DAC.

## como se relacionan entre si

Imagina que pides una pizza en una app:

GUI: Presionas el botón "Comprar". Le avisa al BL.
BL (Lógica): Verifica si tienes saldo en tu tarjeta. Si sí, le pide al DAC que guarde la orden.
DAC (Datos): Toma la orden, la convierte en texto y la escribe en un DataFile (Base de datos). Luego lee esa orden del DataFile, la mete en un DTO y la devuelve.
GUI: Recibe el DTO y muestra "¡Pedido en camino!".

## que es cutomarizacion?

Es la capacidad de modificar la apariencia o el comportamiento estándar de un componente. En lugar de usar un botón gris aburrido de Windows, lo "customizas" cambiándole el color, poniéndole bordes redondeados o cambiando la fuente. Es hacer que el programa se vea único y alineado con la identidad de una marca.

### imagenes absolutas y relativas

Cuando cargas una imagen en tu programa, le debes decir dónde está el archivo. Hay dos formas:

Ruta Absoluta: Le dices la dirección completa desde la raíz de tu computadora.
Ejemplo: C:/Usuarios/Juan/Proyecto/imagenes/logo.png
Problema: Si pasas el proyecto a otra computadora, ¡la ruta no existirá y el programa fallará!
Ruta Relativa: Le dices la dirección basándose en dónde está tu programa actualmente.
Ejemplo: ./imagenes/logo.png
Ventaja: Significa "busca la carpeta imágenes que está al lado de mí". Funciona en cualquier computadora. Siempre se deben usar rutas relativas.

### que es un distribuidor de espacios

Es otra forma de llamar a los Layout Managers (vistos en el punto 1). Se le llama "distribuidor de espacios" porque su tarea matemática es tomar el rectángulo total de tu ventana y fraccionarlo (distribuirlo) en pequeños rectángulos para asignárselos a cada botón, etiqueta o cuadro de texto, decidiendo cuánto espacio en píxeles le toca a cada uno.

### que estudiar

// todo de interfaces y java para el examen
*Leyes de Gestalt: Cómo el cerebro humano agrupa las cosas por color, forma o cercanía.
*Jerarquía Visual: Cómo guiar el ojo del usuario para que mire donde tú quieres (lo más importante debe ser lo más grande/llamativo).
*Accesibilidad: Diseñar para todos (ej. personas daltónicas o con problemas de visión).
pilas con  **Figma**
