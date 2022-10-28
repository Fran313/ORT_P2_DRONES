package drones.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {

    @Test
    public void itShouldCreatePosicionFromCharArea() {
        Posicion p = Posicion.fromChar('C', 6, 2);
        assertEquals(2, p.getArea());
        assertEquals(6, p.getFila());
        assertEquals(2, p.getColumna());
    }

    @Test
    public void itShouldCreatePosicionFromNumbers() {

    }

    @Test
    public void itShouldDetectTwoPositionsAsEqual() {

    }

    @Test
    public void itShouldDetectTwoPositionsWithDifferentAreasAsDifferent() {

    }

    @Test
    public void itShouldDetectTwoPositionsWithDifferentRowsAsDifferent() {

    }

    @Test
    public void itShouldDetectTwoPositionsWithDifferentColumnsAsDifferent() {

    }

}
