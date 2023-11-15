package events;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;

import listaOpcoes.OptionProtein;
import paineis.subpaineis.PLabels;

public class VendasAux {
    private PLabels acesso;

    public VendasAux(PLabels painelLabels) {
        acesso = painelLabels;
    }

    public String getEntradaNome() {
        return acesso.getEntradaNome().getText();
    }

    public String getEntradaId() {
        return acesso.getEntradaId().getText();
    }
    
    public String getIdentificador() {
		return acesso.getEntradaIdentidicador().getSelectedItem().toString();
	}

    public String getEntradaQueijo() {
        return acesso.getEntradaQueijo().getSelectedItem().toString();
    }

    public String getEntradaProteina() {
        return acesso.getEntradaProteina().getSelectedItem().toString();
    }
    
    public float getPriceProteina(String proteina) {
    	OptionProtein proteinaEscolhida = OptionProtein.valueOf(proteina);
    	float price = proteinaEscolhida.getPrice();
        return price;
    }

    public String getEntradaBebida() {
        return acesso.getEntradaBebida().getSelectedItem().toString();
    }

    public ArrayList<String> getAdicionais() {
        ArrayList<String> adicionais = new ArrayList<>();
        for (JCheckBox checkBox : acesso.getEntradaAdicional().getOpcoes()) {
            if (checkBox.isSelected()) {
                adicionais.add(checkBox.getText());
            }
        }
        return adicionais;
    }

    public void setFinalizarVendaListener(ActionListener listener) {
        acesso.getBFinalizar().addActionListener(listener);
    }
}

