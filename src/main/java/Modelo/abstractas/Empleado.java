/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.abstractas;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado extends Persona {

    private String legajo;
    private LocalDate fechaContratacion;
    private double salarioBase;
    private boolean activo;

    public Empleado(String id, String nombre, String apellido,
                    LocalDate fechaNacimiento, String email,
                    String legajo, LocalDate fechaContratacion,
                    double salarioBase, boolean activo) {

        super(id, nombre, apellido, fechaNacimiento, email);

        if (salarioBase <= 0) {
            throw new RuntimeException("Salario inválido");
        }

        if (fechaContratacion.isAfter(LocalDate.now())) {
            throw new RuntimeException("Fecha inválida");
        }

        this.legajo = legajo;
        this.fechaContratacion = fechaContratacion;
        this.salarioBase = salarioBase;
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

    public double getSalarioBase() {
        return salarioBase;
    }

    public boolean isActivo() {
        return activo;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }
}