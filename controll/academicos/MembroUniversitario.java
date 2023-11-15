package academicos;

public class MembroUniversitario {
	private String nome;
	private String identificacao;
	private String idNominal;

	public MembroUniversitario(String nome, String identificacao) {
		this.nome = nome;
		this.identificacao = identificacao;
	}

	public String getNome() {
		return nome;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public String getIdNominal() {
		return idNominal;
	}

	public void setIdNominal(String idNominal) {
		this.idNominal = idNominal;
	}
	
}




