package com.carbonorural.carbonoruralapi.steps;

import io.cucumber.java.pt.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalSteps {

    private RequestSpecification request;
    private Response response;
    private Map<String, String> animalData;
    private static final String BASE_URL = "http://localhost:8080";

    // ============ Cenário Positivo: Cadastrar animal ============

    @Dado("que eu tenho os dados de um animal")
    public void que_eu_tenho_os_dados_de_um_animal(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps();
        animalData = new HashMap<>();
        animalData.put("nome", rows.get(0).get("nome"));
        animalData.put("especie", rows.get(0).get("especie"));

        request = given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(animalData);
    }

    @Quando("eu envio uma requisição POST para {string}")
    public void eu_envio_uma_requisicao_post_para(String endpoint) {
        response = request.post(endpoint);
    }

    @Então("o status da resposta deve ser {int}")
    public void o_status_da_resposta_deve_ser(Integer statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Então("o corpo da resposta deve conter os dados do animal cadastrado")
    public void o_corpo_da_resposta_deve_conter_os_dados_do_animal_cadastrado() {
        response.then()
                .body("nome", equalTo(animalData.get("nome")))
                .body("especie", equalTo(animalData.get("especie")));
    }

    @Então("o campo {string} não deve ser nulo")
    public void o_campo_nao_deve_ser_nulo(String campo) {
        response.then().body(campo, notNullValue());
    }

    // ============ Cenário ESG: Listar e validar contrato ============

    @Dado("que existem animais cadastrados no sistema")
    public void que_existem_animais_cadastrados_no_sistema() {
        given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(Map.of("nome", "Nelore", "especie", "Bovino"))
                .post("/animais");
    }

    @Quando("eu envio uma requisição GET para {string}")
    public void eu_envio_uma_requisicao_get_para(String endpoint) {
        response = given()
                .baseUri(BASE_URL)
                .get(endpoint);
    }

    @Então("a resposta deve ser uma lista")
    public void a_resposta_deve_ser_uma_lista() {
        response.then().body("$", instanceOf(List.class));
    }

    @Então("cada animal da lista deve conter os campos obrigatórios {string}, {string} e {string}")
    public void cada_animal_da_lista_deve_conter_os_campos_obrigatorios(String id, String nome, String especie) {
        List<Map<String, Object>> animais = response.jsonPath().getList("$");
        for (Map<String, Object> animal : animais) {
            assertTrue(animal.containsKey(id), "Animal não contém campo: " + id);
            assertTrue(animal.containsKey(nome), "Animal não contém campo: " + nome);
            assertTrue(animal.containsKey(especie), "Animal não contém campo: " + especie);
        }
    }

    @Então("o contrato da resposta deve estar em conformidade com o JSON Schema")
    public void o_contrato_da_resposta_deve_estar_em_conformidade_com_o_json_schema() {
        response.then()
                .body(matchesJsonSchemaInClasspath("schemas/animal-response-schema.json"));
    }

    // ============ Cenário Negativo: ID inexistente ============

    @Dado("que não existe animal com ID {int}")
    public void que_nao_existe_animal_com_id(Integer id) {
        given().baseUri(BASE_URL).delete("/animais/" + id);
    }
}