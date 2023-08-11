/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import uy.bios.dgg.bibliotecamistica.excepciones.AutorException;
import uy.bios.dgg.bibliotecamistica.excepciones.CategoriaException;
import uy.bios.dgg.bibliotecamistica.excepciones.LibroException;
import uy.bios.dgg.bibliotecamistica.excepciones.PersistenciaException;
import uy.bios.dgg.bibliotecamistica.logica.Autor;
import uy.bios.dgg.bibliotecamistica.logica.Categoria;
import uy.bios.dgg.bibliotecamistica.logica.Libro;
import uy.bios.dgg.bibliotecamistica.logica.Libros;

/**
 *
 * @author DGG
 */
public class PersistenciaLibro {
//Campos: idlibro, codigolibro, libroTitulo, libroAnio, libroAlta, libroBaja, idautor, idcategoria    
    private static final String SQL_OBTENER_LIBROS = "SELECT * FROM biblioteca_mistica.libro WHERE libroBaja IS NULL ORDER BY libroTitulo";
    private static final String SQL_OBTENER_LIBRO = "SELECT * FROM biblioteca_mistica.libro WHERE libroCodigo=? AND libroBaja IS NULL";
    private static final String SQL_OBTENER_LIBRO_ID = "SELECT * FROM biblioteca_mistica.libro WHERE idlibro=?";
    private static final String SQL_INSERTAR_LIBRO = "INSERT INTO biblioteca_mistica.libro (libroCodigo, libroTitulo, libroAnio, libroAlta, idautor, idcategoria) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_MODIFICAR_LIBRO = "UPDATE biblioteca_mistica.libro SET libroCodigo = ?, libroTitulo = ?, libroAnio = ?, idautor = ?, idcategoria = ? WHERE idlibro = ?";
    private static final String SQL_BORRAR_LIBRO = "UPDATE biblioteca_mistica.libro SET libroBaja = ?  WHERE idlibro = ?";
//Receta:
//1. obtener una conexion a la base de datos
//2. crear el statement a ejecutar 
//3. ejecutar la consulta
//4. procesar los resultados
//5. cerrar la conexion

    public void ingresarLibro(Libro libro) throws LibroException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERTAR_LIBRO);
            ps.setString(1, libro.getCodigo());
            ps.setString(2, libro.getTitulo());
            ps.setInt(3, libro.getAnioEdicion());
            
            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(4, ahora);            
            
            ps.setInt(5, libro.getAutor().getIdautor());
            ps.setInt(6, libro.getCategoria().getIdcategoria());        

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
        } catch (java.sql.SQLIntegrityConstraintViolationException ex ) {
            throw new LibroException("No fue posible ingresar el libro, el código ya existe.");
        } catch (SQLException ex ) {
            throw new LibroException("No fue posible ingresar el Libro.");
        } catch (PersistenciaException ex) {
            throw new LibroException("No fue posible establecer la conexión.");
        }
    }

    public void modificarLibro(Libro libro) throws LibroException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_MODIFICAR_LIBRO);
            ps.setString(1, libro.getCodigo());
            ps.setString(2, libro.getTitulo());
            ps.setInt(3, libro.getAnioEdicion());
            ps.setInt(4, libro.getAutor().getIdautor());
            ps.setInt(5, libro.getCategoria().getIdcategoria());
            ps.setInt(6, libro.getIdlibro());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
            
        } catch (java.sql.SQLIntegrityConstraintViolationException ex ) {
            throw new LibroException("No fue posible modificar el libro, el código ya existe.");            
        } catch (SQLException ex) {
            throw new LibroException("No fue posible modificar el libro.");
        } catch (PersistenciaException ex) {
//            Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibroException("No fue posible establecer la conexión.");
        }
    }

    public Libro obtenerLibro(String codigo) throws LibroException, AutorException, CategoriaException {
        Libro libro = new Libro();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_LIBRO);
            ps.setString(1, codigo);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                libro.setIdlibro(rs.getInt("idlibro"));
                libro.setCodigo(rs.getString("libroCodigo"));
                libro.setTitulo(rs.getString("libroTitulo"));
                libro.setAnioEdicion(rs.getInt("libroAnio"));              
                libro.setDisponible(rs.getBoolean("libroDisponible"));
                PersistenciaAutor persistenciaAutor = new PersistenciaAutor();
                Autor autor = persistenciaAutor.obtenerAutor(rs.getInt("idautor"));
                libro.setAutor(autor);
                PersistenciaCategoria persistenciaCategoria = new PersistenciaCategoria();
                Categoria categoria = persistenciaCategoria.obtenerCategoria(rs.getInt("idcategoria"));
                libro.setCategoria(categoria);
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new LibroException("No fue posible obtener el libro.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaLibro.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibroException("No fue posible establecer la conexión.");
        }
        return libro;
    }
    
    public Libro obtenerLibro(Integer idlibro) throws LibroException, AutorException, CategoriaException {
        Libro libro = new Libro();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_LIBRO_ID);
            ps.setInt(1, idlibro);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                libro.setIdlibro(rs.getInt("idlibro"));
                libro.setCodigo(rs.getString("libroCodigo"));
                libro.setTitulo(rs.getString("libroTitulo"));
                libro.setAnioEdicion(rs.getInt("libroAnio"));              
                libro.setDisponible(rs.getBoolean("libroDisponible"));
                PersistenciaAutor persistenciaAutor = new PersistenciaAutor();
                Autor autor = persistenciaAutor.obtenerAutor(rs.getInt("idautor"));
                libro.setAutor(autor);
                PersistenciaCategoria persistenciaCategoria = new PersistenciaCategoria();
                Categoria categoria = persistenciaCategoria.obtenerCategoria(rs.getInt("idcategoria"));
                libro.setCategoria(categoria);
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new LibroException("No fue posible obtener el libro.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaLibro.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibroException("No fue posible establecer la conexión.");
        }
        return libro;
    }

    public Libros obtenerLibros() throws LibroException, AutorException, CategoriaException {
        PreparedStatement ps;
        ResultSet rs;
        Libros libros = new Libros();
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_LIBROS);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setIdlibro(rs.getInt("idlibro"));
                libro.setCodigo(rs.getString("libroCodigo"));
                libro.setTitulo(rs.getString("libroTitulo"));
                libro.setAnioEdicion(rs.getInt("libroAnio"));
                libro.setDisponible(rs.getBoolean("libroDisponible"));
                PersistenciaAutor persistenciaAutor = new PersistenciaAutor();
                Autor autor = persistenciaAutor.obtenerAutor(rs.getInt("idautor"));
                libro.setAutor(autor);
                PersistenciaCategoria persistenciaCategoria = new PersistenciaCategoria();
                Categoria categoria = persistenciaCategoria.obtenerCategoria(rs.getInt("idcategoria"));
                libro.setCategoria(categoria);                
                libros.agregarLibro(libro); 
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new LibroException("No fue posible obtener el libro.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaLibro.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibroException("No fue posible establecer la conexión.");
        }
        return libros;
    }

    public void borrarLibro(Libro libro) throws LibroException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_BORRAR_LIBRO);
            
            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(1, ahora);
            
            ps.setInt(2, libro.getIdlibro());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new LibroException("No fue posible borrar el libro.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaLibro.class.getName()).log(Level.SEVERE, null, ex);
            throw new LibroException("No fue posible establecer la conexión.");
        }
    }
}
