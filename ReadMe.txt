Proyecto manejo de la funcion filter con y sin tokenizeXML utilizando streaming
===============================================================================

Los archivos con los que trabaja la ruta estan en la carpeta files/incoming; los archivos no se eliminaran ya que el elemento file incluye el parámetro noop.

El resultado del procesamiento se verá en la ruta files/outgoing

Para correr el proyecto, desde consola ejecutar:

    mvn celan camel:run

Desde JBoss developer studio, crear un perfil de ejecución:

	clean camel:run