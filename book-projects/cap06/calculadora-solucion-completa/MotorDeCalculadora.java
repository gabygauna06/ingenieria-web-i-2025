/**
 * La parte principal de la calculadora que realiza las operaciones
 * aritméticas y lógicas
 * 
 * @author  David J. Barnes and Michael Kolling 
 * @version 2006.03.30
 */
public class MotorDeCalculadora
{
    // El estado de la calculadora se mantiene en tres campos
    //     construyeValorEnVisor, tieneOperadorIzquierdo, y ultimoOperador.
    
    // Se esta construyendo un nuevo valor en el visor, o el proximo digito
	// va a ser el primero de un nuevo numero
    private boolean construyeValorEnVisor;
    // Se ha ingresado (o calculado) ya un operando izquierdo?
    private boolean tieneOperadorIzquierdo;
    // El último operador ingresado.
    private char ultimoOperador;

    // El valor acutal a se mostrado en el visor.
    private int valorEnVisor;
    // El valor del operandoIzquierdo existente
    private int operandoIzquierdo;

    /**
     * Crea un MotorDeCalculadora.
     */
    public MotorDeCalculadora()
    {
        limpiar();
    }

    /**
     * @return el valor actualmente mostrado en el visor de la calculadora
     */
    public int getValorEnVisor()
    {
        return valorEnVisor;
    }

    /**
     * Un botón de número fue presionado
     * Comenzar un nuevo operando, o incorporar este numero como el
     * digito menso significativo de un numero existente
     * @param numero El numero presionado en la calculadora
     * 
     */
    public void numeroPresionado(int numero)
    {
        if(construyeValorEnVisor) {
            // Incorporar este digito
            valorEnVisor = valorEnVisor*10 + numero;
        }
        else {
            // Comienza a construir un nuevo numero
            valorEnVisor = numero;
            construyeValorEnVisor = true;
        }
    }

    /**
     * El botón 'mas' fue presionado 
     */
    public void mas()
    {
        aplicarOperador('+');
    }

    /**
     * El boton 'menos' fue presionado
     */
    public void menos()
    {
        aplicarOperador('-');
    }
    
    /**
     * El botón '=' fue presionado
     */
    public void igual()
    {
        // Esto completa la construcción de un segundo operando,
    	// para asegurarse de que realmente tenemos un operando izquierdo
    	// un operador y un operando derecho
        if(tieneOperadorIzquierdo &&
                ultimoOperador != '?' &&
                construyeValorEnVisor) {
            calcularResultado();
            ultimoOperador = '?';
            construyeValorEnVisor = false;
        }
        else {
            errorEnSecuenciaDeTeclas();
        }
    }

    /**
     * El botón 'C' (clear-limpiar) fue presionado.
     * Vuelve todo a un esado inicial
     */
    public void limpiar()
    {
        ultimoOperador = '?';
        tieneOperadorIzquierdo = false;
        construyeValorEnVisor = false;
        valorEnVisor = 0;
    }

    /**
     * @return El titulo de este motor de calculo
     */
    public String getTitulo()
    {
        return "Java Calculadora";
    }

    /**
     * @return El autor de este motor
     */
    public String getAutor()
    {
        return "David J. Barnes and Michael Kolling";
    }

    /**
     * @return El numero de versión del motor
     */
    public String getVersion()
    {
       return "Version 1.0";
    }

    /**
     * Combina operandoIzquierdo, ultimoOperador, y el valor en el
     * visor.
     * El resultado se transforma en el operandoIzquierdo y en el nuevo 
     * valor en el visor.
     */
    private void calcularResultado()
    {
        switch(ultimoOperador) {
            case '+':
                valorEnVisor = operandoIzquierdo + valorEnVisor;
                tieneOperadorIzquierdo = true;
                operandoIzquierdo = valorEnVisor;
                break;
            case '-':
                valorEnVisor = operandoIzquierdo - valorEnVisor;
                tieneOperadorIzquierdo = true;
                operandoIzquierdo = valorEnVisor;
                break;
            default:
                errorEnSecuenciaDeTeclas();
                break;
        }
    }
    
    /**
     * Aplica un operador
     * @param operator El operador a aplicar
     */
    private void aplicarOperador(char operator)
    {
        // Si no estamos en el proceso de crear un nuevo operando
    	// entonces esto es un error, a menos que hayamos calculado
    	// un resultado usando '='
         if(!construyeValorEnVisor &&
                    !(tieneOperadorIzquierdo && ultimoOperador == '?')) {
            errorEnSecuenciaDeTeclas();
            return;
        }

        if(ultimoOperador != '?') {
            // Primero aplicar el operador previo
            calcularResultado();
        }
        else {
            // El valorEnVisor se transforma en el operando izquierdo de 
        	// el nuevo operador
            tieneOperadorIzquierdo = true;
            operandoIzquierdo = valorEnVisor;
        }
        ultimoOperador = operator;
        construyeValorEnVisor = false;
    }

    /**
     * Reporta un error en la secuencia de teclas presionadas.
     */
    private void errorEnSecuenciaDeTeclas()
    {
        System.out.println("Ocurrió un error en la secuencia de teclas presionadas");
        // Limpia todo
        limpiar();
    }
}
