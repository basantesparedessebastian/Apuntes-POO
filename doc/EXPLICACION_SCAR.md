# SCAR — Del frontend al backend, y el pintado en tiempo real

Explicación completa de los dos flujos clave del sistema, incluyendo los
**imports** que necesita cada archivo y el **porqué de cada estructura de
control** (`if`, `while`, `for`, `try`...).

---

# PARTE 1 — El viaje de un dato: "nombre" desde la interfaz hasta SQL Server

```
[Teclado] → VISTA → CONTROLADOR → MODELO → DAO → CONEXIÓN → [SQL Server]
```

## Estación 1 — La Vista captura el dato
**Archivo:** `view/VentanaRegistro.java`

**Imports que necesita y para qué:**
```java
import javax.swing.*;                    // JTextField, JButton, JFrame... los componentes visuales
import java.awt.*;                       // Colores, fuentes, layouts (posicionamiento)
import controller.AuthController;        // Para entregarle los datos al controlador
```

| Línea | Qué hace |
|---|---|
| 35 | `private JTextField txtNombre;` — declara la caja de texto como atributo |
| 147, 154 | La crea y la coloca en el formulario con su etiqueta |
| 172 | `btnRegistrar.addActionListener(e -> registrar());` — el clic dispara el viaje |
| 276-279 | `registrar()` extrae el texto con `txtNombre.getText()` y lo pasa al controlador |

**¿Por qué un lambda (`e -> registrar()`)?** Es la forma corta de decir
"cuando ocurra el evento, ejecuta este método". Sin lambda habría que
escribir una clase anónima de 5 líneas para lo mismo.

## Estación 2 — El Controlador valida y decide
**Archivo:** `controller/AuthController.java` (método `registrar`, líneas 41-76)

**Imports que necesita:**
```java
import java.sql.SQLException;    // La excepción que puede lanzar la capa de datos
import dao.EmpleadoDAO;          // Para insertar el empleado
import dao.UsuarioDAO;           // Para crear su cuenta de usuario
import dao.RolDAO;               // Para resolver el id del rol "Usuario"
import dao.AreaTrabajoDAO;       // Para resolver el id del área elegida
import model.Empleado;           // El "paquete" que transporta los datos
import model.Usuario;            // El paquete de la cuenta de login
```

| Línea | Qué hace |
|---|---|
| 44-47 | `if (esVacio(nombre) ...)` — rechaza campos vacíos ANTES de tocar la BD |
| 48-53 | `if` de duplicados: ¿ya existe ese usuario? ¿esa cédula? |
| 63-65 | `empleado.setNombre(nombre.trim())` — empaqueta el dato limpio |
| 68 | `empleadoDAO.insertar(empleado)` — entrega a la capa de datos |

**¿Por qué tantos `if` aquí?** Cada `if` es un **guardián**: valida una
regla de negocio y corta el flujo con una excepción si no se cumple. El
orden importa: primero lo barato (campos vacíos, sin tocar la BD), después
lo costoso (consultas de duplicados). Así la BD nunca recibe basura.

## Estación 3 — El Modelo es el paquete
**Archivo:** `model/Empleado.java` — sin imports especiales: solo atributos,
getters y setters. Transporta los datos con nombres claros entre capas.
Sin él, `registrar()` recibiría 6 Strings sueltos fáciles de confundir.

## Estación 4 — El DAO traduce a SQL
**Archivo:** `dao/EmpleadoDAO.java` (método `insertar`, líneas 15-32)

**Imports que necesita:**
```java
import java.sql.Connection;         // El "cable" abierto hacia SQL Server
import java.sql.PreparedStatement;  // La consulta SQL con huecos (?) seguros
import java.sql.ResultSet;          // El resultado que devuelve la BD
import java.sql.SQLException;       // Errores de BD
import java.sql.Statement;          // Constante RETURN_GENERATED_KEYS (pedir el id creado)
import config.Conexion;             // La fábrica de conexiones
import model.Empleado;              // El paquete que llega con los datos
```

