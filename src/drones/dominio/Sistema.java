/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drones.dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nicolas Russo
 * @author Francisco Suarez
 */
public class Sistema implements Serializable {
  private ArrayList<Articulo> articulos;
  private ArrayList<Funcionario> funcionarios;
  private ArrayList<Dron> drones;
  private ArrayList<Carga> cargas;

  public Sistema() {
    articulos = new ArrayList<>();
    funcionarios = new ArrayList<>();
    drones = new ArrayList<>();
    cargas = new ArrayList<>();
  }

  public void cargarDatosEjemplo() {
    Articulo a = this.agregarArticulo("Bandera", "De peñarol");
    Funcionario f = this.agregarFuncionario("Franki", 19, 812763);
    Posicion p = new Posicion(0, 0, 0);
    this.agregarCarga(1891, a, f, 20, p);
    this.agregarDron("holasoyDron1", "asdf", 2);
  }

  public ArrayList<Carga> getCargas() {
    return this.cargas;
  }

  public ArrayList<Funcionario> getFuncionarios() {
    return this.funcionarios;
  }

  public ArrayList<Articulo> getArticulos() {
    return this.articulos;
  }

  public ArrayList<Dron> getDrones() {
    return this.drones;
  }

  public Funcionario agregarFuncionario(String nombre, int edad, int numero) {
    Funcionario funcionario = new Funcionario(nombre, edad, numero);
    funcionarios.add(funcionario);
    return funcionario;
  }

  public Articulo agregarArticulo(String nombre, String descripcion) {
    Articulo articulo = new Articulo(nombre, descripcion);
    articulos.add(articulo);
    return articulo;
  }

  public Dron agregarDron(String identificacion, String modelo, int camara) {
    Dron dron = new Dron(identificacion, modelo, camara);
    drones.add(dron);
    return dron;
  }

  public Carga agregarCarga(
      int codigo, Articulo articulo, Funcionario funcionario, int cantidad, Posicion posicion) {
    Carga carga = new Carga(codigo, articulo, funcionario, cantidad, posicion);
    cargas.add(carga);
    return carga;
  }

  public Carga buscarCarga(final Posicion posicion) {
    return this.cargas.stream()
        .filter(c -> c.getPosicion().equals(posicion))
        .findAny()
        .orElse(null);
  }

  public Dron buscarDron(String identificacion) {
    return this.drones.stream()
        .filter(d -> d.getIdentificacion().equals(identificacion))
        .findAny()
        .orElse(null);
  }

  public void eliminarCarga(final Carga carga) {
    this.cargas.remove(carga);
  }
}
