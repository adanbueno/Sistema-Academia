package controle;

import dao.AcademiaDAO;

import java.util.List;

import conexao.Conexao;
import entidade.Academia;

public class AcademiaControle {
	Conexao conexao = new Conexao();
	AcademiaDAO academiaDAO = new AcademiaDAO(conexao);
	
	public Academia buscarId(Long id) {
		return academiaDAO.read(id);
	}
	
	public List<Academia> AcademiaList(){
		List<Academia> academiaList = academiaDAO.AcademiaList();
		return academiaList;
	}
	
	public boolean adicionar(Long id, Long telefone1, String rua, String num_casa, String cidade, String estado) {
		Academia academia = new Academia();
		academia.setId(id);
		academia.setTelefone1(telefone1);
		academia.setRua(rua);
		academia.setNum_casa(num_casa);
		academia.setCidade(cidade);
		academia.setEstado(estado);
		
		return academiaDAO.create(academia);
	}
	
	public boolean atualizar(Long id_modifica, Long id, Long telefone1, String rua, String num_casa, String cidade, String estado) {
		Academia academia = new Academia();
		academia.setId(id);
		academia.setTelefone1(telefone1);
		academia.setRua(rua);
		academia.setNum_casa(num_casa);
		academia.setCidade(cidade);
		academia.setEstado(estado);
		
		return academiaDAO.update(id_modifica, academia);
	}
	
	public boolean delete(Long id) {
		return academiaDAO.delete(id);
	}
}
