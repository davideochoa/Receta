/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receta.BitacoraExistenciaExterna;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Usuario
 */
public class Conexion {
    static private DataSource dataSource;
    static private Connection connection;
    static private Statement statement;
    public Conexion() {        
        getDataSource();
        getConnection();            
        getSentencia();
    }
    
    static public void close(){
        try {            
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println();     
            System.out.println(ex.getMessage());                
        }
    }

    static private void getDataSource() {        
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/receta");
        } catch (NamingException ex) {
            System.out.println();     
            System.out.println(ex.getMessage()); 
        }
    }

    static private void getConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            System.out.println();     
            System.out.println(ex.getMessage());  
        }
    }

    static public Statement getSentencia() {
        getDataSource();
        getConnection();
        
        try {    
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            System.out.println();     
            System.out.println(ex.getMessage());  
            statement = null;
        }
        return statement;
    }
}
