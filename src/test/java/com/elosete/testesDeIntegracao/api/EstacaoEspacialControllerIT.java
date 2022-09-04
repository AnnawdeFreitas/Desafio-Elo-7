package com.elosete.testesDeIntegracao.api;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EstacaoEspacialControllerIT {

    private static final String PATH = "/estacao-espacial/sondas";

    @Autowired
    private WebApplicationContext context;

    private MockMvcRequestSpecification given;

    @Before
    public void init() {
        final MockMvc mvc = webAppContextSetup(context).build();
        this.given = RestAssuredMockMvc.given().mockMvc(mvc).contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(ContentType.JSON);
    }

    @Test
    public void deveExplorarPlaneta() {
        given.body("{\n"
                + "    \"x\": 1,\n"
                + "    \"y\": 2,\n"
                + "    \"movimentos\": \"N\",\n"
                + "    \"comandos\": [\"M\",\"L\",\"R\",\"R\"]\n"
                + "}").post(PATH + "/explorar-planeta-pela-jornada").then().assertThat()
                .statusCode(is(HttpStatus.OK.value())).body("x", equalTo(1)).body("y", equalTo(3))
                .body("movimentos", equalTo("E"));
    }

    @Test
    public void deveExplorarPlanetaAposOutraSonda(){
        deveExplorarPlaneta();

        given.body("{\n"
                + "    \"x\": 1,\n"
                + "    \"y\": 2,\n"
                + "    \"movimentos\": \"W\",\n"
                + "    \"comandos\": [\"M\",\"R\"]\n"
                + "}").post(PATH + "/explorar-planeta-pela-jornada").then().assertThat()
                .statusCode(is(HttpStatus.OK.value())).body("x", equalTo(0)).body("y", equalTo(2))
                .body("movimentos", equalTo("N"));
    }

    @Test
    public void deveExplorarPlanetaComVariosMovimentos() {
        given.body("{\n"
                + "    \"x\": 1,\n"
                + "    \"y\": 2,\n"
                + "    \"movimentos\": \"N\",\n"
                + "    \"comandos\": [\"L\",\"M\",\"L\",\"M\",\"L\",\"M\",\"L\",\"M\",\"M\"]\n"
                + "}").post(PATH + "/explorar-planeta-pela-jornada").then().assertThat()
                .statusCode(is(HttpStatus.OK.value())).body("x", equalTo(1)).body("y", equalTo(3))
                .body("movimentos", equalTo("N"));

        given.body("{\n"
                + "    \"x\": 3,\n"
                + "    \"y\": 3,\n"
                + "    \"movimentos\": \"E\",\n"
                + "    \"comandos\": [\"M\",\"M\",\"R\",\"M\",\"M\",\"R\",\"M\",\"R\",\"R\",\"M\"]\n"
                + "}").post(PATH + "/explorar-planeta-pela-jornada").then().assertThat()
                .statusCode(is(HttpStatus.OK.value())).body("x", equalTo(5)).body("y", equalTo(1))
                .body("movimentos", equalTo("E"));

        given.get(PATH).then().assertThat().statusCode(is(HttpStatus.OK.value())).body("size()", is(2))
                .body("x", hasItem(1)).body("y", hasItem(3)).body("movimentos", hasItem("N"))
                .body("x", hasItem(5)).body("y", hasItem(1)).body("movimentos", hasItem("E"));
    }

    @Test
    public void naoDevePousarUmaSondaEmPosicaoJaOcupada() {
        deveExplorarPlaneta();

        given.body("{\n"
                + "    \"x\": 1,\n"
                + "    \"y\": 2,\n"
                + "    \"movimentos\": \"N\",\n"
                + "    \"comandos\": [\"M\",\"L\",\"R\",\"R\"]\n"
                + "}").post(PATH + "/explorar-planeta-pela-jornada").then().assertThat()
                .statusCode(is(HttpStatus.BAD_REQUEST.value()))
                .body("mensagem", equalTo("A posição (1, 3) está ocupada"));
    }

    @Test
    public void deveReportarUmaSonda() {
        deveExplorarPlanetaAposOutraSonda();

        given.get(PATH).then().statusCode(is(HttpStatus.OK.value())).body("size()", is(2)).body("x", hasItem(1))
                .body("y", hasItem(3)).body("movimentos", hasItem("E")).body("x", hasItem(0))
                .body("y", hasItem(2)).body("movimentos", hasItem("N"));
    }

    @Test
    public void deveAdicionarUmaSondaAoPlaneta() {
        given.body("{\n"
                + "    \"x\": 3,\n"
                + "    \"y\": 4,\n"
                + "    \"movimentos\": \"S\"\n"
                + "}").post(PATH).then().assertThat().statusCode(is(HttpStatus.CREATED.value()))
                .body("x", equalTo(3)).body("y", equalTo(4)).body("movimentos", equalTo("S"));
    }

    @Test
    public void deveExplorarPlanetaQuandoCriarUmaSonda() {
        deveExplorarPlaneta();
        given.body("[\"L\",\"M\",\"M\",\"L\"]").put(PATH + "/1/3/explore-planet-by-position"). // E
                then().assertThat().statusCode(is(HttpStatus.OK.value())).body("x", equalTo(1))
                .body("y", equalTo(5)).body("movimentos", equalTo("W"));
    }

    @Test
    public void naoDeveEncontrarSondaNaPosicaoIndicada() {
        given.body("[\"L\"]").put(PATH + "/1/3/explore-planet-by-position"). // E
                then().statusCode(is(HttpStatus.NOT_FOUND.value()))
                .body("mensagem", equalTo("Sonda não encontrada na posição (1, 3)"));
    }

    @Test
    public void naoDeveSerImplantadoForaDaAreaDeSegurancaAntesDaMargemInferiorEsquerda() {
        given.body("{\n"
                + "    \"x\": -1,\n"
                + "    \"y\": 0,\n"
                + "    \"movimentos\": \"S\"\n"
                + "}").post(PATH).then().assertThat().statusCode(is(HttpStatus.BAD_REQUEST.value()))
                .body("mensagem", equalTo("A Posição (-1, 0) Está fora da área que inicia em (0, 0)"));
    }

    @Test
    public void naoDeveSerImplantadoForaDaAreaDeSegurancaAntesDaMargemSuperiorDireita() {
        given.body("{\n"
                + "    \"x\": 200,\n"
                + "    \"y\": 300,\n"
                + "    \"movimentos\": \"S\"\n"
                + "}").post(PATH).then().assertThat().statusCode(is(HttpStatus.BAD_REQUEST.value()))
                .body("mensagem", equalTo("A Posição (200, 300) Está fora da área que termina em (5, 5)"));
    }

}
