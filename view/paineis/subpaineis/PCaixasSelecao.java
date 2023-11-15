package paineis.subpaineis;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import modelosUnitarios.BoxSelect;

public class PCaixasSelecao extends JPanel {
	private static final long serialVersionUID = 8339544370670421702L;
	private ArrayList<BoxSelect> opcoes;

	public PCaixasSelecao(JPanel painel) {
//		int larguraFrame = painel.getWidth();
//		int alturaFrame = painel.getHeight();
		
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBounds(new Rectangle(700, 372, 270, 100));
		setOpaque(false);
		
		opcoes = new ArrayList<>();
		// aqui é um arrayList de várias caixinhas de seleção, cada uma com seus atributos
		opcoes.add(BoxSelect.criarCaixaDeSelecao("Maionese", Color.decode("#EEFFFF"), 
				BorderFactory.createLineBorder(Color.BLACK, 1), 0, 20, 130, 30));
		opcoes.add(BoxSelect.criarCaixaDeSelecao("Ketchup", Color.decode("#EEFFFF"), 
				BorderFactory.createLineBorder(Color.BLACK, 1), 130, 20, 130, 30));
		opcoes.add(BoxSelect.criarCaixaDeSelecao("Ovo", Color.decode("#EEFFFF"), 
				BorderFactory.createLineBorder(Color.BLACK, 1), 0, 53, 130, 30));
		opcoes.add(BoxSelect.criarCaixaDeSelecao("Batata-palha", Color.decode("#EEFFFF"), 
				BorderFactory.createLineBorder(Color.BLACK, 1), 130, 53, 130, 30));
		
		// aqui adicionei ao painel os objetos que criei, por meio da sua referência dentro do arrayList
		for (BoxSelect opcao : opcoes) {
            add(opcao);
        }
	}

	public ArrayList<BoxSelect> getOpcoes() {
		return opcoes;
	}

}
