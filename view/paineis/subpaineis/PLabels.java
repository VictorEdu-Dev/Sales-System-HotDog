package paineis.subpaineis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import listaOpcoes.*;
import modelosUnitarios.CBoxOption;
import modelosUnitarios.LExibidor;
import javax.swing.JButton;
import paineis.PInputBox;
import java.awt.Cursor;

public class PLabels extends JPanel {
	private static final long serialVersionUID = -552699637925287010L;
	private PInputBox entradaNome;
	private PInputBox entradaId;
	private CBoxOption entradaProteina;
	private CBoxOption entradaQueijo;
	private CBoxOption entradaBebida;
	private CBoxOption identificadorMembroUniversitario;
	private PCaixasSelecao entradaAdicional;
	
	private JButton bFinalizar;
	private JButton bAddCarSale;

	public PLabels(JPanel panel) {
		initializeLayout(panel);
		createComponents();
		atualizarRedimensionamento(panel);
	}

	private void initializeLayout(JPanel panel) {
		int larguraFrame = panel.getWidth();
		int alturaFrame = panel.getHeight();

		setLayout(null);
		setOpaque(true);
		setBackground(Color.decode("#12507D"));
		setBounds(new Rectangle(0, 0, larguraFrame, alturaFrame));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

	}

	private void createComponents() {
		createInputBoxNome();
		createInputBoxMatricula();
		createComboBoxProteina();
		createComboBoxQueijo();
		createCheckBoxAdicional();
		createComboBoxBebida();
		createFinalizarButton();
		createAddSaleCar();
	}

	private void createInputBoxNome() {
		identificadorMembroUniversitario = CBoxOption.criarComboBox(
				new String[] { "Professor", "Servidor", "Estudante" }, "Identifique o membro universitário.", 701, 82,
				200, 20);
		entradaNome = PInputBox.criarInputBox(700, 40, 600, 40, Color.decode("#EEFFFF"),
				BorderFactory.createLineBorder(Color.BLACK, 1));
		add(identificadorMembroUniversitario);
		add(entradaNome);
		add(LExibidor.criarLabel("CLIENTE: ", Color.decode("#122136"), Color.WHITE,
				BorderFactory.createLineBorder(Color.BLACK, 1), 15, 15, 1336, 92, true));
	}

	private void createInputBoxMatricula() {
		entradaId = PInputBox.criarInputBox(700, 132, 600, 40, Color.decode("#EEFFFF"),
				BorderFactory.createLineBorder(Color.BLACK, 1));
		add(entradaId);
		add(LExibidor.criarLabel("IDENTIFICAÇÃO: ", Color.decode("#122136"), Color.WHITE,
				BorderFactory.createLineBorder(Color.BLACK, 1), 15, 107, 1336, 92, true));
	}

	private void createComboBoxProteina() {
		entradaProteina = CBoxOption.criarComboBox(CBoxOption.obterElementos(OptionProtein.class),
				"Selcione um cachorro-quente.", 700, 224, 600, 40);
		add(entradaProteina);
		add(LExibidor.criarLabel("CACHORRO-QUENTE: ", Color.decode("#122136"), Color.WHITE,
				BorderFactory.createLineBorder(Color.BLACK, 1), 15, 199, 1336, 92, true));
	}

	private void createComboBoxQueijo() {
		entradaQueijo = CBoxOption.criarComboBox(CBoxOption.obterElementos(OptionIngredient.class),
				"Selecione um queijo.:", 700, 316, 600, 40);
		add(entradaQueijo);
		add(LExibidor.criarLabel("QUEIJO: ", Color.decode("#122136"), Color.WHITE,
				BorderFactory.createLineBorder(Color.BLACK, 1), 15, 291, 1336, 92, true));
	}

	private void createCheckBoxAdicional() {
		entradaAdicional = new PCaixasSelecao(this);
		add(entradaAdicional);
		add(LExibidor.criarLabel("ADICIONAL: ", Color.decode("#122136"), Color.WHITE,
				BorderFactory.createLineBorder(Color.BLACK, 1), 15, 383, 1336, 92, true));
	}

	private void createComboBoxBebida() {
		entradaBebida = CBoxOption.criarComboBox(CBoxOption.obterElementos(OptionDrink.class), "Selecione uma bebida.:",
				700, 500, 600, 40);
		add(entradaBebida);
		add(LExibidor.criarLabel("BEBIDA: ", Color.decode("#122136"), Color.WHITE,
				BorderFactory.createLineBorder(Color.BLACK, 1), 15, 475, 1336, 92, true));
	}

	private void createFinalizarButton() {
		bFinalizar = new JButton("FECHAR VENDA");
		bFinalizar.setBackground(Color.decode("#FCBA00"));
		bFinalizar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		bFinalizar.setBounds(1151, 567, 200, 30);
		bFinalizar.setFont(new Font("Arial", Font.BOLD, 14));
		bFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(bFinalizar);
	}
	
	private void createAddSaleCar() {
		bAddCarSale = new JButton("ADD AO CARRINHO");
		bAddCarSale.setBounds(981, 567, 150, 30);
		bAddCarSale.setFont(new Font("Arial", Font.BOLD, 14));
		bAddCarSale.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		bAddCarSale.setBackground(Color.decode("#FCBA00"));
		bAddCarSale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		add(bAddCarSale);
	}

	private void atualizarRedimensionamento(JPanel panelPai) {
		panelPai.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Calcule as novas posições e tamanhos dos componentes com base no tamanho da
				// janela.
				int novaLargura = panelPai.getWidth();
				int novaAltura = panelPai.getHeight();

				int novoX = 0; // Por exemplo, posiciona o botão no quarto da largura.
				int novoY = 0; // Por exemplo, posiciona o botão no quarto da altura.
				int novoLarguraBotao = novaLargura; // Por exemplo, metade da largura da janela.
				int novaAlturaBotao = novaAltura; // Por exemplo, um quarto da altura da janela.

				// Atualize as posições e tamanhos dos componentes com os valores calculados.
				setBounds(novoX, novoY, novoLarguraBotao, novaAlturaBotao);
				revalidate();
			}
		});
	}

	public JButton getBFinalizar() {
		return bFinalizar;
	}

	public PInputBox getEntradaNome() {
		return entradaNome;
	}

	public PInputBox getEntradaId() {
		return entradaId;
	}

	public CBoxOption getEntradaIdentidicador() {
		return identificadorMembroUniversitario;
	}

	public CBoxOption getEntradaProteina() {
		return entradaProteina;
	}

	public CBoxOption getEntradaQueijo() {
		return entradaQueijo;
	}

	public PCaixasSelecao getEntradaAdicional() {
		return entradaAdicional;
	}

	public CBoxOption getEntradaBebida() {
		return entradaBebida;
	}

	public CBoxOption getIdentificadorMembroUniversitario() {
		return identificadorMembroUniversitario;
	}
}
