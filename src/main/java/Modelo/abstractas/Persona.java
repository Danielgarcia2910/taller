/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.abstractas;



import java.time.LocalDate;
import java.time.Period;
import modelo.excepciones.DatoInvalidoException;


public abstract class Persona {
    
    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;

    public Persona(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }
    
    public abstract int calcularEdad();
    
    public abstract String obtenerTipo();
    
    public abstract String obtenerDocumento();
    
    public String getNombrecompleto(){
        return nombre + " " + apellido;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new DatoInvalidoException("id", id);
        }
        this.id = id;
    }
    
   public String getNombre(){
       return nombre;
       
   }
   public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new DatoInvalidoException("nombre", nombre);
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            throw new DatoInvalidoException("apellido", apellido);
        }
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new DatoInvalidoException("fechaNacimiento", fechaNacimiento);
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new DatoInvalidoException("email", email);
        }
        this.email = email;
    }
    
}