# ✈️ Agencia de Viajes «Rumbo Sur» — Preparación para el 2do Parcial

**Materia:** Programación Orientada a Objetos 2 — UNAHUR
**Modalidad:** simulacro de parcial, resolución con TDD (Baby-Steps) y refactors sucesivos
**Lenguaje:** Java 21 + JUnit 5

---

## 🎯 Objetivo

Construir, etapa por etapa, el sistema de cotización y gestión de ofertas de una agencia de viajes.

El enunciado **no indica qué patrones usar**. Cada etapa agrega requerimientos que ponen a prueba el diseño de la anterior. Cuando el código empiece a doler (duplicación, `if` por tipo, explosión de clases), ese es el momento de refactorizar. Identificar **qué problema aparece** y **qué estructura lo resuelve** es parte de lo evaluado.

> ⚠️ Aplicar cualquier estructura que no responda a una necesidad real del enunciado se considera **uso forzado** y descalifica ese punto.

---

## 📋 Criterios de evaluación

- El código debe **compilar** y los tests deben **pasar**.
- Los **nombres de los tests** deben ser descriptivos (`dadoX_alY_Z`).
- Las excepciones deben ser **no chequeadas** (`RuntimeException`). Justificar la elección en un comentario breve en el código.
- La cobertura debe ser **≥ 75 %**.
- Cada decisión de diseño debe responder a una necesidad del enunciado.
- Se aplica análisis estático anticopia.

### Checkpoints de push

| Checkpoint | Cuándo | Qué debe estar en el repositorio |
|---|---|---|
| **CP-1** | Al terminar la Etapa 1 | Catálogo cargado y primeros tests en verde |
| **CP-2** | Antes de empezar la Etapa 3 | Código de las Etapas 1 y 2 refactorizado |
| **CP-3** | Al finalizar | Entrega final |

---

## 🗺️ Contexto

«Rumbo Sur» arma ofertas turísticas. Una oferta puede ser un **servicio** suelto (un vuelo, una noche de hotel, una excursión) o un **paquete** que reúne varias ofertas bajo un nombre comercial y con un descuento propio.

### Catálogo inicial

**Servicios**

| Nombre | Tarifa |
|---|---|
| Vuelo Buenos Aires - Bariloche | $120.000 |
| Hotel Llao Llao | $200.000 |
| Excursión Cerro Catedral | $35.000 |
| Hotel Los Glaciares | $150.000 |
| Excursión Perito Moreno | $60.000 |
| Vuelo Bariloche - El Calafate | $95.000 |
| Vuelo El Calafate - Buenos Aires | $110.000 |

**Paquetes**

| Paquete | Descuento | Contiene |
|---|---|---|
| Bariloche Clásico | 10 % | Vuelo Buenos Aires - Bariloche, Hotel Llao Llao, Excursión Cerro Catedral |
| Calafate Glaciares | 5 % | Hotel Los Glaciares, Excursión Perito Moreno |
| Aventura Patagónica | 20 % | Bariloche Clásico, Vuelo Bariloche - El Calafate, Calafate Glaciares, Vuelo El Calafate - Buenos Aires |

---

## 🧩 Etapa 1 — Servicios y paquetes simples

**Requerimientos**

1. Modelar los servicios con su nombre y su tarifa.
2. Modelar los paquetes con su nombre y su descuento (porcentaje entre 0 y 100).
3. Calcular el **precio** de un paquete: suma de los precios de lo que contiene, menos el descuento del paquete.
4. Obtener la **descripción** de un servicio o paquete (su nombre).
5. Informar la **cantidad de servicios** que ofrece una oferta (un servicio suelto cuenta como 1).
6. Consultar si una oferta **incluye** un servicio por nombre.

**Restricciones**

- Lanzar `TarifaNegativaException` al crear un servicio con tarifa menor a 0.
- Lanzar `DescuentoInvalidoException` al crear un paquete con descuento menor a 0 o mayor a 100.

