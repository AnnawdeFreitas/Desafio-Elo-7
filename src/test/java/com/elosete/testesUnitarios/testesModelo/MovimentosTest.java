package com.elosete.annafreitas.testesUnitarios.testesModelo;

import com.elosete.annafreitas.modelo.Movimentos;
import com.elosete.annafreitas.modelo.Posicao;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovimentosTest {
    // Testes de movimentos - Andar para Frente

    @Test
    public void deveAndarParaNorte() {
        assertThat(Movimentos.NORTE.andarParaFrente(new Posicao(1, 5))).isEqualTo(new Posicao(1, 6));
    }

    @Test
    public void deveAndarParaSul() {
        assertThat(Movimentos.SUL.andarParaFrente(new Posicao(1, 5))).isEqualTo(new Posicao(1, 4));
    }

    @Test
    public void deveAndarParaOeste() {
        assertThat(Movimentos.OESTE.andarParaFrente(new Posicao(1, 5))).isEqualTo(new Posicao(0, 5));
    }

    @Test
    public void deveAndarParaLeste() {
        assertThat(Movimentos.LESTE.andarParaFrente(new Posicao(1, 5))).isEqualTo(new Posicao(2, 5));
    }

    // Testes de movimentos - Andar Para Esquerda

    @Test
    public void deveApontarDoOesteQuandoVirarAesquerdaDoNorte() {
        assertThat(Movimentos.NORTE.virarAEsquerda()).isEqualTo(Movimentos.OESTE);
    }

    @Test
    public void deveApontarDoLesteQuandoVirarAesquerdaDoSul() {
        assertThat(Movimentos.SUL.virarAEsquerda()).isEqualTo(Movimentos.LESTE);
    }

    @Test
    public void deveApontarDoNorteQuandoVirarAesquerdaDoLeste() {
        assertThat(Movimentos.LESTE.virarAEsquerda()).isEqualTo(Movimentos.NORTE);
    }

    @Test
    public void deveApontarDoSulQuandoVirarAesquerdaDoOeste() {
        assertThat(Movimentos.OESTE.virarAEsquerda()).isEqualTo(Movimentos.SUL);
    }

    // Testes de movimentos - Andar Para Esquerda

    @Test
    public void deveApontarDoNorteQuandoVirarADireitaDoOeste() {
        assertThat(Movimentos.OESTE.virarADireita()).isEqualTo(Movimentos.NORTE);
    }

    @Test
    public void deveApontarDoSulQuandoVirarADireitaDoLeste() {
        assertThat(Movimentos.LESTE.virarADireita()).isEqualTo(Movimentos.SUL);
    }

    @Test
    public void deveApontarDoOesteQuandoVirarADireitaDoNorte() {
        assertThat(Movimentos.NORTE.virarADireita()).isEqualTo(Movimentos.LESTE);
    }

    @Test
    public void deveApontarDoLesteQuandoVirarADireitaDoSul() {
        assertThat(Movimentos.SUL.virarADireita()).isEqualTo(Movimentos.OESTE);
    }
}
