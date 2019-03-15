# MuseoMoneda

Instrucciones para trabajar con git

-- Inicialización --<br/>
Paso 1: Abrimos git bash y nos vamos a la carpeta en la que queramos empezar.<br/>
Paso 2: Creamos la carpeta desde git bash "mkdir NombreCarpeta" y nos vamos a ella "cd NombreCarpeta".<br/>
Paso 3: Una vez en la carpeta, iniciamos el git "git init".<br/>
Paso 4: Ya tenemos una carpeta git, ahora obtenemos el código del repositorio "git clone https://github.com/distribuidosurjc/MuseoMoneda.git" (podéis copiar la URL en el repositorio donde clone or download)<br/>
Passo 5: Ya tenemos todos los archivos en nuestro ordenador. Desde el eclipse STS o el IDE que utilicéis, importáis el proyecto maven desde la carpeta que se ha generado al hacer clone.

-- Una vez ya tenemos el proyecto en local --<br/>
Importante paso previo: Antes de empezar a trabajar, abrir git bash en la carpeta y pedirle que mire si hay alguna novedad y que si la hay que la descargue "git pull".

Ya con los archivos actualizados en local, se trabaja con el eclipse blablabla. 

Una vez se acaba de trabajar, hay que actualizar el repositorio remoto de github "git commit -am "Comentario" <- Ojo con las opciones que si no las ponéis bien peta bastante fuerte.

Habiendo hecho el commit, finalmente hay que hacer "git push". Y ya estará el remoto igual que el local.

-----------------------------------------------

¿Que es complicado? (Que lo es) Pues lo que hemos hecho hasta ahora, descargar ficheros, machacarlos en el eclipse, trabajar con ellos y subirlos de nuevo. Las dos cosas funcionan pero esta da más trabajo.
