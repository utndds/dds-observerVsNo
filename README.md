# dds-observerVsNo
Ejemplo de uso del patron Observer vs. el no uso del patron

### Explicacion
Este es un ejemplo para ver la diferencia que surge en el sistema a nivel de tiempo de procesamiento y legibilidad/mantenimiento del codigo al usar un patron Observer, o, usar una arquitectura de hilos para solo detectar cambios en un cierto objecto 'Observado', y, que los objetos 'Observador' respondan a este. 

### Uso

** ConPatron.ejecutar(...) **
Representa la construccion/ejecucion del ejemplo usando el patron Observer.
No retorna nada.

** SinPatron.ejecutar(...) **
Representa la construccion/ejecucion del ejemplo usando una arquitectura de hilos como reemplazo del patron.
Retorna una lista de los observadores creados para poder determinar, luego de la correcta ejecucion de todos los hilos, cuanto tardo cada uno de los hilos en notar el cambio del objecto 'Observado' y proceder a guardarlo en su atributo, este tiempo queda guardado tambien en un atributo. 

```java
ConPatron.ejecutar(cantObservadores,valorInicial,valorCambiado)
ArrayList<Observador> observadores = SinPatron.ejecutar(cantObservadores,valorInicial,valorCambiado)
```

### Consideraciones

> ¿Hay otras soluciones sin usar un patron Observer?
Seguramente. Lo que aca se demuestra es la solución clásica que siempre se propone al no saber sobre la existencia del patron.

> Hilos y Semaforo mutex
Los hilos son una estructura de programacion a bajo nivel que se usan en procesamiento en paralelo. Como cada 'Observador' esta consultado independientemente el estado de objeto 'Observado' se puede representar esto con hilos.
Un semaforo es una estructura que se usa para "sincronizar" hilos y sirve para que un hilo X no edite informacion mientras otro la esta leyendo ya que esto llevaria a un incorrecto manejo de la informacion o uso de informacion desactualizada. Hay varios tipos de semaforos en este caso es un Mutex el cual obliga a que solo un hilo a la vez pueda pasar por cierta seccion de codigo. En este ejemplo se diseño de tal forma que solo un hilo puede leer el estado del objeto 'Observado' o escribirlo.

> ¿Cuando termina la ejecucion de un hilo?
El hilo se encuentra en un loop infinito hasta que detecte un cambio en el estado del objeto 'Observado' y guarde ese cambio en un atributo suyo.
El tiempo que tarda en pasar todo esto se considera el tiempo que tardo el procesamiento del hilo

> ¿Por que hay un sleep en el codigo?
En vez de estar chequeando si todos los hilos terminaron su ejecucion o no, es mas sencillo poner un sleep para dejar que terminen. Total no influye en el tiempo de procesamiento del hilo

> ¿Por que el tiempo final de la ejecucion SinPatron es un promedio?
Cada hilo tiene un tiempo de procesamiento por separado porque se ejecutan en paralelo pero no todos los hilos empiezan al mismo tiempo ya que solo empieza un hilo y despues otro y asi. Entonces se opto por tomar un promedio entre los tiempos de que tardo cada hilo para disminuir el error.

> Ejecucion del ejemplo
Para ver bien las diferencias lo tenes que correr varias veces seguidas ya que segun las acciones que este realizando la PC en ese momento puede tardar mas o menos.

> Entonces ¿Los hilos siempre son malos?
No, toda solucion depende del contexto. En este caso es una pobre implementacion ya que el uso de procesamiento en paralelo no es optimo (solo se guarda un valor en un atributo), no solo eso si no que en grandes cantidades conlleva mas tiempo.

### Conclusiones
Al principio puede parecer no haber mucha diferencia pero cuando se empieza a trabajar en una gran cantidad de observadores al orden de 100 se empieza a notar y al orden de 10.000 observadores se acentua la diferencia.
Ya a 100.000 observadores mi computadora se quedo sin memoria (8GB RAM) al tratar de ejecutar tantos hilos al mismo tiempo, sin embargo con el patron observer lo finalizo en 0,01 segundos.
