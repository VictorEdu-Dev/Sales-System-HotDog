package modelosUnitarios;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.border.Border;

public class BoxSelect extends JCheckBox {
	private static final long serialVersionUID = -7769507739526717172L;

	public BoxSelect(String text, Color cor, Border border, int x, int y, int width, int height) {
		setText(text);
		setBackground(cor);
		setBorder(border);
		setBounds(x, y, width, height);
		setFont(new Font("Open Sans", Font.ROMAN_BASELINE, 14));
		setForeground(Color.BLACK);
	}

	public static BoxSelect criarCaixaDeSelecao(String text, Color cor, Border border, int x, int y, int width,
			int height) {
		return new BoxSelect(text, cor, border, x, y, width, height);
	}
}
