/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author Orly02
 */



public class PermisoInsuficienteException extends BancoRuntimeException {

    public PermisoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}