package ingredientes;

public enum Adicionais {
	Maionese(1, "Maionese"), 
	Ketchup(2, "Ketchup"), 
	Ovo(3, "Ovo"), 
	BatataPalha(4, "Batata-palha");

	
	private String nome;
	private int index;
	
	Adicionais(int index, String nome) {
		this.nome = nome;
		this.index = index;
	}

	public String getNome() {
		return nome;
	}

	public int getIndex() {
		return index;
	}
}
