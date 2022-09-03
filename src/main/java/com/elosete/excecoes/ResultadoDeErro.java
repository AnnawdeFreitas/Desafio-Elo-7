package com.elosete.excecoes;

import java.io.Serializable;

class ResultadoDeErro implements Serializable{

    private final String mensagem;

    public ResultadoDeErro(String mensagem){
        this.mensagem = mensagem;
    }
    public String pegarMensagem(){
        return mensagem;
    }
}