package ar.edu.utn.buscador.servicios;

import ar.edu.utn.buscador.entidades.SitioDeInteres;
import ar.edu.utn.buscador.entidades.Turista;
import org.junit.Test;
import static org.junit.Assert.*;
import ar.edu.utn.buscador.servicios.ServicioBuscador;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;

public class ServicioBuscadorTest {

    private ServicioBuscador servi;

    public ServicioBuscadorTest() {
    }
    
    @Before
    public void setup()
    {
        List<Turista> listaTurista = new ArrayList<>();
        Turista primerTurista = new Turista();
        Turista segundoTurista = new Turista();
        
        primerTurista.setLatitud(-28.4647);
        primerTurista.setLongitud(-65.8);
        List<String> intereses = new ArrayList<>();
        intereses.add("Salas de cine");
        primerTurista.setIntereses(intereses);
        primerTurista.setHoraDeConsulta(10);
        
        segundoTurista.setLatitud(-34.6);
        segundoTurista.setLongitud(-58.6);
        List<String> interesesDos = new ArrayList<>();
        interesesDos.add("Salas de Teatro");
        interesesDos.add("Salas de cine");
        segundoTurista.setIntereses(interesesDos);
        segundoTurista.setHoraDeConsulta(20);
        
        listaTurista.add(primerTurista);
        listaTurista.add(segundoTurista);

        List<SitioDeInteres> sitiosInteres = new ArrayList<>();
        SitioDeInteres primerSitio = new SitioDeInteres();
        SitioDeInteres segundoSitio = new SitioDeInteres();
        SitioDeInteres tercerSitio = new SitioDeInteres();
        SitioDeInteres cuartoSitio = new SitioDeInteres();

        
        primerSitio.setCategoria("Salas de cine");
        primerSitio.setLatitud(-28.4647);
        primerSitio.setLongitud(-65.8);
        primerSitio.setHoraDeApertura(9);
        primerSitio.setHoraDeCierre(20);
        
        segundoSitio.setCategoria("Salas de cine");
        segundoSitio.setLatitud(-34.6);
        segundoSitio.setLongitud(-58.6);
        segundoSitio.setHoraDeApertura(17);
        segundoSitio.setHoraDeCierre(22);
        
        tercerSitio.setCategoria("Salas de Teatro");
        tercerSitio.setLatitud(-34.6);
        tercerSitio.setLongitud(-58.6);
        tercerSitio.setHoraDeApertura(17);
        tercerSitio.setHoraDeCierre(22);
        
        cuartoSitio.setCategoria("Salas de Teatro");
        cuartoSitio.setLatitud(-34.6);
        cuartoSitio.setLongitud(-58.6);
        cuartoSitio.setHoraDeApertura(17);
        cuartoSitio.setHoraDeCierre(22);
        
        sitiosInteres.add(primerSitio);
        sitiosInteres.add(segundoSitio);
        sitiosInteres.add(tercerSitio);
        sitiosInteres.add(cuartoSitio);

        String opcion = "3";

        servi = new ServicioBuscador(listaTurista, sitiosInteres, opcion);
    }
    
    @Test
    public void testBuscarSitios() throws IOException
    {
        servi.buscarSitios();
        int resultado = servi.getTuristas().get(0).getSitiosPorVisitar().size();
        resultado += servi.getTuristas().get(1).getSitiosPorVisitar().size();
        Assert.assertEquals(3, resultado);
    }
    
    @Test
    public void testBuscarNSitios() throws IOException
    {
        servi.buscarNSitios();
        int resultado = servi.getTuristas().get(0).getSitiosPorVisitar().size();
        resultado += servi.getTuristas().get(1).getSitiosPorVisitar().size();
        Assert.assertEquals(4, resultado);
    }



}
