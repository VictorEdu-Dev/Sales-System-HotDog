package roulle;

import java.util.ArrayList;
import academicos.MembroUniversitario;
import proteinas.CachorroQuente;
import proteinas.*;
import types.Venda;

public class CestaItens {

	private ArrayList<Venda> listaVenda;
	private ArrayList<String> adicional;
	protected float valorTotal;
	private String identificador;

	public CestaItens() {
		adicional = new ArrayList<>();
		listaVenda = new ArrayList<>();
	}

	public void menuOperacoes(String entrada, String identificacao, String identificador, 
			String tipoQueijo, String bebida, String proteina, float price) {
		MembroUniversitario comprador = registrarAcademico(entrada, identificacao, identificador);
		this.identificador = identificador;
		
		Venda venda = new Venda(comprador);
		CachorroQuente hotDog = escolherCachorroQuente(tipoQueijo, bebida, proteina);
		hotDog.setProteina(proteina);
		hotDog.setPrice(price);

		venda.realizarVenda(hotDog);
		valorTotal += calcularPreco(hotDog, venda);
		
		listaVenda.add(venda);
	}

	private float calcularPreco(CachorroQuente hotDog, Venda venda) {
		venda.setValorTotal(hotDog.getPrice());
		float sale = venda.getValorTotal();
		return sale;
	}
	
	public CachorroQuente escolherCachorroQuente(String tipoQueijo, String bebida, String proteina) {
		CachorroQuente hotDog = verificarHotDog(tipoQueijo, proteina);
		hotDog.setBebida(bebida);
		hotDog.adicionarIngredientes(adicional);
		return hotDog;
	}

	private CachorroQuente verificarHotDog(String tipoQueijo, String proteina) {
		CachorroQuente hotDog = null;

		switch (proteina) {
		case "Salsicha":
			hotDog = new Salsicha(tipoQueijo);
			break;
		case "Bacon":
			hotDog = new Bacon(tipoQueijo);
			break;
		case "Linguiça":
			hotDog = new Linguica(tipoQueijo);
			break;
		case "Frango":
			hotDog = new Frango(tipoQueijo);
			break;
		default:
			break;
		}

		return hotDog;
	}

	private MembroUniversitario registrarAcademico(String nome, String identificacao, String identificador) {
		switch (identificador) {
		case "Professor":
			return UniversityMemberType.PROFESSOR.gerarMembroUniversitario(nome, identificacao);
		case "Servidor":
			return UniversityMemberType.SERVIDOR.gerarMembroUniversitario(nome, identificacao);
		case "Estudante":
			return UniversityMemberType.ALUNO.gerarMembroUniversitario(nome, identificacao);
		default:
			break;
		}
		return null;
	}

	public ArrayList<String> getAdicional() {
		return adicional;
	}

	public void setAdicional(ArrayList<String> adicional) {
		this.adicional.addAll(adicional);
	}

	public ArrayList<Venda> getListaVenda() {
		return listaVenda;
	}

	public String getIdentificador() {
		return identificador;
	}
}
