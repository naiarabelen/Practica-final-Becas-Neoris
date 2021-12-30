package ar.edu.utn.buscador;

import ar.edu.utn.buscador.servicios.ServicioBuscador;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ArgumentParser parser = ArgumentParsers.newFor("csvParser").build()
                .description("Cruza dos archivos csv y devuelve la información combinada");
        parser.addArgument("--turistas")
                .type(String.class).required(true)
                .help("Csv con los datos de los turistas");
        parser.addArgument("--sitios")
                .type(String.class).required(true)
                .help("Listado de sitios de interes");
        parser.addArgument("--tipo")
                .type(String.class).setDefault("intereses")
                .help("Tipo de seleccion de datos");
        parser.addArgument("--salida")
                .type(String.class).required(true)
                .help("Ruta del archivo de salida");

        Namespace res = null;
        try {
            res = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.printHelp();
            log.error("Error ejecutando el comando", e);
            System.exit(1);
        }

        ////////////////////////////////////////////////////////////////////////
        try {
            Path csvTuristas = Paths.get(res.getString("turistas"));
            Path csvSitios = Paths.get(res.getString("sitios"));
            Path output = Paths.get(res.getString("salida"));
            String eleccion = res.getString("tipo");

            BufferedReader brTuristas = Files.newBufferedReader(csvTuristas, Charset.forName("ISO-8859-1"));
            BufferedReader brSitios = Files.newBufferedReader(csvSitios, Charset.forName("ISO-8859-1"));

            Files.deleteIfExists(output);
            Files.createFile(output);
            log.info("Se creó el archivo " + output.toAbsolutePath());

            try {
                ServicioBuscador servicio = new ServicioBuscador(brTuristas, brSitios, output, eleccion);

                if (eleccion.equals("intereses")) {
                    servicio.buscarSitios();
                } else {
                    servicio.buscarNSitios();
                }

                servicio.escribirTuristaJson();

                log.info("OK. El archivo " + output.toAbsolutePath() + " se ha escrito correctamente.");
            } catch (NumberFormatException e) {
                log.error("ERROR. En --tipo debe ingresar un número entero válido, o el string \"intereses\". \n"
                        + "(se ingresó: " + eleccion + ")");
                System.err.println("ERROR. En --tipo debe ingresar un número entero válido, o el string \"intereses\". \n"
                        + "(se ingresó: " + eleccion + ")");
                System.exit(1);
            } catch (Exception e) {
                log.error("ERROR. " + Arrays.toString(e.getStackTrace()));
                System.exit(1);
            } finally {
                brTuristas.close();
                brSitios.close();
            }
        } catch (NoSuchFileException e) {
            log.error("ERROR. El archivo que intenta leer no existe.");
            System.exit(1);
        } catch (IOException e) {
            log.error(e.getMessage());
            System.exit(1);
        }
    }
}
