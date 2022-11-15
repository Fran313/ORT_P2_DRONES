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
  
  public static Vuelo fromFile (String path, Sistema sistema) {
      //TODO: Check if ArchivoLectura receive Path or String param for constructor
      ArchivoLectura arch = new ArchivoLectura(path);
      Dron dron;
      int intArea;
      int fila;
      ArrayList<Integer> datos = new ArrayList<>();
      
      //I must use if because .hayMasLineas() returns the new line, there is no other method
      if(arch.hayMasLineas()) {
          String identificacion = arch.linea();
          dron = sistema.buscarDron(identificacion);
      }
      
      if(arch.hayMasLineas()) {
          String stringPos = arch.linea();          
          intArea = (int)(stringPos.charAt(0) - 65);
          fila = Integer.parseInt(stringPos.substring(2,stringPos.length()));
      }
            
      while(arch.hayMasLineas()){
          datos.add(Integer.valueOf(arch.linea()));
      }
      
      arch.cerrar();
                
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
