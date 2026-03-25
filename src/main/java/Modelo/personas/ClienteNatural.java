
package modelo.personas;

import modelo.enums.TipoDocumento;
import modelo.excepciones.CapacidadExcedidaException;

import java.time.LocalDate;
import modelo.abstractas.Cuenta;

public class ClienteNatural extends Cliente {

    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private Cuenta[] cuentas;
    private int cantidadCuentas;

    private static final int MAX_CUENTAS = 5;

    public ClienteNatural(String id, String nombre, String apellido, LocalDate fechaNacimiento, String email,boolean activo, TipoDocumento tipoDocumento,String numeroDocumento) {

        super(id, nombre, apellido, fechaNacimiento, email, activo);

        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
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
        return "Cliente Natural: " + getNombrecompleto() + " - Documento: " + numeroDocumento;
    }

    @Override
    public String obtenerTipo() {
        return "ClienteNatural";
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
        return numeroDocumento;
    }
    
    @Override
    
    public int calcularEdad() {
        
        return java.time.Period.between(getFechaNacimiento(), java.time.LocalDate.now()).getYears();
    
    }
}


