/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.util.Date;
import javafx.scene.image.Image;

/**
 *
 * @author LENOVO
 */
public class Persona {

    private String idpersona;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String domicilio;
    private String celular;
    private String sexo;

    public Persona() {
    }

    public Persona(String idpersona, String nombres, String apellidos, String telefono, String correo, String domicilio, String celular, String sexo) {
        this.idpersona = idpersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.domicilio = domicilio;
        this.celular = celular;
        this.sexo = sexo;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
