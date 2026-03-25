/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.banco;

import modelo.abstractas.Cuenta;
import modelo.enums.EstadoTransaccion;
import modelo.excepciones.EstadoTransaccionInvalidoException;

import java.time.LocalDateTime;

public class Transaccion {

    private String id;
    private Cuenta origen;
    private Cuenta destino;
    private double monto;
    private EstadoTransaccion estado;
    private LocalDateTime fecha;
    private String descripcion;

    public Transaccion(String id, Cuenta origen, Cuenta destino, double monto, String descripcion) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
        this.descripcion = descripcion;
        this.estado = EstadoTransaccion.PENDIENTE;
        this.fecha = LocalDateTime.now();
    }

    public void cambiarEstado(EstadoTransaccion nuevo) {

        if (estado == EstadoTransaccion.PENDIENTE &&
            (nuevo == EstadoTransaccion.PROCESANDO || nuevo == EstadoTransaccion.RECHAZADA)) {

        } else if (estado == EstadoTransaccion.PROCESANDO &&
                   (nuevo == EstadoTransaccion.COMPLETADA || nuevo == EstadoTransaccion.RECHAZADA)) {

        } else if (estado == EstadoTransaccion.COMPLETADA &&
                   nuevo == EstadoTransaccion.REVERTIDA) {

        } else {
            throw new EstadoTransaccionInvalidoException(estado.name(), nuevo.name());
        }

        estado = nuevo;
    }

    public String generarComprobante() {
        return "transaccin " + id + " | monto: " + monto + " | estado: " + estado;
    }
}