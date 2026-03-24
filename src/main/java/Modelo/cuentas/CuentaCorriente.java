/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.cuentas;

import modelo.abstractas.Cuenta;
import modelo.interfaces.*;
import modelo.excepciones.*;

import java.time.LocalDateTime;

public class CuentaCorriente extends Cuenta 
        implements Consultable, Transaccionable, Auditable {

    private double montoSobregiro;
    private double comisionMantenimiento;

    public CuentaCorriente(String numeroCuenta, double saldo, boolean bloqueada,
                           double montoSobregiro, double comisionMantenimiento) {

        super(numeroCuenta, saldo, bloqueada);
        this.montoSobregiro = montoSobregiro;
        this.comisionMantenimiento = comisionMantenimiento;
    }


    @Override
    public double calcularInteres() {
        return 0; 
    }

    @Override
    public double getLimiteRetiro() {
        return getSaldo() + montoSobregiro;
    }

    @Override
    public String getTipoCuenta() {
        return "Corriente";
    }


    @Override
    public void depositar(double monto)
            throws CuentaBloqueadaException {

        verificarBloqueada();
        setSaldo(getSaldo() + monto);
    }

    @Override
    public void retirar(double monto)
            throws CuentaBloqueadaException, SaldoInsuficienteException {

        verificarBloqueada();

        if (monto > getSaldo() + montoSobregiro) {
            throw new SaldoInsuficienteException(getSaldo(), monto);
        }

        setSaldo(getSaldo() - monto);
    }

    @Override
    public double calcularComision(double monto) {
        return comisionMantenimiento;
    }

    @Override
    public double consultarSaldo() {
        return getSaldo();
    }


    @Override
    public String obtenerResumen() {
        return "Cuenta Corriente: " + getNumeroCuenta() +
               " | Saldo: " + getSaldo();
    }

    @Override
    public boolean estaActivo() {
        return !isBloqueada();
    }

    @Override
    public String obtenerTipo() {
        return "CuentaCorriente";
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