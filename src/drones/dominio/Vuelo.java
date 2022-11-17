/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drones.dominio;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import utils.ArchivoLectura;

/**
 * @author Nicolas Russo
 * @author Francisco Suarez
 */
public class Vuelo implements Serializable {

  private Dron dron;
  private int area;
  private int fila;
  ArrayList<Integer> datos = new ArrayList<>();
  private Path fileName;
  private int[] diff;

  public Vuelo(Dron dron, int area, int fila, ArrayList<Integer> datos, Path fileName,
      int[] diff) {
    this.dron = dron;
    this.fila = fila;
    this.area = area;
    this.datos = datos;
    this.fileName = fileName;
    this.diff = diff;
  }

  public static Vuelo fromFile(Path path, Sistema sistema) throws Exception {
    // TODO: Check if ArchivoLectura receive Path or String param for constructor
    ArchivoLectura arch = new ArchivoLectura(path);
    Dron dron = null;
    Integer intArea = null;
    Integer fila = null;
    ArrayList<Integer> datos = new ArrayList<>();

    // I must use if because .hayMasLineas() gets the new line, there is no other
    // method
    if (arch.hayMasLineas()) {
      String identificacion = arch.linea();
      dron = sistema.buscarDron(identificacion);
    }

    if (arch.hayMasLineas()) {
      String stringPos = arch.linea();
      intArea = (int) (stringPos.charAt(0) - 65);
      fila = Integer.parseInt(stringPos.substring(2, stringPos.length())) - 1;
    }

    while (arch.hayMasLineas()) {
      datos.add(Integer.valueOf(arch.linea()));
    }

    arch.cerrar();

    if (dron == null || intArea == null || fila == null) {
      throw new Exception("El archivo tiene formato incorrecto");
    }

    // Calculo coincidencias y diferencias
    int[] archivo = new int[10];
    int[] manual = new int[10];
    int coincidencias = 0;
    int diferencias = 0;
    int sizeDatos = datos.size();

    for (int i = 0; i < sizeDatos; i++) {
      archivo[i] = datos.get(i);
    }

    for (Carga c : sistema.getCargas()) {
      if (c.getPosicion().getFila() == fila && c.getPosicion().getArea() == intArea) {
        manual[c.getPosicion().getColumna()] = c.getCodigo();
      }
    }
    int[] diff = new int[10];

    for (int col = 0; col < sizeDatos; col++) {
      int coincidencia = 0;
      if (archivo[col] == manual[col]) {
        coincidencia = 1;
      }
      diff[col] = coincidencia;
    }

    Vuelo vuelo = new Vuelo(dron, intArea, fila, datos, path.getFileName(), diff);
    dron.agregarVuelo(vuelo);
    return vuelo;
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

  public Boolean getExito() {
    return datos.size() == 10;
  }

  public int getCoincidencias() {
    int coincidencias = 0;
    for (int colDiff : diff) {
      if (colDiff == 1)
        coincidencias++;
    }
    return coincidencias;
  }

  public int getDiferencias() {
    return 10 - getCoincidencias();
  }

  @Override
  public String toString() {
    String response;
    if (this.getExito()) {
      response = "Nombre de archivo: " + this.fileName + " - Area: " + this.area
          + " - Fila: " + this.fila + " - Coincidencias: " + this.getCoincidencias() +
          " - Diferencias: " + this.getDiferencias();
    } else {
      response = "Nombre de archivo: " + this.fileName + " - Area: " + this.area
          + " - Fila: " + this.fila + " - Cantidad de lineas de carga: " + this.getDatos().size();
    }
    return response;
  }
}
