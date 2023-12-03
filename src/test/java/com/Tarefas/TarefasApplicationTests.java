package com.Tarefas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.Tarefas.entity.Tarefa;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql("/remove.sql")
class TarefasApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreatedTarefaSucess() {
		var tarefa = new Tarefa("Tarefa 1", "Tarefa 1 - Tarefa 1 de teste", false, 1);

		webTestClient
			.post()
			.uri("/tarefas")
			.bodyValue(tarefa)
			.exchange()
			.expectStatus().isCreated()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.lenght()").isEqualTo(1)
			.jsonPath("$[0].nome)").isEqualTo(tarefa.getNome())
			.jsonPath("$[0].descricao)").isEqualTo(tarefa.getDescricao())
			.jsonPath("$[0].realizado)").isEqualTo(tarefa.isRealizado())
			.jsonPath("$[0].prioridade)").isEqualTo(tarefa.getPrioridade());
	}

	@Test
	public void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(new Tarefa("", "", false, 0))
				.exchange()
				.expectStatus().isBadRequest();
	}

}
