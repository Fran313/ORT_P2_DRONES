/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drones.dominio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

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

  public static Vuelo fromFile (Path path, Sistema sistema) throws IOException {
    
    Scanner arch = new Scanner (path);
    String identificacion = arch.nextLine();    
    Dron dron = sistema.buscarDron(identificacion);

    String stringPos = arch.nextLine();
    int intArea = Integer.parseInt(stringPos.substring(0, 1));
    int fila = Integer.parseInt(stringPos.substring(2, stringPos.length()));
    Posicion posicion = new Posicion(intArea, fila);

    ArrayList<Integer> datos = new ArrayList<>();
    while(arch.hasNext()) {
      datos.add(arch.nextInt());
    }

    arch.close();
    return new Vuelo(dron, posicion, datos);    
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
