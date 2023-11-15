package organizadores;

import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Bounds {
	
	public Bounds() {
	}
	
	public static void atualizarRedimensionamento(Component frame, Component component) {
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int novaLargura = frame.getWidth() - 25;
				int novaAltura = frame.getHeight() - 103;

				int novoLarguraBotao = novaLargura;
				int novaAlturaBotao = novaAltura / (768/665);

				component.setSize(novoLarguraBotao, novaAlturaBotao);
				component.revalidate();
			}
		});
	}
	
	public static void adjustComponentPosition(Component component, Component frame) {
		  // Obtém as dimensões do frame
		  int width = frame.getWidth();
		  int height = frame.getHeight();

		  // Obtém as dimensões do componente
		  int componentWidth = component.getWidth();
		  int componentHeight = component.getHeight();

		  // Calcula as novas coordenadas do componente
		  int x = (width - componentWidth) / 2;
		  int y = (height - componentHeight) / 2;

		  // Define as novas coordenadas do componente
		  component.setLocation(x, y);
		}

	
	public static void adjustWidth(Component componenteFilho, Component componentePai) {
        componentePai.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Obtém as novas dimensões do componente pai
                int newWidthParent = componentePai.getWidth();
                int newHeightParent = componentePai.getHeight();

                // Calcula a nova posição ao tamanho do pai
                int newPositionChildX = newWidthParent;
                int newPositionChildY = newHeightParent;
                
                // Atualiza a posição do componente filho
                componenteFilho.setLocation(newPositionChildX, newPositionChildY);
                componenteFilho.revalidate();
                componenteFilho.repaint();
            }
            
        });
        
        
    }

}
