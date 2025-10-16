/**
 * Mantiene las citas de un dia completo de un calendario
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class Dia
{
    // La primera y la �ltmia hora del dia en que es posible crear una cita.
    public static final int PRIMER_HORA = 9;
    public static final int ULTIMA_HORA = 17;
    // El n�mero de horas posible de un d�a.
    public static final int MAX_CITAS_POR_DIA =
                                ULTIMA_HORA -
                                PRIMER_HORA + 1;
    
    // Un n�mero de d�a de un a�o en particular. (1-366)
    private int diaNumero;
    // La lista actual de citas de un d�a.
    private Cita[] citas;

    /**
     * Constructor de objetos de la clase Dia.
     * @param diaNumero El n�mero de este d�a en el a�o(1-366).
     */
    public Dia(int diaNumero)
    {
        this.diaNumero = diaNumero;
        citas = new Cita[MAX_CITAS_POR_DIA];
    }

    /**
     * Trata de bucar lugar para una nueva citat.
     * @param cita La nueva cita que se ubicar�.
     * @return La hora m�s temprana en que se puede ubicar la cita
     *         Devuelve -1 si el epacio es insuficiente
     */ 
    public int bucarEspacio(Cita cita)
    {
        int duracion = cita.getDuracion();
        for(int fila = 0; fila < MAX_CITAS_POR_DIA; fila++) {
            if(citas[fila] == null) {
                final int hora = PRIMER_HORA + fila;
                // Potencial punto de inicio.
                if(duracion == 1) {
                    // Se necesita una sola fila.
                    return hora;
                }
                else {
                    // �Cu�ntas filas se necesitan?
                    int cantidad_de_filas_requeridas = duracion - 1;
                    for(int filaSiguiente = fila + 1;
                                cantidad_de_filas_requeridas > 0 &&
                                citas[filaSiguiente] == null;
                                    filaSiguiente++) {
                        cantidad_de_filas_requeridas--;
                    }
                    if(cantidad_de_filas_requeridas == 0) {
                        // Se encontr� espacio suficiente
                        return hora;
                    }
                }
            }
        }
        // No se dispone de espacio suficiente
        return -1;
    }

    /**
     * Anota una cita.
     * @param hora La hora en que comienza la cita.
     * @param cita La cita que se har�.
     * @return true si la cita fue exitosa,
     *         false en caso contrario.
     */
    public boolean anotarCita(int hora,
                                   Cita cita)
    {
        if(horaValida(hora)) {
            int horaInicio = hora - PRIMER_HORA;
            if(citas[horaInicio] == null) {
                int duracion = cita.getDuracion();
                // Completa todas las filas hasta cubrir
                // la duracion de la cita
                for(int i = 0; i < duracion; i++) {
                    citas[horaInicio + i] = cita;
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /**
     * @param hora A qu� hora del d�a. Debe ser una hora comprendida entre
     *        PRIMER_HORA y  ULTIMA_HORA.
     * @return La Cita a la hora dada. Devuelve null si la hora no es v�lida
     *         o si no hay ninguna cita en la hora dada.
     */
    public Cita getCita(int hora)
    {
        if(horaValida(hora)) {
            return citas[hora - PRIMER_HORA];
        }
        else {
            return null;
        }
    }

    /**
     * Imprime la lista de las citas del d�a
     */
    public void mostrarCitas()
    {
        System.out.println("=== Dia " + diaNumero + " ===");
        int hora = PRIMER_HORA;
        for(Cita cita : citas) {
            System.out.print(hora + ": ");
            if(cita != null) {
                System.out.println(cita.getDescripcion());
            }
            else {
                System.out.println();
            }
            hora++;
        }
    }

    /**
     * @return El n�mero de este d�a en el a�o (1 - 366).
     */
    public int getDiaNumero()
    {
        return diaNumero;
    }
    
    /**
     * @return true si la hora est� comprendida entre la PRIMERA_HORA y la
     *         ULTIMA_HORA, false en caso contrario.
     */
    public boolean horaValida(int hora)
    {
        return hora >= PRIMER_HORA && hora <= ULTIMA_HORA;
    }
}
