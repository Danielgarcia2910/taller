/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.excepciones;

public class PermisoInsuficienteException extends BancoRuntimeException {

    public PermisoInsuficienteException(String accion) {
        super("Permiso insuficiente para: " + accion);
    }
}