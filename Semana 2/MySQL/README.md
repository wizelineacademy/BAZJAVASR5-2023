# MySQL


### Practica

Una empresa consultora en materia geográfica, necesita preparar su base de datos para recibir datos de parte del INEGI y posteriormente ser leídos.

Con base en la tabla que se muestra, realiza las siguientes actividades.
![My Image](table.png)
* Imagen tomada de las bases de datos abiertas del INEGI



### PASO 1
*  Normalización de la o las tablas resultantes.
### PASO 2
*  Diseño de una query API, siguiendo los mejores patrones de diseño. 
    * Se necesitan 3 querys.
    * La primera de ellas, necesita seleccionar todos los campos de la tabla principal
    * La segunda necesita seleccionar, Estado, municipio y población activa.
    * La tercera realizar algún join con cualquier otra tabla

### PASO 3
Se esperan grandes cantidades de querys ( lectura) hacia la tabla, especialmente consultas preguntando por los valores de Entidad Federativa, Municipio y Estimador. Actualmente la base de datos cuenta con la configuración mínima que proporciona el proveedor. 



* Con base a eso, responde las siguientes actividades.
* Como manejarias las grandes cantidades de querys de lecturas, ¿cambiarías alguna configuración?
* ¿Que estrategia de indexado seguirias y por que?
* ¿Que columnas serían las mejores para indexar y por que?

### PASO 4
Se busca realizar un prototipo de esa tabla utilizando un motor Nosql, como diseñarias el documento, utilizando la tabla utilizada en este ejercicio 

### Entregables:
Captura de pantalla con el diseño de las tablas y un breve ejemplo, con uno o dos valores por tabla es suficiente. Ejemplo

tabla1_normalizada | tabla1_campo1 | tabla1_campo2 | tabla1_campo3 
|--- |--- |--- |--- 
xxxxx | xxxxx | xxxxx | xxxxx 

tabla2_normalizada | tabla2_campo1 | tabla2_campo2 | tabla2_campo3 
|--- |--- |--- |--- 
xxxxx | xxxxx | xxxxx | xxxxx 


Captura de pantalla o texto donde se muestre la Query API que se diseñó. 
Captura de pantalla o texto donde se respondan las preguntas planteadas en el punto 3
Captura de pantalla o texto donde se muestre el comando para crear índices, breve explicación de por que se selecciono ese índice y esas columnas.
Captura de pantalla o texto donde se muestre un ejemplo de la tabla convertida a documento para un motor noSQL, por ejemplo

{
 "Llave1":"valor1",
 "Llave2":"valor2",
 "Llave3":"valor3",
 "Llave4":"valor4",
 "Llave5":"valor5"
}