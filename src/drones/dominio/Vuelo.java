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
  private String fileName;
  private ArrayList<Integer> datos;
  private int[] manual;

  public Vuelo(Dron dron, int area, int fila, String fileName, ArrayList<Integer> datos,
      int[] manual) {
    this.dron = dron;
    this.fila = fila;
    this.area = area;
    this.fileName = fileName;
    this.datos = datos;
    this.manual = manual;
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

    int[] manual = new int[10];

    for (Carga c : sistema.getCargas()) {
      if (c.getPosicion().getFila() == fila && c.getPosicion().getArea() == intArea) {
        manual[c.getPosicion().getColumna()] = c.getCodigo();
      }
    }

    Vuelo vuelo = new Vuelo(dron, intArea, fila, path.getFileName().toString(), datos, manual);
    dron.agregarVuelo(vuelo);
    return vuelo;
  }

  public Dron getDron() {
    return dron;
  }

  public void setDron(Dron dron) {
    this.dron = dron;
  }

  public int getFila() {
    return fila;
  }

  public int getArea() {
    return area;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public ArrayList<Integer> getDatos() {
    return datos;
  }

  public int[] getManual() {
    return manual;
  }

  public Boolean getExito() {
    return datos.size() == 10;
  }

  public int[] getReading() {
    int[] reading = new int[10];
    for (int i = 0; i < datos.size(); i++) {
      reading[i] = datos.get(i);
    }
    return reading;
  }

  public int[] getDiff() {
    int[] diff = new int[10];
    int[] reading = getReading();

    for (int col = 0; col < reading.length; col++) {
      int coincidencia = 0;
      if (reading[col] == manual[col]) {
        coincidencia = 1;
      }
      diff[col] = coincidencia;
    }
    return diff;

  }

  public int getCoincidencias() {
    int coincidencias = 0;
    int[] diff = getDiff();

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
    if (getExito()) {
      response = "Nombre de archivo: " + fileName + " - Area: " + area
          + " - Fila: " + fila + " - Coincidencias: " + getCoincidencias() +
          " - Diferencias: " + getDiferencias();
    } else {
      response = "Nombre de archivo: " + fileName + " - Area: " + area
          + " - Fila: " + fila + " - Cantidad de lineas de carga: " + datos.size();
    }
    return response;
  }
}
