package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entidade.Funcionario;
import entidade.Academia;


public class FuncionarioDAO {
	private Connection connection;
	private Conexao conexao;
	
	public FuncionarioDAO(Conexao conexao) {
		this.conexao = conexao;
	}
	
	public boolean create(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario(id, cpf, nome, id_academia, tipo, salario, telefone1, rua, num_casa, cidade) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, funcionario.getId());
			stmt.setLong(2, funcionario.getCpf());
			stmt.setString(3, funcionario.getNome());
			stmt.setLong(4, funcionario.getAcademia().getId());
			stmt.setString(5, funcionario.getTipo());
			stmt.setFloat(6, funcionario.getSalario());
			stmt.setLong(7, funcionario.getTelefone1());
			stmt.setString(8, funcionario.getRua());
			stmt.setString(9, funcionario.getNumCasa());
			stmt.setString(10, funcionario.getCidade());
			
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
	
	public Funcionario read(Long id) {
		String sql = "SELECT * FROM funcionario WHERE id = ?";
		Funcionario funcionario = null;
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs =  stmt.executeQuery();
			if(rs.next()) {
				funcionario = new Funcionario();
				AcademiaDAO academiaDao = new AcademiaDAO(conexao);
				Academia academia = academiaDao.read(rs.getLong("academia_id"));
				
				funcionario.setId(rs.getLong("id"));
				funcionario.setCpf(rs.getLong("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setAcademia(academia);
				funcionario.setTipo(rs.getString("tipo"));
				funcionario.setSalario(rs.getFloat("salario"));
				funcionario.setTelefone1(rs.getLong("telefone1"));
				funcionario.setRua(rs.getString("rua"));
				funcionario.setNumCasa(rs.getString("num_casa"));
				funcionario.setCidade(rs.getString("cidade"));
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
		return funcionario;
	}
	public boolean update(Long id_modifica, Funcionario funcionario) {
		String sql = "UPDATE funcionario SET id = ?, cpf = ?, nome =  ?, id_academia = ?, tipo = ?, salario = ?, telefone1 = ?, rua = ?, num_casa = ?, cidade= ? WHERE id = ?";
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, funcionario.getId());
			stmt.setLong(2, funcionario.getCpf());
			stmt.setString(3, funcionario.getNome());
			stmt.setLong(4, funcionario.getAcademia().getId());
			stmt.setString(5, funcionario.getTipo());
			stmt.setFloat(6, funcionario.getSalario());
			stmt.setLong(7, funcionario.getTelefone1());
			stmt.setString(8, funcionario.getRua());
			stmt.setString(9, funcionario.getNumCasa());
			stmt.setString(10, funcionario.getCidade());
			
			stmt.setLong(11, id_modifica);
			
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
		String sql = "DELETE FROM funcionario WHERE id = ?";
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
	
	public List<Funcionario> FuncionarioList(){
		String sql = "Select * FROM funcionario;";
		List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			AcademiaDAO academiaDao = new AcademiaDAO(conexao);
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				Academia academia = academiaDao.read(rs.getLong("id_academia"));
				
				funcionario.setId(rs.getLong("id"));
				funcionario.setCpf(rs.getLong("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setAcademia(academia);
				funcionario.setTipo(rs.getString("tipo"));
				funcionario.setSalario(rs.getFloat("salario"));
				funcionario.setTelefone1(rs.getLong("telefone1"));
				funcionario.setRua(rs.getString("rua"));
				funcionario.setNumCasa(rs.getString("num_casa"));
				funcionario.setCidade(rs.getString("cidade"));
				
				funcionarioList.add(funcionario);
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
		return funcionarioList;
	}
	
	public List<Funcionario> FuncionarioListAcademia(Long id_academia){
		String sql = "Select * FROM funcionario WHERE id_academia = ?";
		List<Funcionario> funcionarioList = new ArrayList<Funcionario>();
		
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id_academia);
			ResultSet rs = stmt.executeQuery();
			AcademiaDAO academiaDao = new AcademiaDAO(conexao);
			
			while(rs.next()) {
				Funcionario funcionario = new Funcionario();
				Academia academia = academiaDao.read(rs.getLong("id_academia"));
				
				funcionario.setId(rs.getLong("id"));
				funcionario.setCpf(rs.getLong("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setAcademia(academia);
				funcionario.setTipo(rs.getString("tipo"));
				funcionario.setSalario(rs.getFloat("salario"));
				funcionario.setTelefone1(rs.getLong("telefone1"));
				funcionario.setRua(rs.getString("rua"));
				funcionario.setNumCasa(rs.getString("num_casa"));
				funcionario.setCidade(rs.getString("cidade"));
				
				funcionarioList.add(funcionario);
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
		return funcionarioList;
	}
}