**Resultados esperados**

| Consulta | Resultado |
|---|---|
| Precio de *Bariloche Clásico* | $319.500 |
| Precio de *Calafate Glaciares* | $199.500 |
| Cantidad de servicios de *Bariloche Clásico* | 3 |
| *Bariloche Clásico* incluye *Hotel Llao Llao* | sí |
| *Bariloche Clásico* incluye *Hotel Los Glaciares* | no |

---

## 🧩 Etapa 2 — Paquetes dentro de paquetes

El catálogo incluye *Aventura Patagónica*, que contiene otros paquetes. Un paquete puede contener servicios **u** otros paquetes, con cualquier nivel de anidamiento.

**Requerimientos**

1. Calcular el precio, la cantidad de servicios y la inclusión por nombre de *Aventura Patagónica* con las **mismas operaciones** de la etapa anterior.
2. Quien consulta una oferta **no debe saber** si tiene delante un servicio suelto o un paquete.

**Restricciones de diseño**

- Evitar `instanceof`, `getClass()` y enums o banderas que indiquen el tipo de una oferta.
- Evitar duplicar la lógica de recorrido entre servicios y paquetes.

**Resultados esperados**

| Consulta | Resultado |
|---|---|
| Precio de *Aventura Patagónica* | $579.200 |
| Cantidad de servicios de *Aventura Patagónica* | 7 |
| *Aventura Patagónica* incluye *Hotel Los Glaciares* | sí |

> ℹ️ El precio de *Aventura Patagónica* se calcula sobre el precio **ya descontado** de sus paquetes internos: (319.500 + 95.000 + 199.500 + 110.000) − 20 % = 579.200.

> 💡 **Pista de diseño:** Si agregás un paquete nuevo a *Aventura Patagónica*, ¿qué parte del código tiene que cambiar? ¿Qué relación hay entre un paquete y lo que contiene? ¿Qué debería poder hacer el código cliente sin preguntar qué es cada cosa?

---

## 🧩 Etapa 3 — Extras de viaje

Los clientes pueden contratar **extras** sobre cualquier oferta (servicio suelto o paquete completo).

| Extra | Efecto sobre el precio | Efecto sobre la descripción |
|---|---|---|
| Traslado privado | + $15.000 | agrega « + Traslado privado» |
| Asistencia al viajero | + $8.000 | agrega « + Asistencia al viajero» |
| Seguro de cancelación | + 10 % del precio acumulado hasta ese momento | agrega « + Seguro de cancelación» |

**Requerimientos**

1. Poder contratar un extra sobre cualquier oferta, y obtener una oferta que se consulta **igual que cualquier otra** (precio, descripción, cantidad de servicios, inclusión).
2. Poder combinar extras en **cualquier orden** y **repetir** el mismo extra.
3. Los extras **no agregan servicios**: la cantidad de servicios y la inclusión por nombre se mantienen.
4. Un extra **no modifica** la oferta original: quien consulta la oferta sin extra sigue viendo el mismo precio.

**Restricciones de diseño**

- Evitar una clase por cada combinación de extras con ofertas.
- Evitar `if` o `switch` por tipo de extra dentro de las ofertas.
- El costo de sumar un cuarto extra debe ser **una clase nueva**, sin modificar las existentes.

**Resultados esperados**

| Oferta | Precio | Descripción |
|---|---|---|
| *Bariloche Clásico* + Traslado privado + Seguro de cancelación | $367.950 | `Bariloche Clásico + Traslado privado + Seguro de cancelación` |
| *Bariloche Clásico* + Seguro de cancelación + Traslado privado | $366.450 | `Bariloche Clásico + Seguro de cancelación + Traslado privado` |
| *Vuelo Buenos Aires - Bariloche* + Traslado privado + Traslado privado | $150.000 | `Vuelo Buenos Aires - Bariloche + Traslado privado + Traslado privado` |
| *Hotel Llao Llao* + Asistencia + Asistencia | $216.000 | `Hotel Llao Llao + Asistencia al viajero + Asistencia al viajero` |

