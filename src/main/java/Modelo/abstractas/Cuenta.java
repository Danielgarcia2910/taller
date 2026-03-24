/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.abstractas;

import modelo.banco.Transaccion;

import java.time.LocalDateTime;
import modelo.excepciones.CapacidadExcedidaException;
import modelo.excepciones.CuentaBloqueadaException;

public abstract class Cuenta {

    private String numeroCuenta;
    private double saldo;
    private boolean bloqueada;

    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificacion;

    // 🔹 Historial (máx 20)
    private Transaccion[] historial;
    private int contadorTransacciones;

    // 🔹 Constructor
    public Cuenta(String numeroCuenta, double saldo, boolean bloqueada) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.bloqueada = bloqueada;

        this.fechaCreacion = LocalDateTime.now();
        this.ultimaModificacion = LocalDateTime.now();
        this.usuarioModificacion = "sistema";

        this.historial = new Transaccion[20];
        this.contadorTransacciones = 0;
    }

    // 🔥 MÉTODOS ABSTRACTOS (OBLIGATORIOS)

    public abstract double calcularInteres();

    public abstract double getLimiteRetiro();

    public abstract String getTipoCuenta();

    // 🔹 MÉTODOS CONCRETOS

    public void verificarBloqueada() throws CuentaBloqueadaException {
        if (bloqueada) {
            throw new CuentaBloqueadaException("La cuenta está bloqueada");
        }
    }

    public void agregarAlHistorial(Transaccion t) throws CapacidadExcedidaException {
        if (contadorTransacciones >= historial.length) {
            throw new CapacidadExcedidaException(20);
        }
        historial[contadorTransacciones++] = t;
    }

    public Transaccion[] getHistorial() {
        Transaccion[] copia = new Transaccion[contadorTransacciones];
        System.arraycopy(historial, 0, copia, 0, contadorTransacciones);
        return copia;
    }

    // 🔹 GETTERS Y SETTERS

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}