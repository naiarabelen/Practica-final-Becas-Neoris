package ar.edu.utn.buscador.utilidades;

import ar.edu.utn.buscador.entidades.SitioDeInteres;
import java.util.Comparator;

/**
 *
 * @author Rodrigo Cruz
 */
public class OrdenarPorDistancia implements Comparator<SitioDeInteres>{

    @Override
    public int compare(SitioDeInteres o1, SitioDeInteres o2) {
        return (int) (o1.getDistanciaEnKm() - o2.getDistanciaEnKm());
    }
}
