/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drones.dominio;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Franc
 */
public class ArchivoLectura {
    
    private Scanner in;
    
    private String linea;
    
    public ArchivoLectura (String fileName) {
        try {
            in = new Scanner(Paths.get(fileName));
        } catch (IOException e) {
            System.err.print("Error de apertura");
            System.exit(1);
        }
    }
    
    public boolean hayMasLineas(){
        boolean hay = false;
        linea = null;
        
        if(in.hasNext()) {
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }
    
    public String linea() {
        return linea;
    }
    
    public void cerrar() {
        in.close();
    }
    
}
