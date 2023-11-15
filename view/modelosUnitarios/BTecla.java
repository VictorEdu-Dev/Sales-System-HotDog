package modelosUnitarios;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.border.Border;

public class BTecla extends JButton {
	private static final long serialVersionUID = -4603441739960425158L;

	public BTecla(String text, Color cor, Border border, int width, int height) {

		setText(text);
		setBackground(cor);
		setFont(new Font("Open Sans", Font.BOLD, 16));
		setPreferredSize(new Dimension(width, height));
		setBorder(border);
		setAlignmentY(0.5f);

	}

	public static BTecla criarBotao(String texto, Color cor, Border border, int width, int height) {
		return new BTecla(texto, cor, border, width, height);
	}

}
