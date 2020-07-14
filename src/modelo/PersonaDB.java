/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class PersonaDB extends Persona {

    private pgConect conecta = new pgConect();

    public PersonaDB() {
    }

    public PersonaDB(String idpersona, String nombres, String apellidos, String telefono, String correo, String domicilio, String celular, String sexo) {
        super(idpersona, nombres, apellidos, telefono, correo, domicilio, celular, sexo);
    }

    public List<Persona> listaPersonas() {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        String sql = "select * from \"Persona\"";
        ResultSet rs = conecta.query(sql);
        try {
            while (rs.next()) {
                Persona p = new Persona();

               p.setIdpersona(rs.getString("idpersona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setCorreo(rs.getString("correo"));
                p.setDomicilio(rs.getString("domicilio"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getString("sexo"));
                listaPersonas.add(p);

            }
            rs.close();
            return listaPersonas;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean insertar() {

        String sql = "INSERT INTO \"Persona\"(idpersona,nombres,apellidos,correo,domicilio,telefono,sexo)";
        sql += " VALUES ";
        sql += " ('" + getIdpersona() + "','" + getNombres() + "','" + getApellidos() + "','" + getCorreo() + "','" + getDomicilio() + "','" + getTelefono()+  "','" + getSexo() + "')";
        if (conecta.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizar() {
        String sql = "UPDATE \"Persona\" SET  ";

        sql += "nombres='" + getNombres() + "'";
        sql += ", apellidos='" + getApellidos() + "'";
        sql += ", correo='" + getCorreo() + "'";
        sql += ", domicilio= '" + getDomicilio() + "'";
        sql += ", telefono='" + getTelefono()+  "'";
        sql += ", sexo=" + getSexo();
        sql += "WHERE idpersona = '" + getIdpersona() + "' ";

        if (conecta.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Persona> buscar_Id(String cedula) {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        String sql = "SELECT * FROM \"Persona\" WHERE idpersona LIKE '%" + cedula + "%' ";
        ResultSet rs = conecta.query(sql);
        try {
            while (rs.next()) {
                Persona p = new Persona();

               p.setIdpersona(rs.getString("idpersona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setCorreo(rs.getString("correo"));
                p.setDomicilio(rs.getString("domicilio"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getString("sexo"));
                listaPersonas.add(p);

            }
            rs.close();
            return listaPersonas;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Persona> buscar_Nombre(String nombre) {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        String sql = "SELECT * FROM \"Persona\" WHERE nombres LIKE '%" + nombre + "%' ";
        ResultSet rs = conecta.query(sql);
        try {
            while (rs.next()) {
                Persona p = new Persona();

                p.setIdpersona(rs.getString("idpersona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setCorreo(rs.getString("correo"));
                p.setDomicilio(rs.getString("domicilio"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getString("sexo"));
                listaPersonas.add(p);

            }
            rs.close();
            return listaPersonas;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Persona> buscar_Apellido(String apellido) {
        List<Persona> listaPersonas = new ArrayList<Persona>();
        String sql = "SELECT * FROM \"Persona\" WHERE apellidos LIKE '%" + apellido + "%' ";
        ResultSet rs = conecta.query(sql);
        try {
            while (rs.next()) {
                Persona p = new Persona();
                p.setIdpersona(rs.getString("idpersona"));
                p.setNombres(rs.getString("nombres"));
                p.setApellidos(rs.getString("apellidos"));
                p.setCorreo(rs.getString("correo"));
                p.setDomicilio(rs.getString("domicilio"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getString("sexo"));
                listaPersonas.add(p);

            }
            rs.close();
            return listaPersonas;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean eliminar(String cod) {

        String sql = "DELETE FROM  \"Persona\" WHERE idpersona = '" + cod
                + "'";

        if (conecta.noquery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    
}
