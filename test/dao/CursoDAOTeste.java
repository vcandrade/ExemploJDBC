package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import entities.Curso;

class CursoDAOTeste {

	@Disabled
	void cadastrarCursoTeste() throws SQLException, IOException {

		Curso curso = new Curso();
		curso.setNome("Tecnol. em Análise e Desenvolv. de Sistemas");
		curso.setPeriodo("Noturno");
		curso.setDuracao(6);

		Connection conn = BancoDados.conectar();
		int resultado = new CursoDAO(conn).cadastrar(curso);

		assertEquals(1, resultado);
	}

	@Test
	void buscarTodosCursosTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		List<Curso> listaCursos = new CursoDAO(conn).buscarTodos();

		assertNotNull(listaCursos);
	}

	@Test
	void buscarPorCodigoCursosTeste() throws SQLException, IOException {

		int codigoCurso = 2;

		Connection conn = BancoDados.conectar();
		Curso curso = new CursoDAO(conn).buscarPorCodigo(codigoCurso);

		assertNotNull(curso);
		assertEquals("Bacharelado em Ciência da Computação", curso.getNome());
	}

	@Disabled
	void atualizarCursoTeste() throws SQLException, IOException {

		Curso curso = new Curso();
		curso.setCodigo(3);
		curso.setDuracao(10);
		curso.setPeriodo("Noturno");

		Connection conn = BancoDados.conectar();
		int resultado = new CursoDAO(conn).atualizar(curso);

		assertEquals(1, resultado);
	}

	@Disabled
	void excluirCursoTeste() throws SQLException, IOException {

		int codigoCurso = 4;

		Connection conn = BancoDados.conectar();
		int resultado = new CursoDAO(conn).excluir(codigoCurso);

		assertEquals(1, resultado);
	}
}
