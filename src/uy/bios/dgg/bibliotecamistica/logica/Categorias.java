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
public class Categorias {
    private ArrayList<Categoria> categorias = new ArrayList();

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public void agregarCategoria(Categoria categoria){
        categorias.add(categoria);
    }
}
