/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.empleados;

import modelo.abstractas.Empleado;
import modelo.interfaces.*;
import modelo.excepciones.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GerenteSucursal extends Empleado implements Consultable, Auditable {

    private String sucursal;
    private double presupuestoAnual;

    public GerenteSucursal(String id, String nombre, String apellido,
                           LocalDate fechaNacimiento, String email,
                           String legajo, LocalDate fechaContratacion,
                           double salarioBase, boolean activo,
                           String sucursal, double presupuestoAnual) {

        super(id, nombre, apellido, fechaNacimiento, email,
              legajo, fechaContratacion, salarioBase, activo);

        this.sucursal = sucursal;
        this.presupuestoAnual = presupuestoAnual;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }

    @Override
    public double calcularBono() {
        return calcularAntiguedad() * 50000 + 200000;
    }

    @Override
    public String obtenerResumen() {
        return "Gerente: " + getNombrecompleto();
    }

    @Override
    public boolean estaActivo() {
        return isActivo();
    }

    @Override
    public String obtenerTipo() {
        return "GerenteSucursal";
    }

    @Override
    public LocalDateTime obtenerFechaCreacion() {
        return LocalDateTime.now();
    }

    @Override
    public LocalDateTime obtenerUltimaModificacion() {
        return LocalDateTime.now();
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return getLegajo();
    }

    @Override
    public void registrarModificacion(String usuario) {
        System.out.println("Modificado por: " + usuario);
    }
}