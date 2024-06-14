package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entities.Aluno;
import entities.Curso;

public class AlunoDAOTeste {

	public static void cadastrarAlunoTeste() throws SQLException, IOException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Curso curso = new Curso();
		curso.setCodigo(2);
		curso.setNome("Tecnologia em Alimentos");
		curso.setPeriodo("Noturno");
		curso.setDuracao(6);

		Aluno aluno = new Aluno();
		aluno.setRegistroAcademico(444444);
		aluno.setNome("Ana Vieira");
		aluno.setSexo("Feminino");
		aluno.setCurso(curso);
		aluno.setDataIngresso(new java.sql.Date(sdf.parse("19/02/2019").getTime()));
		aluno.setPeriodo(6);
		aluno.setCoeficiente(0.61);

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

	public static void atualizarAlunoTeste() throws SQLException, IOException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Curso curso = new Curso();
		curso.setCodigo(4);
		curso.setNome("Bacharelado em Ciências Biológicas");
		curso.setPeriodo("Integral");
		curso.setDuracao(8);

		Aluno aluno = new Aluno();
		aluno.setRegistroAcademico(222222);
		aluno.setNome("Marcela de Almeida");
		aluno.setSexo("Feminino");
		aluno.setCurso(curso);
		aluno.setDataIngresso(new java.sql.Date(sdf.parse("10/05/2015").getTime()));
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

			AlunoDAOTeste.buscarTodosAlunosTeste();

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
