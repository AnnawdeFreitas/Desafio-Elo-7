package com.elosete.testesDeIntegracao.modelo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.elosete.api.mapper.Jornada;
import com.elosete.modelo.Comandos;
import com.elosete.modelo.Movimentos;
import com.elosete.modelo.Posicao;
import com.elosete.modelo.Sentido;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;

@RunWith(SpringRunner.class)
@SpringBootTest

public class JornadaIT {

    private static final String JSON = "{\n"
            + "    \"x\": 1,\n"
            + "    \"y\": 2,\n"
            + "    \"navigationSense\": \"N\",\n"
            + "    \"Comandoss\": [\"M\",\"L\",\"R\",\"R\"]\n"
            + "}";

    @Autowired
    private ObjectMapper objectMapper;

    private Jornada jornada;

    @Before
    public void init() {
        final Posicao posicao = new Posicao(1, 2);
        final Movimentos movimentos = Movimentos.NORTE;
        final Sentido sentido = new Sentido(posicao, movimentos);
        final List<Comandos> comandos = ImmutableList.<Comandos>builder().add(Comandos.MOVE)
                .add(Comandos.VIRAR_ESQUERDA).add(Comandos.VIRAR_DIREITA).add(Comandos.VIRAR_DIREITA).build();

        this.jornada = new Jornada(sentido, comandos);
    }

    @Test
    public void deveSerializar() throws JsonProcessingException {
        assertThatJson(objectMapper.writeValueAsString(jornada)).isEqualTo(JSON);
    }

    @Test
    public void deveDesserializar() throws IOException {
        final Jornada jornada = objectMapper.readValue(JSON, Jornada.class);
        assertThat(jornada).isNotNull().hasFieldOrProperty("sentido").hasFieldOrProperty("comandos");
    }
}
