package paineis;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import modelosUnitarios.TInformation;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PElementos extends JPanel {
	private static final long serialVersionUID = -8136496118325664723L;

	public PElementos(JFrame frame) {
		int larguraFrame = frame.getWidth();
		int alturaFrame = frame.getHeight();
		setLayout(null);
		setBounds(new Rectangle(0, 35, larguraFrame, alturaFrame-90));
		setFont(new Font("Arial", Font.PLAIN, 14));
		setBorder(UIManager.getBorder("Menu.border"));
		setBackground(new Color(255, 154, 53));
		setLayout(new BorderLayout(4, 2));
		
		// adiciona-se uma tabela pré-programada
		add(new TInformation(frame));
		
		atualizarRedimensionamento(frame);
	}

	private void atualizarRedimensionamento(JFrame frame) {
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Calcule as novas posições e tamanhos dos componentes com base no tamanho da
				// janela.
				int novaLargura = frame.getWidth();
				int novaAltura = frame.getHeight();
				
				int novoX = 0; // Por exemplo, posiciona o botão no quarto da largura.
				int novoY = 35; // Por exemplo, posiciona o botão no quarto da altura.
				int novoLarguraBotao = novaLargura - 16; // Por exemplo, metade da largura da janela.
				int novaAlturaBotao = novaAltura - 115; // Por exemplo, um quarto da altura da janela.

				// Atualize as posições e tamanhos dos componentes com os valores calculados.
				setBounds(novoX, novoY, novoLarguraBotao, novaAlturaBotao);
				revalidate();
			}
		});
	}
}
