/**
 * MaquinaDeBoletos modela una mquina de boletos ingenua
 * que entrega boletos de transporte.
 * El precio del boleto se especifica por via del constructor.
 * Es una mquina ingenua en el sentido de que confa en que 
 * sus usuarios insertarn suficiente dinero antes de imprimir
 * el boleto.
 * Incluso asume que los usuarios entraran cantidades suficientes.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2006.03.30
 * Traduccin: Carlos A. Bart
 */
public class MaquinaDeBoletos
{
    // El precio de un boleto a partir de esta m�quina.
    private int precio;
    // La cantidad de dinero ingresada por el usuario hasta
    // el momento.
    private int saldo;
    // El total de dinero recolectado por �sta m�quina.
    private int total;

    /**
     * Crea una m�quina que suministra boletos de un precio dado.
     * Notar que el precio debe ser mayor que cero, y que no se
     * hacen verificaciones para asegurarlo.
     **/
    public MaquinaDeBoletos(int precioBoleto)
    {
        precio = precioBoleto;
        saldo = 0;
        total = 0;
    }

    /**
     * Retorna el precio de un boleto.
     */
    public int getPrecio()
    {
        return precio;
    }

    public void setPrecio(int valor)
    {
        precio = valor;
    }

    /**
     * Retorna la cantidad de dinero ya insertada para el
     * siguiente boleto
     */
    public int getSaldo()
    {
        return saldo;
    }
    
    /**
     * Recibe del usuario una cantidad de dinero en centavos. 
     */
    public void insertarDinero(int cantidad)
    {
        saldo = saldo + cantidad;
    }

    /**
     * Imprime un boleto.
     * Actualiza el total de dinero recolectado y 
     * pone el saldo en cero.
     */
    public void imprimirBoleto()
    {
        // Simula la impresi�n de un boleto.
        System.out.println("##################");
        System.out.println("# La L�nea BlueJ");
        System.out.println("# Boleto");
        System.out.println("# " + precio + " cvos.");
        System.out.println("##################");
        System.out.println();

        // Actualizar el total recolectado con el saldo.
        total = total + saldo;
        // Limpiar el saldo.
        saldo = 0;
    }
}
