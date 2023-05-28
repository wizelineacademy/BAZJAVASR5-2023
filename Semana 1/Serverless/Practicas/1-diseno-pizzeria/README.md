# ¡Diseñemos un sistema de órdenes de Pizza!

## Contexto:

Pizzas “ElGüero” cuenta con un sistema de hace décadas que corre sobre servidores on-site y la mayor parte del día está en desuso debido a que solamente abren por las noches y algunas horas de la madrugada, y descansan los Lunes.
El dueño se enteró de que existen maneras de sólo pagar por los servicios cuando realmente se usan y quiere actualizarse.

Hasta ahora, pueden recibir órdenes mediante una API desarrollada con [Express](https://expressjs.com/) que tiene endpoints para procesar pedidos que llegan por llamadas telefónicas `/phone`, web `/web`, mostrador `/mostrador`.

## Requerimientos:

1. “ElGüero”* no tiene presupuesto para reemplazar todos los sistemas, pero quiere al menos optimizar de momento el módulo de procesamiento de órdenes de manera progresiva.

2. Además, quiere introducir un nuevo endpoint que le permita recibir pedidos por whatsapp `/whatsapp`, tiene casi listo un chatbot y sólo le falta el nuevo endpoint para poder conectarlo.
3. La propuesta debe optimizar costos.
4. Ya existen sistemas que permiten recibir y transformar la información para las distintas entradas de la API actual y el nuevo endpoint del punto 1.
5. Ya existe un sistema final que le permite administrar las órdenes y enviarlas a la cocina.

## Ejercicio:

1. Diseña la arquitectura del sistema propuesto.
2. Compártelo en clase y comparen al menos algunas entre distintos compañeros(as)
