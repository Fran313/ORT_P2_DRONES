/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drones.dominio;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nicolas Russo
 * @author Francisco Suarez 
 */
public class Vuelo implements Serializable {
  private Dron dron; 
  private int area;
  private int fila;
  ArrayList<Integer> datos = new ArrayList<>();

  public Vuelo(Dron dron, int area, int fila, ArrayList<Integer> datos) {
    this.dron = dron;
    this.fila = fila;
    this.area = area;
    this.datos = datos;
  }

  public static Vuelo fromFile (Path path, Sistema sistema) throws IOException {
      
      Scanner arch = new Scanner (path);
      String identificacion = arch.nextLine();    
      Dron dron = sistema.buscarDron(identificacion);
  
      String stringPos = arch.nextLine();
      int intArea = (int) stringPos.charAt(0) - 65;
      int fila = Integer.parseInt(stringPos.substring(2, stringPos.length())) - 1;
  
      ArrayList<Integer> datos = new ArrayList<>();
      while(arch.hasNext()) {
        datos.add(arch.nextInt());
      }
  
      arch.close();

      return new Vuelo(dron, intArea, fila, datos);
  }

  public Dron getDron() {
    return this.dron;
  }

  public void setDron(Dron dron) {
    this.dron = dron;
  }

  public int getFila() {
    return this.fila;
  }
  
  public int getArea() {
    return this.area;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }
  
  public void setArea(int area) {
    this.area = area;
  }

  public ArrayList<Integer> getDatos() {
    return this.datos;
  }

  public void setDatos(ArrayList<Integer> datos) {
    this.datos = datos;
  }

  public Boolean getExito(List<Integer> d) {
    return datos.size() == 10 && datos.equals(d);
  }

}
