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

public class CuentaCorriente extends Cuenta {

    private double sobregiro; 

    public CuentaCorriente(String numeroCuenta, double saldo, double sobregiro) {
        super(numeroCuenta, saldo);
        this.sobregiro = sobregiro;
    }


    @Override
    public double calcularInteres() {
        return 0;
    }

    @Override
    public double getLimiteRetiro() {
        return getSaldo() + sobregiro;
    }

    @Override
    public String getTipoCuenta() {
        return "Corriente";
    }

    // 🔹 Depositar
    public void depositar(double monto)
            throws CuentaBloqueadaException, CapacidadExcedidaException {

        verificarBloqueada();

        if (monto <= 0) {
            return;
        }

        setSaldo(getSaldo() + monto);

        agregarAlHistorial(new Transaccion(monto));
    }

    public void retirar(double monto)
            throws CuentaBloqueadaException, SaldoInsuficienteException, CapacidadExcedidaException {

        verificarBloqueada();

        if (monto > getSaldo() + sobregiro) {
            throw new SaldoInsuficienteException(
                    "Supera el límite de sobregiro",
                    getSaldo(),
                    monto
            );
        }

        setSaldo(getSaldo() - monto);

        agregarAlHistorial(new Transaccion(-monto));
    }


    public double getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(double sobregiro) {
        this.sobregiro = sobregiro;
    }
}