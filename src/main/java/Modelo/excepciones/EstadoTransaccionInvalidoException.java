/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.excepciones;

public class EstadoTransaccionInvalidoException extends BancoRuntimeException {

    public EstadoTransaccionInvalidoException(String estadoActual, String nuevoEstado) {
        super("No se puede cambiar de " + estadoActual + " a " + nuevoEstado);
    }
}