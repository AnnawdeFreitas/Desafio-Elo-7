package com.elosete.modelo;

public class Sondas {
    private Planetas planeta;
    private Posicao posicao;
    private Movimentos movimentos;

    public Sondas(Planetas planeta, Sentido sentido) {
        this(planeta, sentido.pegarPosicao(), sentido.pegarMovimentos());
    }

    public Sondas(Planetas planeta, Posicao posicao, Movimentos movimentos) {
        this.movimentos = movimentos;
        this.planeta = planeta;
        this.posicao = posicao;

        this.planeta.pousar(posicao, this);

    }

    public Posicao andarParaFrente() {
        final Posicao novaPosicao = movimentos.andarParaFrente(posicao);
        planeta.mudarPosicaoAtual(posicao, novaPosicao);
        this.posicao = novaPosicao;
        return posicao;
    }

    public Movimentos virarAEsquerda() {
        this.movimentos = movimentos.virarAEsquerda();
        return this.movimentos;
    }

    public Movimentos virarADireita() {
        this.movimentos = movimentos.virarADireita();
        return this.movimentos;
    }

    public Sentido pegarSentidoAtual() {
        return new Sentido(posicao, movimentos);
    }

}