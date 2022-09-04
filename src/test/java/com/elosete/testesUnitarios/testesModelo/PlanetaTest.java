package com.elosete.testesUnitarios.testesModelo;

import com.elosete.modelo.AreaDoPlaneta;
import com.elosete.modelo.Planetas;
import com.elosete.modelo.Posicao;
import com.elosete.modelo.Sondas;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PlanetaTest {

    @InjectMocks
    private Planetas planeta;

    @Mock
    private AreaDoPlaneta areaPlanalto;

    @Test
    public void devePousarNovaSonda() {
        final Posicao posicao = mock(Posicao.class);
        final Sondas sonda = mock(Sondas.class);

        planeta.pousar(posicao, sonda);
        verify(areaPlanalto, only()).validarArea(posicao);
    }

    @Test
    public void devePousarNovaSondaAposPosicaoEstarLivre() {
        final Posicao posicao = new Posicao(1, 2);
        final Sondas sonda = mock(Sondas.class);
        final Posicao posicao1 = new Posicao(3, 4);
        final Sondas sonda1 = mock(Sondas.class);

        planeta.pousar(posicao, sonda);
        planeta.mudarPosicaoAtual(posicao, posicao1);
        planeta.pousar(posicao, sonda1);

        verify(areaPlanalto, times(3)).validarArea(any(Posicao.class));
    }

    @Test
    public void devePousarNovaSondaEmLugarDiferente() {

        final Posicao posicao = new Posicao(1, 2);
        final Sondas sonda = mock(Sondas.class);
        final Posicao posicao1 = new Posicao(3, 4);
        final Sondas sonda1 = mock(Sondas.class);

        planeta.pousar(posicao, sonda);
        planeta.pousar(posicao1, sonda1);

        verify(areaPlanalto, times(2)).validarArea(any(Posicao.class));
    }

    @Test
    public void deveMudarPosicaoDaSonda() {
        final Posicao posicaoAtual = new Posicao(0, 2);
        final Posicao novaPosicao = new Posicao(1, 2);
        final Sondas sonda = mock(Sondas.class);

        planeta.pousar(posicaoAtual, sonda);
        planeta.mudarPosicaoAtual(posicaoAtual, novaPosicao);

        verify(areaPlanalto, times(2)).validarArea(any(Posicao.class));
    }
}
