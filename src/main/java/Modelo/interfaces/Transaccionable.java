/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.interfaces;

import modelo.excepciones.CapacidadExcedidaException;
import modelo.excepciones.CuentaBloqueadaException;
import modelo.excepciones.SaldoInsuficienteException;


public interface Transaccionable {

    void depositar(double monto)
        throws CuentaBloqueadaException, CapacidadExcedidaException;

    void retirar(double monto)
        throws CuentaBloqueadaException, SaldoInsuficienteException, CapacidadExcedidaException;

    double calcularComision(double monto);

    double consultarSaldo();
}