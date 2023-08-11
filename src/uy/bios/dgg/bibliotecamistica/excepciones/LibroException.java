/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.excepciones;

/**
 *
 * @author DGG
 */
public class LibroException extends Exception {

    /**
     * Creates a new instance of <code>SocioException</code> without detail
     * message.
     */
    public LibroException() {
    }

    /**
     * Constructs an instance of <code>SocioException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LibroException(String msg) {
        super(msg);
    }
}
