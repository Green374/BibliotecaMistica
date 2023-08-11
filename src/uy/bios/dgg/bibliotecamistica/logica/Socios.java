/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.logica;

import java.util.ArrayList;

/**
 *
 * @author Vale
 */
public class Socios {
    private ArrayList<Socio> socios = new ArrayList();

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }
    
    public void agregarSocio(Socio socio){
        socios.add(socio);
    }
    
}
