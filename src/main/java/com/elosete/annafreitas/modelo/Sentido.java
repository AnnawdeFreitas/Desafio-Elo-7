package com.elosete.annafreitas.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Sentido implements Serializable {
    private static long serialVersionUID = 1L;
    private Posicao posicao;
    private Movimentos movimentos;

    @JsonCreator
    public Sentido(@JsonProperty(value = "posicao") @JsonUnwrapped Posicao posicao,
            @JsonProperty(value = "movimentos") Movimentos movimentos) {
        this.posicao = posicao;
        this.movimentos = movimentos;
    }

    public Posicao pegarPosicao() {
        return posicao;
    }

    public Movimentos pegarMovimentos() {
        return movimentos;
    }
}