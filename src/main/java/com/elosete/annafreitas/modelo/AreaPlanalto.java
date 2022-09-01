package com.elosete.annafreitas.modelo;

import com.elosete.annafreitas.excecoes.ExcecaoRegraNegocios;

public class AreaPlanalto {
    private final Posicao margemInferiorEsquerda;
    private final Posicao margemSuperiorDireita;

    public AreaPlanalto(Posicao margemInferiorEsquerda, Posicao margemSuperiorDireita) {

        this.margemSuperiorDireita = margemSuperiorDireita;
        this.margemInferiorEsquerda = margemInferiorEsquerda;
    }

    public void validarArea(Posicao posicao) {
        if (Boolean.FALSE.equals(posicao.eMaiorOuIgualA(margemInferiorEsquerda))) {
            throw new ExcecaoRegraNegocios("A Posicao" + posicao.toString() + "Está fora da área que inicia em"
                    + margemInferiorEsquerda.toString());
        } else if (Boolean.FALSE.equals(posicao.eMenorOuIgualA(margemSuperiorDireita))) {
            throw new ExcecaoRegraNegocios("A Posicao" + posicao.toString() + "Está fora da área que termina em"
                    + margemSuperiorDireita.toString());
        }
    }

}