package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entidade.Academia;


public class AcademiaDAO {
	private Connection connection;
	private Conexao conexao;
	
	public AcademiaDAO(Conexao conexao) {
		this.conexao = conexao;
	}
	
	public boolean create(Academia academia) {
		String sql = "INSERT INTO academia(id, telefone1, rua, num_casa, cidade, estado) VALUES (?,?,?,?,?,?)";
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, academia.getId());
			stmt.setLong(2, academia.getTelefone1());
			stmt.setString(3, academia.getRua());
			stmt.setString(4, academia.getNum_casa());
			stmt.setString(5, academia.getCidade());
			stmt.setString(6, academia.getEstado());
			
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("");
		} finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	public Academia read(Long id) {
		String sql = "SELECT * FROM academia WHERE id = ?";
		Academia academia = null;
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs =  stmt.executeQuery();
			
			if(rs.next()) {
				academia = new Academia();
				academia.setId(rs.getLong("id"));
				academia.setTelefone1(rs.getLong("telefone1"));
				academia.setRua(rs.getString("rua"));
				academia.setNum_casa(rs.getString("num_casa"));
				academia.setCidade(rs.getString("cidade"));
				academia.setEstado(rs.getString("estado"));
			}
			stmt.close();
		}catch(SQLException e) {
			System.out.println("");
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return academia;
	}
	
	public boolean update(Long id_modifica,Academia academia) {
		String sql = "UPDATE academia SET id = ?, telefone1 = ?, rua = ?, num_casa = ?, cidade = ?, estado = ? WHERE id = ?";
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, academia.getId());
			stmt.setLong(2, academia.getTelefone1());
			stmt.setString(3, academia.getRua());
			stmt.setString(4, academia.getNum_casa());
			stmt.setString(5, academia.getCidade());
			stmt.setString(6, academia.getEstado());
			
			stmt.setLong(7, id_modifica);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			System.out.println("");
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean delete(Long id) {
		String sql = "DELETE FROM academia WHERE id = ?";
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt =  connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			int qtdRowsAffected = stmt.executeUpdate();
			stmt.close();
			if(qtdRowsAffected > 0) {
				return true;
			}
			return false;
			
		}catch(SQLException e) {
			System.out.println("");;
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
		
		
	}
	
	public List<Academia> AcademiaList(){
		String sql = "Select * FROM academia;";
		List<Academia> academiaList = new ArrayList<Academia>();
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Academia academia = new Academia();
				academia.setId(rs.getLong("id"));
				academia.setTelefone1(rs.getLong("telefone1"));
				academia.setRua(rs.getString("rua"));
				academia.setNum_casa(rs.getString("num_casa"));
				academia.setCidade(rs.getString("cidade"));
				academia.setEstado(rs.getString("estado"));
				
				academiaList.add(academia);
			}
			stmt.close();
		}catch(SQLException e) {
			System.out.println("");
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return academiaList;
	}
	
}
