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
  public ArrayList<Articulo> articulos;
  public ArrayList<Funcionario> funcionarios;
  public ArrayList<Dron> drones;
  public ArrayList<Carga> cargas;
    
    public void inicio () {
        
    }

    public void agregarFuncionario (String nombre, int edad, int numero) {
      Funcionario funcionario = new Funcionario (nombre, edad, numero);
      funcionarios.add(funcionario);
    }
    
    public void agregarDrone (String identificacion, String modelo, int camara) {
      Dron dron = new Dron(identificacion, modelo, camara);
      drones.add(dron);
    }

    public void agregarCarga (int codigo, Articulo articulo, Funcionario funcionario, int cantidad, Posicion posicion) {
      Carga carga = new Carga(codigo, articulo, funcionario, cantidad, posicion);
      cargas.add(carga);
    }
}
