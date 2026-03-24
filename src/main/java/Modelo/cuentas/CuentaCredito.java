/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.cuentas;

import Modelo.excepciones.CapacidadExcedidaException;
import Modelo.excepciones.CuentaBloqueadaException;
import Modelo.excepciones.SaldoInsuficienteException;
import modelo.abstractas.Cuenta;
import modelo.banco.Transaccion;



public class CuentaCredito extends Cuenta {

    private double limiteCredito;
    private double deuda;

    public CuentaCredito(String numeroCuenta, double limiteCredito) {
        super(numeroCuenta, 0); 
        this.limiteCredito = limiteCredito;
        this.deuda = 0;
    }


    @Override
    public double calcularInteres() {
        return deuda * 0.02; 
    }

    @Override
    public double getLimiteRetiro() {
        return limiteCredito - deuda;
    }

    @Override
    public String getTipoCuenta() {
        return "Credito";
    }

    public void retirar(double monto)
            throws CuentaBloqueadaException, SaldoInsuficienteException, CapacidadExcedidaException {

        verificarBloqueada();

        if (monto > getLimiteRetiro()) {
            throw new SaldoInsuficienteException("Supera el límite de crédito",getLimiteRetiro(),monto);
        }

        deuda += monto;

        agregarAlHistorial(new Transaccion(-monto));
    }

    public void depositar(double monto)
            throws CuentaBloqueadaException, CapacidadExcedidaException {

        verificarBloqueada();

        if (monto <= 0) {
            return;
        }

        deuda -= monto;

        if (deuda < 0) {
            deuda = 0;
        }

        agregarAlHistorial(new Transaccion(monto));
    }


    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getDeuda() {
        return deuda;
    }
}