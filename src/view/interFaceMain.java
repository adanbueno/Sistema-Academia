package view;

import java.sql.SQLException;
import java.util.Scanner;

import controle.AcademiaControle;
import controle.ClienteControle;
import controle.FuncionarioControle;

import crud.Atualizacao;
import crud.Cadastros;
import crud.Delete;


public class interFaceMain {
	Scanner scanner = new Scanner(System.in);
	
	AcademiaControle academiaC = new AcademiaControle();
	ClienteControle clienteC = new ClienteControle();
	FuncionarioControle funcionarioC = new FuncionarioControle();
	
	public void start() throws SQLException{
		boolean loop = true;
		String escolha;
		do {
			System.out.println("----------------------- Menu principal ------------------------");
			System.out.println("1. Cadastrar");
			System.out.println("2. Atualizar");
			System.out.println("3. Deletar");
			System.out.println("4. Buscar");
			escolha = scanner.nextLine();
			
			switch(escolha) {
				case "1":
					cadastrar();
				break;
				case "2":
					atualizar();
				break;
				case "3":
					deletar();
				break;
				case "4":
					buscar();
				break;
				case "5":
					loop = false;
				break;
				default:
					System.out.println("Escolha invalida");
			}
			
		}while(loop);
	}
	
	private void cadastrar() {
		Cadastros cadastrar = new Cadastros();
		System.out.println("Escolha de Cadastro: 'academia', 'funcionario', 'cliente' (Ou: 'voltar')");
		String escolha = scanner.nextLine();
		
		switch(escolha) {
			case "academia":
				cadastrar.Academia();	
			break;
			case "cliente":
				cadastrar.Cliente();
			break;
			case "funcionario":
				cadastrar.Funcionario();
			break;
			case "voltar":
			
			break;
			default:
				System.out.println("Opera��o invalida");
		}
	}
	
	
	
	
	private void atualizar() {
		Atualizacao atualizar = new Atualizacao();
		System.out.println("Escolha de Atualizacao: 'academia', 'equipamento', 'funcionario', 'cliente', 'manutencao' (Ou: 'voltar')");
		String escolha = scanner.nextLine();
		
		System.out.println("Digite o ID de modificacao: ");
		String id = scanner.nextLine();
		Long id_modifica = Long.parseLong(id);
		
		switch(escolha) {
			case "academia":
				atualizar.Academia(id_modifica);	
			break;
			case "cliente":
				atualizar.Cliente(id_modifica);
			break;
			case "funcionario":
				atualizar.Funcionario(id_modifica);
			break;
			case "voltar":
			
			break;
			default:
				System.out.println("Opera��o invalida");
		}
	}
	
	
	private void deletar() {
		Delete deletar = new Delete();
		System.out.println("Escolha de delete: 'academia', 'equipamento', 'funcionario', 'cliente', 'manutencao' (Ou: 'voltar')");
		String escolha = scanner.nextLine();
		
		System.out.println("Digite o ID de delete: ");
		String id = scanner.nextLine();
		Long id_delete = Long.parseLong(id);
		
		switch(escolha) {
			case "academia":
				deletar.Academia(id_delete);	
			break;
			case "cliente":
				deletar.Cliente(id_delete);
			break;
			case "funcionario":
				deletar.Funcionario(id_delete);
			break;
			case "voltar":
			
			break;
			default:
				System.out.println("Opera��o invalida");
		}
	}
	
	private void buscar() {
		Buscas buscar = new Buscas();
		String id = null;
		
		System.out.println("Escolha a busca:");
		System.out.println("1. Listar Academia");
		System.out.println("2. Listar Clientes");
		System.out.println("3. Listar Funcionarios");
		System.out.println("4. Listar Clientes de uma academia");
		System.out.println("5. Listar Funcionarios de uma academia");
		System.out.println("6. Listar Ganhos de uma academia");
		System.out.println("7. Listar Custos de uma academia");
		System.out.println("8. Listar Lucros de uma academia");
		String escolha = scanner.nextLine();
		
		if(escolha.equals("4") || escolha.equals("5") || escolha.equals("6") || escolha.equals("7") || escolha.equals("8")) {
			System.out.println("Digite o Id da academia: ");
			id = scanner.nextLine();
		}
		
		switch(escolha) {
		case "1":
			buscar.Academias();
		break;
		case "2":
			buscar.Clientes();
		break;
		case "3":
			buscar.Funcionarios();
		break;
		case "4":
			buscar.ClientesAcademia(Long.parseLong(id));
		break;
		case "5":
			buscar.FuncionariosAcademia(Long.parseLong(id));
		break;
		case "6":
			buscar.GanhosAcademia(Long.parseLong(id));
		break;
		case "7":
			buscar.GanhosAcademia(Long.parseLong(id));
		break;
		case "8":
			buscar.LucrosAcademia(Long.parseLong(id));
		break;
		default:
			System.out.println("Opera��o invalida");
		}
	}
}