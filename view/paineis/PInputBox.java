package paineis;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class PInputBox extends JTextField {
    private static final long serialVersionUID = -5315299897156928737L;

    public PInputBox(int x, int y, int width, int height, Color corDeFundo, Border borda) {
        setBounds(x, y, width, height);
        setFont(new Font("Open Sans", Font.ROMAN_BASELINE, 14));
        setForeground(Color.BLACK);
        setBorder(borda);
        setBackground(corDeFundo);
        setOpaque(true);
        setEnabled(true);
    }

    public static PInputBox criarInputBox(int x, int y, int width, int height, Color corDeFundo, Border borda) {
        return new PInputBox(x, y, width, height, corDeFundo, borda);
    }
}