| Línea | Qué hace |
|---|---|
| 16-17 | La plantilla: `INSERT INTO Empleado (...) VALUES (?, ?, ...)` |
| 21 | `ps.setString(2, empleado.getNombre())` — el nombre se amarra al 2.º `?` |
| 24 | `ps.executeUpdate()` — el INSERT viaja a SQL Server |
| 25-28 | Recupera el `id_empleado` autogenerado |

**¿Por qué `?` y no concatenar el texto?** Si concatenaras
(`"...VALUES ('" + nombre + "')"`), un usuario malicioso podría escribir
SQL dentro del campo (inyección SQL). El `PreparedStatement` escapa el
valor y lo hace imposible.

**¿Por qué `try (...)` con paréntesis (try-with-resources)?** La conexión
y el statement son recursos que HAY que cerrar. Esta forma de `try` los
cierra automáticamente al salir, incluso si hubo error — sin él, cada
error dejaría una conexión abierta hasta agotar el servidor.

**¿Por qué el `if (rs.next())` de la línea 26?** `ResultSet` es un cursor
que empieza ANTES de la primera fila; `next()` avanza y devuelve `false`
si no hay nada. El `if` protege de leer un resultado vacío.

## Estación 5 — La Conexión es el cable
**Archivo:** `config/Conexion.java` (líneas 9-17)

**Imports:**
```java
import java.sql.Connection;     // Lo que devuelve: el cable abierto
import java.sql.DriverManager;  // El que sabe abrir cables JDBC
import java.sql.SQLException;   // Si el servidor no responde
```
La URL dice servidor (`Localhost\SQLEXPRESS`), base (`BD_SCAR`) y
autenticación (la de Windows). Todos los DAO piden su conexión aquí:
un solo lugar que cambiar si la BD se muda de servidor.

## Receta para replicarlo (agregar un campo, ej. "teléfono")
1. **BD:** `ALTER TABLE Empleado ADD telefono VARCHAR(20);`
2. **Modelo:** atributo `telefono` + getter/setter en `Empleado.java`
3. **DAO:** columna y `?` extra en el INSERT + su `ps.setString(...)`
4. **Controlador:** parámetro nuevo en `registrar(...)` + `setTelefono(...)`
5. **Vista:** `JTextField` nuevo + pasarlo en la llamada al controlador

---

# PARTE 2 — Cómo se pinta la tarjeta de reconocimiento en tiempo real

```
Python (cámara) → consola → CamaraService → callback → BD → publish() → tarjeta
      proceso 2              hilo de fondo                        hilo de interfaz
```

## Paso 1 — Python confirma a la persona
**Archivo:** `Scar_python/src/reconocer_camara.py` (líneas 139-146)

**Imports que necesita y para qué:**
```python
import sys                          # sys.exit(1): terminar con código de error
import pickle                       # Leer la galería de embeddings del disco
import threading                    # (cuando está activo) cargar el modelo sin frenar el video
import cv2                          # Cámara, detección de caras, dibujo, ventana de video
import numpy as np                  # Vectores: los embeddings son arrays
from numpy.linalg import norm       # Normalizar el embedding (largo = 1)
from keras_facenet import FaceNet   # La red neuronal cara → vector de 512 números
import tensorflow as tf             # Apagar las barras de progreso de Keras
from scar_paths import MODELS, UTILS, preparar_entorno   # Rutas del proyecto
```

```python
racha = racha + 1 if nombre_frame == ultimo_nombre else 1   # 141
if racha >= FRAMES_SEGUIDOS and emitido != ultimo_nombre:   # 144
    print(f"RECONOCIDO:{emitido}", flush=True)              # 146
```

**¿Por qué el `while True` del bucle principal (línea 130)?** El video es
un flujo infinito: no se sabe cuántos frames vendrán. El bucle corre "para
siempre" y solo sale con `break` cuando el usuario presiona ESC o cierra
la ventana — la condición de salida está DENTRO, no en la cabecera.

