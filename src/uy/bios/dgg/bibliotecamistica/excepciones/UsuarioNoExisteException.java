/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.excepciones;

/**
 *
 * @author DGG
 */
public class UsuarioNoExisteException extends Exception{

    /**
     * Creates a new instance of <code>UsuarioNoExisteException</code> without
     * detail message.
     */
    public UsuarioNoExisteException() {
    }

    /**
     * Constructs an instance of <code>UsuarioNoExisteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UsuarioNoExisteException(String msg) {
        super(msg);
    }
}