> ℹ️ El orden importa solo para el seguro: (319.500 + 15.000) × 1,10 = 367.950, pero 319.500 × 1,10 + 15.000 = 366.450.

> 💡 **Pista de diseño:** Con 3 extras y 2 tipos de oferta, ¿cuántas clases saldrían si se modela cada combinación? ¿Y con un cuarto extra? ¿Qué relación hay entre un extra y la oferta sobre la que se aplica: uno a uno o uno a muchos? ¿Cuál es el *propósito* de esa relación?

### Reservas

Una **reserva** registra el nombre del cliente y la oferta contratada (con o sin extras). Al crearla, **fija el importe** vigente y la descripción en ese momento.

| Dado | Cuando | Entonces |
|---|---|---|
| Reserva de «Ana» sobre *Bariloche Clásico* | consultar su importe | $319.500 |

> ℹ️ La reserva **no es una oferta del catálogo**: no se cotiza ni se combina. Modelarla con alguna de las estructuras anteriores se considera uso forzado.

---

## 🧩 Etapa 4 — Gestión del catálogo

El equipo comercial modifica el catálogo todos los días. Se necesita un **gestor** que centralice esas modificaciones.

**Modificaciones disponibles**

| Modificación | Efecto |
|---|---|
| Agregar una oferta a un paquete | Pasa a ser un componente directo del paquete |
| Quitar una oferta de un paquete | Deja de ser un componente directo del paquete |
| Actualizar la tarifa de un servicio | El servicio pasa a tener la nueva tarifa |

**Requerimientos**

1. **Aplicar** una modificación de inmediato. Si se aplica correctamente, queda en el **historial**.
2. **Revertir la última modificación aplicada**, repetidamente, en orden inverso al de aplicación. Revertir una actualización de tarifa devuelve la tarifa **anterior**; revertir un agregado quita lo agregado; revertir un quitado lo vuelve a agregar.
3. **Programar** modificaciones para aplicarlas más tarde, sin ejecutarlas todavía.
4. **Cerrar el día**: aplicar las modificaciones programadas en el **orden en que se programaron**. Cada una pasa al historial al aplicarse.
5. Una modificación programada **no se puede revertir** hasta que se aplique.

**Reglas ante errores**

- Quitar una oferta que no es componente directo del paquete: lanzar `ItemNoIncluidoException`, sin alterar el paquete.
- Actualizar una tarifa a un valor negativo: lanzar `TarifaNegativaException`.
- Revertir con el historial vacío: lanzar `NadaParaRevertirException`.
- Una modificación que falla **no se registra** en el historial.
- Si al cerrar el día una modificación falla, el proceso se **interrumpe**: las anteriores quedan aplicadas y en el historial; la que falló y las siguientes **siguen programadas**.

**Restricciones de diseño**

- Evitar que el gestor tenga un `if` o `switch` por tipo de modificación.
- Evitar un método distinto en el gestor por cada combinación de «modificación × inmediata / programada».
- El costo de sumar una cuarta modificación debe ser **una clase nueva**, sin tocar el gestor.

**Resultados esperados**

*Secuencia inmediata* partiendo del catálogo inicial. Se crea el servicio *Cena de bienvenida* ($25.000).

| Paso | Modificación | Precio de *Bariloche Clásico* |
|---|---|---|
| 0 | (catálogo inicial) | $319.500 |
| 1 | Agregar *Cena de bienvenida* a *Bariloche Clásico* | $342.000 |
| 2 | Actualizar tarifa de *Hotel Llao Llao* a $220.000 | $360.000 |
| 3 | Quitar *Excursión Cerro Catedral* de *Bariloche Clásico* | $328.500 |
| 4 | Revertir | $360.000 |
| 5 | Revertir | $342.000 |
| 6 | Revertir | $319.500 |
| 7 | Revertir | `NadaParaRevertirException` |

