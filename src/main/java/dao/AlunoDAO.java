package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AlunoDTO;

public class AlunoDAO implements DAO<AlunoDTO, Integer> {

	private Connection conn;

	public AlunoDAO(Connection conn) {

		this.conn = conn;
	}

	@Override
	public int cadastrar(AlunoDTO alunoDTO) throws SQLException {

		return 0;
	}

	@Override
	public List<AlunoDTO> buscarTodos() throws SQLException {

		return null;
	}

	@Override
	public AlunoDTO buscarPorChave(Integer chavePrimaria) throws SQLException {

		return null;
	}

	@Override
	public int atualizar(AlunoDTO alunoDTO) throws SQLException {

		return 0;
	}

	@Override
	public int excluir(Integer chavePrimaria) throws SQLException {
		
		return 0;
	}
}
