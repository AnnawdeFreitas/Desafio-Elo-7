package com.elosete.annafreitas.testesUnitarios.testesConfig;

import com.elosete.annafreitas.componente.ExplorandoBuild;
import com.elosete.annafreitas.configuracoes.AreaDoPlanetaConfig;
import com.elosete.annafreitas.configuracoes.ExplorandoConfig;
import com.elosete.annafreitas.configuracoes.AreaDoPlanetaConfig.Limite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ExplorandoConfigTest {
    @InjectMocks
    private ExplorandoConfig explorandoConfig;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private ExplorandoBuild explorandoBuild;

    private AreaDoPlanetaConfig areaDoPlanetaConfig;

    @Before
    public void init() {
        areaDoPlanetaConfig = new AreaDoPlanetaConfig();
        final Limite limite = new Limite();
        limite.setX(9);
        limite.setY(6);
        areaDoPlanetaConfig.setLimite(limite);
    }

    @Test
    public void deveConstruirAmbienteComParametros() {
        assertThat(explorandoConfig.pegarEstacaoEspacial(areaDoPlanetaConfig, explorandoBuild)).isNotNull();
    }

}
