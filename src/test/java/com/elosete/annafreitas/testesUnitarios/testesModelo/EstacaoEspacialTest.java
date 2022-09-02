package com.elosete.annafreitas.testesUnitarios.testesModelo;

import com.elosete.annafreitas.modelo.Comandos;
import com.elosete.annafreitas.modelo.EstacaoEspacial;
import com.elosete.annafreitas.modelo.Planetas;
import com.elosete.annafreitas.modelo.Sentido;
import com.elosete.annafreitas.modelo.Sondas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EstacaoEspacialTest {

    @InjectMocks
    private EstacaoEspacial estacaoEspacial;

    @Mock
    private Planetas planeta;

    @Test
    public void deveAdicionarSondaNoPlaneta() {
        assertThat(estacaoEspacial.adicionaSondaNoPlaneta(mock(Sentido.class))).isNotNull();
    }

    @Test
    public void deveMoverSonda() {
        final Comandos comando = Comandos.MOVE;
        final Sondas sonda = mock(Sondas.class);

        estacaoEspacial.mover(comando, sonda);
        verify(sonda, only()).andarParaFrente();
    }

}
