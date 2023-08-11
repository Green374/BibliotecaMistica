/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.logica;

import uy.bios.dgg.bibliotecamistica.excepciones.AutorException;
import uy.bios.dgg.bibliotecamistica.excepciones.CategoriaException;
import uy.bios.dgg.bibliotecamistica.excepciones.LibroException;
import uy.bios.dgg.bibliotecamistica.excepciones.SocioException;
import uy.bios.dgg.bibliotecamistica.persistencia.PersistenciaAutor;
import uy.bios.dgg.bibliotecamistica.persistencia.PersistenciaCategoria;
import uy.bios.dgg.bibliotecamistica.persistencia.PersistenciaLibro;
import uy.bios.dgg.bibliotecamistica.persistencia.PersistenciaSocio;
import uy.bios.dgg.bibliotecamistica.persistencia.PersistenciaUsuario;

/**
 *
 * @author DGG
 */
public class FachadaLogica {
    /*Categoria  */

    public Boolean existeUsuario(Usuario usuario) {
        Boolean resultado = false;
        PersistenciaUsuario pers = new PersistenciaUsuario();
        resultado = pers.existeUsuario(usuario);
        return resultado;
    }
    
    public Categorias obtenerCategorias() throws CategoriaException{
        Categorias categorias;
        PersistenciaCategoria persistenciaCategoria = new PersistenciaCategoria();
        categorias = persistenciaCategoria.obtenerCategorias();
        return categorias;
    }
    
    public Autores obtenerAutores() throws AutorException{
        Autores autores;
        PersistenciaAutor persistenciaAutor = new PersistenciaAutor();
        autores = persistenciaAutor.obtenerAutores();
        return autores;
    }
    
    public Socios obtenerSocios() throws SocioException{
        Socios socios;
        PersistenciaSocio persistenciaSocio = new PersistenciaSocio();
        socios = persistenciaSocio.obtenerSocios();
        return socios;
    }
    
    public Libros obtenerLibros() throws LibroException, AutorException, CategoriaException{
        Libros libros;
        PersistenciaLibro persistenciaLibro = new PersistenciaLibro();
        libros = persistenciaLibro.obtenerLibros();
        return libros;
    }
    
    public Categoria obtenerCategoria(String codigo) throws CategoriaException{
        Categoria categoria;
        PersistenciaCategoria persistenciaCategoria = new PersistenciaCategoria();
        categoria = persistenciaCategoria.obtenerCategoria(codigo);
        return categoria;
    }    

    public Autor obtenerAutor(String codigo) throws AutorException{
        Autor autor;
        PersistenciaAutor persistenciaAutor = new PersistenciaAutor();
        autor = persistenciaAutor.obtenerAutor(codigo);
        return autor;
    }
    
    public Socio obtenerSocio(String docIdentidad) throws SocioException{
        Socio socio;
        PersistenciaSocio persistenciaSocio = new PersistenciaSocio();
        socio = persistenciaSocio.obtenerSocio(docIdentidad);
        return socio;
    }
    
    public Libro obtenerLibro(String codigo) throws LibroException, AutorException, CategoriaException{
        Libro libro;
        PersistenciaLibro persistenciaLibro = new PersistenciaLibro();
        libro = persistenciaLibro.obtenerLibro(codigo);
        return libro;
    }
    
    public void ingresarCategoria(Categoria categoria) throws CategoriaException{
        PersistenciaCategoria persistenciaCategoria = new PersistenciaCategoria();
        persistenciaCategoria.ingresarCategoria(categoria);
    }
    
    public void ingresarAutor(Autor autor) throws AutorException{
        PersistenciaAutor persistenciaAutor = new PersistenciaAutor();
        persistenciaAutor.ingresarAutor(autor);
    }
    
    public void ingresarSocio(Socio socio) throws SocioException{
        PersistenciaSocio persistenciaSocio = new PersistenciaSocio();
        persistenciaSocio.ingresarSocio(socio);
    }
    
    public void ingresarLibro(Libro libro) throws LibroException{
        PersistenciaLibro persistenciaLibro = new PersistenciaLibro();
        persistenciaLibro.ingresarLibro(libro);
    }
    
    public void modificarCategoria(Categoria categoria) throws CategoriaException{
        PersistenciaCategoria persistenciaCategoria = new PersistenciaCategoria();
        persistenciaCategoria.modificarCategoria(categoria);
    }
    
    public void modificarAutor(Autor autor) throws AutorException{
        PersistenciaAutor persistenciaAutor = new PersistenciaAutor();
        persistenciaAutor.modificarAutor(autor);
    }
    
    public void modificarSocio(Socio socio) throws SocioException{
        PersistenciaSocio persistenciaSocio = new PersistenciaSocio();
        persistenciaSocio.modificarSocio(socio);
    }
    
    public void modificarLibro(Libro libro) throws LibroException{
        PersistenciaLibro persistenciaLibro = new PersistenciaLibro();
        persistenciaLibro.modificarLibro(libro);
    }
    
    public void borrarCategoria(Categoria categoria) throws CategoriaException {
        PersistenciaCategoria persistenciaCategoria = new PersistenciaCategoria();
        persistenciaCategoria.borrarCategoria(categoria);
    }
    
    public void borrarAutor(Autor autor) throws AutorException {
        PersistenciaAutor persistenciaAutor = new PersistenciaAutor();
        persistenciaAutor.borrarAutor(autor);
    }
    
    public void borrarSocio(Socio socio) throws SocioException {
        PersistenciaSocio persistenciaSocio = new PersistenciaSocio();
        persistenciaSocio.borrarSocio(socio);
    }
    
    public void borrarLibro(Libro libro) throws LibroException {
        PersistenciaLibro persistenciaLibro = new PersistenciaLibro();
        persistenciaLibro.borrarLibro(libro);
    }
    
}
