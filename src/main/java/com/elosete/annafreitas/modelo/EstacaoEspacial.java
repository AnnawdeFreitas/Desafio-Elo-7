package com.elosete.annafreitas.modelo;

import java.util.List;
import java.util.Optional;

public class EstacaoEspacial {

    private Planetas planeta;

    public EstacaoEspacial(Planetas planeta) {
        this.planeta = planeta;
    }

    public Sondas adicionaSondaNoPlaneta(Sentido sentido) {
        return new Sondas(planeta, sentido);
    }

    public void mover(Comandos comandos, Sondas sonda) {
        comandos.mover(sonda);
    }

    public List<Sondas> pegarSonda() {
        return planeta.pegarSonda();
    }

    public Sondas buscarPelaPosicao(Posicao posicao) {
        return planeta.buscarPelaPosicao(posicao);
    }

}
