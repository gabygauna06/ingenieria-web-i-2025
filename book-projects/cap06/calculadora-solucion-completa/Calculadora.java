/**
 * La clase principal de una calculadora simple. Crea una de estas y podr[as
 * obtener el valor de los calculos en la pantalla.
 
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 */
public class Calculadora
{
    private MotorDeCalculadora motor;
    private InterfazDeUsuario igu;

    /**
     * Crea una nueva Calculadora y la muestra
     */
    public Calculadora()
    {
        motor = new MotorDeCalculadora();
        igu = new InterfazDeUsuario(motor);
    }

    /**
     * En el caso de que la ventana este cerrada, la muestra nuevamente.
     */
    public void mostrar()
    {
        igu.setVisible(true);
    }
}
