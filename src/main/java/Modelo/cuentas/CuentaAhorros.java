/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.cuentas;

import modelo.abstractas.Cuenta;
import modelo.interfaces.Consultable;
import modelo.interfaces.Transaccionable;
import modelo.interfaces.Auditable;
import modelo.excepciones.*;

import java.time.LocalDateTime;

public class CuentaAhorros extends Cuenta 
        implements Consultable, Transaccionable, Auditable {

    private double tasaInteres;
    private int retirosMesActual;
    private int maxRetirosMes;

    public CuentaAhorros(String numeroCuenta, double saldo, boolean bloqueada,double tasaInteres, int maxRetirosMes) {

        super(numeroCuenta, saldo, bloqueada);

        this.tasaInteres = tasaInteres;
        this.maxRetirosMes = maxRetirosMes;
        this.retirosMesActual = 0;
    }


    @Override
    public double calcularInteres() {
        return getSaldo() * tasaInteres / 12;
    }

    @Override
    public double getLimiteRetiro() {
        return 1000; 
    }

    @Override
    public String getTipoCuenta() {
        return "ahoros";
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

        if (monto > getSaldo()) {
            throw new SaldoInsuficienteException(getSaldo(), monto);
        }

        setSaldo(getSaldo() - monto);
        retirosMesActual++;
    }

    @Override
    public double calcularComision(double monto) {
        return monto * 0.01;
    }

    @Override
    public double consultarSaldo() {
        return getSaldo();
    }


    @Override
    public String obtenerResumen() {
        return "cuenta ahorros: " + getNumeroCuenta() +" | saldo: " + getSaldo();
    }

    @Override
    public boolean estaActivo() {
        return !isBloqueada();
    }

    @Override
    public String obtenerTipo() {
        return "CuentaAhorros";
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
