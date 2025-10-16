
/**
 * La clase Estudiante representa un estudiane en un sistema de administraci�n
 * de estudiantes. Mantiene los detalles relevantes del estudiante en el contexto
 * de la instituc�n.
 * 
 * @author Michael Kolling and David Barnes
 * @version 2006.03.30
 * Traducci�n Carlos A. Bart�
 */
public class Estudiante
{
    // el nombre completo del estudiante.
    private String nombre;
    // la matr�cula del estudiante.
    private String matricula;
    // la cantidad de cr�ditos por estudios realizados por el estudiante
    // hasta el momento.
    private int creditos;

    /**
     * Crea un nuevo estudiante con un nombre y una matr�cula dados.
     */
    public Estudiante(String nombreCompleto, String matriculaEstudiante)
    {
        nombre = nombreCompleto;
        matricula = matriculaEstudiante;
        creditos = 0;
    }

    /**
     * Retorna el nombre completo de este estudiante.
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * establece un nuevo nombre para este estudiante.
     */
    public void cambiaNombre(String nombreReemplazo)
    {
        nombre = nombreReemplazo;
    }

    /**
     * Retorna la matr�cula de este estudiante.
     */
    public String getMatriculaEstudiante()
    {
        return matricula;
    }

    /**
     * Agrega algunos puntos de cr�dito al acumulado del estudiante.
     */
    public void agregaCreditos(int puntosAditionales)
    {
        creditos += puntosAditionales;
    }

    /**
     * Retorna el n�mero de puntos de cr�dito que el estudiante ha acumulado.
     */
    public int getCreditos()
    {
        return creditos;
    }

    /**
     * Retorna el nombre de usuario de este estudiante. El nombre de usuario es
     * una combinaci�n de los primeros cuatro caracteres del nombre del estudiante
     * y los tres primeros caracteres de su matr�cula.
     */
    public String getNombreUsuario()
    {
        return nombre.substring(0,4) + matricula.substring(0,3);
    }
    
    /**
     * Imprime en la pantalla el nombre y la matr�cula de este estudiante.
     */
    public void print()
    {
        System.out.println(nombre + " (" + matricula + ")");
    }
}
