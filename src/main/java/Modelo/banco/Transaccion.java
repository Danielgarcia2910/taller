/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.banco;

/**
 *
 * @author Orly02
 */

import java.time.LocalDateTime;

public class Transaccion {

    private double monto;
    private LocalDateTime fecha;

    public Transaccion(double monto) {
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}