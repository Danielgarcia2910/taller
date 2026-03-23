/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author Orly02
 */

public class CapacidadExcedidaException extends SistemaBancarioException {

    private int capacidadMaxima;

    public CapacidadExcedidaException(String mensaje, int capacidadMaxima) {
        super(mensaje);
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    @Override
    public String toString() {
        return "CapacidadExcedidaException{" +
                "capacidadMaxima=" + capacidadMaxima +
                ", mensaje=" + getMessage() +
                '}';
    }
}