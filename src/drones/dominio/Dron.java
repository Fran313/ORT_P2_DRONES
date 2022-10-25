/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drones.dominio;

import java.util.ArrayList;

/**
 *
 * @author Nicolas Russo
 * @author Francisco Suarez 
 */
public class Dron {
    private String identificacion;
    private String modelo;
    private int camara;
    ArrayList<Vuelo> vuelos = new ArrayList<>();

    public Dron(String identificacion, String modelo, int camara) {
        this.identificacion = identificacion;
        this.modelo = modelo;
        this.camara = camara;        
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCamara() {
        return this.camara;
    }

    public void setCamara(int camara) {
        this.camara = camara;
    }

    public ArrayList<Vuelo> getVuelos() {
        return this.vuelos;
    }

    public void setVuelos(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
}
