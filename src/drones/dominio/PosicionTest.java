package drones.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PosicionTest {

  static Posicion pBase;

  @BeforeAll
  public static void setup() {
    pBase = new Posicion(1, 1, 1);
  }
  
  @Test
  public void itShouldCreatePosicionFromNumbers() {
    assertEquals(1, pBase.getArea());
    assertEquals(1, pBase.getFila());
    assertEquals(1, pBase.getColumna());
  }

  @Test
  public void itShouldDetectTwoPositionsAsEqual() {
    Posicion pIgual = new Posicion(1, 1, 1);
    assertEquals(true, pBase.equals(pIgual));
  }

  @Test
  public void itShouldDetectTwoPositionsWithDifferentAreasAsDifferent() {
    Posicion p = new Posicion(0, 1, 1);
    assertEquals(false, pBase.equals(p));
  }

  @Test
  public void itShouldDetectTwoPositionsWithDifferentRowsAsDifferent() {
    Posicion p = new Posicion(1, 0, 1);
    assertEquals(false, pBase.equals(p));
  }

  @Test
  public void itShouldDetectTwoPositionsWithDifferentColumnsAsDifferent() {
    Posicion p = new Posicion(1, 1, 0);
    assertEquals(false, pBase.equals(p));
  }
}
