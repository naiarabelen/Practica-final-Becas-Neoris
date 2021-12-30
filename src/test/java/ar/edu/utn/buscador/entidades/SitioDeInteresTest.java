package ar.edu.utn.buscador.entidades;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SitioDeInteresTest {

    private SitioDeInteres sitio;

    @Before
    public void setUp()
    {
        sitio = new SitioDeInteres();
        sitio.setHoraDeApertura(8);
        sitio.setHoraDeCierre(18);
    }

    @Test
    public void testHorarioOk()
    {
        int hora = 10;
        Boolean resultado = sitio.estaAbierto(hora);
        Assert.assertEquals(true, resultado);
    }

}
