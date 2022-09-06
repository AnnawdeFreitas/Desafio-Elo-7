package com.elosete.api.mapper;

import com.elosete.modelo.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.io.Serializable;
import java.util.List;

public class Jornada implements Serializable {

    private static final long serialVersionUID = 4919597663624575408L;
    private final List<Comandos> comandos;

    @JsonUnwrapped
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final Sentido sentido;

    @JsonCreator
    public Jornada(
            @JsonProperty(value = "sentido") final Sentido sentido,
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
