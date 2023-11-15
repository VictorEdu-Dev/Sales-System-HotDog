package types;
import java.util.ArrayList;

import academicos.MembroUniversitario;
import proteinas.CachorroQuente;

public class Venda {

	private MembroUniversitario membroUniversitario;
	private ArrayList<CachorroQuente> cachorrosQuentes;
	private float valorTotal;
	
	
	public Venda(MembroUniversitario membroUniversitario) {
		this.membroUniversitario = membroUniversitario;
		cachorrosQuentes = new ArrayList<CachorroQuente>();
	}
	
	public void realizarVenda(CachorroQuente hotDog) {
		cachorrosQuentes.add(hotDog);
	}

	public MembroUniversitario getMembroUniversitario() {
		return membroUniversitario;
	}

	public ArrayList<CachorroQuente> getCachorrosQuentes() {
		return cachorrosQuentes;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal += valorTotal;
	}
	
}
