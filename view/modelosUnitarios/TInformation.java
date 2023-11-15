package modelosUnitarios;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.DropMode;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;

public class TInformation extends JTable {
	private static final long serialVersionUID = -8381247397262671238L;

	public TInformation(JFrame frame) {
		setGridColor(SystemColor.textText);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		setDropMode(DropMode.ON);
		setRowHeight(30);
		setRowSelectionAllowed(false);
		setFillsViewportHeight(true);
		setForeground(Color.WHITE);
		setBackground(Color.decode("#12507D"));
		setIntercellSpacing(new Dimension(5, 5));
		setBorder(new LineBorder(Color.BLACK));
		setFont(new Font("Arial Black", Font.PLAIN, 15));

		setModel(
				new DefaultTableModel(
						new Object[][] { { "Preço", "HotDog" }, { "R$ 3,00", "Linguiça" }, { "R$ 2,00", "Salsicha" },
								{ "R$ 3,50", "Bacon" }, { "R$ 2,50", "Frango" }, },
						new String[] { "Pre\u00E7o", "Produto" }) {
					private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int row, int column) {
						return false; // Torna todas as células não editáveis
					}
				});
	}
}