*Lote:* partiendo del catálogo inicial, programar las mismas tres modificaciones de los pasos 1 a 3.

| Paso | Acción | Resultado |
|---|---|---|
| a | Consultar precio de *Bariloche Clásico* | $319.500 (nada se aplicó) |
| b | Revertir | `NadaParaRevertirException` |
| c | Cerrar el día | Precio de *Bariloche Clásico*: $328.500 |
| d | Cerrar el día de nuevo | Sin cambios: $328.500 |
| e | Revertir tres veces | $319.500 |

*Lote con falla:* partiendo del catálogo inicial, programar en este orden: (1) actualizar tarifa de *Hotel Llao Llao* a $220.000, (2) quitar *Excursión Perito Moreno* de *Bariloche Clásico*, (3) agregar *Cena de bienvenida* a *Bariloche Clásico*.

| Paso | Acción | Resultado |
|---|---|---|
| a | Cerrar el día | `ItemNoIncluidoException` (*Perito Moreno* no está en ese paquete) |
| b | Consultar precio de *Bariloche Clásico* | $337.500 (solo se aplicó la 1) |
| c | Modificaciones aún programadas | 2 |
| d | Revertir | Precio $319.500 |
| e | Revertir | `NadaParaRevertirException` |

> 💡 **Pista de diseño:** Una modificación tiene que poder **guardarse** para después, **ejecutarse** cuando se pida y **deshacerse** más tarde. ¿Qué información necesita conservar cada modificación para poder deshacerse? ¿Qué diferencia hay entre una acción que cambia el estado del catálogo y un cálculo que devuelve un valor?

---

## ✅ Tests mínimos (Given-When-Then)

Escribir los tests con nombres descriptivos. Ejemplos de nombres válidos:

- `dadoUnServicioConTarifaNegativa_alCrearlo_lanzaTarifaNegativaException`
- `dadoUnPaqueteConDescuentoMayorACien_alCrearlo_lanzaDescuentoInvalidoException`
- `dadoUnPaqueteConServicios_alCalcularPrecio_aplicaElDescuentoDelPaquete`
- `dadoUnPaqueteQueContieneOtroPaquete_alContarServicios_sumaLosServiciosDeLosPaquetesInternos`
- `dadoUnExtraDeSeguro_alAplicarloAntesQueUnTraslado_elOrdenAlteraElPrecioFinal`
- `dadaUnaReservaCreada_alCambiarLaTarifaDeUnServicio_elImporteReservadoNoCambia`
- `dadaUnaModificacionDeTarifa_alRevertirla_devuelveLaTarifaAnterior`
- `dadoUnLoteConUnaModificacionInvalida_alCerrarElDia_lasSiguientesQuedanProgramadas`

**Cobertura obligatoria**

| Etapa | Casos a cubrir |
|---|---|
| 1 | Precio con descuento · cantidad de servicios · inclusión · tarifa negativa · descuento inválido |
| 2 | Precio, cantidad e inclusión con paquetes anidados |
| 3 | Cada extra por separado · combinación en ambos órdenes · extra repetido · extra sobre paquete · reserva con importe fijo |
| 4 | Cada modificación aplicada y revertida · secuencia inmediata · lote · lote con falla · historial vacío · quitar algo no incluido |

---

## 📌 Recomendaciones de resolución

1. Empezar por el test más simple de la Etapa 1 y avanzar de a un paso.
2. Dejar que el código **duplique** o **incomode** antes de refactorizar. El refactor se justifica por un dolor concreto, no por anticipación.
3. Hacer un commit por cada ciclo rojo → verde → refactor.
4. Antes de cada refactor, confirmar que todos los tests están en verde.
5. Revisar al terminar cada etapa: *¿qué cambió en el diseño y por qué?*
