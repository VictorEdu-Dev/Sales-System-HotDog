package modelosUnitarios;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class LExibidor extends JLabel {
	private static final long serialVersionUID = -4603441739960425158L;

	public LExibidor(String text, Color cor, Color font, int x, int y, int width, int height, Boolean verify) {
		setLayout(null);
		setText(text);
		setBackground(cor);
		setForeground(font);
		setOpaque(verify);
		setFont(new Font("Arial", Font.BOLD, 16));
		setBounds(x, y, width, height);
		setBorder(new EmptyBorder(0, 15, 0, 0));
		setAlignmentX(0.5f);

	}

	public static LExibidor criarLabel(String texto, Color cor, Color font, Border border, int x, int y, int width,
			int height, Boolean verify) {
		return new LExibidor(texto, cor, font, x, y, width, height, verify);
	}

	public static LExibidor criarLabel(Color font, Border border, int x, int y, int width, int height, Boolean verify) {
		return new LExibidor(null, null, font, x, y, width, height, verify);
	}

	public static LExibidor criarLabel(Color cor, Color font, Border border, int x, int y, int width, int height,
			Boolean verify) {
		return new LExibidor(null, cor, font, x, y, width, height, verify);
	}

}
