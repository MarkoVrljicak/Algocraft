## Carpeta

### Generalidades

###### ¿Son correctos los supuestos y extensiones?
**NO**
* Faltan supuestos (ej: las minas / volcanes se quedan sin recursos? se pueden atacar unidades / edificios del propio jugador? cuándo se termina el juego?)

###### ¿Es prolija la presentación? (hojas del mismo tamaño, numeradas y con tipografía uniforme)
**SI**
* Falta carátula

### Modelo

###### ¿Está completo? ¿Contempla la totalidad del problema?
**SI**
* No se muestran mensajes de información al no poder realizar acciones (ej: intentar mover una unidad sin tener suficientes movimientos, intentar atacar sin ataques restantes en el turno, etc.)

###### ¿Respeta encapsulamiento?
**SI**
* Validación de si puede almacenarse una `Propiedad` en un `Terreno` debería hacerla el terreno (`Propiedad.almacenarme()`)
* Atributo _color_ usado para decidir si se puede atacar a una unidad o no (`UnidadAtacante.atacar()`)

###### ¿Hace un buen uso de excepciones?
**SI**

###### ¿Utiliza polimorfismo en las situaciones esperadas?
**NO**
* Abuso de enumerados para diferenciar objetos (ej: `Terrenos`, `UnidadesTerran`, `Ataques`, etc.). Todo esto se podría haber resuelto polimorficamente como lo discutimos en clase durante las pre-entregas

## Diagramas

### Diagrama de clases

###### ¿Está completo?
**SI**

###### ¿Está bien utilizada la notación?
**SI**
* Nombres de asociaciones que no son explícitas tienen que ponerse sobre las flechas (ej: `CreadorDeUnidades.unidadesCreables` en "Modelo General.png")
* Asociación de uso se denota con punta de flecha simple (ej: `CreadorDeUnidades` -> `Construccion` en "Modelo General.png")

### Diagramas de secuencia

###### ¿Está completo?
**SI**
* Diagrama "mover Unidad exitoso.png" muy incompleto, faltan mensajes y objetos intervinientes

###### ¿Es consistente con el diagrama de clases?
**SI**

###### ¿Está bien utilizada la notación?
**SI**
* No se utiliza la notación para la creación de objetos (ej: objeto `strategy` es creado luego de _1: actionPerformed_ en diagrama "acciones de unidades-ejemplo de Movimiento.png")
* Usar nombres de instancias en los parámetros de los mensajes cuando sea posible (ej: mensaje _1.1: setStrategyAccion_ en mismo diagrama que el ejemplo anterior)
* Notación incorrecta para objetos (diagrama "mover Unidad exitoso.png")


## Código

### Generalidades

###### ¿Respeta estándares de codificación?
**SI**
* Código con warnings (ver archivo `pmd_report.html` generado al ejecutar el build desde ant)
* Estándar para recorrer iteradores en java es usando un ciclo `for` (ej: `Juego.ponerNuevasUnidadesEnMapa()`). _YA HABÍA SIDO CORREGIDO EN UNA PRE-ENTREGA_

###### ¿Está correctamente documentado?
**SI**


**NOTA: 8**