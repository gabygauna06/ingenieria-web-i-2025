import java.util.ArrayList;

/**
 * Una clase para mantener una arbitrariamente larga lista de notas.
 * Las notas se enumeran para la referencia externa de un usuario humano.
 * En esta versi�n la numeraci�n de las notas comienzan en 0.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2006.03.30
 */
public class Agenda
{
    // Espacio para almacenar un n�mero arbitrario de notas.
    private ArrayList<String> notas;

    /**
     * Realiza cualquier inicializacion que sea requerida para 
     * la agenda
     */
    public Agenda()
    {
        notas = new ArrayList<String>();
    }

    /**
     * Almacena una nueva nota en la agenda.
     * @param nota La nota a ser almacenada.
     */
    public void guardarNota(String nota)
    {
        notas.add(nota);
    } 

    /**
     * @return El n�mero de notas que tiene actualmente la agenda.
     */
    public int numeroDeNotas()
    {
        return notas.size();
    } 
    /**
     * Retira una nota de la genda si esta existe.
     * @param numeroDeNota The number of the note to be removed.
     */
    public void removeNote(int numeroDeNota)
    {
        if(numeroDeNota < 0) {
             // No es un n�mero de nota v�lido, por lo tanto no se hace nada.
        }
        else if(numeroDeNota < numeroDeNotas()) {
            // Es un n�mero de nota v�lido.
            notas.remove(numeroDeNota);
        }
        else {
            // No es un n�mero de nota v�lido, por lo tanto no se hace nada.
        }
    }

    /**
     * Lista todas las notas en la agenda.
     */
    public void imprimirNotas()
    {
        for(String nota : notas) {
            System.out.println(nota);
        }
    }
}
