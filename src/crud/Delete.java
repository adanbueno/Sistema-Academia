package crud;

import controle.AcademiaControle;
import controle.ClienteControle;
import controle.FuncionarioControle;

public class Delete {
	
	private AcademiaControle academiaC = new AcademiaControle();
	private ClienteControle clienteC = new ClienteControle();
	private FuncionarioControle funcionarioC = new FuncionarioControle();
	
	public void Academia(Long id) {
		boolean data = academiaC.delete(id);
		if(data) {
			System.out.println("Delete de Academia: Sucesso");
		}else {
			System.out.println("Delete de Academia: Fracasso");
		}
	}
	
	public void Funcionario(Long id) {
		boolean data = funcionarioC.deleteFuncionario(id);
		if(data) {
			System.out.println("Delete de Funcionario: Sucesso");
		}else {
			System.out.println("Delete de Funcionario: Fracasso");
		}
	}
	
	public void Cliente(Long id) {
		boolean data = clienteC.delete(id);
		if(data) {
			System.out.println("Delete de Cliente: Sucesso");
		}else {
			System.out.println("Delete de Cliente: Fracasso");
		}
	}
	
}
