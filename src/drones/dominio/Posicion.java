package drones.dominio;

import java.io.Serializable;

/**
 * @author Nicolas Russo
 * @author Francisco Suarez
 */
public class Posicion implements Serializable {
  private int area;
  private int fila;
  private int columna;

  public Posicion(int area, int fila, int columna) {
    this.area = area;
    this.fila = fila;
    this.columna = columna;
  }

  public static Posicion fromChar(char area, int fila, int columna) {
    int intArea = (int) Character.toUpperCase(area) - 65;
    return new Posicion(intArea, fila, columna);
  }

  public int getArea() {
    return this.area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public int getFila() {
    return this.fila;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }

  public int getColumna() {
    return this.columna;
  }

  public void setColumna(int columna) {
    this.columna = columna;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof Posicion)) {
      return false;
    } else {
      Posicion posicion = (Posicion) object;
      return (posicion.getArea() == this.area)
          && (posicion.getFila() == this.fila)
          && (posicion.getColumna() == this.columna);
    }
  }

  @Override
  public String toString() {
    return String.valueOf((char) (this.area + 65)) + this.fila + this.columna;
  }
}
