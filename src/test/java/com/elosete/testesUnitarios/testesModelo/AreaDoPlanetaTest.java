package com.elosete.testesUnitarios.testesModelo;

import com.elosete.modelo.AreaDoPlaneta;
import com.elosete.modelo.Posicao;
import org.junit.Before;
import org.junit.Test;
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

}