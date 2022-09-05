package com.elosete.testesDeIntegracao.modelo;


import com.elosete.modelo.Movimentos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovimentosIT {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void deveSerializar() throws JsonProcessingException {
        assertThat(objectMapper.writeValueAsString(Movimentos.NORTE)).isEqualTo("\"N\"");
        assertThat(objectMapper.writeValueAsString(Movimentos.LESTE)).isEqualTo("\"E\"");
        assertThat(objectMapper.writeValueAsString(Movimentos.SUL)).isEqualTo("\"S\"");
        assertThat(objectMapper.writeValueAsString(Movimentos.OESTE)).isEqualTo("\"W\"");
    }

    @Test
    public void deveDesserializar() throws IOException {
        assertThat(objectMapper.readValue("\"N\"", Movimentos.class)).isEqualTo(Movimentos.NORTE);
        assertThat(objectMapper.readValue("\"E\"", Movimentos.class)).isEqualTo(Movimentos.LESTE);
        assertThat(objectMapper.readValue("\"S\"", Movimentos.class)).isEqualTo(Movimentos.SUL);
        assertThat(objectMapper.readValue("\"W\"", Movimentos.class)).isEqualTo(Movimentos.OESTE);
    }
}
