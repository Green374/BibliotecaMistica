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
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.bios.dgg.bibliotecamistica.excepciones.AutorException;
import uy.bios.dgg.bibliotecamistica.excepciones.PersistenciaException;
import uy.bios.dgg.bibliotecamistica.logica.Autor;
import uy.bios.dgg.bibliotecamistica.logica.Autores;

/**
 *
 * @author DGG
 */
public class PersistenciaAutor {
//Campos: idautor, autorCodigo, autorNombre, autorApellido, autorNacionalidad, autorAlta, autorBaja   

    private static final String SQL_OBTENER_AUTORES = "SELECT * FROM biblioteca_mistica.autor WHERE autorBaja IS NULL ORDER BY autorNombre, autorApellido";
    private static final String SQL_OBTENER_AUTOR_ID = "SELECT * FROM biblioteca_mistica.autor WHERE idautor=?";
    private static final String SQL_OBTENER_AUTOR = "SELECT * FROM biblioteca_mistica.autor WHERE autorCodigo=? AND autorBaja IS NULL";
    private static final String SQL_INSERTAR_AUTOR = "INSERT INTO biblioteca_mistica.autor (autorCodigo, autorNombre, autorApellido, autorNacionalidad, autorAlta) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_MODIFICAR_AUTOR = "UPDATE biblioteca_mistica.autor SET autorCodigo = ?, autorNombre = ?, autorApellido = ?, autorNacionalidad = ? WHERE idautor = ?";
    private static final String SQL_BORRAR_AUTOR = "UPDATE biblioteca_mistica.autor SET autorBaja = ?  WHERE idautor = ?";
//Receta:
//1. obtener una conexion a la base de datos
//2. crear el statement a ejecutar 
//3. ejecutar la consulta
//4. procesar los resultados
//5. cerrar la conexion

    public void ingresarAutor(Autor autor) throws AutorException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERTAR_AUTOR);
            ps.setString(1, autor.getCodigo());
            ps.setString(2, autor.getNombre());
            ps.setString(3, autor.getApellido());
            ps.setString(4, autor.getNacionalidad());
            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(5, ahora);

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
        } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
            throw new AutorException("No fue posible ingresar el autor, el código ya existe.");
        } catch (SQLException ex) {
            throw new AutorException("No fue posible ingresar el autor.");
        } catch (PersistenciaException ex) {
            throw new AutorException("No fue posible establecer la conexión.");
        }
    }

    public void modificarAutor(Autor autor) throws AutorException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_MODIFICAR_AUTOR);
            ps.setString(1, autor.getCodigo());
            ps.setString(2, autor.getNombre());
            ps.setString(3, autor.getApellido());
            ps.setString(4, autor.getNacionalidad());
            ps.setInt(5, autor.getIdautor());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();

        } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
            throw new AutorException("No fue posible modificar el autor, el código ya existe.");
        } catch (SQLException ex) {
            throw new AutorException("No fue posible modificar el autor.");
        } catch (PersistenciaException ex) {
//            Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new AutorException("No fue posible establecer la conexión.");
        }
    }

    public Autor obtenerAutor(String codigo) throws AutorException {
        Autor autor = new Autor();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_AUTOR);
            ps.setString(1, codigo);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                autor.setIdautor(rs.getInt("idautor"));
                autor.setCodigo(rs.getString("autorCodigo"));
                autor.setNombre(rs.getString("autorNombre"));
                autor.setApellido(rs.getString("autorApellido"));
                autor.setNacionalidad(rs.getString("autorNacionalidad"));
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new AutorException("No se encontró el autor.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaAutor.class.getName()).log(Level.SEVERE, null, ex);
            throw new AutorException("No fue posible establecer la conexión.");
        }
        return autor;
    }

    public Autores obtenerAutores() throws AutorException {
        PreparedStatement ps;
        ResultSet rs;
        Autores autores = new Autores();
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_AUTORES);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                Autor autor = new Autor();
                autor.setIdautor(rs.getInt("idautor"));
                autor.setCodigo(rs.getString("autorCodigo"));
                autor.setNombre(rs.getString("autorNombre"));
                autor.setApellido(rs.getString("autorApellido"));
                autor.setNacionalidad(rs.getString("autorNacionalidad"));
                autores.agregarAutor(autor);
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new AutorException("No fue posible modificar el autor.");
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersistenciaAutor.class.getName()).log(Level.SEVERE, null, ex);
            throw new AutorException("No fue posible establecer la conexión.");
        }
        return autores;
    }

    public void borrarAutor(Autor autor) throws AutorException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_BORRAR_AUTOR);

            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(1, ahora);

            ps.setInt(2, autor.getIdautor());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new AutorException("No fue posible borrar el autor.");
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersistenciaAutor.class.getName()).log(Level.SEVERE, null, ex);
            throw new AutorException("No fue posible establecer la conexión.");
        }
    }

    public Autor obtenerAutor(Integer idAutor) throws AutorException {
        Autor autor = new Autor();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_AUTOR_ID);
            ps.setInt(1, idAutor);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                autor.setIdautor(rs.getInt("idautor"));
                autor.setCodigo(rs.getString("autorCodigo"));
                autor.setNombre(rs.getString("autorNombre"));
                autor.setApellido(rs.getString("autorApellido"));
                autor.setNacionalidad(rs.getString("autorNacionalidad"));
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new AutorException("No fue posible obtener el autor.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaAutor.class.getName()).log(Level.SEVERE, null, ex);
            throw new AutorException("No fue posible establecer la conexión.");
        }
        return autor;
    }
}
