import java.util.*;

/**
 * 
 * La clase ClaseLab representa una lista de matriculación de una clase de laboratorio.
 * Almacena el horario, aula y participantes del lab, tanto como el nombre del 
 * instructor.
 * 
 * @author Michael Kolling and David Barnes
 * @version 2006.03.30
 * Traducción Carlos A. Bartó
 */
public class ClaseLab
{
    private String instructor;
    private String aula;
    private String diaYHora;
    private List<Estudiante> Estudiantes;
    private int capacidad;
    
    /**
     * Crea una ClaseLab con un número máximo de matrículas. Todos los otros
     * detalles se establecen en los valores por defecto.
     */
    public ClaseLab(int maximoNumeroDeEstudiantes)
    {
        instructor  = "desconocido";
        aula        = "desconocido";
        diaYHora    = "desconocido";
        Estudiantes = new ArrayList<Estudiante>();
        capacidad   = maximoNumeroDeEstudiantes;
    }

    /**
     * Agrega un Estudiante a esta ClaseLab
     */
    public void matriculaEstudiante(Estudiante nuevoEstudiante)
    {
        if(Estudiantes.size() == capacidad) {
            System.out.println("La clase esta completa, ud. no se puede matricular.");
        }
        else {
            Estudiantes.add(nuevoEstudiante);
        }
    }
    
    /**
     * Retorna el número de estudiantes actualmente matriculados en esta ClaseLab.
     */
    public int numeroDeEstudiantes()
    {
        return Estudiantes.size();
    }
    
    /**
     * Establece el número del aula para esta ClaseLab
     */
    public void setAula(String aulaNumero)
    {
        aula = aulaNumero;
    }
    
    /**
     * Establece el horario para esta ClaseLab. El parámetro debería definir 
     * el día y la hora, tal como "Viernes, 10:00"
     */
    public void setHora(String diaYHoraCadena)
    {
        diaYHora = diaYHoraCadena;
    }
    
    /**
     * Establece el nombre del instructor para esta ClaseLab.
     */
    public void setInstructor(String instructorNombre)
    {
        instructor = instructorNombre;
    }
    
    /**
     * Imprime una lista de la clase en la terminal, con otros detalles no estandard
     * de la ClaseLab.
     */
    public void printList()
    {
        System.out.println("Clase de Laboratorio " + diaYHora);
        System.out.println("Instructor: " + instructor + "   aula: " + aula);
        System.out.println("Listado de la clase:");
        for(Estudiante Estudiante : Estudiantes) {
            Estudiante.print();
        }
        System.out.println("Numero of Estudiantes: " + numeroDeEstudiantes());
    }
}
