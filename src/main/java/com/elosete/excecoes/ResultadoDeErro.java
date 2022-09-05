package com.elosete.excecoes;

import java.io.Serializable;

class ResultadoDeErro implements Serializable{

    private final String message;

    public ResultadoDeErro(String message){
        this.message = message;
    }
    public String pegarMensagem(){
        return message;
    }
}