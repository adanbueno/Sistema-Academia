package entidade;

public class Funcionario {
	private Long id;
	private Long cpf;
	private String nome;
	private Academia academia;
	private String tipo;
	private float salario;
	private Long telefone1;
	private String rua;
	private String numCasa;
	private String cidade;

	public Funcionario() {
		
	}
	
	public Funcionario(Long id, Long cpf, String nome, Academia academia, String tipo, float salario, Long telefone1,
			String rua, String numCasa, String cidade) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.academia = academia;
		this.tipo = tipo;
		this.salario = salario;
		this.telefone1 = telefone1;
		this.rua = rua;
		this.numCasa = numCasa;
		this.cidade = cidade;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Academia getAcademia() {
		return academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Long getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(Long telefone1) {
		this.telefone1 = telefone1;
	}
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", idAcademia=" + academia.getId() + ", tipo=" + tipo
				+ ", salario=" + salario + ", telefone1=" + telefone1 + ", rua=" + rua + ", numCasa=" + numCasa
				+ ", cidade=" + cidade + "]";
	}
}
