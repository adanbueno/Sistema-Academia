package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entidade.Academia;
import entidade.Cliente;

public class ClienteDAO {
	private Connection connection;
	private Conexao conexao;
	
	public ClienteDAO(Conexao conexao) {
		this.conexao = conexao;
	}
	
	public boolean create(Cliente cliente) {
		String sql = "INSERT INTO cliente(id, cpf, nome, id_academia, objetivo, mensalidade, data_prox_pag, telefone1, dat_nasc, rua, num_casa, cidade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, cliente.getId());
			stmt.setLong(2, cliente.getCpf());
			stmt.setString(3, cliente.getNome());
			stmt.setLong(4, cliente.getAcademia().getId());
			stmt.setString(5, cliente.getObjetivo());
			stmt.setFloat(6, cliente.getMensalidade());
			stmt.setDate(7, cliente.getDataProxPag());
			stmt.setLong(8, cliente.getTelefone1());
			stmt.setDate(9, cliente.getDataNasc());
			stmt.setString(10, cliente.getRua());
			stmt.setString(11, cliente.getNumCasa());
			stmt.setString(12, cliente.getCidade());
			
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
	
	public Cliente read(Long id) {
		String sql = "SELECT * FROM cliente WHERE id = ?";
		Cliente cliente = null;
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs =  stmt.executeQuery();
			if(rs.next()) {
				cliente = new Cliente();
				AcademiaDAO academiaDao = new AcademiaDAO(conexao);
				Academia academia = academiaDao.read(rs.getLong("id"));
				
				cliente.setId(rs.getLong("id"));
				cliente.setCpf(rs.getLong("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setAcademia(academia);
				cliente.setObjetivo(rs.getString("objetivo"));
				cliente.setMensalidade(rs.getFloat("mensalidade"));
				cliente.setDataProxPag(rs.getDate("data_prox_pag"));
				cliente.setTelefone1(rs.getLong("telefone1"));
				cliente.setDataNasc(rs.getDate("dat_nasc"));
				cliente.setRua(rs.getString("rua"));
				cliente.setNumCasa(rs.getString("num_casa"));
				cliente.setCidade(rs.getString("cidade"));
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
		return cliente;
	}
	
	public boolean update(Long id_modifica, Cliente cliente) {
		String sql = "UPDATE cliente SET id = ?, cpf = ?, nome = ?, id_academia = ?, objetivo = ?, mensalidade = ?, data_prox_pag = ?, telefone1 = ?, dat_nasc = ?, rua = ?, num_casa = ?, cidade= ? WHERE id = ?";
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1, cliente.getId());
			stmt.setLong(2, cliente.getCpf());
			stmt.setString(3, cliente.getNome());
			stmt.setLong(4, cliente.getAcademia().getId());
			stmt.setString(5, cliente.getObjetivo());
			stmt.setFloat(6, cliente.getMensalidade());
			stmt.setDate(7, cliente.getDataProxPag());
			stmt.setLong(8, cliente.getTelefone1());
			stmt.setDate(9, cliente.getDataNasc());
			stmt.setString(10, cliente.getRua());
			stmt.setString(11, cliente.getNumCasa());
			stmt.setString(12, cliente.getCidade());
			
			stmt.setLong(13, id_modifica);
			
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
		String sql = "DELETE FROM cliente WHERE id = ?";
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
	
	public List<Cliente> ClienteList(){
		String sql = "Select * FROM cliente;";
		List<Cliente> clienteList = new ArrayList<Cliente>();
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			AcademiaDAO academiaDao = new AcademiaDAO(conexao);
			
			while(rs.next()) {
				Cliente cliente = new Cliente();	
				Academia academia = academiaDao.read(rs.getLong("id_academia"));
	
				cliente.setId(rs.getLong("id"));
				cliente.setCpf(rs.getLong("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setAcademia(academia);
				cliente.setObjetivo(rs.getString("objetivo"));
				cliente.setMensalidade(rs.getFloat("mensalidade"));
				cliente.setDataProxPag(rs.getDate("data_prox_pag"));
				cliente.setTelefone1(rs.getLong("telefone1"));
				cliente.setDataNasc(rs.getDate("dat_nasc"));
				cliente.setRua(rs.getString("rua"));
				cliente.setNumCasa(rs.getString("num_casa"));
				cliente.setCidade(rs.getString("cidade"));
				
				clienteList.add(cliente);
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
		return clienteList;
	}
	
	public List<Cliente> ClienteListAcademia(Long id_academia){
		String sql = "Select * FROM cliente WHERE id_academia = ?";
		List<Cliente> clienteList = new ArrayList<Cliente>();
		
		try {
			this.connection = conexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id_academia);
			ResultSet rs = stmt.executeQuery();
					
			AcademiaDAO academiaDAO = new AcademiaDAO(conexao);
			
			while(rs.next()) {
				Cliente cliente = new Cliente();	
				Academia academia = academiaDAO.read(rs.getLong("id_academia"));
	
				cliente.setId(rs.getLong("id"));
				cliente.setCpf(rs.getLong("cpf"));
				cliente.setNome(rs.getString("nome"));
				cliente.setAcademia(academia);
				cliente.setObjetivo(rs.getString("objetivo"));
				cliente.setMensalidade(rs.getFloat("mensalidade"));
				cliente.setDataProxPag(rs.getDate("data_prox_pag"));
				cliente.setTelefone1(rs.getLong("telefone1"));
				cliente.setDataNasc(rs.getDate("dat_nasc"));
				cliente.setRua(rs.getString("rua"));
				cliente.setNumCasa(rs.getString("num_casa"));
				cliente.setCidade(rs.getString("cidade"));
				
				clienteList.add(cliente);
			}
			stmt.close();
		}catch(SQLException e) {
			System.out.println("Lista de cliente academia fracassado");
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return clienteList;
	}
}
