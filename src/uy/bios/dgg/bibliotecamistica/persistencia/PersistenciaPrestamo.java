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
import uy.bios.dgg.bibliotecamistica.excepciones.PrestamoException;
import uy.bios.dgg.bibliotecamistica.excepciones.SocioException;
import uy.bios.dgg.bibliotecamistica.logica.Libro;
import uy.bios.dgg.bibliotecamistica.logica.Prestamo;
import uy.bios.dgg.bibliotecamistica.logica.Prestamos;
import uy.bios.dgg.bibliotecamistica.logica.Socio;

/**
 *
 * @author DGG
 */
public class PersistenciaPrestamo {
//Campos: idprestamo, prestamoFecha, prestamoFechaDevolucion, prestamoEstadoDevolucion, idsocio, idlibro   
    private static final String SQL_OBTENER_PRESTAMOS = "SELECT * FROM biblioteca_mistica.prestamo WHERE prestamoFechaDevolucion IS NULL";
    private static final String SQL_OBTENER_PRESTAMOS_SOCIO = "SELECT * FROM biblioteca_mistica.prestamo WHERE idsocio=? AND prestamoFechaDevolucion IS NULL";
    private static final String SQL_OBTENER_PRESTAMO_LIBRO = "SELECT * FROM biblioteca_mistica.prestamo WHERE idLibro=? AND prestamoFechaDevolucion IS NULL";
    private static final String SQL_INSERTAR_PRESTAMO = "INSERT INTO biblioteca_mistica.prestamo (prestamoFecha, idsocio, idlibro) VALUES (?, ?, ?)";
    private static final String SQL_MODIFICAR_PRESTAMO = "UPDATE biblioteca_mistica.prestamo SET idsocio = ?, idlibro = ? WHERE idprestamo = ?";
    private static final String SQL_DEVOLVER_PRESTAMO = "UPDATE biblioteca_mistica.prestamo SET prestamoFechaDevolucion = ?  WHERE idprestamo = ?";
//Receta:
//1. obtener una conexion a la base de datos
//2. crear el statement a ejecutar 
//3. ejecutar la consulta
//4. procesar los resultados
//5. cerrar la conexion
    // Crea un objeto Prestamo desde los datos de un resultSet
    private Prestamo crearPrestamo(ResultSet rs) throws SQLException, SocioException, LibroException, AutorException, CategoriaException {
        Prestamo prestamo = new Prestamo();
        prestamo.setIdprestamo(rs.getInt("idprestamo"));
        prestamo.setFechaPrestamo((Date) rs.getDate("prestamoFecha"));
        prestamo.setEstadoDevolucion(rs.getString("prestamoEstadoDevolucion"));       
        if (rs.getDate("prestamoFechaDevolucion") != null){
            prestamo.setFechaDevolucion((Date) rs.getDate("prestamoFechaDevolucion"));
        }
        PersistenciaSocio persistenciaSocio = new PersistenciaSocio();
        Socio socio = persistenciaSocio.obtenerSocio(rs.getInt("idsocio"));
        prestamo.setSocio(socio);
        PersistenciaLibro persistenciaLibro = new PersistenciaLibro();
        Libro libro = persistenciaLibro.obtenerLibro("idlibro");
        prestamo.setLibro(libro);
        return prestamo;
    }    
    
    public void ingresarPrestamo(Prestamo prestamo) throws LibroException, PrestamoException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();
            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERTAR_PRESTAMO);
            //prestamoFecha, idsocio, idlibro            
            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(1, ahora);            
            ps.setInt(2, prestamo.getSocio().getIdSocio());
            ps.setInt(3, prestamo.getLibro().getIdlibro());
            //paso 3
            ps.executeUpdate();
            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new PrestamoException("No fue posible ingresar el préstamo.");
        } catch (PersistenciaException ex) {
            throw new PrestamoException("No fue posible establecer la conexión.");
        }
    }

    public void modificarPrestamo(Prestamo prestamo) throws PrestamoException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();
            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_MODIFICAR_PRESTAMO);
            ps.setInt(1, prestamo.getSocio().getIdSocio());
            ps.setInt(2, prestamo.getLibro().getIdlibro());
            ps.setInt(3, prestamo.getIdprestamo());
            //paso 3
            ps.executeUpdate();
            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new PrestamoException("No fue posible modificar el préstamo.");
        } catch (PersistenciaException ex) {
            throw new PrestamoException("No fue posible establecer la conexión.");
        }
    }

    public Prestamo obtenerPrestamoLibro(Integer idlibro) throws LibroException, AutorException, CategoriaException, PrestamoException, SocioException {
        Prestamo prestamo = new Prestamo();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();
            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_PRESTAMO_LIBRO);
            ps.setInt(1, idlibro);
            //paso 3
            rs = ps.executeQuery();
            //pase4
            while (rs.next()) {
                prestamo = crearPrestamo(rs);
            }
            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new PrestamoException("No fue posible obtener el préstamo.");
        } catch (PersistenciaException ex) {
            throw new PrestamoException("No fue posible establecer la conexión.");
        }
        return prestamo;
    }

    public Prestamos obtenerPrestamos() throws LibroException, AutorException, CategoriaException, PrestamoException, SocioException {
        PreparedStatement ps;
        ResultSet rs;
        Prestamos prestamos = new Prestamos();
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();
            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_PRESTAMOS);
            //paso 3
            rs = ps.executeQuery();
            //pase4
            while (rs.next()) {
                Prestamo prestamo = crearPrestamo(rs);
                prestamos.agregarPrestamo(prestamo);
            }
            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new PrestamoException("No fue posible obtener el préstamo.");
        } catch (PersistenciaException ex) {
            throw new PrestamoException("No fue posible establecer la conexión.");
        }
        return prestamos;
    }
    
    public Prestamos obtenerPrestamosSocio(Socio socio) throws LibroException, AutorException, CategoriaException, PrestamoException, SocioException {
        PreparedStatement ps;
        ResultSet rs;
        Prestamos prestamos = new Prestamos();
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();
            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_PRESTAMOS_SOCIO);
            ps.setInt(1, socio.getIdSocio());
            //paso 3
            rs = ps.executeQuery();
            //pase4
            while (rs.next()) {
                Prestamo prestamo = crearPrestamo(rs);
                prestamos.agregarPrestamo(prestamo);
            }
            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new PrestamoException("No fue posible obtener el préstamo.");
        } catch (PersistenciaException ex) {
            throw new PrestamoException("No fue posible establecer la conexión.");
        }
        return prestamos;
    }

    public void devolverPrestamo(Prestamo prestamo) throws PrestamoException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();
            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_DEVOLVER_PRESTAMO);
            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(1, ahora);
            ps.setInt(2, prestamo.getIdprestamo());
            //paso 3
            ps.executeUpdate();
            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new PrestamoException("No fue posible realizar la devolución.");
        } catch (PersistenciaException ex) {
            throw new PrestamoException("No fue posible establecer la conexión.");
        }
    }
}
