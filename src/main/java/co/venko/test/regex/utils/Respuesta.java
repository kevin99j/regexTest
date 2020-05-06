package com.venko.test.regex.utils;

public class Respuesta {

    String genero;
    String edad;
    String municipio;

    public Respuesta(String genero, String edad, String municipio) {
        this.genero = genero;
        this.edad = edad;
        this.municipio = municipio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
