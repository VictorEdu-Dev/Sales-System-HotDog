package modelosUnitarios;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.*;
import organizadores.ActionFrame;
import paineis.*;
import java.awt.event.*;

public class FJanela extends JFrame {
	private static final long serialVersionUID = -6344726861520037304L;
	private PButtonPrincipal painelBotoes;
	private PRealizarVenda painelRealizarVendas;
	private PVendas painelVendas;
	private PReport painelRelatorio;
	private PClientes painelClientes;
	private PElementos painelElementos;
	protected BufferedImage icon;

	protected static final int widthWindowMin = 600;
	protected static final int heightWindowMin = 400;

	protected static final int widthWindowMax = 1366;
	protected static final int heightWindowMax = 768;

	public FJanela() {
		criarJanela();
	}

	private void criarJanela() {

		setImage();
		initializeFrame();
		createPanels();
		addPanelsToFrame();
		configureCloseAction();
	}

	private void initializeFrame() {
		setLayout(null);
		setSize(800, 600);
		revalidate();
		setMaximumSize(new Dimension(widthWindowMax, heightWindowMax));
		setMinimumSize(new Dimension(widthWindowMin, heightWindowMin));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HotDog´s Freddy");
		getContentPane().setBackground(Color.decode("#12507D"));
	}

	private void createPanels() {
		painelRelatorio = new PReport(this);
		painelBotoes = new PButtonPrincipal(this);
		painelRealizarVendas = new PRealizarVenda(this);
		painelVendas = new PVendas(this);
		painelClientes = new PClientes(this);
		painelElementos = new PElementos(this);
	}

	private void addPanelsToFrame() {
		add(painelBotoes);
		add(painelRealizarVendas);
		add(painelVendas);
		add(painelRelatorio);
		add(painelClientes);
		add(painelElementos);
		ActionFrame.actionVisible(painelBotoes, painelRealizarVendas, painelElementos, painelVendas, painelRelatorio,
				painelClientes);
		setVisible(true);
	}

	private void configureCloseAction() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação de saída",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0); // Fecha o programa
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	private void setImage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("ufc2.png")));
	}

	public PButtonPrincipal getPainelBotoes() {
		return painelBotoes;
	}

	public PRealizarVenda getPainelRealizarVendas() {
		return painelRealizarVendas;
	}

	public PClientes getPainelClientes() {
		return painelClientes;
	}

	public PVendas getPainelVendas() {
		return painelVendas;
	}
}
