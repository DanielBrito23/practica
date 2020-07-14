/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practap;

import controlador.personaControlador;
import modelo.PersonaDB;
import vista.PersonaVista;

/**
 *
 * @author LENOVO
 */
public class PracTap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           PersonaDB modelo= new PersonaDB();
            PersonaVista vista= new PersonaVista();
            personaControlador c = new personaControlador(modelo, vista);
            c.iniciaControl();
    }
    
}
