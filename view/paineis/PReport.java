package paineis;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JTable;

import tabelas.TClientes;

import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.Font;

public class PReport extends JPanel {
	private static final long serialVersionUID = 8L;
	private JTable table;

	public PReport(JFrame frame) {
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setLayout(null);
		setVisible(false);
		setBounds(new Rectangle(0, 35, 1366, 675));
		setBackground(Color.decode("#122136"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane.setBounds(5, 5, 1346, 655);
		add(scrollPane);

		table = new JTable();
		table.setRowHeight(30);
		table.setForeground(new Color(255, 255, 255));
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		table.setBackground(Color.decode("#122136"));
		scrollPane.setViewportView(table);

		atualizarRedimensionamento(frame, scrollPane);
	}

	private void atualizarRedimensionamento(JFrame frame, JScrollPane scrollPane) {
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				// Calcule as novas posições e tamanhos dos componentes com base no tamanho da
				// janela.
				int novaLargura = frame.getWidth() - 25;
				int novaAltura = frame.getHeight() - 90;

				int novoX = 5; // Por exemplo, posiciona o botão no quarto da largura.
				int novoY = 5; // Por exemplo, posiciona o botão no quarto da altura.
				int novoLarguraBotao = novaLargura; // Por exemplo, metade da largura da janela.
				int novaAlturaBotao = novaAltura / (135 / 131); // Por exemplo, um quarto da altura da janela.

				// Atualize as posições e tamanhos dos componentes com os valores calculados.
				scrollPane.setBounds(novoX, novoY, novoLarguraBotao, novaAlturaBotao);
				scrollPane.revalidate();
			}
		});
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(TClientes model) {
		this.table.setModel(model);
	}

}
