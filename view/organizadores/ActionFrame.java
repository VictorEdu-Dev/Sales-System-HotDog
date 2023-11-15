package organizadores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import paineis.PButtonPrincipal;
import paineis.PClientes;
import paineis.PElementos;
import paineis.PVendas;
import paineis.PRealizarVenda;
import paineis.PReport;

public class ActionFrame {

	public static void actionVisible(PButtonPrincipal button, PRealizarVenda painel1, 
			PElementos painel2, PVendas painel3, PReport painel4, PClientes painel5) {

		button.getBRealizarVenda().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(painel1.isVisible()) {
					painel1.setVisible(false);
					painel2.setVisible(true);
					painel3.setVisible(false);
					painel4.setVisible(false);
					painel5.setVisible(false);
				} else {
					painel1.setVisible(true);
					painel2.setVisible(false);
					painel3.setVisible(false);
					painel4.setVisible(false);
					painel5.setVisible(false);
				}
			}
		});

		button.getBListarVendas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel3.setVisible(true);
				painel1.setVisible(false);
				painel2.setVisible(false);
				painel4.setVisible(false);
				painel5.setVisible(false);
			}
		});


		button.getBMostrarRelatorio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel4.setVisible(true);
				painel1.setVisible(false);
				painel2.setVisible(false);
				painel3.setVisible(false);
				painel5.setVisible(false);
				
			}
		});

		button.getBListarClientes().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painel5.setVisible(true);
				painel4.setVisible(false);
				painel1.setVisible(false);
				painel2.setVisible(false);
				painel3.setVisible(false);
			}
		});

	}

	
}
