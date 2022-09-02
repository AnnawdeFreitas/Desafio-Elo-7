package com.elosete.annafreitas.testesUnitarios.testesModelo;

import com.elosete.annafreitas.excecoes.ExcecaoNaoEncontrada;
import com.elosete.annafreitas.excecoes.ExcecaoRegraNegocios;
import com.elosete.annafreitas.modelo.AreaPlanalto;
import com.elosete.annafreitas.modelo.Planetas;
import com.elosete.annafreitas.modelo.Posicao;
import com.elosete.annafreitas.modelo.Sondas;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
    private AreaPlanalto areaPlanalto;

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

    @Test
    public void naoDeveMudarPosicaoDaSondaQuandoAreaPlanaltoForInvalida() {
        final Posicao posicaoAtual = mock(Posicao.class);
        final Posicao novaPosicao = new Posicao(9, 10);

        final String messageException = "A posição está fora da área de segurança";
        
        Assertions.assertThrows(ExcecaoRegraNegocios.class, ()->  planeta.mudarPosicaoAtual(posicaoAtual,novaPosicao));
        doThrow(new ExcecaoRegraNegocios(messageException))
                .when(areaPlanalto)
                .validarArea(novaPosicao);
        planeta.mudarPosicaoAtual(posicaoAtual, novaPosicao);
    }

    @Test
    public void naoDevePousarASondaEnquantoAAreaDePousoEstiverOcupada() {
        final Sondas sonda = mock(Sondas.class);
        final Posicao posicao = new Posicao(3, 5);
        final Posicao posicaoDuplicada = new Posicao(3, 5);

        Assertions.assertThrows(ExcecaoNaoEncontrada.class, ()->  planeta.pousar(posicao,sonda));
        Assertions.assertThrows(ExcecaoNaoEncontrada.class, ()->  planeta.pousar(posicaoDuplicada,sonda));

        verify(areaPlanalto, only()).validarArea(posicao);
    }

}
