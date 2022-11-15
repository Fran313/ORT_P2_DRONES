package drones.dominio;

import java.io.Serializable;

/**
 * @author Nicolas Russo
 * @author Francisco Suarez
 */
public class Carga implements Serializable {
  private int codigo;
  private Articulo articulo;
  private Funcionario funcionario;
  private int cantidad;
  private Posicion posicion;

  public Carga(
      int codigo, Articulo articulo, Funcionario funcionario, int cantidad, Posicion posicion) {
    this.codigo = codigo;
    this.articulo = articulo;
    this.funcionario = funcionario;
    this.cantidad = cantidad;
    this.posicion = posicion;
  }

  public int getCodigo() {
    return this.codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public Articulo getArticulo() {
    return this.articulo;
  }

  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  public Funcionario getFuncionario() {
    return this.funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public int getCantidad() {
    return this.cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public Posicion getPosicion() {
    return this.posicion;
  }

  public void setPosicion(Posicion posicion) {
    this.posicion = posicion;
  }

  @Override
  public boolean equals(Object object) {
    if ((object == null) || !(object instanceof Carga)) {
      return false;
    } else {
      Carga carga = (Carga) object;
      return (carga.codigo == this.codigo);
    }
  }
}
