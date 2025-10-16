/**
 * Una clase que mantiene la información sobre un libro.
 * Esto puede formar parte de una aplicación más grande
 * tal como un sistema bibliográfico, por ejemplo.
 *
 * @autor   (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Libro
{
    // The fields.
    private String autor;
    private String titulo;

    /**
     * Establece los campos de autor y título cuando
     * se construye este objeto.
     */
    public Libro(String autorLibro, String tituloLibro)
    {
        autor  = autorLibro;
        titulo = tituloLibro;
    }

    // Add the methods here ...
}
