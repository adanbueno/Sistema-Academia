package controle;

import dao.FuncionarioDAO;
import dao.AcademiaDAO;
import entidade.Academia;
import entidade.Funcionario;

import java.util.List;

import conexao.Conexao;

public class FuncionarioControle {
	Conexao conexao = new Conexao();
	FuncionarioDAO funcionarioDAO = new FuncionarioDAO(conexao);
	
	public Funcionario buscarId(Long id) {
		return funcionarioDAO.read(id);
	}
	
	public List<Funcionario> listFuncionarios(){
		return funcionarioDAO.FuncionarioList();
	}
	
	public List<Funcionario> listFuncionariosAcademia(Long id_academia){
		return funcionarioDAO.FuncionarioListAcademia(id_academia);
	}
	
	public boolean addFuncionario(Long id, Long cpf, String nome, Long idAcademia, String tipo, Long salario, Long telefone1, String rua, String numCasa, String cidade) {
		Funcionario funcionario = new Funcionario();
		AcademiaDAO academiaDAO = new AcademiaDAO(conexao);
		Academia academia = academiaDAO.read(idAcademia);
		
		funcionario.setId(id);
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionario.setAcademia(academia);
		funcionario.setTipo(tipo);
		funcionario.setSalario(salario);
		funcionario.setTelefone1(telefone1);
		funcionario.setRua(rua);
		funcionario.setNumCasa(numCasa);
		funcionario.setCidade(cidade);
		
		return funcionarioDAO.create(funcionario);
	}
	
	public boolean atualizar(Long id_modifica, Long id, Long cpf, String nome, Long idAcademia, String tipo, Long salario, Long telefone1, String rua, String numCasa, String cidade) {
		Funcionario funcionario = new Funcionario();
		AcademiaDAO academiaDAO = new AcademiaDAO(conexao);
		Academia academia = academiaDAO.read(idAcademia);
		
		funcionario.setId(id);
		funcionario.setCpf(cpf);
		funcionario.setNome(nome);
		funcionario.setAcademia(academia);
		funcionario.setTipo(tipo);
		funcionario.setSalario(salario);
		funcionario.setTelefone1(telefone1);
		funcionario.setRua(rua);
		funcionario.setNumCasa(numCasa);
		funcionario.setCidade(cidade);
		
		return funcionarioDAO.update(id_modifica, funcionario);
	}
	
	
	public boolean deleteFuncionario(Long id) {
		return funcionarioDAO.delete(id);
	}
}
