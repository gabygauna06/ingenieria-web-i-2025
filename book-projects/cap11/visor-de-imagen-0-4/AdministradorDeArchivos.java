import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.io.*;

/**
 * AdministradorDeArchivos es una pequeña clase con métodos estáticos
 * para cargar y grabar imágenes.
 * 
 * Los archivos en el disco pueden estar en formato JPG o PNG.
 * Los archivos escritos por esta clase tienen formato determinado
 * por la constante FORMATO_IMAGEN
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class AdministradorDeArchivos
{
    // Una constante para el formato de imagen que se usará para escribir.
    // Los formatos disponibles son "jpg" y "png".
    private static final String FORMATO_IMAGEN = "jpg";
    private static JFileChooser selectorArchivo = new JFileChooser(System.getProperty("user.dir"));
    
    /**
     * Abre un selector de archivos y permite al usuario elegir un archivo de
     * imagen del sistema de archivos. Luego lee la imagen del disco y la
     * devuelve como una imagen. Este método puede leer los formatos JPG y PNG.
     * En caso de algún problema (ej., el archivo no existe, está en un formato
     * que no puede decodificarse o cualquier otro error) este método devuelve
     * el valor null.
     * 
     * @return       El objeto de imagen o null si no es una imágen válida.
     */
    public static ImagenOF getImagen()
    {
        int valorRetorno = selectorArchivo.showOpenDialog(null);

        if(valorRetorno != JFileChooser.APPROVE_OPTION) {
            return null;  // cancelado
        }
        File archivoElegido = selectorArchivo.getSelectedFile();
        return cargarImagen(archivoElegido);
    }

    /**
     * Lee un archivo de imagen del disco y lo devuelve como una BufferedImage.
     * Este metodo puede leer los archivos de formato JPG y PNG.
     * En caso de algún problema (ej., el archivo no existe, está en un formato
     * que no puede decodificarse o cualquier otro error) este método devuelve
     * el valor null.
     * 
     * @param archivoImagen  El archivo de imagen a cargar.
     * @return         El objeto de imagen o null si no es una imágen válida.
     */
    public static ImagenOF cargarImagen(File archivoImagen)
    {
        try {
            BufferedImage imagen = ImageIO.read(archivoImagen);
            if(imagen == null || (imagen.getWidth(null) < 0)) {
                // no podemos cargar la imagen - probablemente es un formato no valido
                return null;
            }
            return new ImagenOF(imagen);
        }
        catch(IOException exc) {
            return null;
        }
    }

    /**
     * Escribe un archivo de imagen en el disco. El formato del archivo es JPG.
     * En caso de algun problema el metodo termina silenciosamente.
     * 
     * @param imagen   La imagen a guardar.
     * @param archivo  El archivo a guardar.
     */
    public static void guardarImagen(ImagenOF imagen, File archivo)
    {
        try {
            ImageIO.write(imagen, FORMATO_IMAGEN, archivo);
        }
        catch(IOException exc) {
            return;
        }
    }
}
