/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.cuentas;

import modelo.abstractas.Cuenta;
import modelo.interfaces.*;
import modelo.excepciones.*;

import java.time.LocalDateTime;

public class CuentaCredito extends Cuenta implements Consultable, Transaccionable, Auditable {

    private double limiteCredito;
    private double tasaInteres;
    private double deudaActual;

    public CuentaCredito(String numeroCuenta, double saldo, boolean bloqueada,double limiteCredito, double tasaInteres) {

        super(numeroCuenta, saldo, bloqueada);
        this.limiteCredito = limiteCredito;
        this.tasaInteres = tasaInteres;
        this.deudaActual = 0;
    }


    @Override
    public double calcularInteres() {
        return deudaActual * tasaInteres / 12;
    }

    @Override
    public double getLimiteRetiro() {
        return limiteCredito;
    }

    @Override
    public String getTipoCuenta() {
        return "credito";
    }


    @Override
    public void depositar(double monto)
            throws CuentaBloqueadaException {

        verificarBloqueada();

        deudaActual -= monto;
        if (deudaActual < 0) deudaActual = 0;
    }

    @Override
    public void retirar(double monto)
            throws CuentaBloqueadaException, CapacidadExcedidaException {

        verificarBloqueada();

        if (deudaActual + monto > limiteCredito) {
            throw new CapacidadExcedidaException((int) limiteCredito);
        }

        deudaActual += monto;
    }

    @Override
    public double calcularComision(double monto) {
        return monto * 0.02;
    }

    @Override
    public double consultarSaldo() {
        return limiteCredito - deudaActual;
    }


    @Override
    public String obtenerResumen() {
        return "cuenta crediito: " + getNumeroCuenta() +" | deuda: " + deudaActual;
    }

    @Override
    public boolean estaActivo() {
        return !isBloqueada();
    }

    @Override
    public String obtenerTipo() {
        return "CuentaCredito";
    }


    @Override
    public LocalDateTime obtenerFechaCreacion() {
        return getFechaCreacion();
    }

    @Override
    public LocalDateTime obtenerUltimaModificacion() {
        return getUltimaModificacion();
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return getUsuarioModificacion();
    }

    @Override
    public void registrarModificacion(String usuario) {
        setUltimaModificacion(LocalDateTime.now());
        setUsuarioModificacion(usuario);
    }
}