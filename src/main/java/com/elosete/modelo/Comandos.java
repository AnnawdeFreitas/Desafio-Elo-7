package com.elosete.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.function.Consumer;

public enum Comandos {
    @JsonProperty("M")
    MOVE(Sondas::andarParaFrente),

    @JsonProperty("L")
    VIRAR_ESQUERDA(Sondas::virarAEsquerda),

    @JsonProperty("R")
    VIRAR_DIREITA(Sondas::virarADireita);

    private Consumer<Sondas> movimento;

    Comandos(Consumer<Sondas> movimento) {
        this.movimento = movimento;
    }

    public void mover(Sondas sonda) {
        movimento.accept(sonda);
    }

}
