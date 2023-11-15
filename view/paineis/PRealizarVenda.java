package paineis;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import paineis.subpaineis.PLabels;

public class PRealizarVenda extends JPanel {
	private static final long serialVersionUID = 5649198591290075277L;
	private PLabels labels;

	public PRealizarVenda(JFrame frame) {
		int larguraFrame = frame.getWidth();
		int alturaFrame = frame.getHeight();
		
		setLayout(null);
		setVisible(false);
		setBackground(Color.decode("#12507D"));
		setBounds(new Rectangle(0, 35, larguraFrame, alturaFrame));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		
		labels = new PLabels(this);
		add(labels);
		atualizarRedimensionamento(frame, this);
		
	}
	
	private void atualizarRedimensionamento(JFrame frame, JPanel panel) {
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Calcule as novas posições e tamanhos dos componentes com base no tamanho da
				// janela.
				int novaLargura = frame.getWidth();
				int novaAltura = frame.getHeight();

				int novoX = 0; // Por exemplo, posiciona o botão no quarto da largura.
				int novoY = 35; // Por exemplo, posiciona o botão no quarto da altura.
				int novoLarguraBotao = novaLargura; // Por exemplo, metade da largura da janela.
				int novaAlturaBotao = novaAltura; // Por exemplo, um quarto da altura da janela.

				// Atualize as posições e tamanhos dos componentes com os valores calculados.
				panel.setBounds(novoX, novoY, novoLarguraBotao, novaAlturaBotao);
				panel.revalidate();
			}
		});
	}
	
	public PLabels getPLabels() {
		return labels;
	}
}