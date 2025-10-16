/**
 * Lleva a cabo pruebas de la clase Dia que consisten
 * en anotar citas de una hora de duraci�n
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class PruebaUnaHora
{
    // El objeto Dia que sera probado
    private Dia dia;

    /**
     * Constructor de objetos de la clase PruebaUnaHora
     */
    public PruebaUnaHora()
    {
        // Create a Dia object that can be used in testing.
        // Individual methods might choose to create
        // their own instances.
        dia = new Dia(1);
    }

    /**
     * Prueba la funcionalidad b�sica tanto al comienzo, al final como en 
     * la mitad del d�a.
     */
    public void anotarTresCitas()
    {
    	// Comienza con un objeto d�a nuevo.
        dia = new Dia(1);
        // Crea tres citas de una hora de duraci�n
        Cita primera = new Cita("conferencia de Java", 1);
        Cita segunda = new Cita("Clase de Java", 1);
        Cita tercera = new Cita("Ver a John", 1);
        
        // Registrar cada cita con una hora diferente
        dia.anotarCita(9, primera);
        dia.anotarCita(13, segunda);
        dia.anotarCita(17, tercera);
        
        dia.mostrarCitas();
    }
    
    /**
     * Verifica que no est� permitido registrar dos citas en una misma hora
     */
    public void probarDobleCita()
    {
        // Inicializa el d�a con tres citas leg�timas.
        anotarTresCitas();
        Cita citaMala = new Cita("Error", 1);
        dia.anotarCita(9, citaMala);
        
        // muestra que la citaMala no qued� registrada
        dia.mostrarCitas();
    }

    /**
     * Prueba la funcionalidad b�sica completando un d�a con citas.
     */
    public void completarElDia()
    {
    	// Comienza con un objeto d�a nuevo.
        dia = new Dia(1);
        for(int hora = Dia.PRIMER_HORA;
                    hora <= Dia.ULTIMA_HORA;
                        hora++) {
            dia.anotarCita(hora,
                                new Cita("Prueba " + hora, 1));
        }
        
        dia.mostrarCitas();
    }
}
