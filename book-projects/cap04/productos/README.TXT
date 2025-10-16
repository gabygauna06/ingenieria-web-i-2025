BlueJ project "productos".
Authors:  David J. Barnes and Michael Kolling

Este proyecto es parte del material suplementario de Java para
el capítulo 4 del libro

   Programación Orientada a Objetos con Java
   Una Introducción Práctica usando BlueJ
   Third edition
   David J. Barnes and Michael Kolling
   Pearson Educacion, 2007
 

Purpósito del proyecto
======================
El proyecto está orientado a extender la comprensión de
las colecciones de objetos, incluyendo el uso de ciclos,
iteradores y moldeo. El ejercicio puede ser encarado
después de completar la Sección 4.9 del Capítulo 4.

Los ejercicios
==============
Una compañia registra los niveles de stock de los productos que vende.
Un objeto GestorDeStock mantiene una lista de longitud arbitraria de
objetos de la clase Producto. La tarea consiste en completar el esquema
de implementación de la clase GestorDeStock.

La clase DemoDeStock se ha provisto para ayudar a demostrar diversas
formas en las cuales pueden usarse las clases GestorDeStock y Producto.
Se puede crear un objeto GestorDeStock en el banco de objetos y llamar
a su método demo(). A medida que se desarrolla la clase GestorDeStock,
demo() debe reflejar una funcionalidad creciente.

La clase GestorDeStock
======================
La clase GestorDeStock usa un objeto LinkedList para almacenar cero o
más items de Producto. Su método agregaProducto agrega un nuevo producto
a la colección. Es necesario completar los siguientes métodos:
entrega, encuentraProducto, imprimeDetallesDeProducto y numeroEnStok.

+ El método entrega() debe encontrar el Producto con el ID dado
en la lista de productos y luego llamar su método incrementaCantidad.

+ El método encuentraProducto() debe buscar en la colección 
un producto cuyo campo id sea el argumento id de este método.
Si se encuentra un producto, ese Producto debería ser retornado
como el resultado del método. Si no se encuentra un producto
el método debería retornal null.

+ El método imprimirDetallesDelProducto() debería iterar sobre la lista
de productos e imprimir el resultado del llamadao al método toString()
con cada uno.

+ El método cantidadEnStock() debería ubicar un producto en la colección
con un ID que se ajuste al solicitado y retornal al cantidad actual del
como resultado del método. Si no se encuentra un producto con el ID 
solicitado se debe retornar cero.

La clase Producto
=================
Se ha provisto esta clase y se espera que no se le hagan
alteraciones a la misma.

Cada producto vendido por la compañía es representado por una
instancia de la clase Producto, la cual registra un ID del mismo, su
nombre y cuantos productos hay actualmente en stock.
La clase Producto define el metodo incrementarCantidad() para 
registrar los incrementos en el nivel de stock del producto.
El método venderUno() registra que un ítem del producto ha sido 
vendido por medio de la reducción del campo de nivel de cantidad
en una unidad. 

Implementación en Etapas
========================
La tarea general ha sido descompuesta en etapas sugeridas para
ayudar a crear la versión terminada en pequeños pasos. Se
recomienda compilar y ejecutar el programa después de cada
etapa para verificar que los cambios realizados sean correstos.

1. Implementar el método imprimirDetallesDelProducto() para 
asegurarse que se es capaz de iterar sobre la colección de 
productos. Simplemente se debe imprimir cada producto usando 
System.out.  El enfoque preferido para ello es usar un iterador,
pero se puede usar una variable índice si se lo encuentra más
fácil de entender. 

2. Implementar método encuentraProducto(). Este difiere del método
imprimirDetallesDelProducto() en que no necesariamente tiene que
examinar cada producto en la colección antes de que se encuentre
lo buscado. Por ejemplo, si el primer producto en la colección
se corresponde con el nombre del producto buscado, la iteración
puede terminar y retornar el primer porducto. Por otra parte, es 
posible que no se porduzaca ninguna correspondencia con ningún 
producto y en este caso se debe retornal null.

Cuando se busca una correspondencia, será necesario llamar al 
método getID() sobre un Producto. Esto significa que será necesario
usar un molde cuando se recupere un iyem de la lista. Se puede 
leer sobre moldes (casting) en la lista de discusión del proyecto
de subasta (auction) en el Capìtulo 4. 

3. Implementar el método cantidadEnStock(). Esto es relativamente 
simple de implementar una vez que el método encuentraProducto() haya
sido completado. Por ejemplo, cantidadEnStock puede llamar al método
encuentraProducto() para hacer la búsqueda, y luego llamar al método 
getCantidad() sobre el resultado. Sin embargo se debe cobservar que
ocurre con los productos no encontrados.

4. Implementar el método se entrega() usando un enfque similar al
usado en el método cantidadEnStock().

Ejercicios opcionales desafiantes
=================================
+ Implementar un método en la clase GestorDeStock para imprimir los
detalles de todos los productos con un nivel de stock debajo de un 
valor (pasado al método como parámetro).  

+ Modifique el método agregarProcucto() de tal manera que el nuevo
producto no pueda ser añadido a la lista si ya existe otro producto
con el mismo ID.

+ Agregar a la clase GestorDeStock un método que encuentre un producto
a partir de su nombre en ves de su ID.

    public Product encuentraProduct(String nombre)

Para hacer esto se necesita conocer como se pueden comparar para 
establecer la igualdad de dos objetos String s1 y s2 con la 
expresión boolena:

    s1.equals(s2)

Se pueden encontrar más detalles en el Capítulo 5.