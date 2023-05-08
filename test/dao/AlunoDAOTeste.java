package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Aluno;
import entities.Curso;

public class AlunoDAOTeste {

	public static void cadastrarAlunoTeste() throws SQLException, IOException {

		Curso curso = new Curso();
		curso.setCodigo(5);
		curso.setNome("Bacharelado em Ciências Biológicas");
		curso.setPeriodo("Diurno");
		curso.setDuracao(8);

		Aluno aluno = new Aluno();
		aluno.setNome("Rogério");
		aluno.setSexo("Masculino");
		aluno.setCurso(curso);
		aluno.setDataIngresso("01/08/2018");
		aluno.setPeriodo(2);
		aluno.setCoeficiente(0.69);

		Connection conn = BancoDados.conectar();
		new AlunoDAO(conn).cadastrar(aluno);

		System.out.println("Cadastro efetuado com sucesso.");
	}

	public static void buscarTodosAlunosTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		List<Aluno> listaAlunos = new AlunoDAO(conn).buscarTodos();

		for (Aluno aluno : listaAlunos) {

			System.out.println(aluno.getRegistroAcademico() + " - " + aluno.getNome() + " - " + aluno.getSexo() + " - "
					+ aluno.getCurso().getCodigo() + " - " + aluno.getDataIngresso() + " - " + aluno.getPeriodo()
					+ " - " + aluno.getCoeficiente());
		}
	}

	public static void buscarPorRegistroAcademicoTeste() throws SQLException, IOException {

		int ra = 5;

		Connection conn = BancoDados.conectar();
		Aluno aluno = new AlunoDAO(conn).buscarPorRA(ra);

		if (aluno != null) {

			System.out.println(aluno.getRegistroAcademico() + " - " + aluno.getNome() + " - " + aluno.getSexo() + " - "
					+ aluno.getCurso().getCodigo() + " - " + aluno.getDataIngresso() + " - " + aluno.getPeriodo()
					+ " - " + aluno.getCoeficiente());

		} else {

			System.out.println("RA não encontrado.");
		}
	}

	public static void atualizarAlunoTeste() throws SQLException, IOException {

		Curso curso = new Curso();
		curso.setCodigo(5);
		curso.setNome("Bacharelado em Ciências Biológicas");
		curso.setPeriodo("Diurno");
		curso.setDuracao(8);

		Aluno aluno = new Aluno();
		aluno.setRegistroAcademico(4);
		aluno.setNome("Marcela");
		aluno.setSexo("Feminino");
		aluno.setCurso(curso);
		aluno.setDataIngresso("15/05/2015");
		aluno.setPeriodo(2);
		aluno.setCoeficiente(0.88);

		Connection conn = BancoDados.conectar();
		new AlunoDAO(conn).atualizar(aluno);

		System.out.println("Dados do aluno atualizados com sucesso.");
	}

	public static void excluirAlunoTeste() throws SQLException, IOException {

		int ra = 6;

		Connection conn = BancoDados.conectar();
		int linhasManipuladas = new AlunoDAO(conn).excluir(ra);

		if (linhasManipuladas > 0) {

			System.out.println("Aluno excluído com sucesso.");

		} else {

			System.out.println("Nenhum registro foi encontrado.");
		}

	}

	public static void main(String[] args) {

		try {

			AlunoDAOTeste.excluirAlunoTeste();

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
