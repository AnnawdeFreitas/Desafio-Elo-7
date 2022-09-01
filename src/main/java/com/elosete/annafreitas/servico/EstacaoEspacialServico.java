package com.elosete.annafreitas.servico;

import com.elosete.annafreitas.excecoes.ExcecaoNaoEncontrada;
import com.elosete.annafreitas.modelo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstacaoEspacialServico {

    private final EstacaoEspacial estacaoEspacial;

    @Autowired
    public EstacaoEspacialServico(EstacaoEspacial estacaoEspacial) {
        this.estacaoEspacial = estacaoEspacial;
    }

    private Sentido explorarPlaneta(final Sondas sonda, List<Comandos> comandos) {
        comandos.forEach(g -> g.mover(sonda));
        return sonda.pegarSentidoAtual();
    }

    public Sentido explorarPlaneta(Sentido sentidoInicial, List<Comandos> comandos) {
        final Sondas sonda = estacaoEspacial.adicionaSondaNoPlaneta(sentidoInicial);
        return explorarPlaneta(sonda, comandos);
    }

    public List<Sentido> pegarSonda() {
        return estacaoEspacial.pegarSonda().stream().map(Sondas::pegarSentidoAtual).collect(Collectors.toList());
    }

    public Sentido adicionaSondaNoPlaneta(Sentido sentido) {
        return estacaoEspacial.adicionaSondaNoPlaneta(sentido).pegarSentidoAtual();
    }

    public Sentido explorarPlaneta(Posicao posicao, List<Comandos> comandos) {
        final Sondas sonda = estacaoEspacial.buscarPelaPosicao(posicao).orElseThrow(
                () -> new ExcecaoNaoEncontrada(" Sonda não foi encontrada na posição" + posicao.toString()));
        return explorarPlaneta(sonda, comandos);

    }

}
