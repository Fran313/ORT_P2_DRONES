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
public class Vuelo {
  private Dron dron; 
  private Posicion fila;
  ArrayList<Integer> datos = new ArrayList<>();

  public Vuelo(Dron dron, Posicion fila, ArrayList<Integer> datos) {
    this.dron = dron;
    this.fila = fila;
    this.datos = datos;
  }

  public Dron getDron() {
    return this.dron;
  }

  public void setDron(Dron dron) {
    this.dron = dron;
  }

  public Posicion getFila() {
    return this.fila;
  }

  public void setFila(Posicion fila) {
    this.fila = fila;
  }

  public ArrayList<Integer> getDatos() {
    return this.datos;
  }

  public void setDatos(ArrayList<Integer> datos) {
    this.datos = datos;
  }

  public Boolean getExito() {
    return datos.size() == 10;
  }

}
