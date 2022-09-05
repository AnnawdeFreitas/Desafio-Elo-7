package com.elosete.excecoes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExcecaoRegraNegocioHandler {
    private static Logger LOGGER = LoggerFactory.getLogger(ExcecaoRegraNegocioHandler.class);

    @ExceptionHandler(ExcecaoRegraNegocios.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultadoDeErro regraNegocioExcecao(ExcecaoRegraNegocios e) {
        LOGGER.error("Bad request: {}", e);
        return new ResultadoDeErro(e.getMessage());
    }

    @ExceptionHandler(ExcecaoNaoEncontrada.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultadoDeErro excecaoRegraNegocios(ExcecaoNaoEncontrada e) {
        LOGGER.error("Not found {}.", e);
        return new ResultadoDeErro(e.getMessage());
    }

}
