# TALLER 7: APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES

### Demo del proyecto (por si no corre): https://youtu.be/5xfDRMQtiXI

En este taller se implementará una aplicación encargada de garantizar autenticación, autorización e integridad de usuarios.

### Prerrequisitos

- Java: Es un lenguaje de programación de propósito general orientado a objetos, portátil y muy versátil.
- Maven: Es una herramienta que maneja el ciclo de vida del programa.
- Git: Es un sistema de control de versiones distribuido (VCS).

### Qué se hizo
1. Se desarrolló una clase encargada de registrar usuarios y sus contraseñas hash, verifica los usuarios y los redirige a una página de confirmación

<img width="1013" alt="Captura de pantalla 2023-10-21 a la(s) 12 13 06 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/dc4ada84-6996-478f-af3e-b31388508cda">

2. Se creó una instancia de EC2 en AWS y posteriormente se subieron las clases y las credenciales a través de sftp al servidor

<img width="643" alt="Captura de pantalla 2023-10-21 a la(s) 12 18 57 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/31595b84-c9f3-4d69-bfe5-a0362bcf9869">
<img width="650" alt="Captura de pantalla 2023-10-21 a la(s) 12 20 39 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/ef8221f6-5600-46ec-a165-9004781ead48">

3. Se descomprimen las clases y sus dependencias

<img width="648" alt="Captura de pantalla 2023-10-21 a la(s) 12 22 07 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/d682bf6c-f471-47a4-b63b-676267192492">

4. Se ejecuta la clase Login

<img width="649" alt="Captura de pantalla 2023-10-21 a la(s) 12 28 30 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/28611948-6857-4191-9c58-241cc54af057">

5. Se accede a la direccíon
```
https://ec2-3-90-207-33.compute-1.amazonaws.com:5001/login.html
```

<img width="1418" alt="Captura de pantalla 2023-10-21 a la(s) 12 29 46 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/8450f446-61d5-4f5a-bce5-35f436ea77da">

   
### Instalación

1. Clonar los dos repositorios:

```
https://github.com/jloading/Taller6AREP-App.git
```

```
https://github.com/jloading/Taller6AREP-Service.git
```

2. Se construye el proyecto con Maven

```
mvn package
```

**Nota:** Si desea ejecutar la aplicación sin descargar las imágenes directamente de los repositorios (como se indica abajo), deberá crear las imágenes correspondientes a cada repositorio que clonó y la de MongoDB. Luego, simplemente siga los mismos pasos explicados abajo, pero reemplace las imágenes de los repositorios por las que creó. 

### Corriendo la aplicación

### * Usando Docker:
Ingrese los siguientes comandos en su terminal (en el orden que se muestran)

```
docker network create my_network
```

```
docker run -d -p 36000:4567 --name logger-app --network my_network jloading9/taller6arep-app
```

```
docker run -d -p 36001:4568 --name logger-service1 --network my_network jloading9/taller6-service
```

```
docker run -d -p 36002:4568 --name logger-service2 --network my_network jloading9/taller6-service
```

```
docker run -d -p 36003:4568 --name logger-service3 --network my_network jloading9/taller6-service
```

```
docker run -d -p 27017:27017 -v mongodb:/data/db -v mongodb_config:/data/configdb --name db --network my_network mongo:7.0.2 mongod
```

Luego de ejecutar los comandos correctamente, se ingresa a la dirección

```
http://localhost:36000
```

<img width="677" alt="Captura de pantalla 2023-10-05 a la(s) 2 26 33 a m" src="https://github.com/jloading/Taller6AREP-App/assets/65261708/a92835e8-3749-4ac5-b6a1-73b8df355455">

### * A través de AWS:

Se ingresa a la siguiente dirección:

```
http://ec2-54-92-196-10.compute-1.amazonaws.com:36000/
```

Luego de haber ajustado la configuración de seguridad de la instancia para permitir el paso del tráfico a través de los puertos que requerimos, nos conectamos a la instancia mediante SSH y ejecutamos los comandos que se detallaron anteriormente para poner en marcha las instancias de los recursos que necesitamos utilizar. Una vez completado este proceso, fue posible acceder al servicio a través de la URL proporcionada.

<img width="617" alt="Captura de pantalla 2023-10-05 a la(s) 2 27 01 a m" src="https://github.com/jloading/Taller6AREP-App/assets/65261708/a1cf2562-0b86-4c25-b2d0-1b88ea726fcb">



## Hecho con

* Java: Lenguaje de programación de propósito general con enfoque a el paradigma de orientado a objetos, y con un fuerte tipado de variables.
* Git: Es un sistema de control de versiones distribuido (VCS).
* Maven: Es una herramienta que estandariza la configuración del ciclo de vida del proyecto.
* HTML: Es un lenguaje de marcado que estructura una página web y su contenido.
* JavaScript: Lenguaje de programación que los desarrolladores utilizan para hacer paginas web dinamicas.
* Docker: Es un proyecto de código abierto que automatiza el despliegue de aplicaciones dentro de contenedores de software, proporcionando una capa adicional de abstracción y automatización de virtualización de aplicaciones en múltiples sistemas operativos.
* AWS: Es una colección de servicios de computación en la nube pública (también llamados servicios web) que en conjunto forman una plataforma de computación en la nube, ofrecidas a través de Internet por Amazon.com.

## Autor

* **Juan Carlos Acosta**

