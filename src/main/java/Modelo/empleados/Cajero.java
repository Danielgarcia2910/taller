/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.empleados;





import modelo.abstractas.Empleado;
import java.time.LocalDate;

public class Cajero extends Empleado {

    public Cajero(String id, String nombre, String apellido, LocalDate fechaNacimiento,String email, String legajo, LocalDate fechaContratacion,double salarioBase, boolean activo) {

        super(id, nombre, apellido, fechaNacimiento, email,legajo, fechaContratacion, salarioBase, activo);
    }


    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularBono();
    }

    @Override
    public double calcularBono() {
        return getSalarioBase() * 0.05;
    }

    @Override
    public String obtenerTipo() {
        return "Cajero";
    }
}