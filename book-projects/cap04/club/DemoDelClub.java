
/**
 * Provee una demostración de las clases Club y Socios 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemoDelClub
{
    // variables de instancia - reemplace el ejemplo que sigue con el propio.
    private Club club;

    /**
     * Constructor para objetos de la clase DemoDelClub
     */
    public DemoDelClub()
    {
        club = new Club();
    }

    /**
     * Agregue algunos miembros al club, y luego
     * muestre cuantos hay.
     * Ejemplos posteriores de llamadas pueden agregarse si se 
     * agrega más funcionalidad a la clase Club.
     */
    public void demo()
    {
        club.asociar(new Socio("David", 2, 2004));
        club.asociar(new Socio("Miguel", 1, 2004));
        System.out.println("El club tiene " +
                           club.numeroDeSocios() +
                           " socios.");
    }
}
