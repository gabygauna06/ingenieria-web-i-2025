/**
 * Una clase para modelar una clase de email simple. El cliente
 * es ejecutado por un usuario particular, y envía y recupera
 * mail por medio de un servidor particular.
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class ClienteDeCorreo
{
    // El servidor usado para enviar y recibir.
    private ServidorDeCorreo servidor;
    // El usurio que ejecuta este cliente.
    private String usuario;

    /**
     * Create a mail client run by usuario and attached to the given servidor.
     */
    public ClienteDeCorreo(ServidorDeCorreo servidor, String usuario)
    {
        this.servidor = servidor;
        this.usuario = usuario;
    }

    /**
     * Retorna el siguiente item de mail (si hay alguno) para este usuario.
     */
    public ItemDeCorreo getSiguienteItemDeCorreo()
    {
        return servidor.getSiguienteItemDeCorreo(usuario);
    }

    /**
     * Imprime en la terminal de texto el siguiene item de mail (si hay alguno)
     * para este usuario.
     */
    public void imprimirSiguienteItemDeCorreo()
    {
        ItemDeCorreo item = servidor.getSiguienteItemDeCorreo(usuario);
        if(item == null)
        {
            System.out.println("No hay mail nuevo.");
        }
        else {
            item.print();
        }
    }

    /**
     * Envía el mensaje al destinatario por medio del
     * servidor adjunto.
     * @param para El destinatario.
     * @param mensaje El texto del mensaje a ser enviado.
     */
    public void enviarItemDeCorreo(String para, String mensaje)
    {
        ItemDeCorreo item = new ItemDeCorreo(usuario, para, mensaje);
        servidor.repartir(item);
    }
}
