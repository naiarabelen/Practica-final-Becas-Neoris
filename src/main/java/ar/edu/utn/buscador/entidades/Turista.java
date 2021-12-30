package ar.edu.utn.buscador.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class Turista {

    private Long dni;
    private String nombre;
    private String apellido;

    @JsonIgnore
    private Character sexo;
    private List<String> intereses;

    @JsonIgnore
    private Double latitud;

    @JsonIgnore
    private Double longitud;
    private Integer horaDeConsulta;
    private List<SitioDeInteres> sitiosPorVisitar;

    public Turista() {
        this.sitiosPorVisitar = new ArrayList();
        this.intereses = new ArrayList();
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public List<String> getIntereses() {
        return intereses;
    }

    public void setIntereses(List<String> intereses) {
        this.intereses = intereses;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Integer getHoraDeConsulta() {
        return horaDeConsulta;
    }

    public void setHoraDeConsulta(Integer horaDeConsulta) {
        this.horaDeConsulta = horaDeConsulta;
    }

    public List<SitioDeInteres> getSitiosPorVisitar() {
        return sitiosPorVisitar;
    }

    public void setSitiosPorVisitar(List<SitioDeInteres> sitiosPorVisitar) {
        this.sitiosPorVisitar = sitiosPorVisitar;
    }

    public void agregarSitioPorVisitar(SitioDeInteres sitio) {
        this.sitiosPorVisitar.add(sitio);
    }
}
