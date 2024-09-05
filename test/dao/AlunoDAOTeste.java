package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import entities.Aluno;
import entities.Curso;

class AlunoDAOTeste {

	@Disabled
	void cadastrarAlunoTeste() throws ParseException, SQLException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Curso curso = new Curso();
		curso.setCodigo(1);

		Aluno aluno = new Aluno();
		aluno.setRegistroAcademico(222222);
		aluno.setNome("Maria de Oliveira");
		aluno.setSexo("Feminino");
		aluno.setCurso(curso);
		aluno.setDataIngresso(new java.sql.Date(sdf.parse("05/09/2021").getTime()));
		aluno.setPeriodo(2);
		aluno.setCoeficiente(0.72);

		Connection conn = BancoDados.conectar();
		int resultado = new AlunoDAO(conn).cadastrar(aluno);

		assertEquals(1, resultado);
	}

	@Test
	void buscarTodosAlunosTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		List<Aluno> listaAlunos = new AlunoDAO(conn).buscarTodos();

		assertNotNull(listaAlunos);
	}

	@Test
	void buscarPorRegistroAcademicoTeste() throws SQLException, IOException {

		int ra = 222222;

		Connection conn = BancoDados.conectar();
		Aluno aluno = new AlunoDAO(conn).buscarPorRA(ra);

		assertNotNull(aluno);
		assertEquals("Maria de Oliveira", aluno.getNome());
	}

	@Disabled
	void atualizarAlunoTeste() throws ParseException, SQLException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Curso curso = new Curso();
		curso.setCodigo(2);

		Aluno aluno = new Aluno();
		aluno.setRegistroAcademico(222222);
		aluno.setNome("Marcela de Almeida");
		aluno.setSexo("Feminino");
		aluno.setCurso(curso);
		aluno.setDataIngresso(new java.sql.Date(sdf.parse("10/05/2015").getTime()));
		aluno.setPeriodo(3);
		aluno.setCoeficiente(0.88);

		Connection conn = BancoDados.conectar();
		int resultado = new AlunoDAO(conn).atualizar(aluno);
		
		assertEquals(1, resultado);
	}
	
	@Disabled
	void excluirAlunoTeste() throws SQLException, IOException {
		
		int ra = 222222;

		Connection conn = BancoDados.conectar();
		int resultado = new AlunoDAO(conn).excluir(ra);
		
		assertEquals(1, resultado);
	}
}
