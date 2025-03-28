package com.ebc.juegos.dto;

public class AdivinadorRespuesta {
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    private int numero;
    private String mensaje;

}
