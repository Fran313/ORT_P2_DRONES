package drones.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VueloTest {

    static Sistema sistema;
    static Dron d;
    static Vuelo v; 


    @BeforeAll
    public static void setup () throws IOException {
        sistema = new Sistema();
        d = sistema.agregarDron("holasoyDron1", "modeloDron2", 3);
        v = Vuelo.fromFile(Paths.get("vuelo.ejemplo.txt"), sistema);
    }

    @Test
    public void itShouldLoadSuccessVueloFromFile()  {        
        List<Integer> datosEsperados = new ArrayList<Integer>(Arrays.asList(
            7389099,
            7328947,
            0,
            0,
            0,
            0,
            0,
            0,
            9043859,
            0));

        assertEquals(d, v.getDron());
        assertEquals(new Posicion(0, 0), v.getFila());
        assertEquals(datosEsperados, v.getDatos());
        assertEquals(true, v.getExito(datosEsperados));
    }

    @Test
    public void itShouldLoadFailedVueloFromFile() {        
        List<Integer> datosEsperados = new ArrayList<Integer>(Arrays.asList(
            222000,
            7328947,
            0,
            0,
            0,
            0,
            0,
            0,
            9043859,
            0));
        assertEquals(d, v.getDron());
        assertEquals(new Posicion(0, 0), v.getFila());
//        assertEquals(datosEsperados, v.getDatos());
        assertEquals(false, v.getExito(datosEsperados));
    }    
}
