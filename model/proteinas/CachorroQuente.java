package proteinas;

import java.util.ArrayList;

public class CachorroQuente {

	private String proteina;
	private String queijo;
	private String bebida;
	private ArrayList<String> adicionais;
	private float price;
	private int identificador;
	
	
	public CachorroQuente() {
		adicionais = new ArrayList<String>();
	}
	
	
	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}
	
	public String getQueijo() {
		return queijo;
	}

	public String getBebida() {
		return bebida;
	}

	public void adicionarIngredientes(ArrayList<String> adicional) {
		adicionais.addAll(adicional);
	}
	
	public ArrayList<String> getAdicionais() {
		return adicionais;
	}
	
	public void setBebida(String bebida) {
		this.bebida = bebida;
	}
	
	public void setQueijo(String queijo) {
		this.queijo = queijo;
	}


	public String getProteina() {
		return proteina;
	}

	public void setProteina(String nome) {
		this.proteina = nome;
	}


	public int getIdentificador() {
		return identificador;
	}


	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
