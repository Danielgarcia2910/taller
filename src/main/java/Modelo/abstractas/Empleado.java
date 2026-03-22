/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.abstractas;

/**
 *
 * @author Orly02
 */

import java.time.LocalDate;
import java.time.Period;
import modelo.excepciones.DatoInvalidoException;

public abstract class Empleado extends Persona {
    
    private String legajo;
    private LocalDate fechaContratacion;
    private double salarioBase;
    private boolean activo;

    public Empleado(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                    String email, String legajo, LocalDate fechaContratacion,
                    double salarioBase, boolean activo) {

        super(id, nombre, apellido, fechaNacimiento, email);

        setLegajo(legajo);
        setFechaContratacion(fechaContratacion);
        setSalarioBase(salarioBase);
        this.activo = activo;
    }

    public abstract double calcularSalario();

    public abstract double calcularBono();

    public int calcularAntiguedad() {
        return Period.between(fechaContratacion, LocalDate.now()).getYears();
    }


    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        if (legajo == null || legajo.isEmpty()) {
            throw new DatoInvalidoException("legajo", legajo);
        }
        this.legajo = legajo;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        if (fechaContratacion == null || fechaContratacion.isAfter(LocalDate.now())) {
            throw new DatoInvalidoException("fechaContratacion", fechaContratacion);
        }
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase <= 0) {
            throw new DatoInvalidoException("salarioBase", salarioBase);
        }
        this.salarioBase = salarioBase;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}