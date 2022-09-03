package com.elosete.testesUnitarios.testesServico;

import com.elosete.modelo.Comandos;
import com.elosete.modelo.EstacaoEspacial;
import com.elosete.modelo.Sentido;
import com.elosete.modelo.Sondas;
import com.elosete.servico.EstacaoEspacialServico;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.assertj.core.api.Assertions;


@RunWith(MockitoJUnitRunner.class)
public class EstacaoEspacialServicoTest {

    @InjectMocks
    private EstacaoEspacialServico estacaoEspacialServico;
    @Mock
    private EstacaoEspacial estacaoEspacial;

    @Test
    public void deveExplorarPlanetas(){
        final Sentido sentidoInicial = mock(Sentido.class);
        final List<Comandos> comandos = mock(List.class);
        final Sondas sonda = mock(Sondas.class);
        final Sentido sentidoFinal = mock(Sentido.class);

        when(estacaoEspacial.adicionaSondaNoPlaneta(sentidoInicial)).thenReturn(sonda);
        when(sonda.pegarSentidoAtual()).thenReturn(sentidoFinal);
        final Sentido result = estacaoEspacialServico.explorarPlaneta(sentidoInicial, comandos);

        Assertions.assertThat(result).isEqualTo(sentidoFinal);

        verify(comandos, only()).forEach(any(Consumer.class));
    }

}
