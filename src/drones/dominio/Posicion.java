package drones.dominio;

/**
 *
 * @author Nicolas Russo
 * @author Francisco Suarez 
 */

public class Posicion {
    private int area;
    private int fila;
    private int columna;

    public Posicion(int area, int fila, int columna) {
        this.area = area;
        this.fila = fila;
        this.columna = columna;
    }

    public Posicion(int area, int fila) {
        this.area = area;
        this.fila = fila;        
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
}
