package com.elosete.annafreitas.api.mapper;

import com.elosete.annafreitas.modelo.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.io.Serializable;
import java.util.List;

public class Jornada implements Serializable {

    private static long serialVersionUID = 0;
    private final Sentido sentido;
    private final List<Comandos> comandos;

    @JsonCreator
    public Jornada(
            @JsonProperty(value = "sentido") @JsonUnwrapped final Sentido sentido,
            @JsonProperty(value = "comandos") final List<Comandos> comandos) {
        this.sentido = sentido;
        this.comandos = comandos;
    }

    @JsonUnwrapped
    public Sentido pegarSentido() {
        return sentido;
    }

    public List<Comandos> pegarComandos() {
        return comandos;
    }

}
