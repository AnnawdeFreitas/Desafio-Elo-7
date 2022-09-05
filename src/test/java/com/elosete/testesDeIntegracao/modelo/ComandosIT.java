package com.elosete.testesDeIntegracao.modelo;

import com.elosete.modelo.Comandos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComandosIT {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveSerializar() throws JsonProcessingException {
        assertThat(objectMapper.writeValueAsString(Comandos.MOVE)).isEqualTo("\"M\"");
        assertThat(objectMapper.writeValueAsString(Comandos.VIRAR_ESQUERDA)).isEqualTo("\"L\"");
        assertThat(objectMapper.writeValueAsString(Comandos.VIRAR_DIREITA)).isEqualTo("\"R\"");
    }

    @Test
    public void deveDesserializar() throws IOException {
        assertThat(objectMapper.readValue("\"M\"", Comandos.class)).isEqualTo(Comandos.MOVE);
        assertThat(objectMapper.readValue("\"L\"", Comandos.class)).isEqualTo(Comandos.VIRAR_ESQUERDA);
        assertThat(objectMapper.readValue("\"R\"", Comandos.class)).isEqualTo(Comandos.VIRAR_DIREITA);
    }
}
