/**
 * Prueba la clase MotorDeCalculadora
 * 
 * @author Hacker T. Largebrain 
 * @version 0.1
 */
public class MotorDeCalculadoraProbador
{
    // El motor a ser probado
    private MotorDeCalculadora motor;

    /**
     * Constructor de objetos de la clase MotorDeCalculadoraProbador
     */
    public MotorDeCalculadoraProbador()
    {
        motor = new MotorDeCalculadora();
    }
    
    /**
     * Prueba todo.
     */
    public void testTodo()
    {
        System.out.println("Probando la operaci�n adici�n...");
        System.out.println("El resultado es: " + testMas());
        System.out.println("Probando la operaci�n sustracci�n...");
        System.out.println("El resultado es: " + testMenos());
        System.out.println("Todos las pruebas pasaron exitosamente.");
    }

    /**
     * Prueba la operaci�n adici�n del motor.
     * @return el resultado del c�lculo 3+4.
     */
    public int testMas()
    {
        // Asegurarse de que el motor se encuentra en un estado inicial v�lido.
        motor.limpiar();
        // Simular que se presiona: 3 + 4 =
        motor.numeroPresionado(3);
        motor.mas();
        motor.numeroPresionado(4);
        motor.igual();
        // Muestra el resultado, que deber�a ser 7.
        return motor.getValorEnVisor();
    }

    /**
     * Prueba la operaci�n sustracci�n del motor
     * @return  el resultado del c�lculo  9 - 4.
     */
    public int testMenos()
    {
        // Asegurarse de que el motor se encuentra en un estado inicial v�lido.
        motor.limpiar();
        // Simular que se presiona: 9 - 4 =
        motor.numeroPresionado(9);
        motor.menos();
        motor.numeroPresionado(4);
        motor.igual();
        // Muestra el resultado, que deber�a ser 5.
        return motor.getValorEnVisor();
    }
}
