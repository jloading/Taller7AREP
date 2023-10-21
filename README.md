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

   
### Instalación y ejecución

### * Local:

1. Clonar el repositorio:

```
https://github.com/jloading/Taller7AREP.git
```

2. Se construye el proyecto con Maven

```
mvn clean install
```

3. Se ejecuta la clase Login con el comando

```
java -cp "target/classes:target/dependency/*" org.example.Login
```

4. Se accede a la dirección
```
https://localhost:5001/login.html
```

<img width="695" alt="Captura de pantalla 2023-10-21 a la(s) 12 39 23 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/c4c393f5-b1b9-4fce-8728-f2b690806613">

### * A través de AWS:

1. Se accede a la dirección
```
https://ec2-3-90-207-33.compute-1.amazonaws.com:5001/login.html
```

<img width="1126" alt="Captura de pantalla 2023-10-21 a la(s) 12 41 01 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/1c5d07b2-b891-4fb4-bd14-4447a0f50429">

### Pruebas

Al acceder a la dirección

```
https://ec2-3-90-207-33.compute-1.amazonaws.com:5001/login.html
```

Podrá ingresar distintos usuarios y contraseñas, al ingresar una combinación incorrecta, verá

<img width="1034" alt="Captura de pantalla 2023-10-21 a la(s) 12 44 10 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/154689fc-7e1a-4d2f-b8b9-cde1f4559ca8">

Si ingresa la combinacíon correcta (Username: user, Password: password), verá

<img width="1021" alt="Captura de pantalla 2023-10-21 a la(s) 12 45 26 a  m" src="https://github.com/jloading/Taller7AREP/assets/65261708/03b5159b-30c4-4a22-a810-bcc090e81aff">

### Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios

Para mejorar la seguridad en la clase Login, es importante no almacenar contraseñas directamente en el código, utilizar contraseñas seguras con hashing, y asegurarse de que solo usuarios autorizados tengan acceso a las funciones y datos necesarios. 

### Hecho con

* Java: Lenguaje de programación de propósito general con enfoque a el paradigma de orientado a objetos, y con un fuerte tipado de variables.
* Git: Es un sistema de control de versiones distribuido (VCS).
* Maven: Es una herramienta que estandariza la configuración del ciclo de vida del proyecto.
* HTML: Es un lenguaje de marcado que estructura una página web y su contenido.
* JavaScript: Lenguaje de programación que los desarrolladores utilizan para hacer paginas web dinamicas.
* AWS: Es una colección de servicios de computación en la nube pública (también llamados servicios web) que en conjunto forman una plataforma de computación en la nube, ofrecidas a través de Internet por Amazon.com.

### Autor

* **Juan Carlos Acosta**

