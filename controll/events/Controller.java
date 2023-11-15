package events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import conexao.ConnectionDatabase;
import conexao.DataInserter;
import conexao.DataSelect;
import conexao.DatabaseManager;
import modelosUnitarios.FJanela;
import roulle.CestaItens;
import tabelas.TClientes;
import tabelas.TVendas;

public class Controller {
    private FJanela janelaPrincipal;
    private CestaItens barraca;
    private VendasAux vendaInterface;
    private ConnectionDatabase initDatabase;
    private DataInserter inserirDados;

    public Controller() {
        janelaPrincipal = new FJanela();
        barraca = new CestaItens();
        vendaInterface = new VendasAux(janelaPrincipal.getPainelRealizarVendas().getPLabels());

        initDatabase = new ConnectionDatabase();
        inserirDados = new DataInserter(initDatabase.getConnection());

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
        
        inserirDados.inserirVenda(barraca);
        
        // é necessário atualizar as tabelas novamente
        atualizarTabelaNoPainelClientes();
        atualizarTabelaNoPainelVendas();
    }

	private void atualizarTabelaNoPainelClientes() {
		TClientes model = new TClientes(DataSelect.obterClientes(initDatabase.getConnection()));
        janelaPrincipal.getPainelClientes().setTableModel(model);
        janelaPrincipal.getPainelClientes().getColumn(0, 50);
	}
	
	private void atualizarTabelaNoPainelVendas() {
		TVendas model = new TVendas(DataSelect.obterVendas(initDatabase.getConnection()));
        janelaPrincipal.getPainelVendas().setTable(model);
        
	}

    public void fecharConexao() {
        if (initDatabase.getConnection() != null) {
            try {
                initDatabase.getConnection().close();
                DatabaseManager.pararServicos();
                System.out.println("Conexão com o banco de dados fechada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
