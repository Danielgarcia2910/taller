/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.excepciones;

public class CapacidadExcedidaException extends SistemaBancarioException {

    private int capacidadMaxima;

    public CapacidadExcedidaException(int capacidadMaxima) {
        super("Capacidad máxima alcanzada", "CAP-001");
        this.capacidadMaxima = capacidadMaxima;
    }

    // 🔥 ESTE CONSTRUCTOR FALTABA
    public CapacidadExcedidaException(String mensaje, int capacidadMaxima) {
        super(mensaje, "CAP-001");
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}