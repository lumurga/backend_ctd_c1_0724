package com.backend.model;

public class Tarjeta {

    private String banco;
    private String numero;

    public Tarjeta(String banco, String numero) {
        this.banco = banco;
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
