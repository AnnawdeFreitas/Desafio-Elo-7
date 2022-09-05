package com.elosete.configuracoes;

import com.elosete.configuracoes.AreaDoPlanetaConfig.Limite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.elosete.componente.ExplorandoBuild;
import com.elosete.modelo.EstacaoEspacial;

@Configuration
public class ExplorandoConfig {

    @Bean
    @Autowired
    public EstacaoEspacial pegarEstacaoEspacial(AreaDoPlanetaConfig areaDoPlanetaConfig,
            ExplorandoBuild explorandoBuild) {
        final Limite limite = areaDoPlanetaConfig.getLimite();
        return explorandoBuild
                .limiteAreaDoPlaneta(limite.getX(), limite.getY())
                .comPlaneta()
                .comEstacaoEspacial()
                .build();
    }

}
