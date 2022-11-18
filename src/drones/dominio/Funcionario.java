package drones.dominio;

import java.io.Serializable;

/**
 * @author Nicolas Russo
 * @author Francisco Suarez
 */
public class Funcionario implements Serializable {
  private String nombre;
  private int edad;
  private int numero;

  /**
   * Constructor de la clase Funcionario
   *
   * @param nombre Nombre del funcionario
   * @param edad   Edad del funcionario
   * @param numero Numero del funcionario
   */
  public Funcionario(String nombre, int edad, int numero) {
    this.nombre = nombre;
    this.edad = edad;
    this.numero = numero;
  }

  /**
   * Devuelve el nombre del funcionario
   *
   * @return Nombre del funcionario
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Devuelve la edad del funcionario
   *
   * @return Edad del funcionario
   */
  public int getEdad() {
    return this.edad;
  }

  /**
   * Devuelve el numero del funcionario
   *
   * @return Numero del funcionario
   */
  public int getNumero() {
    return this.numero;
  }

  @Override
  public String toString() {
    return this.nombre;
  }
}
