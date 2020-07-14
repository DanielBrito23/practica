/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Asus
 */
public class pgConect {
        private final static String cadenaConexion = "jdbc:postgresql://database-1.cmcd0p4ioiqd.us-east-1.rds.amazonaws.com:5432/AWSdatabase";
    private final static String pgusuario = "postgres";
    private final static String pgpass = "12345678";
    
   
    

    private Connection con;
    private Statement st;
    private ResultSet rs;

    

    public pgConect() {
        conectar();
    }
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(cadenaConexion, pgusuario, pgpass);
           return con; 
        } catch (SQLException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
            return null;        
        }
    }
    
    public PreparedStatement getPs(String sql) {
        try {
            return con.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public SQLException noquery(PreparedStatement ps) {
        try {
            int res = ps.executeUpdate();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }

    public SQLException noquery(String sql) {
        try {
            st = con.createStatement();
            st.execute(sql);
            st.close();
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }

    public ResultSet query(String sql) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(pgConect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
}
