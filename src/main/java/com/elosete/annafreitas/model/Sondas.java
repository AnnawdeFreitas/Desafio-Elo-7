public class Sondas {
    private Planetas planeta;
    private Posicao posicao;
    private Comandos comandos;

    public Sondas(Planetas planeta, Sentido sentido) {
        this(planeta, sentido.getPosicao(), sentido.getMovimentos());
    }

    public Sondas(Planetas planeta, Posicao posicao, Comandos comandos) {
        this.comandos = comandos;
        this.planeta = planeta;
        this.posicao = posicao;

        this.planeta.pousar(posicao, this);

    }

    public Posicao andarParaFrente() {
        posicao novaPosicao = comandos.andarParaFrente(posicao);
        planeta.mudaPosicaoAtual(posicao, novaPosicao);
        this.posicao = novaPosicao;
        return posicao;
    }

    public Comandos virarAEsquerda() {
        this.comandos = comandos.virarAEsquerda();
        return this.comandos;
    }

    public Comandos virarADireita() {
        this.comandos = comandos.virarADireita();
        return this.comandos;
    }

    public Sentido getSentidoAtual() {
        return new Sentido(posicao, comandos);
    }

}