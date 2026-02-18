# ARSW-RMI
### Formas de ejecución

Lo primero es iniciar el servidor de nombres donde se registrarán los objetos que prestan 
servicios remotos, este servicio se iniciar´a en el puerto 23000 y los debe ejecutar desde la raíz
del classpath (es decir desde el directorio donde el registry puede encontrar las definiciones
de clase):

`rmiregistry 23000`

Ahora para ejecutar el servidor debe ejecutar desde la consola el siguiente comando:

`java -cp . -Djava.rmi.server.codebase=file:/<pathToClasses>/ -Djava.security.policy=file:/<pathToPolicy>/policy rmiexample.EchoServerImpl`

Este comando invoca la máquina virtual de java con tres parámetros específicos. El 
primer parámetro define un classpath (cp) donde el programa busca las definiciones de
clase. También define el codebase que es donde el sistema de RMI busca las definiciones 
de clases que necesita enviar por la red. Finalmente, antes de invocar la clase a ejecutar, 
define la ubicación del archivo de seguridad.
De manera similar para ejecutar el cliente debe ejecutar desde la consola el siguiente 
comando:
`java -cp .-Djava.rmi.server.codebase=file:/<pathToClasses>/ -Djava.security.policy=file:/<pathToPolicy>/policy rmiexample.EchoClient`
