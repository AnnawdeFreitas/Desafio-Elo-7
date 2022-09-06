package com.elosete.componente;

import com.elosete.modelo.*;

import org.springframework.stereotype.Component;

@Component
public class ExplorandoBuild {
    
    public AreaDoPlanetaBuildImpl limiteAreaDoPlaneta(Integer margemSuperiorDireitaX, Integer margemInferiorEsquerdaY) {
        return new AreaDoPlanetaBuildImpl(margemInferiorEsquerdaY, margemSuperiorDireitaX);
    }

    public static class AreaDoPlanetaBuildImpl {

        private final Posicao margemSuperiorDireita;
        private final Posicao margemInferiorEsquerda;

        private AreaDoPlanetaBuildImpl(Integer margemSuperiorDireitaX, Integer margemInferiorEsquerdaY) {
            this.margemSuperiorDireita = new Posicao(margemSuperiorDireitaX, margemInferiorEsquerdaY);
            this.margemInferiorEsquerda = new Posicao(0, 0);
        }

        public PlanetaBuildImpl comPlaneta() {
            return new PlanetaBuildImpl(new AreaDoPlaneta(margemSuperiorDireita, margemInferiorEsquerda));
        }
    }

    public static class PlanetaBuildImpl {
        private final AreaDoPlaneta areaDoPlaneta;

        private PlanetaBuildImpl(AreaDoPlaneta areaDoPlaneta) {
            this.areaDoPlaneta = areaDoPlaneta;
        }

        public EstacaoEspacialBuildImpl comEstacaoEspacial() {
            return new EstacaoEspacialBuildImpl(new Planetas(areaDoPlaneta));

        }
    }

    public static class EstacaoEspacialBuildImpl {
        private final Planetas planeta;

        private EstacaoEspacialBuildImpl(Planetas planeta) {
            this.planeta = planeta;
        }

        public EstacaoEspacial build() {
            return new EstacaoEspacial(planeta);
        }
    }

}
