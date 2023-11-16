package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import conexao.DataInserter;
import conexao.DataSelect;
import modelosUnitarios.FJanela;
import roulle.CestaItens;
import tabelas.TClientes;
import tabelas.TVendas;

public class Controller {
    private FJanela janelaPrincipal;
    private CestaItens barraca;
    private VendasAux vendaInterface;
    private DataInserter inserirDados;
    private DataSelect obterDados;

    public Controller() {
        janelaPrincipal = new FJanela();
        barraca = new CestaItens();
        vendaInterface = new VendasAux(janelaPrincipal.getPainelRealizarVendas().getPLabels());
        inserirDados = new DataInserter();
        obterDados = new DataSelect();
        
        atualizarTabelaNoPainelClientes();
        atualizarTabelaNoPainelVendas();
        confirmarVenda();
    }

    private void confirmarVenda() {
        janelaPrincipal.getPainelRealizarVendas().getPLabels().getBFinalizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = JOptionPane.showConfirmDialog(
                        janelaPrincipal.getPainelRealizarVendas().getPLabels().getBFinalizar(),
                        "Deseja finalizar venda?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    registrarEventos();
                    JOptionPane.showMessageDialog(janelaPrincipal, "Venda finalizada com sucesso!");
                }
            }
        });
    }

    private void registrarEventos() {
        String entrada = vendaInterface.getEntradaNome();
        String identificacao = vendaInterface.getEntradaId();
        String queijo = vendaInterface.getEntradaQueijo();
        String proteina = vendaInterface.getEntradaProteina();
        String bebida = vendaInterface.getEntradaBebida();
        String identificador = vendaInterface.getIdentificador();
        float price = vendaInterface.getPriceProteina(proteina);
        ArrayList<String> adicionais = vendaInterface.getAdicionais();

        // Conecta diretamente ao back-end
        barraca.menuOperacoes(entrada, identificacao, identificador,
        		queijo, bebida, proteina, price);
        barraca.setAdicional(adicionais);
        
        inserirDados.inserirVenda(barraca, entrada, identificacao);
        
        // é necessário atualizar as tabelas novamente
        atualizarTabelaNoPainelClientes();
        atualizarTabelaNoPainelVendas();
    }

	private void atualizarTabelaNoPainelClientes() {
		TClientes model = new TClientes(obterDados.obterClientes());
        janelaPrincipal.getPainelClientes().setTableModel(model);
        janelaPrincipal.getPainelClientes().getColumn(0, 50);
	}
	
	private void atualizarTabelaNoPainelVendas() {
		TVendas model = new TVendas(obterDados.obterVendas());
        janelaPrincipal.getPainelVendas().setTable(model);
        
	}
}
