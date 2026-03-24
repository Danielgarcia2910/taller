/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.banco;

import modelo.abstractas.*;
import modelo.personas.*;
import modelo.excepciones.*;

public class Banco {

    private String nombre;

    private Cliente[] clientes = new Cliente[200];
    private Cuenta[] cuentas = new Cuenta[500];
    private Empleado[] empleados = new Empleado[50];

    private int cClientes = 0, cCuentas = 0, cEmpleados = 0;

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public void registrarCliente(Cliente c) throws CapacidadExcedidaException {
        if (cClientes >= clientes.length)
            throw new CapacidadExcedidaException(clientes.length);
        clientes[cClientes++] = c;
    }

    public void registrarEmpleado(Empleado e) throws CapacidadExcedidaException {
        if (cEmpleados >= empleados.length)
            throw new CapacidadExcedidaException(empleados.length);
        empleados[cEmpleados++] = e;
    }

    public Cliente buscarCliente(String id) throws ClienteNoEncontradoException {
        for (int i = 0; i < cClientes; i++) {
            if (clientes[i].getId().equals(id))
                return clientes[i];
        }
        throw new ClienteNoEncontradoException(id);
    }

    public void abrirCuenta(String idCliente, Cuenta c)
            throws ClienteNoEncontradoException, CapacidadExcedidaException {

        Cliente cli = buscarCliente(idCliente);

        if (cCuentas >= cuentas.length)
            throw new CapacidadExcedidaException(cuentas.length);

        cuentas[cCuentas++] = c;
    }

    public double calcularNominaTotal() {
        double total = 0;
        for (int i = 0; i < cEmpleados; i++) {
            total += empleados[i].calcularSalario();
        }
        return total;
    }

    public void calcularInteresesMensuales() {
        for (int i = 0; i < cCuentas; i++) {
            System.out.println(cuentas[i].calcularInteres());
        }
    }
}