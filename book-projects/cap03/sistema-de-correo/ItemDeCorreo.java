/**
 * Una clase para modelar un simple item de mail. El mail tiene las direcciones
 * del remitente y del destinatario y un mensaje en una cadena de caracteres. 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class ItemDeCorreo
{
    // El remitente del item.
    private String de;
    // El destinatario.
    private String para;
    // The text of the message.
    private String mensaje;

    /**
     * Crea un item de mail desde el servidor para el destinatario 
     * dado, conteniendo el mensaje dado.
     * @param de El remitente de este item.
     * @param para El destinatario de este item.
     * @param mensaje El texto del mensaje a ser enviado.
     */
    public ItemDeCorreo(String de, String para, String mensaje)
    {
        this.de = de;
        this.para = para;
        this.mensaje = mensaje;
    }

    /**
     * @return EL remitente de este mensaje.
     */
    public String getDe()
    {
        return de;
    }

    /**
     * @return El destinatario de este mensaje.
     */
    public String getPara()
    {
        return para;
    }

    /**
     * @return El texto del mensaje.
     */
    public String getMensaje()
    {
        return mensaje;
    }

    /**
     * Imprime este mensaje de mail en la terminal de texto.
     */
    public void print()
    {
        System.out.println("De: " + de);
        System.out.println("Para: " + para);
        System.out.println("Mensaje: " + mensaje);
    }
}