**¿Por qué el contador `racha` con su `if`?** Un solo frame puede
equivocarse (giro de cara, luz). Exigir 10 frames seguidos iguales antes
de anunciar es un **filtro de estabilidad**: cambia "creo que es Andres"
por "confirmado que es Andres".

**¿Por qué `emitido != ultimo_nombre`?** Para anunciar UNA sola vez por
persona. Sin esa condición, imprimiría RECONOCIDO 30 veces por segundo.

**¿Por qué `flush=True`?** Python guarda lo impreso en un buffer y lo
envía "cuando se llene". `flush` lo envía inmediatamente — sin él, Java
recibiría los avisos tarde y no habría tiempo real.

**¿Por qué el `for (x, y, w, h) in faces` (línea 170)?** `detectMultiScale`
devuelve una lista de rectángulos (puede haber varias caras en el frame).
El `for` recorre cada una para dibujarle su recuadro y predecir quién es.

**¿Por qué `try/finally` (líneas 129, 161)?** Pase lo que pase (error,
ESC, cierre), el `finally` SIEMPRE libera la cámara y avisa `FIN`. Sin él,
un error dejaría la cámara "secuestrada" hasta reiniciar.

## Paso 2 — Java escucha la consola de Python
**Archivo:** `service/CamaraService.java` (líneas 78-82)

**Imports que necesita y para qué:**
```java
import java.io.BufferedReader;             // Leer la salida de Python línea por línea
import java.io.IOException;                // Si el proceso no se puede lanzar/leer
import java.io.InputStreamReader;          // Convertir bytes del proceso en texto
import java.nio.charset.StandardCharsets;  // Leer como UTF-8 (acentos correctos)
import java.util.function.Consumer;        // El callback que avisa a la vista
import config.RutasPython;                 // Dónde están python.exe y el script
import exceptions.CamaraException;         // Error propio del dominio "cámara"
import interfaces.ICamaraService;          // El contrato que esta clase cumple
```

```java
while ((linea = lector.readLine()) != null) {              // 78
    if (linea.startsWith("RECONOCIDO:")) {                 // 79
        oyente.accept(linea.substring("RECONOCIDO:".length())); // 80
    } else if (linea.equals("NADIE")) {                    // 81
        oyente.accept(null);                               // 82
```

**¿Por qué `while` con `readLine()` en la condición?** `readLine()` es
**bloqueante**: duerme hasta que Python imprime algo. Cuando Python
termina, devuelve `null` y el `while` acaba solo. Es un bucle que "vive"
exactamente lo mismo que el proceso de Python.

**¿Por qué la cadena de `if / else if`?** Es el **traductor del
protocolo**: cada línea recibida solo puede ser una cosa (RECONOCIDO,
NADIE, ERROR o ruido de TensorFlow). Los `else if` son excluyentes, y lo
que no coincide con nada simplemente se ignora — así los warnings de
TensorFlow no rompen nada.

## Paso 3 — El callback consulta la BD (hilo de fondo)
**Archivo:** `view/VentanaDeEscaneo.java` (líneas 241-246)

**Imports que necesita y para qué:**
```java
import controller.CamaraController;        // Iniciar reconocimiento y buscar en BD
import exceptions.CamaraException;         // El error que puede lanzar el servicio
import model.UsuarioDetalle;               // Los datos de la persona (BD)
import javax.swing.*;                      // JDialog, JLabel, SwingWorker...
import java.awt.*;                         // Colores, layouts, fuentes del tema oscuro
import java.text.SimpleDateFormat;         // Formato de la fecha de registro (BD)
import java.time.LocalTime;                // La hora del reconocimiento
import java.time.format.DateTimeFormatter; // Darle formato HH:mm:ss
import java.util.List;                     // La lista de eventos que recibe process()
```

