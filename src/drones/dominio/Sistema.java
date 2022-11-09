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
public class Sistema {
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
    
    public void inicio () {
        Articulo bandera = new Articulo("Bandera", "De peñarol");
        Funcionario fran = new Funcionario("Franki", 19, 812763);
        Posicion p = new Posicion(0, 0, 0);
        this.agregarCarga(1891, bandera, fran, 0, p);
    }
    
    public ArrayList<Carga> getCargas() {
        return this.cargas;
    }



    public void agregarFuncionario (String nombre, int edad, int numero) {
      Funcionario funcionario = new Funcionario (nombre, edad, numero);
      funcionarios.add(funcionario);
    }
    
    public Dron agregarDron (String identificacion, String modelo, int camara) {
      Dron dron = new Dron(identificacion, modelo, camara);
      drones.add(dron);
      return dron;
    }

    public void agregarCarga (int codigo, Articulo articulo, Funcionario funcionario, int cantidad, Posicion posicion) {
      Carga carga = new Carga(codigo, articulo, funcionario, cantidad, posicion);
      cargas.add(carga);
    }

    public Carga buscarCarga (final Posicion posicion) {
      return this.cargas.stream().filter(c -> c.getPosicion().equals(posicion)).findAny().orElse(null);   
    }

    public void eliminarCarga (final Carga carga) {
      this.cargas.remove(carga);
    }

    public Dron buscarDron (String identificacion) {
      return this.drones.stream().filter(d -> d.getIdentificacion().equals(identificacion)).findAny().orElse(null);   
    }
}
