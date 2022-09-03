package com.elosete.modelo;

import com.elosete.excecoes.ExcecaoNaoEncontrada;
import com.elosete.excecoes.ExcecaoRegraNegocios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Planetas {
    private AreaDoPlaneta areaDoPlaneta;
    private Map<Posicao, Sondas> sondas;

    public Planetas(AreaDoPlaneta areaDoPlaneta) {
        this.areaDoPlaneta = areaDoPlaneta;
        this.sondas = new HashMap<>();
    }

    public void pousar(Posicao posicao, Sondas sonda) {
        checarNovaPosicao(posicao);
        salvarPosicao(posicao, sonda);
    }

    public void mudarPosicaoAtual(Posicao posicaoAtual, Posicao novaPosicao) {
        checarNovaPosicao(novaPosicao);
        final Sondas sonda = removerPosicao(posicaoAtual);
        salvarPosicao(novaPosicao, sonda);

    }

    private void checarNovaPosicao(Posicao novaPosicao) {
        if (sondas.containsKey(novaPosicao)) {
            throw new ExcecaoRegraNegocios("A posição " + novaPosicao.toString() + "já está ocupada");
        }
        areaDoPlaneta.validarArea(novaPosicao);
    }

    private Sondas removerPosicao(Posicao posicaoAtual) {
        if (!sondas.containsKey(posicaoAtual)) {
            throw new ExcecaoNaoEncontrada("Não é possível remover a posição atual, pois a posição"
                    + posicaoAtual.toString() + "está vazia.");
        }
        return sondas.remove(posicaoAtual);
    }

    private void salvarPosicao(Posicao novaPosicao, Sondas sonda) {
        sondas.put(novaPosicao, sonda);
    }

    public List<Sondas> pegarSonda() {
        return List.copyOf(sondas.values());
    }

    public Optional<Sondas> buscarPelaPosicao(Posicao posicao) {
        return Optional.ofNullable(sondas.get(posicao));
    }
}