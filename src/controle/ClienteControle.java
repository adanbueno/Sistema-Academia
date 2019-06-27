package controle;

import dao.ClienteDAO;
import dao.AcademiaDAO;
import entidade.Academia;
import entidade.Cliente;

import java.sql.Date;
import java.util.List;

import conexao.Conexao;

public class ClienteControle {
	Conexao conexao = new Conexao();
	ClienteDAO clienteDAO = new ClienteDAO(conexao);
	
	public Cliente buscarId(Long id) {
		return clienteDAO.read(id);
	}
	
	public List<Cliente> clientList() {
		return clienteDAO.ClienteList();
	}
	
	public List<Cliente> clienteListAcademia(Long id_academia) {
		return clienteDAO.ClienteListAcademia(id_academia);
	}
	
	public boolean adicionar(Long id, Long cpf, String nome, Long idAcademia, String objetivo, Long mensalidade,
					Date dataNasc, Long telefone1, String rua, String numCasa, String cidade) {
		
		Cliente cliente = new Cliente();
		AcademiaDAO academiaDao = new AcademiaDAO(conexao);
		Academia academia = academiaDao.read(idAcademia);
		java.util.Date dataa = new java.util.Date();
		java.sql.Date proxdata = new java.sql.Date(dataa.getTime());
		
		cliente.setId(id);
		cliente.setCpf(cpf);
		cliente.setNome(nome);
		cliente.setAcademia(academia);
		cliente.setObjetivo(objetivo);
		cliente.setMensalidade(mensalidade);
		cliente.setDataProxPag(proxdata);
		cliente.setDataNasc(dataNasc);
		cliente.setTelefone1(telefone1);
		cliente.setRua(rua);
		cliente.setNumCasa(numCasa);
		cliente.setCidade(cidade);
		
		return clienteDAO.create(cliente);
		
	}
	
	public boolean atualizar(Long id_modifica, Long id, Long cpf, String nome, Long idAcademia, String objetivo, Long mensalidade,
			Date dataNasc, Long telefone1, String rua, String numCasa, String cidade) {

		Cliente cliente = new Cliente();
		AcademiaDAO academiaDao = new AcademiaDAO(conexao);
		Academia academia = academiaDao.read(idAcademia);
		java.util.Date dataa = new java.util.Date();
		java.sql.Date proxdata = new java.sql.Date(dataa.getTime());
		
		cliente.setId(id);
		cliente.setCpf(cpf);
		cliente.setNome(nome);
		cliente.setAcademia(academia);
		cliente.setObjetivo(objetivo);
		cliente.setMensalidade(mensalidade);
		cliente.setDataProxPag(proxdata);
		cliente.setDataNasc(dataNasc);
		cliente.setTelefone1(telefone1);
		cliente.setRua(rua);
		cliente.setNumCasa(numCasa);
		cliente.setCidade(cidade);
		
		return clienteDAO.update(id_modifica, cliente);		
	}
	
	public boolean delete(Long id) {
		return clienteDAO.delete(id);
	}
	
}
