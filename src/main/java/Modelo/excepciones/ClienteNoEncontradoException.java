/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author Orly02
 */

public class ClienteNoEncontradoException extends SistemaBancarioException {

    private String idCliente;

    public ClienteNoEncontradoException(String mensaje, String idCliente) {
        super(mensaje);
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return "ClienteNoEncontradoException{" +
                "idCliente='" + idCliente + '\'' +
                ", mensaje=" + getMessage() +
                '}';
    }
}