```java
camaraController.iniciarReconocimiento(nombre -> {   // 241: el callback
    UsuarioDetalle datos = (nombre != null)
            ? camaraController.buscarPersona(nombre) // 244: SELECT en la BD
            : null;
    publish(new Reconocimiento(nombre, datos));      // 246: al buzón de Swing
});
```

**¿Por qué el operador ternario (`? :`)?** Es un `if/else` en una
expresión: si hay nombre, consulta la BD; si es `null` (no hay nadie), no
hay nada que buscar. Compacto y claro para decisiones de una línea.

**¿Por qué consultar la BD aquí y no en `process()`?** Porque este código
corre en el **hilo de fondo**. Si la BD tarda 2 segundos, la ventana no se
congela. Regla: lo lento, fuera del hilo de la interfaz.

## Pasos 4 y 5 — publish() / process(): el puente entre hilos
**Mismo archivo, líneas 238-259**

```java
new SwingWorker<Void, Reconocimiento>() {            // 238
    protected Void doInBackground() { ... }          // 240: hilo de fondo
    protected void process(List<Reconocimiento> eventos) {  // 252: hilo de interfaz
        Reconocimiento evento = eventos.get(eventos.size() - 1);
        String hora = LocalTime.now().format(...);   // 258
        mostrarDatosPersona(evento.nombre, evento.datos, hora);  // 259
```

**¿Por qué no puede el hilo de fondo hacer `setText()` directamente?**
Swing exige que SOLO su hilo de eventos (EDT) toque componentes visuales;
violar eso produce fallos aleatorios imposibles de depurar. `publish()`
deja el evento en un buzón seguro y Swing llama a `process()` en el hilo
correcto.

**¿Por qué `process` recibe una Lista y tomamos el último?** Si llegaron
varios eventos mientras la interfaz estaba ocupada, Swing los agrupa. Solo
interesa el estado ACTUAL, o sea el más reciente:
`eventos.get(eventos.size() - 1)`.

## Paso 6 — Pintar la tarjeta
**Mismo archivo, `mostrarDatosPersona()` (línea 183)**

Pone "Reconocido: [Nombre]" en verde y reparte los datos en los `JLabel`
del arreglo `valoresTarjeta[]` con `setText()`.

**¿Por qué el `if (datos != null)` dentro?** Es el plan B: si la persona
que reconoció el modelo NO está en la BD (o la BD está caída), la tarjeta
muestra "[Nombre] (sin registro)" en vez de reventar con un
`NullPointerException`. Programación defensiva.

**¿Por qué el `for` en `crearTarjetaPersona()` (línea 155) y en
`limpiarTarjeta()`?** Las 6 filas de la tarjeta son idénticas en
estructura (etiqueta + valor). El `for` las fabrica/limpia en 5 líneas en
vez de copiar y pegar 6 bloques iguales — menos código, menos errores.

---

# Resumen: cuándo se usa cada estructura (para el examen)

| Estructura | Cuándo se usa | Ejemplo en SCAR |
|---|---|---|
| `if` | Decidir o validar (guardián) | Campos vacíos, duplicados, umbral de similitud |
| `if / else if` | Clasificar entre opciones excluyentes | Traducir el protocolo RECONOCIDO/NADIE/ERROR |
| Ternario `? :` | if/else de una sola expresión | Buscar en BD solo si hay nombre |
| `while (cond)` | Repetir hasta que algo externo termine | Leer líneas de Python hasta que muera el proceso |
| `while True` + `break` | Flujo infinito con salida interna | El bucle de video (sale con ESC) |
| `for` sobre colección | Hacer lo mismo a cada elemento | Cada cara detectada, cada fila de la tarjeta, cada persona de la galería |
| `try / catch` | Reaccionar a errores esperables | SQLException al consultar la BD |
| `try-with-resources` | Cerrar recursos automáticamente | Conexiones y statements JDBC |
| `try / finally` | Limpieza garantizada pase lo que pase | Liberar la cámara e imprimir FIN |
| Lambda / callback | Entregar "qué hacer" como parámetro | El clic del botón; el oyente del reconocimiento |
