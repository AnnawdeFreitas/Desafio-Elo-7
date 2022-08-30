import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.function.Function;

public enum
Comandos {
    @JsonProperty("N")
    NORTE(posicaoAtual -> new

            Posicao(posicaoAtual.getX(), posicaoAtual.

            getY() + 1)) {
        public Comandos virarAEsquerda() {
            return OESTE;
        }

        public Comandos virarADireita() {
            return LESTE;
        }
    },

    @JsonProperty("E")
    LESTE(posicaoAtual -> new

            Posicao(posicaoAtual.getX() + 1, posicaoAtual.getY())) {
        public Comandos virarAEsquerda() {
            return NORTE;
        }

        public Comandos virarADireita() {
            return SUL;
        }
    },

    @JsonProperty("S")
    SUL(posicaoAtual -> new

            Posicao(posicaoAtual.getX(), posicaoAtual.

            getY() - 1)) {
        public Comandos virarAEsquerda() {
            return LESTE;
        }

        public Comandos virarADireita() {
            return OESTE;
        }
    },

    @JsonProperty("W")
    OESTE(posicaoAtual -> new

            Posicao(posicaoAtual.getX() - 1, posicaoAtual.

            getY())) {
        public Comandos virarAEsquerda() {
            return SUL;
        }

        public Comandos virarADireita() {
            return NORTE;
        }
    };

    private Function<Posicao, Posicao>
            andarParaFrente;

    Comandos(Function<Posicao, Posicao> andarParaFrente) {
        this.andarParaFrente = andarParaFrente;
    }

    public Posicao andarParaFrente(Posicao, posicaoAtual) {
        return andarParaFrente.apply(posicaoAtual);
    }

    public abstract Comandos virarAEsquerda();

    public abstract Comandos virarADireita();

}