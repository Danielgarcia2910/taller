/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.excepciones;

public class ClienteNoEncontradoException extends SistemaBancarioException {

    private String idCliente;

    public ClienteNoEncontradoException(String idCliente) {
        super("cliente no encontrado: " + idCliente, "CLI-001");
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    @Override
    public String toString() {
        return super.toString() + " | ID: " + idCliente;
    }
}