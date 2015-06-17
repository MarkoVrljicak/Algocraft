## 17/6

* Imagenes pertenecen al paquete de la vista, no del controlador
* _algocraft_ es el nombre de la aplicación completa, debería ser o el paquete raíz o renombrar el paquete actual a _modelo_ o similar
* Por qué son necesarios los métodos `setearXXXX` en `Unidad`? Es para evitar pasarlos por parámetro al constructor? De ser así porque no se invoca al método `inicializar()` en el constructor de la case base en vez de hacerlo desde cada unidad? (**A nadie le hizo ruido tener que poner el mismo pedazo de código duplicado en todos los construcores?**)
* Usar `for` para iterar sobre los terrenos en `AltoTemplario.alucinacion()`
* Faltan validaciones (ej: al invocar ataques especiales, `AltoTemplario.alucinacion()` debería arrojar una excepción si no tiene suficiente magia, si la unidad a clonar no es del mismo jugador, etc.)
* Es necesaria la jerarquía de clases e interfases tan compleja para las unidades?
* La convención en Java es usar ciclos `for` para recorrer iteradores en vez de `while(iterator.hasNext())` (ej: `UnidadMagica.iniciarTurno()`)
* Usar constantes en vez de _números mágicos_ para los factories de edificios
* Dependencias deberían setearse al construir los objetos (ej: `Raza` tiene como dependencia al `duenio` pero este no se setea por parámetro en el constructor sino que se inicializa a través de un setter)
* Al usarse excepciones como mecanismo de comunicación en vez de chequear si un jugador tiene los recursos necesarios para crear una construcción en `Raza.crearConstruccion()`, se puede dar el caso que si tiene suficiente mineral pero **no tiene** suficiente gas, se decrementa el mineral aunque no se haya construido el edificio. No debería ser necesario el bloque `try / catch` si ya se hace la verificación más arriba.

## 10/6

* Modelo
  * Ataques especiales no implementados
* Encapsulamiento / polimorfismo
  * Mantuvieron la implementación de una clase por cada edificio / unidad. Cuál es la justificación de esta decisión?
  * _IFs_ en `Terran.crearConstruccion()`!
  * Por qué se inicializa el atributo `Raza.duenio` con un `JugadorNulo` en vez de ser un parámetro del constructor? Puede existir un objeto `Raza` que no tenga un `Jugador` asociado?
  * No romper encapsulamiento al exponer los recursos del `Jugador` (`Jugador.getRecursos()`)
  * Evitar usar directamente atributos protegidos. ej: En vez de usar directamente `construccionesCreables` en `Terran` y `Protoss`, declarar métodos para acceder a esa colección (**no** un setter sino un método para agregar construcciones posibles)
  * Idem objetos `CreadorDeUnidades` con atributo `unidadesCreables`
  * Responsabilidades mal asignadas (**ejemplos**, seguramente hay otros casos!)
    * `Raza` tiene responsabilidad de saber el costo de construir cada tipo de edificio
    * Los objetos `CreadorDeUnidades` tienen responsabilidad de saber el costo de construir cada tipo de unidad y la cantidad de población requerida
    * `Jugador` tiene responsabilidad de calcular la población máxima preguntando por los tipos específicos de los edificios (`Jugador.getPoblacionMaxima()`)
    * `Mapa` responsable de validar si unidad puede moverse de una posición a otra (`Mapa.moverUnidad()`)
  * `Raza` conoce quien es su dueño, pero no lo setea al construir un nuevo edificio (ej: `Jugador.construir()`)
  * Casteo de `Unidad` a `Daniable` no debería ser necesario (ej: `Jugador.limpiarMuertos()`)
  * Idem para `Movible` a `Actualizable` (ej: `Mapa.moverUnidad()`)
  * No duplicar código con clases base (ej: en `EdificioConEscudo.iniciarTurno()` se debería usar `super.iniciarTurno()` en vez de llamar a `disminuirTiempoDeConstruccion()` directamente).
* Pruebas
  * Usar constantes de clases del modelo en las pruebas en vez de números mágicos (ej: `IntegracionesJugadorTest.testLlevoPoblacionMaximaAlTopeYVerifico()`)
  * Faltan pruebas de integración para la construcción de unidades
* Excepciones
  * Solo hay **5** (por la cantidad de excepciones propias declaradas) validaciones en todo el juego?
  * Si intentar construir un edificio / unidad sin los recursos o dependencias necesarios es un caso excepcional, entonces se debería arrojar una excepción en vez de devolver `null`
  * Idem para otras situaciones excepcionales (ej: intentar subir más unidades de las permitidas a un transporte, intentar usar un ataque especial sin energía suficiente, etc.)
  * No capturar excepciones sin procesarlas (ej: `Raza.crearConstruccionEspecifico()`)
  * Pruebas de unidad de transporte no demuestran que al bajar la unidad esta cambia de posición en el mapa
* Código
  * Paquetes siguen desorganizados (habían dicho que iban a mover todo a `algocraft`)
  * Enumerado `EnumEdificiosTerran` con métodos???
  * Idem: implementa interfaz `Unidades`
  * Uso de enum a través de constantes (ej: `Terran.nombreBarraca`)
  * Usar accesores a métodos correctamente (ej: `almacenarEnSuelo` y `almacenarEnCielo` de `Mapa` son públicos)
  * Usar constantes en vez de números mágicos (ej: `Jugador.getPoblacionMaxima()`)
  * Nombres de atributos deben ser explícitos (ej: `Unidad.stat` representa la vitalidad de la unidad)
