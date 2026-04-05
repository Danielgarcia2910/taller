
package modelo.personas;
import modelo.abstractas.Persona;
import modelo.interfaces.Consultable;
import modelo.interfaces.Notificable;
import modelo.interfaces.Auditable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Cliente extends Persona implements Consultable, Notificable, Auditable {

    protected boolean activo;

    protected LocalDateTime fechaCreacion;
    protected LocalDateTime ultimaModificacion;
    protected String usuarioModificacion;

    public Cliente(String id, String nombre, String apellido,LocalDate fechaNacimiento, String email, boolean activo) {

        super(id, nombre, apellido, fechaNacimiento, email);
        this.activo = activo;
        this.fechaCreacion = LocalDateTime.now();
        this.ultimaModificacion = LocalDateTime.now();
    }

    @Override
    public boolean estaActivo() {
        return activo;
    }

    @Override
    public void notificar(String mensaje) {
        if (aceptaNotificaciones()) {
            System.out.println("notificacion para " + getNombrecompleto() + ": " + mensaje);
        }
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

    @Override
    public abstract String obtenerResumen();

    @Override
    public abstract String obtenerTipo();

    @Override
    public abstract String obtenerContacto();

    @Override
    public abstract boolean aceptaNotificaciones();
}
