/**
 * La parte principal de la calculadora que realiza las operaciones
 * aritméticas y lógicas
 * @author Hacker T. Largebrain 
 * @version 0.1
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
     * Una botón de número fue presionado
     * @param numero el digito presionado.
     */
    public void numeroPresionado(int numero)
    {
        valorEnVisor = valorEnVisor * 10 + numero;
    }

    /**
     * El boton '+' fue presionado 
     */
    public void mas()
    {
        aplicarOperadorPrevio();
        operadorPrevio = '+';
        valorEnVisor = 0;
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
        if(operadorPrevio == '+') {
            valorEnVisor = operandoIzquierdo + valorEnVisor;
        }
        else {
            valorEnVisor = operandoIzquierdo - valorEnVisor;
        }
        operandoIzquierdo = 0;
    }

    /**
     * El botón 'C' (clear-limpiar) fue presionado.
     */
    public void limpiar()
    {
        valorEnVisor = 0;
    }

    /**
     * @return el título de este motor de cálculo
     * 
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
     * Se presionó un botón de operador
     * Aplica el operador previo al nuevo operando 
     * para calcular un resultado intermedio. Este será utilizado
     * como operando izquierdo del nuevo operador
     */
    private void aplicarOperadorPrevio()
    {
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
    }
}
