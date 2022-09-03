package com.elosete.testesUnitarios.testesComponente;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.elosete.componente.ExplorandoBuild;
import com.elosete.modelo.EstacaoEspacial;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ExplorandoBuildTest {

    @InjectMocks
    private ExplorandoBuild explorandoBuild;

    @Test
    public void deveConstruirAmbiente() {
        final EstacaoEspacial estacaoEspacial = explorandoBuild.limiteAreaDoPlaneta(3, 5).comPlaneta()
                .comEstacaoEspacial().build();
        assertThat(estacaoEspacial).isNotNull();
    }

}
