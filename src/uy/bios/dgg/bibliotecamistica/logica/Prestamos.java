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
public class Prestamos {
    private ArrayList<Prestamo> prestamos = new ArrayList();

    public void agregarPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
