package com.elosete.annafreitas.testesModelo;

import com.elosete.annafreitas.excecoes.ExcecaoRegraNegocios;
import com.elosete.annafreitas.modelo.AreaPlanalto;
import com.elosete.annafreitas.modelo.Posicao;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AreaPlanaltoTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private AreaPlanalto areaPlanalto;

    @Mock
    private Posicao margemInferiorEsquerda;

    @Mock
    private Posicao margemSuperiorDireita;

    @Mock
    private Posicao posicao;

    @Before
    public void init() {
        this.areaPlanalto = new AreaPlanalto(margemInferiorEsquerda, margemSuperiorDireita);
    }

    @Test
    public void deveSerValidoQuandoEstiverDentroDoLimite() {
        when(posicao.eMaiorOuIgualA(margemInferiorEsquerda)).thenReturn(true);
        when(posicao.eMenorOuIgualA(margemSuperiorDireita)).thenReturn(true);

        areaPlanalto.validarArea(posicao);

        verify(posicao).eMaiorOuIgualA((margemInferiorEsquerda));
        verify(posicao).eMenorOuIgualA((margemSuperiorDireita));

    }

    @Test
    public void deveSerInvalidoQuandoEstiverForaDoLimiteDaMargemInferiorEsquerda() {
        when(posicao.eMaiorOuIgualA(margemInferiorEsquerda)).thenReturn(false);

        when(posicao.toString()).thenReturn("(3,4)");
        when(margemInferiorEsquerda.toString()).thenReturn("(7,8)");

        expectedException.expect(ExcecaoRegraNegocios.class);
        expectedException.expectMessage("A Posição (3,4) Está fora da área que inicia em (7,8)");

        areaPlanalto.validarArea(posicao);

    }

    @Test
    public void deveSerInvalidoQuandoEstiverForaDoLimiteDaMargemSuperiorDireita() {
        when(posicao.eMaiorOuIgualA(margemInferiorEsquerda)).thenReturn(true);
        when(posicao.eMenorOuIgualA(margemSuperiorDireita)).thenReturn(false);

        when(posicao.toString()).thenReturn("(5,6)");
        when(margemSuperiorDireita.toString()).thenReturn("(1,2)");

        expectedException.expect(ExcecaoRegraNegocios.class);
        expectedException.expectMessage("A Posição (5,6) Está fora da área que termina em (1,2)");

        areaPlanalto.validarArea(posicao);

    }

}