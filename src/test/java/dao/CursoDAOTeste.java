package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dto.CursoDTO;

public class CursoDAOTeste {

	public static void cadastrarCursoTeste() throws SQLException, IOException {

		CursoDTO entidade = new CursoDTO();
		entidade.setNome("Automação Industrial");
		entidade.setPeriodo("Integral");
		entidade.setDuracao(6);

		Connection conn = BancoDados.conectar();
		CursoDAO cursoDAO = new CursoDAO(conn);
		int resultado = cursoDAO.cadastrar(entidade);

		if (resultado > 0) {

			System.out.println("Cadastro realizado com sucesso.");

		} else {

			System.out.println("Erro ao cadastrar um novo curso");
		}
	}

	public static void buscarTodosCursosTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		CursoDAO cursoDAO = new CursoDAO(conn);
		List<CursoDTO> listaCursos = cursoDAO.buscarTodos();

		for (CursoDTO cursoDTO : listaCursos) {

			System.out.println(cursoDTO);
		}
	}
	
	public static void buscarPorChaveCursoTeste() throws SQLException, IOException {

		int codigoCurso = 5;

		Connection conn = BancoDados.conectar();
		CursoDAO cursoDAO = new CursoDAO(conn);
		CursoDTO cursoDTO = cursoDAO.buscarPorChave(codigoCurso);

		if (cursoDTO != null) {
			
			System.out.println(cursoDTO);

		} else {
			
			System.out.println("Nenhum curso encontrado.");
		}
	}

	
	public static void atualizarCursoTeste() throws SQLException, IOException {
		
		CursoDTO entidade = new CursoDTO();
		
		entidade.setCodigo(15);
		entidade.setPeriodo("Diurno");
		entidade.setDuracao(8);
		
		Connection conn = BancoDados.conectar();
		CursoDAO cursoDAO = new CursoDAO(conn);
		int resultado = cursoDAO.atualizar(entidade);
		
		if (resultado > 0) {
			
			System.out.println("Curso atualizado com sucesso.");
			
		} else {
			
			System.out.println("Erro ao atualizar o curso.");
		}
	}
	
	public static void excluirCursoTeste() throws SQLException, IOException {

		int codigoCurso = 2;

		Connection conn = BancoDados.conectar();
		CursoDAO cursoDAO = new CursoDAO(conn);
		int resultado = cursoDAO.excluir(codigoCurso);

		if (resultado > 0) {

			System.out.println("Curso excluído com sucesso.");

		} else {

			System.out.println("Erro ao excluir o curso.");
		}
	}
	
	public static void main(String[] args) {

		try {

//			CursoDAOTeste.cadastrarCursoTeste();
			CursoDAOTeste.buscarTodosCursosTeste();
//			CursoDAOTeste.buscarPorChaveCursoTeste();
//			CursoDAOTeste.atualizarCursoTeste();
//			CursoDAOTeste.excluirCursoTeste();

		} catch (SQLException | IOException e) {

			System.out.println(e.getMessage());
		}
	}
}
