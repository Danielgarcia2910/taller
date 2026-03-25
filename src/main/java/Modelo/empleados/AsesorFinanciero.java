/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.empleados;

import modelo.abstractas.Empleado;
import modelo.personas.Cliente;
import modelo.interfaces.Consultable;
import modelo.interfaces.Auditable;
import modelo.excepciones.CapacidadExcedidaException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AsesorFinanciero extends Empleado implements Consultable, Auditable {

    private double comisionBase;
    private double metasMensuales;

    private Cliente[] clientesAsignados;
    private int cantidadClientes;

    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaModificacion;
    private String usuarioModificacion;

    private static final int MAX_CLIENTES = 20;

    public AsesorFinanciero(String id, String nombre, String apellido,LocalDate fechaNacimiento, String email,String legajo, LocalDate fechaContratacion,double salarioBase, boolean activo,
            double comisionBase, double metasMensuales) {

        super(id, nombre, apellido, fechaNacimiento, email,
              legajo, fechaContratacion, salarioBase, activo);

        this.comisionBase = comisionBase;
        this.metasMensuales = metasMensuales;

        this.clientesAsignados = new Cliente[MAX_CLIENTES];
        this.cantidadClientes = 0;

        this.fechaCreacion = LocalDateTime.now();
        this.ultimaModificacion = LocalDateTime.now();
        this.usuarioModificacion = "sistema";
    }

   
    public double getComisionBase() {
        return comisionBase;
    }

    public void setComisionBase(double comisionBase) {
        this.comisionBase = comisionBase;
    }

    public double getMetasMensuales() {
        return metasMensuales;
    }

    public void setMetasMensuales(double metasMensuales) {
        this.metasMensuales = metasMensuales;
    }

    public Cliente[] getClientesAsignados() {
        Cliente[] copia = new Cliente[cantidadClientes];
        System.arraycopy(clientesAsignados, 0, copia, 0, cantidadClientes);
        return copia;
    }

   
    public void asignarCliente(Cliente cliente) throws CapacidadExcedidaException {
        if (cantidadClientes >= MAX_CLIENTES) {
            throw new CapacidadExcedidaException("Limite de clientes alcanzado", MAX_CLIENTES);
        }
        clientesAsignados[cantidadClientes++] = cliente;
    }

    @Override
    public double calcularSalario() {
        double total = getSalarioBase();

        if (cantidadClientes > 0) {
            total += comisionBase;
        }

        return total;
    }

    @Override
    public double calcularBono() {
        return comisionBase * 0.1;
    }

   

    @Override
    public String obtenerResumen() {
        return "Asesor: " + getNombre() + ", clientes: " + cantidadClientes;
    }

    @Override
    public boolean estaActivo() {
        return isActivo();
    }

    @Override
    public String obtenerTipo() {
        return "AsesorFinanciero";
    }

    @Override
    public LocalDateTime obtenerFechaCreacion() {
        return fechaCreacion;
    }

    @Override
    public LocalDateTime obtenerUltimaModificacion() {
        return ultimaModificacion;
    }

    @Override
    public String obtenerUsuarioModificacion() {
        return usuarioModificacion;
    }

    @Override
    public void registrarModificacion(String usuario) {
        this.ultimaModificacion = LocalDateTime.now();
        this.usuarioModificacion = usuario;
    }


    public void listarClientesAsignados() {
        System.out.println("clientes del asesor " + getNombre() + ":");
        for (int i = 0; i < cantidadClientes; i++) {
            System.out.println("- " + clientesAsignados[i].getNombrecompleto());
        }
    }
    @Override
    public int calcularEdad() {
        return java.time.Period.between(getFechaNacimiento(), java.time.LocalDate.now()).getYears();
    }
    
    
    @Override
    public String obtenerDocumento() {
        return getId();
    }
}