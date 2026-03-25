/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo.principal;

import modelo.banco.*;
import modelo.personas.*;
import modelo.cuentas.*;
import modelo.empleados.*;
import modelo.enums.*;
import modelo.excepciones.*;

import java.time.LocalDate;
import modelo.abstractas.Cuenta;
import modelo.abstractas.Empleado;

public class SistemaBancarioDemo {

    public static void main(String[] args) {
        
         System.out.println("===== sistema bancario =====");

    Banco banco = new Banco("banco Java");

    try {

    
        System.out.println("\n===== clientes =====");

        ClienteNatural c1 = new ClienteNatural(
                "1", "Juan", "Perez",
                LocalDate.of(2000, 5, 10),
                "juan@mail.com", true,
                TipoDocumento.CEDULA, "123");

        ClienteNatural c2 = new ClienteNatural(
                "2", "Ana", "Lopez",
                LocalDate.of(1998, 3, 20),
                "ana@mail.com", false,
                TipoDocumento.PASAPORTE, "456");

        ClienteEmpresarial ce = new ClienteEmpresarial(
                "3", "Empresa", "SAS",
                LocalDate.of(1990, 1, 1),
                "empresa@mail.com", true,
                "900123", "Tech SAS", "Esteban");

        banco.registrarCliente(c1);
        banco.registrarCliente(c2);
        banco.registrarCliente(ce);

        System.out.println("clientes registrados correctamente");

      
      
        System.out.println("\n===== cuentas =====");

        CuentaAhorros ahorros = new CuentaAhorros("A1", 5000, false, 0.05, 3);
        CuentaCorriente corriente = new CuentaCorriente("C1", 2000, false, 1000, 50);
        CuentaCredito credito = new CuentaCredito("CR1", 0, false, 3000, 0.1);

        banco.abrirCuenta("1", ahorros);
        banco.abrirCuenta("2", corriente);
        banco.abrirCuenta("3", credito);

        System.out.println("cuentas creadas correctamente");

      
      
        System.out.println("\n===== depositos =====");

        ahorros.depositar(1000);
        System.out.println("deposito exitoso saldo: " + ahorros.consultarSaldo());

        ahorros.setBloqueada(true);
        try {
            ahorros.depositar(500);
        } catch (CuentaBloqueadaException e) {
            System.out.println("error: " + e.getMessage());
        }
        ahorros.setBloqueada(false);

   
        System.out.println("\n===== retiros =====");

        ahorros.retirar(1000);
        System.out.println("retiro exitoso saldo: " + ahorros.consultarSaldo());

        try {
            ahorros.retirar(100000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("error: " + e.getMessage());
        }

      
        System.out.println("\n===== transferencia =====");

        corriente.depositar(500);
        corriente.retirar(200);

        System.out.println("transferencia simulada correctamente");

        
        
        
        
        System.out.println("\n===== empleados =====");

        Empleado[] empleados = new Empleado[3];

        empleados[0] = new Cajero("10", "Luis", "Diaz",LocalDate.of(1995, 2, 2), "luis@mail.com","L1", LocalDate.of(2020, 1, 1),
                2000000, true, Turno.MAÑANA, "Sucursal 1");

        empleados[1] = new AsesorFinanciero("11", "Maria", "Gomez",
                LocalDate.of(1992, 6, 6), "maria@mail.com",
                "L2", LocalDate.of(2019, 1, 1),
                2500000, true, 500000, 10);

        empleados[2] = new GerenteSucursal("12", "Daniel", "Garcia",
                LocalDate.of(1985, 8, 8), "carlos@mail.com",
                "L3", LocalDate.of(2015, 1, 1),
                4000000, true, "Central", 10000000);

       for (Empleado e : empleados) {
    try {
        banco.registrarEmpleado(e);
    } catch (CapacidadExcedidaException ex) {
        System.out.println("error: " + ex.getMessage());
    }
    
    
    System.out.println("salario: " + e.calcularSalario());       
       }
      
        System.out.println("\n===== intereses =====");

        Cuenta[] cuentas = {ahorros, corriente, credito};

        for (Cuenta c : cuentas) {
            System.out.println(c.getTipoCuenta() + " | interes: " + c.calcularInteres());
        }

        
        System.out.println("\n===== transacciones =====");

        Transaccion t = new Transaccion("T1", ahorros, corriente, 500, "transferencia");

        try {
            t.cambiarEstado(EstadoTransaccion.COMPLETADA);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

    
        
        
        
        
        
        System.out.println("\n===== permisos =====");

        try {
            throw new PermisoInsuficienteException("no puede aprobar credito");
        } catch (PermisoInsuficienteException e) {
            System.out.println("error: " + e.getMessage());
        }

     
        
        
        System.out.println("\n===== notificaciones =====");

        c1.notificar("hola cliente");
        c2.notificar("mensaje importante");

        
      
        
        
        
        System.out.println("\n===== auditoria =====");

        ahorros.registrarModificacion("admin");

        System.out.println("ultima modificacion: " + ahorros.obtenerUltimaModificacion());
        System.out.println("usuario: " + ahorros.obtenerUsuarioModificacion());

     
        System.out.println("\n===== nomina =====");

        System.out.println("nomina total: " + banco.calcularNominaTotal());

    } catch (Exception e) {
        System.out.println("error general: " + e.getMessage());
    }
    
}
    
    
    


        
        
    }
        
        
        
        
        
        
        
    
        
    

   