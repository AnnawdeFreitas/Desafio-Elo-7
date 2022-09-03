package com.elosete.annafreitas.modelo;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Movimentos {
    @JsonProperty("N")
    NORTE(posicaoAtual -> new

    Posicao(posicaoAtual.getX(), posicaoAtual.

            getY() + 1)) {
        public Movimentos virarAEsquerda() {
            return OESTE;
        }

        public Movimentos virarADireita() {
            return LESTE;
        }
    },

    @JsonProperty("E")
    LESTE(posicaoAtual -> new

    Posicao(posicaoAtual.getX() + 1, posicaoAtual.getY())) {
        public Movimentos virarAEsquerda() {
            return NORTE;
        }

        public Movimentos virarADireita() {
            return SUL;
        }
    },

    @JsonProperty("S")
    SUL(posicaoAtual -> new

    Posicao(posicaoAtual.getX(), posicaoAtual.

            getY() - 1)) {
        public Movimentos virarAEsquerda() {
            return LESTE;
        }

        public Movimentos virarADireita() {
            return OESTE;
        }
    },

    @JsonProperty("W")
    OESTE(posicaoAtual -> new

    Posicao(posicaoAtual.getX() - 1, posicaoAtual.

            getY())) {
        public Movimentos virarAEsquerda() {
            return SUL;
        }

        public Movimentos virarADireita() {
            return NORTE;
        }
    };

    private Function<Posicao, Posicao> andarParaFrente;

    Movimentos(UnaryOperator<Posicao> andarParaFrente) {
        this.andarParaFrente = andarParaFrente;
    }

    public Posicao andarParaFrente(Posicao posicaoAtual) {
        return andarParaFrente.apply(posicaoAtual);
    }

    public abstract Movimentos virarAEsquerda();

    public abstract Movimentos virarADireita();

}