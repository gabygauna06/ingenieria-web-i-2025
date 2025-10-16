/**
 * La parte principal de la calculadora que realiza las operaciones
 * aritméticas y lógicas
 * Esta versión incorpora instrucciones de impresión para detectar problemas 
 * @author Hacker T. Largebrain (version 0.1)
 * @version 0.2
 */
public class MotorDeCalculadora
{
	// El valor en el visor.
    private int valorEnVisor;
    // El operador previamente tipeado (+ or -).
    private char operadorPrevio;
    // El operando previo al operador previo
    private int operandoIzquierdo;

    /**
     * Crea una instancia de MotorDeCalculadora.
     */
    public MotorDeCalculadora()
    {
        valorEnVisor = 0;
        operadorPrevio = ' ';
        operandoIzquierdo = 0;
    }


    /**
     * @return El valor actualmente mostrado en el visor
     * de la calculadora
     */
    public int getValorEnVisor()
    {
        return valorEnVisor;
    }

    /**
     * A number button was pressed.
     */
    public void numeroPresionado(int numero)
    {
        System.out.println("numeroPresionado invocado con: " +
                           numero);
        valorEnVisor = valorEnVisor * 10 + numero;
        informarEstado("fin de numeroPresionado");
    }

    /**
     * El boton '+' fue presionado 
     */
    public void mas()
    {
        System.out.println("mas invocado");
        aplicarOperadorPrevio();
        operadorPrevio = '+';
        valorEnVisor = 0;
        informarEstado("fin de mas");
    }

    /**
     * El botón '-' fue presionado
     */
    public void menos()
    {
        aplicarOperadorPrevio();
        operadorPrevio = '-';
        valorEnVisor = 0;
    }
    
    /**
     * El botón '=' fue presionado
     */
    public void igual()
    {
        System.out.println("igual invocado");
        if(operadorPrevio == '+') {
            valorEnVisor = operandoIzquierdo + valorEnVisor;
        }
        else {
            valorEnVisor = operandoIzquierdo - valorEnVisor;
        }
        operandoIzquierdo = 0;
        informarEstado("fin de igual");
    }

    /**
     * El botón 'C' (clear-limpiar) fue presionado.
     */
    public void limpiar()
    {
        System.out.println("limpiar invocado");
        valorEnVisor = 0;
        informarEstado("fin de limpiar");
    }

    /**
     * @return el título de este motor de cálculo

     */
    public String getTitulo()
    {
        return "Super Calculadora";
    }

    /**
     * @return El autor de este motor.
     */
    public String getAutor()
    {
        return "Hacker T. Largebrain";
    }

    /**
     * @return El numero de version de este motor
     */
    public String getVersion()
    {
        return "version 0.2";
    }

    /**
     * Imprime los valores de los campos de este objeto.
     * @param donde Donde ocurre este estado.
     */
    public void informarEstado(String donde)
    {
        System.out.println("valorEnVisor: " + valorEnVisor +
                           " operandoIzquierdo: " + operandoIzquierdo +
                           " operadorPrevio: " +
                           operadorPrevio + " en " + donde);
    }
    
    /**
     * Se presionó un botón de operador
     * Aplica el operador previo al nuevo operando 
     * para calcular un resultado intermedio. Este será utilizado
     * como operando izquierdo del nuevo operador
     */
    private void aplicarOperadorPrevio()
    {
        System.out.println("aplicarOperadorPrevio invocado");
        if(operadorPrevio == '+') {
            operandoIzquierdo += valorEnVisor;
        }
        else if(operadorPrevio == '-') {
            operandoIzquierdo -= valorEnVisor;
        }
        else {
            // No existía operador previo.
            operandoIzquierdo = valorEnVisor;
        }
        informarEstado("fin de aplicarOperadorPrevio");
    }
}
