# ThreadLab
Hilos en MVC 
solo un thread a la vez ejecuta un metodo peligroso

10 objetos y 3 metodos 1 clase.... cuantos threads puede haber???? 10 como maximo aunque haya 3 metodos en la clase

cuántas regiones críticas tengo por clase? depende de cuantos objetos tengas. es decir 1 por objeto de la clase

con la palabra syncrhonized marcamos los metodos peligrosos.
que formas tenemos de quedarnos esperando (los hilos que no puedan pasar)? 
-1 bucle (horror porque estas consumiendo recursos solamente esperando para consumir)

-1 bucle a lo loco con sleep(mejor opcion que la anterior)
cuando hacemos un sleep se libera la región crítica

-cuando se produzca se avisara a los consumidores que estan esperando(en cola)
algun tipo de lista de espera que no consuma recursos: wait(se pone en espera, en vez de emplear sleep empleamos wait que no se despierta nunca a no ser que el productor le diga) y notify (es el metodo que hace que notifica pero solo despierta un hilo. existe peligro porque igual hay algun hilo que nunca se despertará)
también está el notifyAll (el que empleamos nosotros)
y cuando se despierten, como están en una región crítica, irán uno detrás del otro.
elq ue coge el control de la región crítica, cogerá el producto. los otros ya no, y tendrán que volver a hacer cola. 
bucle mientras no haya producto -> wait
si llega al wait es porque un productor(thread) ha despertado.
antes de consumir hay que volver a comprobar si hay producto o no
despues consumo / o produzco
y luego notifyAll

**el único sitio donde la región crítica no es mía es en el wait

en el bucle de producir pasa algo parecido:
si hay un desbordamiento en la cantidad que produces también tendrá que queder en hibernación 

este es el problema paradigmático del productor/consumidor porque hay muchas comprobaciones que hacer
incluir un checkbox más que sea controlar producción(no se va a poder producir por encima de un máx) y controlar consumo(no vamos a poder bajar nunca de cero)
e implementaremos diferentes regiones críticas, es decir crear más de un producto


