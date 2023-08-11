/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.logica;

/**
 *
 * @author dasm2
 */
public class Libro {
    private Integer idLibro;
    private String codigo;
    private String titulo;
    private Integer anioEdicion;
    private Boolean disponible = true;
    private Autor autor;
    private Categoria categoria;
    
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(Integer anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Integer getIdlibro() {
        return idLibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idLibro = idlibro;
    }

    @Override
    public String toString() {
        String disponibilidad = "No disponible";
        if (disponible){
            disponibilidad = "Disponible";
        }
        return codigo + ", " + titulo + ", " + anioEdicion  + ", " + autor.getNombre() + " " + autor.getApellido() + ", " + categoria.getDescripcion() + ", " + disponibilidad ;
    } 
}
