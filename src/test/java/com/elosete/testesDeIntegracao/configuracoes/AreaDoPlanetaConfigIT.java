package com.elosete.testesDeIntegracao.configuracoes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.elosete.configuracoes.AreaDoPlanetaConfig;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AreaDoPlanetaConfigIT {
    @Autowired
    private AreaDoPlanetaConfig areaDoPlanetaConfig;

    @Test
    public void deveConfigurar() {
        assertThat(areaDoPlanetaConfig.getLimite()).isNotNull().hasFieldOrPropertyWithValue("x", 5)
                .hasFieldOrPropertyWithValue("y", 5);
    }

}
