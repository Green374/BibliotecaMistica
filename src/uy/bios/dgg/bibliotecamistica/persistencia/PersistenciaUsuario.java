/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.bios.dgg.bibliotecamistica.excepciones.PersistenciaException;
import uy.bios.dgg.bibliotecamistica.logica.Usuario;


/**
 *
 * @author DGG
 */
public class PersistenciaUsuario {
    private static final String SQL_CONSULTA_EXISTE_USUARIO = ("SELECT * FROM biblioteca_mistica.usuario WHERE nombre=? AND clave=? ");

//metodo para chequear si los datos que me ingreso el usuario estan en la tabla usuario de mi aplicacion
//1. obtener una conexion a la base de datos
//2. crear el statement a ejecutar 
//3. ejecutar la consulta
//4. procesar los resultados
//5. cerrar la conexion
    public Boolean existeUsuario(Usuario usuario) {
        Boolean resultado = false;
        PreparedStatement ps;
        ResultSet rs;
        
        Connection con;
        try {
            //paso1
            con = Conexion.conectar();

            //paso 2
            ps = (PreparedStatement) con.prepareStatement(SQL_CONSULTA_EXISTE_USUARIO);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getClave());
            
            //paso 3
            rs = ps.executeQuery();
            
            //paso 4
            while (rs.next()) {
                resultado = true;
            }
            
            //paso 5
            con.close();
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersistenciaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenciaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}