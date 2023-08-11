/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.logica;

import java.util.ArrayList;

/**
 *
 * @author DGG
 */
public class Libros {
    private ArrayList<Libro> libros = new ArrayList();

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    public void agregarLibro(Libro libro){
        libros.add(libro);
    }
}
