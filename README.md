# Unicomer
## Se requiere desarrollar un servicio para capturar los datos de candidatos de posibles clientes para Unicomer Jamaica.

### Pasos para poder compilar la aplicación:
- Paso 1:
    - Correr el comando:
    ~~~
    mvn clean package -DskipTest
    ~~~
    Para poder crear el .jar de aplicación, considerar open-jdk-17 que se creo la aplicación

- Paso 2:
    - Ejecutar el siguiente comando si esta en linux, desde la ruta raíz del proyecto el archivo llamado Makefile: 
    ~~~
    sudo make run 
    ~~~
    - Si no cuenta con con el comando make, ejecutar el siguiente comando:
    ~~~
    sudo apt install make
    ~~~
    - Si esta en windows, desde la ruta raíz del proyecto, se ejecuta el archivo llamado Makefile.win: 
    ~~~
    nmake -f makefile.win
    ~~~
    - Si no funciona el archivo Makefile por alguna razón, ejecutar los siguientes comandos
    ~~~
    docker build -t unicomer-api:0.0.1 .
    docker-compose up --build
    ~~~
    Para crear las imagenes docker y luego generar el contenedor

El servicio de spring boot se levanta en el puerto 8030.

La Base de datos postgresql se levanta en el puerto 5432 que viene por defecto.

La aplicación está funcionando con swagger:
~~~
http://localhost:8030/swagger-ui/index.html 
~~~