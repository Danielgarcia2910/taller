/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.empleados;

import modelo.abstractas.Empleado;
import modelo.interfaces.Consultable;
import modelo.interfaces.Auditable;
import modelo.enums.Turno;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cajero extends Empleado 
        implements Consultable, Auditable {

    private Turno turno;
    private String sucursalAsignada;
    private int transaccionesDia;

    public Cajero(String id, String nombre, String apellido, LocalDate fechaNacimiento,
                  String email, String legajo, LocalDate fechaContratacion,
                  double salarioBase, boolean activo,
                  Turno turno, String sucursalAsignada) {

        super(id, nombre, apellido, fechaNacimiento, email,
              legajo, fechaContratacion, salarioBase, activo);

        this.turno = turno;
        this.sucursalAsignada = sucursalAsignada;
        this.transaccionesDia = 0;
    }


    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }

    @Override
    public double calcularBono() {
        return transaccionesDia * 1000; 
    }

    @Override
    public String obtenerTipo() {
        return "Cajero";
    }


    @Override
    public String obtenerResumen() {
        return "Cajero: " + getNombrecompleto() +
               " | Legajo: " + getLegajo() +
               " | Turno: " + turno;
    }

    @Override
    public boolean estaActivo() {
        return isActivo();
    }


    @Override
    public LocalDateTime obtenerFechaCreacion() {
        return getFechaContratacion().atStartOfDay();
    }

    @Override
    public LocalDateTime obtenerUltimaModificacion() {
        return getFechaContratacion().atStartOfDay(); // simplificado
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return getLegajo();
    }

    @Override
    public void registrarModificacion(String usuario) {
        System.out.println("Modificado por: " + usuario);
    }


    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getSucursalAsignada() {
        return sucursalAsignada;
    }

    public void setSucursalAsignada(String sucursalAsignada) {
        this.sucursalAsignada = sucursalAsignada;
    }

    public int getTransaccionesDia() {
        return transaccionesDia;
    }

    public void setTransaccionesDia(int transaccionesDia) {
        this.transaccionesDia = transaccionesDia;
    }
}