# PersistenciaRedis
Es un proyecto Maven.
El proyecto trata de tener persistencia de datos con el servidor de bases de datos en memoria, REDIS.
Otra funcionalidad de este proyecto es insertar nombres y países en conjunto en una base de datos de un servidor de BD.
Las bases de datos utilizadas son MySQL y SQLite3.

### Prerequisitos

Qué cosas necesitamos antes de empezar:

Instalaciones:
```
Mysql-server
Sqlite3 
Redis
```
Las librerías necesarias están vinculadas al pom.xml
Obviamente, necesitamos el servidor Redis funcionando.
Podemos instalarlo desde aquí:
```
https://github.com/antirez/redis

```

## Creación
Necesitamos crear base de datos en cada una de ellas.
```
Nombre de base de datos
Tabla person
Columnas name y country
```
En estas URLs podemos visualizar la creación en los 2 servidores de BD:

* http://www.oscarabadfolgueira.com/crear-una-base-datos-mysql-desde-consola/
* https://www.imaginanet.com/blog/primeros-pasos-con-sqlite3-comandos-basicos.html

Para usar una base de datos u otra, sólo basta con tocar el archivo Beans.xml ya que comentando los parámetros de la que no vayamos a usar, estaría en funcionamiento la otra.

IMPORTANTE
````
En el archivo Beans.xml hay que cambiar los nombres de las bases de datos por la que se esté utilizando
````
## Ejecución

Para ejecutar, nos vamos al raíz del proyecto maven y ejecutamos los comandos siguientes:
```
$  mvn compile
$  mvn dependency:copy-dependencies package
$  java -cp target/archivo.jar:target/dependency:. MainApp2
```

## Authors

* **Javier Bernal** - *Initial work* 


