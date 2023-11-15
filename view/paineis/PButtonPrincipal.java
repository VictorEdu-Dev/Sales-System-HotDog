package paineis;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import modelosUnitarios.BTecla;

public class PButtonPrincipal extends JPanel {
	private static final long serialVersionUID = 3488410545748288786L;
	private BTecla bRealizarVenda;
    private BTecla bListarVendas;
    private BTecla bMostrarRelatorio;
    private BTecla bListarClientes;

    public PButtonPrincipal(JFrame frame) {
        int larguraFrame = frame.getWidth();
        int alturaFrame = frame.getHeight();
        
        Color cor = Color.decode("#FCBA00");
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 4));
        setBackground(Color.decode("#12507D"));
		setBounds(0, 0, larguraFrame, alturaFrame / (128/5));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
        bRealizarVenda = BTecla.criarBotao("INICIAR VENDA", cor, border, 200, 20);
        bListarVendas = BTecla.criarBotao("VENDAS", cor, border, 200, 20);
        bMostrarRelatorio = BTecla.criarBotao("RELATÓRIO", cor, border, 200, 20);
        bListarClientes = BTecla.criarBotao("CLIENTES", cor, border, 200, 20);
        
        adicionarBotoes();
        atualizarRedimensionamento(frame);
    }

    private void atualizarRedimensionamento(JFrame frame) {
		frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcule as novas posições e tamanhos dos componentes com base no tamanho da janela.
                int novaLargura = frame.getWidth();
                int novaAltura = frame.getHeight();

                int novoX = 0;
                int novoY = 0;
                int novoLarguraBotao = novaLargura;
                int novaAlturaBotao = novaAltura / 25;

                // Atualize as posições e tamanhos dos componentes com os valores calculados.
                setBounds(novoX, novoY, novoLarguraBotao, novaAlturaBotao);
                revalidate();
            }
        });
	}

    private void adicionarBotoes() {
        add(bRealizarVenda);
        add(bListarVendas);
        add(bMostrarRelatorio);
        add(bListarClientes);
    }

    public BTecla getBRealizarVenda() {
        return bRealizarVenda;
    }

    public BTecla getBListarVendas() {
        return bListarVendas;
    }

    public BTecla getBMostrarRelatorio() {
        return bMostrarRelatorio;
    }

    public BTecla getBListarClientes() {
        return bListarClientes;
    }
}
