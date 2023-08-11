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
public class Autores {
    private ArrayList<Autor> autores = new ArrayList();

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }
    
    public void agregarAutor(Autor autor){
        autores.add(autor);
    }
}
