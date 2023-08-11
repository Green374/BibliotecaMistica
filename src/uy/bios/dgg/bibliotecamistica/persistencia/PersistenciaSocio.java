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
import uy.bios.dgg.bibliotecamistica.excepciones.PersistenciaException;
import uy.bios.dgg.bibliotecamistica.excepciones.SocioException;
import uy.bios.dgg.bibliotecamistica.logica.Socio;
import uy.bios.dgg.bibliotecamistica.logica.Socios;

/**
 *
 * @author Green
 */
public class PersistenciaSocio {
//idsocio, socioDocIdentidad, socioNombre, socioApellido, socioNacionalidad, socioDireccion, socioTelefono, socioEmail, socioAlta, socioBaja
    private static final String SQL_OBTENER_SOCIOS = "SELECT * FROM biblioteca_mistica.socio WHERE socioBaja IS NULL ORDER BY socioNombre, socioApellido";
    private static final String SQL_OBTENER_SOCIO = "SELECT * FROM biblioteca_mistica.socio WHERE socioDocIdentidad=? AND socioBaja IS NULL";
    private static final String SQL_OBTENER_SOCIO_ID = "SELECT * FROM biblioteca_mistica.socio WHERE idsocio=?";
    private static final String SQL_INSERTAR_SOCIO = "INSERT INTO biblioteca_mistica.socio (socioDocIdentidad, socioNombre, socioApellido, socioNacionalidad, socioDireccion, socioTelefono, socioEmail, socioAlta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_MODIFICAR_SOCIO = "UPDATE biblioteca_mistica.socio SET socioDocIdentidad = ? ,socioNombre = ? ,socioApellido = ? ,socioNacionalidad = ? ,socioDireccion = ? ,socioTelefono = ? ,socioEmail = ? WHERE idsocio = ?";
    private static final String SQL_BORRAR_SOCIO = "UPDATE biblioteca_mistica.socio SET socioBaja = ?  WHERE idsocio = ?";

//Receta:
//1. obtener una conexion a la base de datos
//2. crear el statement a ejecutar 
//3. ejecutar la consulta
//4. procesar los resultados
//5. cerrar la conexion
    
    public void ingresarSocio(Socio socio) throws SocioException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_INSERTAR_SOCIO);
            ps.setString(1, socio.getDocIdentidad());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setString(4, socio.getNacionalidad());
            ps.setString(5, socio.getDireccion());
            ps.setString(6, socio.getTelefono());
            ps.setString(7, socio.getEmail());
            
            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(8, ahora);
            
            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
        } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
            throw new SocioException("No fue posible ingresar el socio, el socio ya existe.");
        } catch (SQLException ex) {
            throw new SocioException("No fue posible ingresar el socio hola es aqui?.");
        } catch (PersistenciaException ex) {
            throw new SocioException("No fue posible establecer la conexión.");
        }
    }

    public void modificarSocio(Socio socio) throws SocioException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_MODIFICAR_SOCIO);
            ps.setString(1, socio.getDocIdentidad());
            ps.setString(2, socio.getNombre());
            ps.setString(3, socio.getApellido());
            ps.setString(4, socio.getNacionalidad());
            ps.setString(5, socio.getDireccion());
            ps.setString(6, socio.getTelefono());
            ps.setString(7, socio.getEmail());
            ps.setInt(8, socio.getIdSocio());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();

        } catch (java.sql.SQLIntegrityConstraintViolationException ex) {
            throw new SocioException("No fue posible modificar el socio, el socio ya existe.");
        } catch (SQLException ex) {
            throw new SocioException("No fue posible modificar el socio.");
        } catch (PersistenciaException ex) {
//            Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new SocioException("No fue posible establecer la conexión.");
        }
    }

    public Socio obtenerSocio(String docIdentidad) throws SocioException {
        Socio socio = new Socio();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_SOCIO);
            ps.setString(1, docIdentidad);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                socio.setIdSocio(rs.getInt("idsocio"));
                socio.setDocIdentidad(rs.getString("socioDocIdentidad"));
                socio.setDireccion(rs.getString("socioDireccion"));
                socio.setNacionalidad(rs.getString("socioNacionalidad"));
                socio.setEmail(rs.getString("socioEmail"));
                socio.setNombre(rs.getString("socioNombre"));
                socio.setApellido(rs.getString("socioApellido"));
                socio.setTelefono(rs.getString("socioTelefono"));
                socio.setAlta(rs.getDate("socioAlta"));
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new SocioException("No fue posible obtener el socio.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new SocioException("No fue posible establecer la conexión.");
        }
        return socio;
    }

    public Socio obtenerSocio(Integer idsocio) throws SocioException {
        Socio socio = new Socio();
        PreparedStatement ps;
        ResultSet rs;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_SOCIO_ID);
            ps.setInt(1, idsocio);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                socio.setIdSocio(rs.getInt("idsocio"));
                socio.setDocIdentidad(rs.getString("socioDocIdentidad"));
                socio.setDireccion(rs.getString("socioDireccion"));
                socio.setNacionalidad(rs.getString("socioNacionalidad"));
                socio.setEmail(rs.getString("socioEmail"));
                socio.setNombre(rs.getString("socioNombre"));
                socio.setApellido(rs.getString("socioApellido"));
                socio.setTelefono(rs.getString("socioTelefono"));
                socio.setAlta(rs.getDate("socioAlta"));
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new SocioException("No fue posible obtener el socio.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new SocioException("No fue posible establecer la conexión.");
        }
        return socio;
    }

    public Socios obtenerSocios() throws SocioException {
        PreparedStatement ps;
        ResultSet rs;
        Socios socios = new Socios();
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_OBTENER_SOCIOS);

            //paso 3
            rs = ps.executeQuery();

            //pase4
            while (rs.next()) {
                Socio socio = new Socio();
                socio.setIdSocio(rs.getInt("idsocio"));
                socio.setDocIdentidad(rs.getString("socioDocIdentidad"));
                socio.setDireccion(rs.getString("socioDireccion"));
                socio.setNacionalidad(rs.getString("socioNacionalidad"));
                socio.setEmail(rs.getString("socioEmail"));
                socio.setNombre(rs.getString("socioNombre"));
                socio.setApellido(rs.getString("socioApellido"));
                socio.setTelefono(rs.getString("socioTelefono"));
                socio.setAlta(rs.getDate("socioAlta"));
                socios.agregarSocio(socio);
            }

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new SocioException("No fue posible obtener el socio.");
        } catch (PersistenciaException ex) {
            //Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new SocioException("No fue posible establecer el socio.");
        }
        return socios;
    }

    public void borrarSocio(Socio socio) throws SocioException {
        PreparedStatement ps;
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_BORRAR_SOCIO);

            Date hoy = new Date();
            java.sql.Date ahora = new java.sql.Date(hoy.getTime());
            ps.setDate(1, ahora);
            ps.setInt(2, socio.getIdSocio());

            //paso 3
            ps.executeUpdate();

            //paso 5
            con.close();
        } catch (SQLException ex) {
            throw new SocioException("No fue posible borrar el socio.");
        } catch (PersistenciaException ex) {
            // Logger.getLogger(PersistenciaCategoria.class.getName()).log(Level.SEVERE, null, ex);
            throw new SocioException("No fue posible establecer la conexión.");
        }
    }
}
