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
