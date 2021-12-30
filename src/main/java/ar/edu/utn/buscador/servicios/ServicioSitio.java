package ar.edu.utn.buscador.servicios;

import ar.edu.utn.buscador.entidades.SitioDeInteres;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServicioSitio {

    final static Logger log = LoggerFactory.getLogger(ServicioSitio.class);

    public List<SitioDeInteres> sitiosAObjetos(BufferedReader sitiosCsv) throws IOException {
        String lineaCsv = "";
        List<SitioDeInteres> sitios = new ArrayList();

        while ((lineaCsv = sitiosCsv.readLine()) != null) {

            String[] aux = lineaCsv.split(",");

            if (aux[0].equals("Cod_Loc")) {
                continue;
            }

            if (aux.length == 23) {
                SitioDeInteres sitio = new SitioDeInteres();

                sitio.setCategoria(aux[4]);
                sitio.setProvincia(aux[5]);
                sitio.setNombre(aux[8]);
                sitio.setDireccion(aux[9]);
                sitio.setSitioWeb(aux[15]);
                sitio.setLatitud(Double.valueOf(aux[16]));
                sitio.setLongitud(Double.valueOf(aux[17]));
                sitio.setHoraDeApertura(Integer.valueOf(aux[21]));
                sitio.setHoraDeCierre(Integer.valueOf(aux[22]));

                sitios.add(sitio);

            } else {
                log.error("ERROR. El registro del sitio no tiene todos los campos. " + Arrays.toString(aux));
            }
        }
        return sitios;
    }
}
