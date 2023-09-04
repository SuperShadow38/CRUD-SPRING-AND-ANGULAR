# Manual de Despliegue de Proyecto

## Introducción

Este manual se ha creado con el propósito de guiar eficientemente al desarrollador que lo maneje para lograr un despliegue ágil.

## Requisitos

- Node JS instalado.
- Un IDE para la edición de código, de preferencia, puede ser VsCode.

## Proceso de Despliegue

1. **Clone el Repositorio de GitHub:**

   ```shell
   git clone "https://gitlab.com/01septiembre2023sasf/fabio-avila/-/tree/favila-teorica/PRUEBA_TEORICA/ALGORITMOS/ALGORITMO%201?ref_type=heads"
 

2. **Navega hasta el directorio de tu proyecto en la terminal.**

3. **Instala las dependencias con el comando `npm install` en la terminal.**

4. **Inicia tu proyecto:**

   - Si deseas estar en modo desarrollador, ejecuta:
     ```shell
     ng serve
     ```
   - Si deseas arrancar el proyecto en modo producción, ejecuta:
     ```shell
     ng build
     ```
   Luego, abre tu navegador web preferido y accede al endpoint del proyecto (por defecto es `localhost:4200`).

## Gestión de Actualizaciones

Cuando sea necesario realizar actualizaciones en la aplicación, siga estos pasos:

1. **Actualice el repositorio con los cambios necesarios.**

2. **Ejecute nuevamente el proceso de generación de build.**

3. **Implemente los cambios en el servidor web.**



