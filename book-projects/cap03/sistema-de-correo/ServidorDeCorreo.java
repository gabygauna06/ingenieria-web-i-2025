import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Un modelo simple de servidor de mail. El servidor es capaz de 
 * recibir items de mails para almacenarlos, y enviarlos a los 
 * clientes en demanda.
 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class ServidorDeCorreo
{
    // Almacenamiento para el número arbitrario de items de mail 
    // a ser guardados en el servidor
    private List<ItemDeCorreo> items;

    /**
     * Construye un servidor de mail.
     */
    public ServidorDeCorreo()
    {
        items = new ArrayList<ItemDeCorreo>();
    }

    /**
     * Retorna cuantos items de mails estan esperando por un usuario.
     * @param quien Es el usuario a quien se debe chequear
     * @param who El usuario a quien chequear.
     * @return Cuantos items están esperando. 
     */
    public int cuantosItemsDeCorreos(String quien)
    {
        int count = 0;
        for(ItemDeCorreo item : items) {
            if(item.getPara().equals(quien)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retorna el siguiente item de mail para un usuario o null
     * @param quien El usuario que requiere su próximo item.
     * @return El siguiente item del usuario.
     */
    public ItemDeCorreo getSiguienteItemDeCorreo(String quien)
    {
        Iterator<ItemDeCorreo> it = items.iterator();
        while(it.hasNext()) {
            ItemDeCorreo item = it.next();
            if(item.getPara().equals(quien)) {
                it.remove();
                return item;
            }
        }
        return null;
    }

    /**
     * Agrega el item de mail dado a la lista de mensajes.
     * @param item El item de mail a ser almacenado en el servidor.
     */
    public void repartir(ItemDeCorreo item)
    {
        items.add(item);
    }
}
