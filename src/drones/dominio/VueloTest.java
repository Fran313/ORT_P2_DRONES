package drones.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VueloTest {

    @Test
    public void itShouldLoadSuccessVueloFromFile() throws IOException {
        Sistema sistema = new Sistema();
        Dron d = sistema.agregarDron("holasoyDron1", "modeloDron2", 3);
        Vuelo v = Vuelo.fromFile(Paths.get("vuelo.ejemplo.txt"), sistema);
        List<Integer> datosEsperados = new ArrayList<Integer>(Arrays.asList(7389099, 7328947, 0, 0, 0, 0, 0, 0, 9043859, 0));
        assertEquals(d, v.getDron());
        assertEquals(new Posicion(0, 0), v.getFila());
        assertEquals(datosEsperados, v.getDatos());
        assertEquals(true, v.getExito(datosEsperados));
    }

    @Test
    public void itShouldLoadFailedVueloFromFile() throws IOException {
        Sistema sistema = new Sistema();
        Dron d = sistema.agregarDron("holasoyDron1", "modeloDron2", 3);
        Vuelo v = Vuelo.fromFile(Paths.get("vuelo.ejemplo.txt"), sistema);
        List<Integer> datosEsperados = new ArrayList<Integer>(Arrays.asList(222000, 7328947, 0, 0, 0, 0, 0, 0, 9043859, 0));
        assertEquals(d, v.getDron());
        assertEquals(new Posicion(0, 0), v.getFila());
//        assertEquals(datosEsperados, v.getDatos());
        assertEquals(false, v.getExito(datosEsperados));
    }

    @Test
    public void itShouldLoadVueloWithLessLoad() throws IOException {
        Sistema sistema = new Sistema();
        Dron d = sistema.agregarDron("holasoyDron1", "modeloDron2", 3);
        Vuelo v = Vuelo.fromFile(Paths.get("vuelo.menoscarga.txt"), sistema);
        List<Integer> datosEsperados = new ArrayList<Integer>(Arrays.asList(7389099, 7328947, 0, 0, 0, 0, 0, 0, 9043859, 0));
        assertEquals(d, v.getDron());
        assertEquals(new Posicion(0, 0), v.getFila());
//        assertEquals(datosEsperados, v.getDatos());
        assertEquals(false, v.getExito(datosEsperados));
    }

    @Test
    public void itShouldLoadVueloWithWrongLoad() throws IOException {

    }
}
