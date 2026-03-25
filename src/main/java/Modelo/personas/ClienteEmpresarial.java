/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.personas;

import modelo.abstractas.Cuenta;
import modelo.excepciones.CapacidadExcedidaException;

import java.time.LocalDate;

public class ClienteEmpresarial extends Cliente {

    private String nit;
    private String razonSocial;
    private String representanteLegal;

    private Cuenta[] cuentas;
    private int cantidadCuentas;

    private static final int MAX_CUENTAS = 5;

    public ClienteEmpresarial(String id, String nombre, String apellido,LocalDate fechaNacimiento, String email,boolean activo, String nit,String razonSocial, String representanteLegal) {

        super(id, nombre, apellido, fechaNacimiento, email, activo);

        this.nit = nit;
        this.razonSocial = razonSocial;
        this.representanteLegal = representanteLegal;

        this.cuentas = new Cuenta[MAX_CUENTAS];
        this.cantidadCuentas = 0;
    }

    public void agregarCuenta(Cuenta cuenta) throws CapacidadExcedidaException {
        if (cantidadCuentas >= MAX_CUENTAS) {
            throw new CapacidadExcedidaException("Maximo de cuentas alcanzado", MAX_CUENTAS);
        }
        cuentas[cantidadCuentas++] = cuenta;
    }

    @Override
    public String obtenerResumen() {
        return "Empresa: " + razonSocial + " - NIT: " + nit;
    }

    @Override
    public String obtenerTipo() {
        return "ClienteEmpresarial";
    }

    @Override
    public String obtenerContacto() {
        return getEmail();
    }

    @Override
    public boolean aceptaNotificaciones() {
        return true;
    }

    @Override
    public String obtenerDocumento() {
        return nit;
    }
    
    @Override
    public int calcularEdad() {
        return java.time.Period.between(getFechaNacimiento(), java.time.LocalDate.now()).getYears();
    }
}