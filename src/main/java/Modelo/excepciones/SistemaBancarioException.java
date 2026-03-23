/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;



import java.time.LocalDateTime;

public class SistemaBancarioException extends Exception {

    protected String codigoError;
    protected LocalDateTime timestamp;

    public SistemaBancarioException(String mensaje) {
        super(mensaje);
        this.timestamp = LocalDateTime.now();
        this.codigoError = "ERR-" + System.currentTimeMillis();
    }
}