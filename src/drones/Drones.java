/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package drones;

import drones.dominio.Sistema;
import drones.interfaz.Inicio;
/**
 *
 * @author nrusso
 */
 class Drones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Inicio inicio = new Inicio(sistema);
        sistema.inicio();
        inicio.setVisible(true);
    }
    
}
