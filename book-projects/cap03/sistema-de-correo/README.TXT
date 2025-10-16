Projecto: sistema-de-correo
Autores: David Barnes and Michael Kolling

Este proyecto es parte del material para el libro

   Programación Orientada a Objetos con Java
   Una Introducción Práctica usando BlueJ
   Third edition
   David J. Barnes and Michael Kolling
   Pearson Educacion, 2007 

Es discutido en el capítulo 3. 

Este proyecto simula un sistema simple de correo electrónico. Los clientes simulan
los programas de email de diferentes usuarios. Si crea dos o más clientes, ellos
pueden enviarse mails entre si. (Observe que esta es una simulación simple: realmente
no se pueden enviar mails. Tosos los mensajes son intercambiados solo entre los
objetos de cliente de email en enste proyecto.)

Para usar este pproyecto,

 - cree una instancia de un ServidorDeMail.
 - cree una instancia de ClienteDeMail. Aquie se tiene que pasar el servidor de mail
   como un parámetro, y se tiene que crear un nombre para este usuario.
 - cree un segundo objeto de ClieteDeMail con el mismo servidor de mail y un nombre de
   usuario diferente.
 - Use el método "enviarItemDeCorreo" de un ClienteDeCorreo para enviar un mensaje al otro
   cliente de correo.
 - Use el método "imprimirElSiguienteItemDeCorreo" del segundo cliente de mail a recibir el
   mensaje.

El propósito de este proyecto es demostrar la interacción entre objetos. Incluye llamadas
a métodos externos (un objeto llama a los métodos de otro objeto) y las sentencias de
creación de objetos.

El debugger puede ser usado para investigar esas interacciones entre los objetos.
