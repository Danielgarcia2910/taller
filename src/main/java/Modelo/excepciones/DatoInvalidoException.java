/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.excepciones;

/**
 *
 * @author Orly02
 */
public class DatoInvalidoException extends BancoRuntimeException {


    private String campo;
    private Object valorRecibido;

   public DatoInvalidoException(String campo, Object valorRecibido) {
    super("Dato inválido en el campo: " + campo);
    this.campo = campo;
    this.valorRecibido = valorRecibido;
}
   }