package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.CursoDAO;
import entities.Curso;

public class CursoService {

	public void cadastrarAluno(Curso curso) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CursoDAO(conn).cadastrar(curso);
	}
	
	public List<Curso> buscarCursos() throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new CursoDAO(conn).buscarTodos();
	}
	
	public void excluirCurso(int codigoCurso) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new CursoDAO(conn).excluir(codigoCurso);
	}
}
