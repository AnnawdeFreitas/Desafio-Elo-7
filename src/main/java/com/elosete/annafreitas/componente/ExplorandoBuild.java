package com.elosete.annafreitas.componente;

import com.elosete.annafreitas.modelo.*;

import org.springframework.stereotype.Component;

@Component
public class ExplorandoBuild {
    public AreaPlanaltoBuildImpl limiteAreaPlanalto(Integer margemSuperiorDireitaX, Integer margemInferiorEsquerdaY) {
        return new AreaPlanaltoBuildImpl(margemInferiorEsquerdaY, margemSuperiorDireitaX);
    }

    public static class AreaPlanaltoBuildImpl {

        private final Posicao margemSuperiorDireita;
        private final Posicao margemInferiorEsquerda;

        private AreaPlanaltoBuildImpl(Integer margemSuperiorDireitaX, Integer margemInferiorEsquerdaY) {
            this.margemSuperiorDireita = new Posicao(margemSuperiorDireitaX, margemInferiorEsquerdaY);
            this.margemInferiorEsquerda = new Posicao(0, 0);
        }

        public PlanetaBuildImpl comPlaneta() {
            return new PlanetaBuildImpl(new AreaPlanalto(margemSuperiorDireita, margemInferiorEsquerda));
        }
    }

    public static class PlanetaBuildImpl {
        private final AreaPlanalto areaPlanalto;

        private PlanetaBuildImpl(AreaPlanalto areaPlanalto) {
            this.areaPlanalto = areaPlanalto;
        }

        public EstacaoEspacialBuildImpl comEstacaoEspacial() {
            return new EstacaoEspacialBuildImpl(new Planetas(areaPlanalto));

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
