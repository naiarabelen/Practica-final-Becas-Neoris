package ar.edu.utn.buscador.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SitioDeInteres {

    private String nombre;
    private String provincia;
    private String direccion;
    private String sitioWeb;
    private String categoria;

    @JsonIgnore
    private Double latitud;

    @JsonIgnore
    private Double longitud;
    private Integer horaDeApertura;
    private Integer horaDeCierre;
    private Double distanciaEnKm;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public Integer getHoraDeApertura() {
        return horaDeApertura;
    }

    public void setHoraDeApertura(Integer horaDeApertura) {
        this.horaDeApertura = horaDeApertura;
    }

    public Integer getHoraDeCierre() {
        return horaDeCierre;
    }

    public void setHoraDeCierre(Integer horaDeCierre) {
        this.horaDeCierre = horaDeCierre;
    }

    public Double getDistanciaEnKm() {
        return this.distanciaEnKm;
    }

    public void setDistanciaEnKm(Double distancia) {
        this.distanciaEnKm = distancia;
    }

    public boolean estaAbierto(int hora) {
        return hora >= this.horaDeApertura && hora < this.horaDeCierre;
    }
}
