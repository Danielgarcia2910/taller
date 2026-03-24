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
public class CuentaAhorros extends Cuenta {

    private double tasaInteres;

    // 🔹 Constructor
    public CuentaAhorros(String numeroCuenta, double saldo, double tasaInteres) {
        super(numeroCuenta, saldo);
        this.tasaInteres = tasaInteres;
    }

    // 🔹 Implementación de métodos abstractos

    @Override
    public double calcularInteres() {
        return getSaldo() * tasaInteres;
    }

    @Override
    public double getLimiteRetiro() {
        return 1000000; // límite ejemplo
    }

    @Override
    public String getTipoCuenta() {
        return "Ahorros";
    }

    // 🔹 Depositar dinero
    public void depositar(double monto)
            throws CuentaBloqueadaException, CapacidadExcedidaException {

        verificarBloqueada();

        if (monto <= 0) {
            return;
        }

        setSaldo(getSaldo() + monto);

        agregarAlHistorial(new Transaccion(monto));
    }

    // 🔹 Retirar dinero
    public void retirar(double monto)
            throws CuentaBloqueadaException, SaldoInsuficienteException, CapacidadExcedidaException {

        verificarBloqueada();

        if (monto > getSaldo()) {
            throw new SaldoInsuficienteException(
                    "Saldo insuficiente",
                    getSaldo(),
                    monto
            );
        }

        if (monto > getLimiteRetiro()) {
            throw new SaldoInsuficienteException(
                    "Supera el límite de retiro",
                    getSaldo(),
                    monto
            );
        }

        setSaldo(getSaldo() - monto);

        agregarAlHistorial(new Transaccion(-monto));
    }

    // 🔹 Getter y Setter

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
}