package com.elosete.annafreitas.testesUnitarios.testesModelo;

import com.elosete.annafreitas.modelo.Movimentos;
import com.elosete.annafreitas.modelo.Planetas;
import com.elosete.annafreitas.modelo.Posicao;
import com.elosete.annafreitas.modelo.Sondas;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.assertj.core.api.Assertions;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SondasTest {

    private Sondas sonda;

    @Mock
    private Planetas planeta;

    private Posicao posicao;
    private Movimentos movimentos;

    @Before
    public void init() {
        this.posicao = new Posicao(1, 2);
        this.movimentos = Movimentos.NORTE;
        this.sonda = new Sondas(planeta, posicao, movimentos);
    }

    @Test
    public void deveAndarParaFrente() {
        Assertions.assertThat(sonda.andarParaFrente()).isEqualTo(new Posicao(1, 3));
    }

    @Test
    public void devePousarNoPlaneta() {
        final Planetas planeta = mock(Planetas.class);
        final Posicao posicao = mock(Posicao.class);
        final Sondas sonda = new Sondas(planeta, posicao, mock(Movimentos.class));

        verify(planeta, only()).pousar(posicao, sonda);
    }

    @Test
    public void deveVirarAEsquerda() {
        Assertions.assertThat(sonda.virarAEsquerda()).isEqualTo(Movimentos.OESTE);
    }

    public void deveVirarADireita() {
        Assertions.assertThat(sonda.virarADireita()).isEqualTo(Movimentos.LESTE);
    }

    public void devePegarAoSentidoAtual() {
        Assertions.assertThat(sonda.pegarSentidoAtual()).isNotNull();
    }
}
