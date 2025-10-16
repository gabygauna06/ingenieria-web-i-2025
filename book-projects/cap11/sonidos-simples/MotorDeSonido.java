import java.io.*;
import javax.sound.sampled.*;

/**
 * La clase MotorDeSonido provee funcionalidad al procesamiento de archivos
 * de sonido. Los sonidos se pueden cargar, reproducir, pausar, continuar
 * su reproducción y detener.
 * 
 * El motor de sonido puede reproducir múltiples sonidos simultáneamente, pero
 * sólo el último sonido cargado puede controlarse (pausa, continuar, etc.).
 * 
 * El motor de sonindo puede reproducir archivos WAV, AIFF y AU con muestreo
 * estándar de 22.050 kHz o 11.025 kHz.
 * 
 * @author Michael Kolling and David J Barnes 
 * @author Traducción: Maximiliano A. Eschoyez
 * @version 1.0
 */
public class MotorDeSonido
{
    // Los tres campos siguientes contienen información acerca del archivo
    // de sonido actualmente cargado en este motor
    private Clip clipActualDeSonido = null;
    private int duracionDelSonidoActual = 0;
    private int duracionDelCuadroActual = 0;
    
    /**
     * Crea un MotorDeSonido que puede reproducir archivos de sonido.
     */
    public MotorDeSonido()
    {
    }

    /**
     * Carga y reproduce una archivo de sonido. Si el archivo no se encuentra
     * en un formato reconocido, se devuelve 'false'. En caso contrario, se
     * inicia el sonido y se devuelve 'true'. El método termina inmediatamente
     * luego de iniciar el sonido.
     * 
     * @param archivoDeSonido  El archivo de sonido a cargar.
     * @return  True, si se pudo cargar el sonido, false en caso contrario.
     */
    public boolean reproducir(File archivoDeSonido)
    {
        if(cargarSonido(archivoDeSonido)) {
            clipActualDeSonido.start();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Detiene la reproducción de sonido (si se está reproduciendo un archivo).
     * Si no se está reproduciendo, este método no tiene efecto.
     */
    public void detener()
    {
        if(clipActualDeSonido != null) {
            clipActualDeSonido.stop();
            clipActualDeSonido = null;
        }
    }            

    /**
     * Pausa la reproducción de sonido. Si no se está reproduciendo,
     * este método no tiene efecto.
     */
    public void pausar()
    {
        if(clipActualDeSonido != null) {
            clipActualDeSonido.stop();
        }
    }

    /**
     * Continúa la reproducción de sonido. Si no se está reproduciendo,
     * este método no tiene efecto.
     */
    public void continuar()
    {
        if(clipActualDeSonido != null) {
            clipActualDeSonido.start();
        }
    }

    /**
     * Establece la posición actual de reproducción del sonido a 'valor'.
     * 'valor' es un pocentaje (0 a 100). Si no se está reproduciendo,
     * este método no tiene efecto.
     * 
     * @param valor  La posición destino dentro del archivo de sonido, como
     *               un porcentaje.
     */
    public void posicionar(int valor)
    {
        if(clipActualDeSonido != null) {
            int nuevaPosicion = duracionDelCuadroActual / 100 * valor;
            clipActualDeSonido.setFramePosition(nuevaPosicion);
        }
    }
    
    /**
     * Establecer el volumen de reproduccion del sonido actual. Si no se
     * está reproduciendo, este método no tiene efecto.
     * 
     * @param vol  Nivel de volumn como un porcentaje (0..100).
     */
    public void setVolumen(int vol)
    {
        if(clipActualDeSonido == null) {
            return;
        }
        if(vol < 0 || vol > 100) {
            vol = 100;
        }

        double val = vol / 100.0;

        try {
            FloatControl volControl =
              (FloatControl) clipActualDeSonido.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float)(Math.log(val == 0.0 ? 0.0001 : val) / Math.log(10.0) * 20.0);
            volControl.setValue(dB);
        } catch (Exception ex) {
            System.out.println("No se puede ajustar el volumen");
        }
    }

    /**
     * Devuelve la duracion del sonido cargado.
     * 
     * @return  La duracion del sonido cargado, o 0 si no se cargo uno.
     */
    public int getDuracion()
    {
        return duracionDelSonidoActual;
    }

    /**
     * Carga el archivo de sonido dado como parametro a este motor de sonido.
     * 
     * @return  'true' en caso de exito, 'false' si no se puede decodificar.
     */
    private boolean cargarSonido(File archivo) 
    {
        duracionDelSonidoActual = 0;

        try {
            AudioInputStream sonido = AudioSystem.getAudioInputStream(archivo);
            AudioFormat formato = sonido.getFormat();

            // no se puede reproducir ALAW/ULAW, se lo convierte a PCM
            //
            if ((formato.getEncoding() == AudioFormat.Encoding.ULAW) ||
                (formato.getEncoding() == AudioFormat.Encoding.ALAW)) 
            {
                AudioFormat tmp = new AudioFormat(
                                          AudioFormat.Encoding.PCM_SIGNED, 
                                          formato.getSampleRate(),
                                          formato.getSampleSizeInBits() * 2,
                                          formato.getChannels(),
                                          formato.getFrameSize() * 2,
                                          formato.getFrameRate(),
                                          true);
                sonido = AudioSystem.getAudioInputStream(tmp, sonido);
                formato = tmp;
            }
            DataLine.Info info = new DataLine.Info(Clip.class, 
                                           sonido.getFormat(),
                                           ((int) sonido.getFrameLength() *
                                           formato.getFrameSize()));

            clipActualDeSonido = (Clip) AudioSystem.getLine(info);
            clipActualDeSonido.open(sonido);
            duracionDelCuadroActual = (int) sonido.getFrameLength();
            duracionDelSonidoActual = (int) (clipActualDeSonido.getBufferSize() / 
                              (clipActualDeSonido.getFormat().getFrameSize() * 
                              clipActualDeSonido.getFormat().getFrameRate()));
            return true;
        } catch (Exception ex) {
            clipActualDeSonido = null;
            return false;
        }
    }
}
