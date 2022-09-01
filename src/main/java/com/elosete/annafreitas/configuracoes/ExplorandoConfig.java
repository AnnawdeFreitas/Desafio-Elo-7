package com.elosete.annafreitas.configuracoes;

import com.elosete.annafreitas.configuracoes.AreaPlanaltoConfig.Limite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.elosete.annafreitas.componente.ExplorandoBuild;
import com.elosete.annafreitas.modelo.EstacaoEspacial;

@Configuration
public class ExplorandoConfig {

    @Bean
    @Autowired
    public EstacaoEspacial pegarEstacaoEspacial(AreaPlanaltoConfig areaPlanaltoConfig, ExplorandoBuild explorandoBuild) {
         final Limite limite = areaPlanaltoConfig.getLimite();
        return explorandoBuild.limiteAreaPlanalto(limite.getX(), limite.getY()).comPlaneta().comEstacaoEspacial()
                .build();
    }

}
