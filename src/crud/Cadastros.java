package crud;

import java.sql.Date;
import java.util.Scanner;

import controle.AcademiaControle;
import controle.ClienteControle;
import controle.FuncionarioControle;

public class Cadastros {
	
	private Scanner scanner = new Scanner(System.in);
	private AcademiaControle academiaC = new AcademiaControle();
	private ClienteControle clienteC = new ClienteControle();
	private FuncionarioControle funcionarioC = new FuncionarioControle();
	
	
	public void Academia() {
		System.out.println("Informe o id: ");
		String idL = scanner.nextLine();
		if(idL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long id = Long.parseLong(idL);
		
		System.out.println("Informe telefone: ");
		String telL = scanner.nextLine();
		if(telL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long tel = Long.parseLong(telL);
		
		System.out.println("Digite sua rua: ");
		String rua = scanner.nextLine();
		if(rua.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite o numero da casa: ");
		String num_casa = scanner.nextLine();
		if(num_casa.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite sua cidade:");
		String cidade = scanner.nextLine();
		if(cidade.equals("")) {
			System.out.println("invalido");
			return;
		}
				
		System.out.println("Digite seu estado: ");
		String estado = scanner.nextLine();
		if(estado.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		boolean verificador = academiaC.adicionar(id, tel, rua, num_casa, cidade, estado);
		if(verificador) {
			System.out.println("Cadastro de Academia: Sucesso");
		}else {
			System.out.println("Cadastro de Academia: Fracasso");
		}
	}	
	
	public void Cliente() {
		System.out.println("Informe o id: ");
		String idL = scanner.nextLine();
		if(idL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long id = Long.parseLong(idL);
		
		System.out.println("Informe seu cpf: ");
		String cpfL = scanner.nextLine();
		if(cpfL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long cpf = Long.parseLong(cpfL);
		
		System.out.println("Digite seu nome: ");
		String nome = scanner.nextLine();
		if(nome.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite o id da academia: ");
		String id_academiaL = scanner.nextLine();
		if(id_academiaL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long id_academia = Long.parseLong(id_academiaL);
		
		System.out.println("Digite seu objetivo:");
		String objetivo = scanner.nextLine();
		if(objetivo.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite sua mensalidade: ");
		String mensalidadeL = scanner.nextLine();
		if(mensalidadeL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long mensalidade = Long.parseLong(mensalidadeL);
		
		System.out.println("Digite seu telefone: ");
		String telL = scanner.nextLine();
		if(telL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long tel = Long.parseLong(telL);
		
		System.out.println("Digite o dia que nasceu: ");
		String date1 = scanner.nextLine();
		if(date1.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite o mes que nasceu: ");
		String date2 = scanner.nextLine();
		if(date1.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite o ano que nasceu: ");
		String date3 = scanner.nextLine();
		if(date1.equals("")) {
			System.out.println("invalido");
			return;
		}
		Date date = null;
		int data1 = Integer.parseInt(date1);
		int data2 = Integer.parseInt(date2);
		int data3 = Integer.parseInt(date3);
		
		date.setDate(data1);
		date.setMonth(data2);
		date.setYear(data3);
		
		System.out.println("Digite a rua: ");
		String rua = scanner.nextLine();
		if(rua.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite o numero da casa: ");
		String num_casa = scanner.nextLine();
		if(num_casa.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite sua cidade: ");
		String cidade = scanner.nextLine();
		if(cidade.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		boolean verificador = clienteC.adicionar(id, cpf, nome, id_academia, objetivo, mensalidade, date, tel, rua, num_casa, cidade);
		if(verificador) {
			System.out.println("Cadastro de Cliente: Sucesso");
		}else {
			System.out.println("Cadastro de Cliente: Fracasso");
		}
	}
	
	public void Funcionario() {
		System.out.println("Informe o id: ");
		String idL = scanner.nextLine();
		if(idL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long id = Long.parseLong(idL);
		
		System.out.println("Informe seu cpf: ");
		String cpfL = scanner.nextLine();
		if(cpfL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long cpf = Long.parseLong(cpfL);
		
		System.out.println("Digite seu nome:");
		String nome = scanner.nextLine();
		if(nome.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite o id da academia:");
		String id_academiaL = scanner.nextLine();
		if(id_academiaL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long id_academia = Long.parseLong(id_academiaL);
		
		System.out.println("Digite seu salario:");
		String salarioL = scanner.nextLine();
		if(salarioL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long salario = Long.parseLong(salarioL);
		
		System.out.println("Digite seu telefone: ");
		String telL = scanner.nextLine();
		if(telL.equals("")) {
			System.out.println("invalido");
			return;
		}
		Long tel = Long.parseLong(telL);
		
		System.out.println("Digite o tipo: ");
		String tipo = scanner.nextLine();
		if(tipo.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite a rua: ");
		String rua = scanner.nextLine();
		if(rua.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		System.out.println("Digite numero da casa: ");
		String num_casa = scanner.nextLine();
		if(num_casa.equals("")) {
			System.out.println("invalido");
			return;
		}
		System.out.println("digite sua cidade");
		String cidade = scanner.nextLine();
		if(cidade.equals("")) {
			System.out.println("invalido");
			return;
		}
		
		boolean verificador = funcionarioC.addFuncionario(id, cpf, nome, id_academia, tipo, salario, tel, rua, num_casa, cidade);
		if(verificador) {
			System.out.println("Cadastro de Funcionario: Sucesso");
		}else {
			System.out.println("Cadastro de Funcionario: Fracasso");
		}
	}
}
