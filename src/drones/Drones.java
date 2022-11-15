/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package drones;

import drones.dominio.Sistema;
import drones.interfaz.Inicio;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nrusso
 */
class Drones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Cargar sistema serializado o crear uno nuevo si no existe
        Sistema sistema;
        try {
            FileInputStream fis
                    = new FileInputStream("./sistema.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            sistema = (Sistema) ois.readObject();
            
            fis.close();
            ois.close();
            Logger.getLogger(Inicio.class.getName()).log(Level.INFO, "Sistema cargado de sistema.ser");

        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(Inicio.class.getName()).log(Level.INFO, "No se encontró un sistema previo. Nuevo sistema creado", e);
            sistema = new Sistema();
            

        }

        // sistema.cargarDatosEjemplo();
        
        Inicio inicio = new Inicio(sistema);
        inicio.setVisible(true);
    }

}
