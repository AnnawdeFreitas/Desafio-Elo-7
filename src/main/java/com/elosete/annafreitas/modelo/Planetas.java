package com.elosete.annafreitas.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.elosete.annafreitas.excecoes.ExcecaoNaoEncontrada;
import com.elosete.annafreitas.excecoes.ExcecaoRegraNegocios;

public class Planetas {
    private AreaPlanalto areaDoPlaneta;
    private Map<Posicao, Sondas> sonda;

    public Planetas(AreaPlanalto areaDoPlaneta) {
        this.areaDoPlaneta = areaDoPlaneta;
        this.sonda = new HashMap<>();
    }

    public void pousar(Posicao posicao, Sondas sonda) {
        checarNovaPosicao(posicao);
        salvarPosicao(posicao, sonda);
    }

    private void checarNovaPosicao(Posicao novaPosicao) {
        if (sonda.containsKey(novaPosicao)) {
            throw new ExcecaoRegraNegocios("A posição " + novaPosicao.toString() + "já está ocupada");
        }
        areaDoPlaneta.validarArea(novaPosicao);
    }

    public void mudarPosicaoAtual(Posicao posicaoAtual, Posicao novaPosicao) {
        checarNovaPosicao(novaPosicao);
        final Sondas sonda = removerPosicao(posicaoAtual);
        salvarPosicao(novaPosicao, sonda);

    }

    private Sondas removerPosicao(Posicao posicaoAtual) {
        if (!sonda.containsKey(posicaoAtual)) {
            throw new ExcecaoNaoEncontrada("Não é possível remover a posição atual, pois a posição"
                    + posicaoAtual.toString() + "está vazia.");
        }
        return sonda.remove(posicaoAtual);
    }

    private void salvarPosicao(Posicao novaPosicao, Sondas sonda) {
        sonda.put(novaPosicao, sonda);
    }

    public List<Sondas> pegarSonda() {
        return List.copyOf(sonda.values());
    }

    public Optional<Sondas> buscarPelaPosicao(Posicao posicao) {
            return Optional.ofNullable(sonda.get(posicao));
    }
}