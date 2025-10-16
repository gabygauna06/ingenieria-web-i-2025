import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * La clase Contestador represante un objeto generador de respuestas.
 * Se lo usa para generar una respuesta autom�tica por azar seleccionando 
 * una frase de una lista predefinida de respuestas.
 * 
 * @version    1.0
 * @author     Michael Kolling and David J. Barnes
 */
public class Contestador
{
    // Usado para mapear palabras clave con respuestas.
    private HashMap<String, String> mapaDeRespuestas;
    // Respuesta por defecto usada cuando no reconocemos una palabra
    private ArrayList<String> respuestaPorDefecto;
    private Random generadorDeAzar;

    /**
     * Crea un Contestador
     */
    public Contestador()
    {
        mapaDeRespuestas = new HashMap<String, String>();
        respuestaPorDefecto = new ArrayList<String>();
        rellenarRespuestas();
        rellenarRespuestaPorDefecto();
        generadorDeAzar = new Random();
    }

    /**
     * Genera una respuesta desde un set de palabras de entrada dado
     * 
     * @param palabras  Un set de palabras ingresado por el usuario
     * @return       Una cadena que se podr�a mostrar como respuesta
     */
    public String generarRespuesta(HashSet<String> palabras)
    {
        Iterator<String> it = palabras.iterator();
        while(it.hasNext()) {
            String palabra = it.next();
            String respuesta = mapaDeRespuestas.get(palabra);
            if(respuesta != null) {
                return respuesta;
            }
        }
        // si llegamos aqu�, ninguna de las palabras ingresadas fue reconocida
        // en este caso, elegimos una de nuestras respuestas por defecto (lo que
        // respondemos cuando no podemos pensar otra cosa que decir...)
        
        return elegirRespuestaPorDefecto();
    }
    

    /**
     * Ingresar todas las palabras clave conocidas y sus respuesta asociadas
     * en nuestro mapa de respuestas.
     */
    private void rellenarRespuestas()
    {
        mapaDeRespuestas.put("lento", 
                        "Me parece que esto tiene qu ver con su hardware.\n" +
                        "Actualizar su procesador pordr�a resolver todos \n" +
                        "estos problemas. �Ha tenidao alg�n inconveniente \n" +
                        "con nuestro software?");
        mapaDeRespuestas.put("problema", 
                        "Bueno, Ud. sabe, todos los programas tienen alg�n \n" +
                        "defecto. Pero nuestros ingenieros est�n trabajando \n" +
                        "duro para solucionarlos. �Puede describir el problema\n" +
                        "m�s detalladamente?");
        mapaDeRespuestas.put("caro", 
                        "El costo de nuesto producto es muy competitivo. \n" +
                        "Realmente, �ha visto y comparado todas nuestras \n" +
                        "caracter�sticas?");
       
    }

    /**
     * Construye una lista de respuestas por defecto desde donde se tomar�
     * una cuando no sepamso m�s qu� decir.
     */
    private void rellenarRespuestaPorDefecto()
    {
        respuestaPorDefecto.add("Parece complicado. �Podr�a describir \n" +
        		"el problema m�s detalladamente?");
        respuestaPorDefecto.add("Hasta ahora, ning�n cliente inform� \n" +
        		"sobre este problema. �Cu�l es la configuraci�n de su equipo?");
        respuestaPorDefecto.add("Lo que dice parece interesante, " +
        		"cu�nteme un poco m�s");
        respuestaPorDefecto.add("Necesito un poco m�s de informaci�n.");
        respuestaPorDefecto.add("�Verific� si tienen alg�n conflicto con una dll?");
        respuestaPorDefecto.add("Ese problema est� explicado en el manual.\n" +
        		"�Ley� el manual?");
        respuestaPorDefecto.add("Su descripci�n es un poco confusa.\n" +
        		"�Cuenta con alg�n experto que lo ayude a \n" +
        		"describir el problma de manera m�s precisa?");
        respuestaPorDefecto.add("Eso no es una falla, es una caracter�stica\n" +
        		"del programa!");
        respuestaPorDefecto.add("�Ha podido elaborar esto?");
    }

    /**
     * Selecciona una respuesta por defecto al azar.
     * @return     Una respuesta al azar
     */
    private String elegirRespuestaPorDefecto()
    {
        // Elige un n�mero aleatorio al azar par el index en la lista de 
    	// de respuestas por defecto
        // El n�mero ser� entre 0 (inclusive) y el tama�o de la lista (excluye)
        int index = generadorDeAzar.nextInt(respuestaPorDefecto.size());
        return respuestaPorDefecto.get(index);
    }
}
