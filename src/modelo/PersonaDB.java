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
                p.setFechanacimiento(rs.getDate("fechanacimiento"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getString("sexo"));
                p.setSueldo(rs.getDouble("sueldo"));
                p.setCupo(rs.getInt("cupo"));
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

        String sql = "INSERT INTO \"Persona\"(idpersona,nombres,apellidos,fechanacimiento,telefono,sexo,sueldo,cupo)";
        sql += " VALUES ";
        sql += " ('" + getIdpersona() + "','" + getNombres() + "','" + getApellidos() + "','" + getFechanacimiento() + "','" + getTelefono() + "','" + getSexo() + "','" + getSueldo() + "','" + getCupo()
                + "')";
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
        sql += ", fechanacimiento='" + getFechanacimiento() + "'";
        sql += ", telefono= '" + getTelefono() + "'";
        sql += ", sexo='" + getSexo() + "'";
        sql += ", sueldo=" + getSueldo();
        sql += ", cupo=" + getCupo();
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
                p.setFechanacimiento(rs.getDate("fechanacimiento"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getString("sexo"));
                p.setSueldo(rs.getDouble("sueldo"));
                p.setCupo(rs.getInt("cupo"));
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
                p.setFechanacimiento(rs.getDate("fechanacimiento"));
                p.setTelefono(rs.getString("telefono"));
                p.setSexo(rs.getString("sexo"));
                p.setSueldo(rs.getDouble("sueldo"));
                p.setCupo(rs.getInt("cupo"));
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

    public boolean insertarfoto() {
        String sql = "INSERT INTO \"Persona\"(idpersona,nombres,apellidos,fechanacimiento,telefono,sexo,sueldo,cupo,foto)";
        sql += "VALUES";
        sql += " ('" + getIdpersona() + "','" + getNombres() + "','" + getApellidos() + "','" + getFechanacimiento() + "','" + getTelefono() + "','" + getSexo() + "','" + getSueldo() + "','" + getCupo() + "',?)";

        PreparedStatement ps = conecta.getPs(sql);

        try {
            ps.setBinaryStream(1, getFile(), getLogBytes());
            conecta.noquery(ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
