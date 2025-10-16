/**
 * Provee una interfaz de texto a la LibretaDeDirecciones.
 * Los diferentes comandos proveen acceso a los datos de la libreta.
 *
 *      Uno para buscar en la libreta.
 *
 *      Uno para permitir la carga de datos de un contacto.
 *
 *      Uno para mostrar todas las entradas en la libreta.
 *
 * @author David J. Barnes and Michael Kolling.
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 2006.03.30
 */
public class LibretaDeDireccionesInterfazTexto
{
    // La libreta de direcciones a mostrar y modificar.
    private LibretaDeDirecciones libreta;
    // Un parser para manejar los comandos del usuario.
    private Parser parser;
    
    /**
     * Constructor para la clase LibretaDeDireccionesInterfazTexto
     * @param libreta La libreta de direcciones a utilizar.
     */
    public LibretaDeDireccionesInterfazTexto(LibretaDeDirecciones libreta)
    {
        this.libreta = libreta;
        parser = new Parser();
    }
    
    /**
     * Lee una serie de comandos del usuario para interactuar con la
     * libreta de direcciones. Termina cuando el usuario escribe 'salir'.
     */
    public void ejecutar()
    {
        System.out.println("Libreta de Direcciones");
        System.out.println("Escriba 'ayuda' para ver la lista de comandos.");
        
        String comando;
        do{
            comando = parser.getComando();
            if(comando.equals("agregar")){ 
                agregar();
            }
            else if(comando.equals("tomar")){
                get();
            }
            else if(comando.equals("listar")){
                listar();
            }
            else if(comando.equals("buscar")){
                buscar();
            }
            else if(comando.equals("borrar")){
                borrar();
            }
            else if(comando.equals("ayuda")){
                ayuda();
            }
            else{
                // Hacer nada.
            }
        } while(!(comando.equals("salir")));

        System.out.println("Adios.");
    }
    
    /**
     * Agregar una nueva entrada.
     */
    private void agregar()
    {
        System.out.print("Nombre: ");
        String nombre = parser.leerLinea();
        System.out.print("Teléfono: ");
        String telefono = parser.leerLinea();
        System.out.print("Dirección: ");
        String direccion = parser.leerLinea();
        libreta.agregarContacto(new DatosDelContacto(nombre, telefono, direccion));
    }
    
    /**
     * Busca entradas que coinciden con la clave.
     */
    private void get()
    {
        System.out.println("Ingrese la palabra a buscar.");
        String clave = parser.leerLinea();
        DatosDelContacto resultado = libreta.getContacto(clave);
        System.out.println(resultado);
    }
    
    /**
     * Borra una entrada que coincide con la clave.
     */
    private void borrar()
    {
        System.out.println("Ingrese la clave de la entrada.");
        String clave = parser.leerLinea();
        libreta.eliminarContacto(clave);
    }
    
    /**
     * Busca entradas que coinciden con el prefijo.
     */
    private void buscar()
    {
        System.out.println("Ingrese el prefijo a buscar.");
        String prefijo = parser.leerLinea();
        DatosDelContacto[] resultados = libreta.buscar(prefijo);
        for(int i = 0; i < resultados.length; i++){
            System.out.println(resultados[i]);
            System.out.println("=====");
        }
    }
    
    /**
     * Listar los comandos disponibles.
     */
    private void ayuda()
    {
        parser.showComandos();
    }
    
    /**
     * Listar el contenido de la libreta de direcciones.
     */
    private void listar()
    {
        System.out.println(libreta.listarContactos());
    }
}
