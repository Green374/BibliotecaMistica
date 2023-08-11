/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.bios.dgg.bibliotecamistica.excepciones.PersistenciaException;


/**
 *
 * @author DGG
 */

public class Conexion {
  
    public static Connection conectar() throws PersistenciaException {
        //jdbc:mysql://localhost:3306/biblioteca_mistica?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca_mistica?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "password");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("No encontré el driver de BASE DE DATOS");
        } catch (InstantiationException exInst) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, exInst);
            throw new PersistenciaException("No encontré instanciación  BASE DE DATOS");
        } catch (IllegalAccessException exIllegal) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, exIllegal);
            throw new PersistenciaException("Acceso ilegal a la BASE DE DATOS");
        } catch (SQLException eSql) {
            throw new PersistenciaException("REVISA EL SQL la BASE DE DATOS");
        }
        return con;
    }
}