package view;

import java.util.List;

import controle.AcademiaControle;
import controle.ClienteControle;
import controle.FuncionarioControle;

import entidade.Academia;
import entidade.Cliente;
import entidade.Funcionario;

public class Buscas {
	
	AcademiaControle academiaC = new AcademiaControle();
	ClienteControle clienteC = new ClienteControle();
	FuncionarioControle funcionarioC = new FuncionarioControle();
	
	public void Academias() {
		List<Academia> academias = academiaC.AcademiaList();
		for (Academia academia : academias) {
			System.out.println(academia.toString());
		}
	}
	
	public void Clientes() {
		List<Cliente> clientes = clienteC.clientList();
		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
	}
	
	public void Funcionarios() {
		List<Funcionario> funcionarios = funcionarioC.listFuncionarios();
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.toString()); 
		}
	}
	
	public void ClientesAcademia(Long id) {
		List<Cliente> clientes = clienteC.clienteListAcademia(id);
		for (Cliente cliente : clientes) {
			System.out.println(cliente.toString());
		}
	}
	
	public void FuncionariosAcademia(Long id) {
		List<Funcionario> funcionarios = funcionarioC.listFuncionariosAcademia(id);
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.toString()); 
		}
	}
	
	public void GanhosAcademia(Long id) {
		float ganhos = 0;
		List<Cliente> clientes = clienteC.clientList();
		for (Cliente cliente : clientes) {
			if(cliente.getAcademia().getId() == id)
				ganhos += cliente.getMensalidade();
		}
		System.out.println("Ganhos da academia " + id + ": " + ganhos);
	}
	
	public void CustosAcademia(Long id) {
		float custos = 0;
		List<Funcionario> funcionarios = funcionarioC.listFuncionarios();
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getAcademia().getId() == id)
				custos += funcionario.getSalario(); 
		}
		System.out.println("Ganhos da academia " + id + ": " + custos);
	}
	
	public void LucrosAcademia(Long id) {
		float custos = 0,  ganhos = 0, lucros = 0;
		List<Cliente> clientes = clienteC.clientList();
		List<Funcionario> funcionarios = funcionarioC.listFuncionarios();
		
		for (Cliente cliente : clientes) {
			if(cliente.getAcademia().getId() == id)
				ganhos += cliente.getMensalidade();
		}
		
		for (Funcionario funcionario : funcionarios) {
			if(funcionario.getAcademia().getId() == id)
				custos += funcionario.getSalario(); 
		}
		
		lucros = ganhos - custos;
		
		System.out.println("Lucros de uma academia " + id + ": " + lucros);
	}
}
