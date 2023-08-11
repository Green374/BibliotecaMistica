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
import uy.bios.dgg.bibliotecamistica.excepciones.CategoriaException;
import uy.bios.dgg.bibliotecamistica.excepciones.PersistenciaException;
import uy.bios.dgg.bibliotecamistica.logica.Categoria;
import uy.bios.dgg.bibliotecamistica.logica.Categorias;

/**
 *
 * @author DGG
 */
public class PersistenciaCategoria {
//Campos: idcategoria, categoriaCodigo, categoriaDescripcion, categoriaBaja
    private static final String SQL_OBTENER_CATEGORIAS = "SELECT * FROM biblioteca_mistica.categoria WHERE categoriaBaja IS NULL ORDER BY categoriaDescripcion";
    private static final String SQL_OBTENER_CATEGORIA = "SELECT * FROM biblioteca_mistica.categoria WHERE categoriaCodigo=? AND categoriaBaja IS NULL";
    private static final String SQL_OBTENER_CATEGORIA_ID = "SELECT * FROM biblioteca_mistica.categoria WHERE idcategoria=?";
    private static final String SQL_INSERTAR_CATEGORIA = "INSERT INTO biblioteca_mistica.categoria (categoriaCodigo, categoriaDescripcion) VALUES (?, ?)";
    private static final String SQL_MODIFICAR_CATEGORIA = "UPDATE biblioteca_mistica.categoria SET categoriaCodigo = ? ,categoriaDescripcion = ? WHERE idcategoria = ?";
    private static final String SQL_BORRAR_CATEGORIA = "UPDATE biblioteca_mistica.categoria SET categoriaBaja = ?  WHERE idcategoria = ?";
//Receta:
//1. obtener una conexion a la base de datos
//2. crear el statement a ejecutar 
//3. ejecutar la consulta
//4. procesar los resultados
//5. cerrar la conexion

    public void ingresarCategoria(Categoria categoria) throws CategoriaException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERTAR_CATEGORIA);
            ps.setString(1, categoria.getCodigo());
            ps.setString(2, categoria.getDescripcion());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
        } catch (java.sql.SQLIntegrityConstraintViolationException ex ) {
            throw new CategoriaException("No fue posible ingresar la categoria, el código ya existe.");
        } catch (SQLException ex ) {
            throw new CategoriaException("No fue posible ingresar la categoria.");
        } catch (PersistenciaException ex) {
            throw new CategoriaException("No fue posible establecer la conexión.");
        }
    }

    public void modificarCategoria(Categoria categoria) throws CategoriaException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_MODIFICAR_CATEGORIA);
            ps.setString(1, categoria.getCodigo());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getIdcategoria());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
            
        } catch (java.sql.SQLIntegrityConstraintViolationException ex ) {
            throw new CategoriaException("No fue posible modificar la categoria, el código ya existe.");            
        } catch (SQLException ex) {
            throw new CategoriaException("No fue posible modificar la categoria.");
        } catch (PersistenciaException ex) {
//            Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new CategoriaException("No fue posible establecer la conexión.");
        }
    }

    public Categoria obtenerCategoria(String codigo) throws CategoriaException {
        Categoria categoria = new Categoria();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_CATEGORIA);
            ps.setString(1, codigo);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                categoria.setIdcategoria(rs.getInt("idcategoria"));
                categoria.setCodigo(rs.getString("categoriaCodigo"));
                categoria.setDescripcion(rs.getString("categoriaDescripcion"));
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new CategoriaException("No fue posible obtener la categoria.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new CategoriaException("No fue posible establecer la conexión.");
        }
        return categoria;
    }

    public Categoria obtenerCategoria(Integer idcategoria) throws CategoriaException {
        Categoria categoria = new Categoria();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_CATEGORIA_ID);
            ps.setInt(1, idcategoria);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                categoria.setIdcategoria(rs.getInt("idcategoria"));
                categoria.setCodigo(rs.getString("categoriaCodigo"));
                categoria.setDescripcion(rs.getString("categoriaDescripcion"));
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new CategoriaException("No fue posible obtener la categoria.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new CategoriaException("No fue posible establecer la conexión.");
        }
        return categoria;    
    }
    
    public Categorias obtenerCategorias() throws CategoriaException {
        PreparedStatement ps;
        ResultSet rs;
        Categorias categorias = new Categorias();
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_CATEGORIAS);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdcategoria(rs.getInt("idcategoria"));
                categoria.setCodigo(rs.getString("categoriaCodigo"));
                categoria.setDescripcion(rs.getString("categoriaDescripcion"));
                categorias.agregarCategoria(categoria);
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new CategoriaException("No fue posible obtener la categoria.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new CategoriaException("No fue posible establecer la conexión.");
        }
        return categorias;
    }

    public void borrarCategoria(Categoria categoria) throws CategoriaException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_BORRAR_CATEGORIA);
            
            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(1, ahora);
            
            ps.setInt(2, categoria.getIdcategoria());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new CategoriaException("No fue posible borrar la categoria.");
        } catch (PersistenciaException ex) {
           // Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new CategoriaException("No fue posible establecer la conexión.");
        }
    }
}