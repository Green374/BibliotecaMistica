/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.logica;

/**
 *
 * @author DGG
 */
public class Autor extends Persona{
    private Integer idautor;
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    @Override
    public String toString() {
        return codigo + ", "  + this.getNombre() + " " + this.getApellido();
    }
}
