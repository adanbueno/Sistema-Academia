package entidade;

import java.sql.Date;

public class Cliente {
	private Long id;
	private Long cpf;
	private String nome;
	private Academia academia;
	private String objetivo;
	private float mensalidade;
	private Date dataProxPag;
	private Date dataNasc;
	private Long telefone1;
	private String rua;
	private String numCasa;
	private String cidade;
	
	
	
	public Cliente() {
		
	}

	public Cliente(Long id, Long cpf, String nome, Academia academia, String objetivo, float mensalidade,
			Date dataProxPag, Date dataNasc, Long telefone1, String rua, String numCasa, String cidade) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.academia = academia;
		this.objetivo = objetivo;
		this.mensalidade = mensalidade;
		this.dataProxPag = dataProxPag;
		this.dataNasc = dataNasc;
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

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Date getDataProxPag() {
		return dataProxPag;
	}

	public void setDataProxPag(Date dataProxPag) {
		this.dataProxPag = dataProxPag;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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
		return "Cliente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", idAcademia=" + academia.getId() + ", objetivo="
				+ objetivo + ", mensalidade=" + mensalidade + ", dataProxPag=" + dataProxPag + ", dataNasc=" + dataNasc
				+ ", telefone1=" + telefone1 + ", rua=" + rua + ", numCasa=" + numCasa + ", cidade=" + cidade + "]";
	}
}
