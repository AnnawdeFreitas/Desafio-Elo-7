package com.elosete.testesUnitarios.testesModelo;

import com.elosete.excecoes.ExcecaoRegraNegocios;
import com.elosete.modelo.AreaDoPlaneta;
import com.elosete.modelo.Posicao;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AreaDoPlanetaTest {

    private AreaDoPlaneta areaDoPlaneta;

    @Mock
    private Posicao margemInferiorEsquerda;

    @Mock
    private Posicao margemSuperiorDireita;

    @Mock
    private Posicao posicao;

    @Before
    public void init() {
        this.areaDoPlaneta = new AreaDoPlaneta(margemInferiorEsquerda, margemSuperiorDireita);
    }

    @Test
    public void deveSerValidoQuandoEstiverDentroDoLimite() {
        when(posicao.eMaiorOuIgualA(margemInferiorEsquerda)).thenReturn(true);
        when(posicao.eMenorOuIgualA(margemSuperiorDireita)).thenReturn(true);

        areaDoPlaneta.validarArea(posicao);

        verify(posicao).eMaiorOuIgualA((margemInferiorEsquerda));
        verify(posicao).eMenorOuIgualA((margemSuperiorDireita));

    }

    @Test
    public void deveSerInvalidoQuandoEstiverForaDoLimiteDaMargemInferiorEsquerda() {
        when(posicao.eMaiorOuIgualA(margemInferiorEsquerda)).thenReturn(false);

        when(posicao.toString()).thenReturn("(3,4)");
        when(margemInferiorEsquerda.toString()).thenReturn("(7,8)");

        Assertions.assertThrows( "A Posição (3,4) Está fora da área que inicia em (7,8)");

        areaDoPlaneta.validarArea(posicao);

    }

    @Test
    public void deveSerInvalidoQuandoEstiverForaDoLimiteDaMargemSuperiorDireita() {
        when(posicao.eMaiorOuIgualA(margemInferiorEsquerda)).thenReturn(true);
        when(posicao.eMenorOuIgualA(margemSuperiorDireita)).thenReturn(false);

        when(posicao.toString()).thenReturn("(5,6)");
        when(margemSuperiorDireita.toString()).thenReturn("(1,2)");

        Assertions.assertThat("A Posição (5,6) Está fora da área que termina em (1,2)");

        areaDoPlaneta.validarArea(posicao);

    }

}