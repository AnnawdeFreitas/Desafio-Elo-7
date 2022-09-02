package com.elosete.annafreitas.testesUnitarios.testesModelo;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import com.elosete.annafreitas.modelo.Posicao;

public class PosicaoTest {

    private Posicao posicao;

    @Before
    public void init() {
        this.posicao = new Posicao(1, 2);
    }


    @Test
    public void deveSerIgualComXeY() {
        final Posicao posicao = new Posicao(1, 2);
        Assertions.assertThat(posicao.eMaiorOuIgualA(posicao)).isTrue();
        Assertions.assertThat(posicao.eMenorOuIgualA(posicao)).isTrue();

    }

    @Test
    public void deveSerIguaXeY() {
        Assertions.assertThat(posicao.eMaiorOuIgualA(new Posicao(0, 0))).isTrue();
    }

    @Test
    public void deveSerMaiorX() {
        Assertions.assertThat(posicao.eMaiorOuIgualA(new Posicao(1, 0))).isTrue();
    }

    @Test
    public void deveSerMaiorY() {
        Assertions.assertThat(posicao.eMaiorOuIgualA(new Posicao(0, 1))).isTrue();
    }

    @Test
    public void naoDeveSerMaiorXeY() {
        Assertions.assertThat(posicao.eMaiorOuIgualA(new Posicao(2, 3))).isFalse();
    }

    @Test
    public void naoDeveSerMaiorQueX() {
        Assertions.assertThat(posicao.eMaiorOuIgualA(new Posicao(2, 0))).isFalse();
    }

    @Test
    public void naoDeveSerMaiorQueY() {
        Assertions.assertThat(posicao.eMaiorOuIgualA(new Posicao(0, 3))).isFalse();
    }

    @Test
    public void deveSerMenorQueXeY() {
        Assertions.assertThat(posicao.eMenorOuIgualA(new Posicao(2, 3))).isFalse();
    }

    @Test
    public void deveSerMenorQueX() {
        Assertions.assertThat(posicao.eMenorOuIgualA(new Posicao(2, 2))).isFalse();
    }

    @Test
    public void deveSerMenorQueY() {
        Assertions.assertThat(posicao.eMenorOuIgualA(new Posicao(1, 3))).isFalse();
    }

    @Test
    public void naoDeveSerMenorQueXeY() {
        Assertions.assertThat(posicao.eMenorOuIgualA(new Posicao(0, 0))).isTrue();
    }

    @Test
    public void naoDeveSerMenorQueX() {
        Assertions.assertThat(posicao.eMenorOuIgualA(new Posicao(1, 0))).isTrue();
    }

    @Test
    public void naoDeveSerMenorQueY() {
        Assertions.assertThat(posicao.eMenorOuIgualA(new Posicao(0, 1))).isTrue();
    }

    @Test
    public void deveCompararPosicao() {
        Assertions.assertThat(posicao.compareCom(new Posicao(1, 2))).isEqualTo(0);

        Assertions.assertThat(posicao.compareCom(new Posicao(4, 2))).isEqualTo(-1);
        Assertions.assertThat(posicao.compareCom(new Posicao(1, 3))).isEqualTo(-1);

        Assertions.assertThat(posicao.compareCom(new Posicao(1, 0))).isEqualTo(1);
        Assertions.assertThat(posicao.compareCom(new Posicao(0, 2))).isEqualTo(1);

    }

}
