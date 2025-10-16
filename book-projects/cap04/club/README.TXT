BlueJ proyecto: "club".
Autores: David J. Barnes and Michael Kolling

Este proyecto es parte del material suplementario del libro

   Programación Orientada a Objetos con Java
   Una Introducción Práctica usando BlueJ
   Third edition
   David J. Barnes and Michael Kolling
   Pearson Educacion, 2007 

Propósito del proyecto
======================
Este proyecto está orientado a extender la comprensión de
las colecciones de objetos. Los ejercicios pueden ser abordados
después de completar la sección 4.6 del Capítulo 4.

El ejercicio
============
La asociación a un club es representada por una instancia de la
clase Socio. Una versión completa de la clase Socio se provee en
en el proyecto "club", y no debería necesitar modificación. Cada
objeto Socio contiene los detalles del nombre de una persona, y
el mes y el año en la cual se asoció al club. Todos los detalles
del socio se completan cuando se crea un objeto Socio. 

Su tarea es completar la clase Club, de la cual se suministra un
esquema en el proyecto "club".

La clase CLub esta orientada a almacenar los objetos Socio en una
colección de tamaño flexible.

Un nuevo objeto Socio se agrega a un objeto clección del Club via
el método asociar() del club, el cual tiene la siguiente firma y
descripción:

    /**
     * Agrega un nuevo socio a la colección de socios del club.
     * @param socio El objeto Socio a ser agregado.
     */
    public void asociar(Socio socio)

Puede suponer que el objeto Socio pasado como un parámetro ya 
ha sido creado y esta completamente inicializado.

La clase Club incluso define un método para retornar cuantos
socios hay en el club. Tiene la siguiente firma y descripción:

    /**
     * @return El número de miembros(Socio objects) en
     *         el club.
     */
    public int numeroDeSocios()

El número de socios corresponde al número de objetos Socio 
actualmente almacenados en la colección de tamaño flexible.

Definición completa de la clase. Debería incluir:

    + Un campo para referirse a un objeto de una colección 
      de tamaño flexible.

    + Un constructor sin argumentos que establezca un objeto
      apropiado de colección de tamaño flexible para almacenar
      los objetos de Socio.

    + Una definición completa del método de asociar.

    + Una definición completa del método numeroDeObjetos.

Más abajo hay posteriores ejercicios desafiantes para aquellos que
quieran experimentar con cuestiones adicionales de las colecciones.

Posible implementación en etapas 
================================
Esta tarea ha sido dividida en etapas separadas sugeridas para
ayudarlo a crea la versión terminada en pequeños pasos. Se le
recomienda compilar y ejecutar el programa después de cada etapa
para verificar que los cambios que ha hecho son correctos. 

1. Defina un campo que será usado para referirse a un objeto
colección de tamaño flexible. Use una sentencia apropiada para
importar esta colección. En el constructor, cree el objeto 
colección y asígnelo al campo.

2. Complete el método numeroDeMiembros para retornar el tamaño
actual del objeto colección. Por cierto que hasta que complete
el método asociar, este siempre retornará cero, pero estará listo
para posteriores pruebas cuendo el método asociar esté listo.

3. Complete el método asociar.

Cuando quiera agregar un nuevo objeto Socio al objeto Club desde
el banco de objetos, hay dos formas en las que puede hacerlo:

    + Creee un nuevo objeto Socio en el banco de objetos, llame
    al metodo asociar del objeto Club, y haga clik en el objeto
    Socio para suministrar el parámetro.
    
    + O llame al método asociar en el objeto Club y escriba:

    new Socio("ponga aqui los nombres de los socios ...", numero-de-mes-aqui, numero-de-año-aqui)

    en el parámetro de la caja de diálogo del constructor.

Cuando haya agregado un nuevo socio use el método numeroDeSocios
para verificar: a) Que el método asociar esta agregando a la 
colección y b) Que el método numeroDeSicios esté funcionando.

Ejercicio desafiantes
=====================
Estos ejercicios deafiantes están diseñados para llevar 
el projecto club a una aplicación completa. Se pueden realizar
luego de haber completado la Sección 4.9 del Capítulo 4.

+ defina un método en la clase Club con la siguiente firma y 
descripción:

    /** 
     * Retorna cuantos socios se asociaro en un mes dado. 
     * @param mes El mes en el cual se tiene interés. 
     * @return Cuantos socios se asociaron en el mes dado. 
     */
    public int asociadosEnElMes(int mes) 

Si el parámetro está fuera del rango válido de 1-12, imprima
un mensaje de error y retorne cero.

+ Defina un método en la clase Club con la siguiente firma y 
descripcción:

    /**
     * Remove from the club's collection all members who joined
     * in the given month, and return them stored in a separate
     * collection object.
     * @param month The month of the Membership.
     * @param year The year of the Membership.
     */
    public ArrayList purge(int month, int year)

If the month parameter is outside the valid range of 1-12,
print an error message and return a collection object with no
objects stored in it.

Note: the purge method is significantly harder to write than
any of the others.
