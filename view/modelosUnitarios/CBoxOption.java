package modelosUnitarios;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import javax.swing.UIManager;

public class CBoxOption extends JComboBox<String> {
	private static final long serialVersionUID = 7651568712674829531L;

	public CBoxOption(String[] items, String text, int x, int y, int width, int height) {
		super(items);
		;
		setBorder(UIManager.getBorder("ComboBox.border"));
		setToolTipText(text);
		setBounds(new Rectangle(x, y, width, height));
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setMaximumRowCount(5);
		setFont(new Font("Arial", Font.BOLD, 14));
	}

	public static CBoxOption criarComboBox(String[] items, String text, int x, int y, int width, int height) {
		return new CBoxOption(items, text, x, y, width, height);
	}

	public static <E extends Enum<E>> String[] obterElementos(Class<E> enumClass) {
		E[] enumConstants = enumClass.getEnumConstants();
		String[] itemsList = new String[enumConstants.length];

		for (int i = 0; i < enumConstants.length; i++) {
			itemsList[i] = enumConstants[i].name();
		}
		return itemsList;
	}

}
