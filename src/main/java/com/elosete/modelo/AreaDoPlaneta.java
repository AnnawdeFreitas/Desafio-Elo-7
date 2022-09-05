package com.elosete.modelo;

import com.elosete.excecoes.ExcecaoRegraNegocios;

public class AreaDoPlaneta {
    private final Posicao margemInferiorEsquerda;
    private final Posicao margemSuperiorDireita;

    public AreaDoPlaneta(Posicao margemInferiorEsquerda, Posicao margemSuperiorDireita) {

        this.margemSuperiorDireita = margemSuperiorDireita;
        this.margemInferiorEsquerda = margemInferiorEsquerda;
    }

    public void validarArea(Posicao posicao) {
        if (Boolean.FALSE.equals(posicao.eMaiorOuIgualA(margemInferiorEsquerda))) {
            throw new ExcecaoRegraNegocios("A Posição " + posicao.toString() + " Está fora da área que inicia em "
                    + margemInferiorEsquerda.toString());
        } else if (Boolean.FALSE.equals(posicao.eMenorOuIgualA(margemSuperiorDireita))) {
            throw new ExcecaoRegraNegocios("A Posição " + posicao.toString() + " Está fora da área que termina em "
                    + margemSuperiorDireita.toString());
        }
    }

}