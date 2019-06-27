package entidade;

public class Academia {
	private Long id;
	private Long telefone1;
	private String rua;
	private String num_casa;
	private String cidade;
	private String estado;
	
	
	public Academia() {
		
	}

	public Academia(Long id, Long telefone1, String rua, String num_casa, String cidade, String estado) {
		super();
		this.id = id;
		this.telefone1 = telefone1;
		this.rua = rua;
		this.num_casa = num_casa;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNum_casa() {
		return num_casa;
	}

	public void setNum_casa(String num_casa) {
		this.num_casa = num_casa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Academia [id=" + id + ", telefone1=" + telefone1 + ", rua=" + rua + ", num_casa=" + num_casa
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}
}
