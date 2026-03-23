/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.abstractas;


import Modelo.excepciones.CapacidadExcedidaException;
import Modelo.excepciones.CuentaBloqueadaException;
import java.time.LocalDateTime;
import modelo.banco.Transaccion; // si está en otro paquete correcto
public abstract class Cuenta {

    // 🔹 Atributos
    private String numeroCuenta;
    private double saldo;
    private boolean bloqueada;
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificacion;

    // 🔹 Historial (máximo 20)
    private Transaccion[] historial;
    private int cantidadTransacciones;

    // 🔹 Constructor
    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.bloqueada = false;
        this.fechaCreacion = LocalDateTime.now();
        this.ultimaModificacion = LocalDateTime.now();
        this.historial = new Transaccion[20];
        this.cantidadTransacciones = 0;
    }

    // 🔹 Métodos abstractos
    public abstract double calcularInteres();

    public abstract double getLimiteRetiro();

    public abstract String getTipoCuenta();

    // 🔹 Verificar si la cuenta está bloqueada
    public void verificarBloqueada() throws CuentaBloqueadaException {
        if (bloqueada) {
            throw new CuentaBloqueadaException("La cuenta está bloqueada");
        }
    }

    // 🔹 Agregar transacción al historial
    public void agregarAlHistorial(Transaccion t) throws CapacidadExcedidaException {
        if (cantidadTransacciones >= historial.length) {
            throw new CapacidadExcedidaException("Historial lleno", historial.length);
        }
        historial[cantidadTransacciones] = t;
        cantidadTransacciones++;
    }

    // 🔹 Obtener copia del historial
    public Transaccion[] getHistorial() {
        Transaccion[] copia = new Transaccion[cantidadTransacciones];
        for (int i = 0; i < cantidadTransacciones; i++) {
            copia[i] = historial[i];
        }
        return copia;
    }

    // 🔹 Getters y Setters

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
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