package com.elosete.api.controller;

import com.elosete.servico.EstacaoEspacialServico;
import com.elosete.api.mapper.Jornada;
import com.elosete.modelo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estacao-espacial/sondas")
public class EstacaoEspacialController {

    private final EstacaoEspacialServico estacaoEspacialServico;

    @Autowired
    public EstacaoEspacialController(EstacaoEspacialServico estacaoEspacialServico) {
        this.estacaoEspacialServico = estacaoEspacialServico;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Sentido> pegarSonda() {
        return estacaoEspacialServico.pegarSonda();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sentido adicionaSondaNoPlaneta(@RequestBody final Sentido sentido) {
        return estacaoEspacialServico.adicionaSondaNoPlaneta(sentido);

    }

    @PutMapping(value = "/{x}/{y}/explorar-planeta-pela-posicao")
    @ResponseStatus(HttpStatus.OK)
    public Sentido explorarPlaneta(
            @PathVariable("x") final Integer x, @PathVariable("y") final Integer y,
            @RequestBody final List<Comandos> comandos) {
        return estacaoEspacialServico.explorarPlaneta(new Posicao(x, y), comandos);

    }

    @PostMapping("/explorar-planeta-pela-jornada")
    @ResponseStatus(HttpStatus.OK)
    public Sentido explorarPlaneta(@RequestBody final Jornada jornada) {
        return estacaoEspacialServico.explorarPlaneta(jornada.pegarSentido(), jornada.pegarComandos());
    }

}
