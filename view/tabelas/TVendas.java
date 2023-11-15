package tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import proteinas.CachorroQuente;

public class TVendas extends AbstractTableModel {
    private static final long serialVersionUID = 802090229987492177L;
    private List<CachorroQuente> data;

    public TVendas(List<CachorroQuente> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size(); // Retorna o número de linhas na tabela.
    }

    @Override
    public int getColumnCount() {
        return 5; // Retorna o número de colunas (cinco no total).
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < data.size()) {
            CachorroQuente venda = data.get(rowIndex);
            if (columnIndex == 0) {
                return venda.getIdentificador(); // Retorna o valor da coluna 0 (ID).
            } else if (columnIndex == 1) {
                return venda.getProteina(); // Retorna o valor da coluna 1 (Proteína).
            } else if (columnIndex == 2) {
                return venda.getQueijo(); // Retorna o valor da coluna 2 (Queijos).
            } else if (columnIndex == 3) {
                return venda.getBebida(); // Retorna o valor da coluna 3 (Bebidas).
            } else if (columnIndex == 4) {
                return venda.getPrice(); // Retorna o valor da coluna 4 (Preço).
            }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID"; // Retorna o nome da primeira coluna.
        } else if (column == 1) {
            return "TIPO DE CACHORRO-QUENTE"; // Retorna o nome da segunda coluna.
        } else if (column == 2) {
            return "QUEIJOS"; // Retorna o nome da terceira coluna.
        } else if (column == 3) {
            return "BEBIDAS"; // Retorna o nome da quarta coluna.
        } else if (column == 4) {
            return "TOTAL"; // Retorna o nome da quinta coluna.
        }
        return super.getColumnName(column); // Se não corresponder a nenhuma das colunas acima, retorna o nome padrão.
    }

    public void addData(CachorroQuente venda) {
        data.add(venda); // Adiciona uma nova venda aos dados.
        fireTableRowsInserted(data.size() - 1, data.size() - 1); // Notifica a tabela sobre a inserção da nova linha.
    }

    public void removeData(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < data.size()) {
            data.remove(rowIndex); // Remove uma venda dos dados.
            fireTableRowsDeleted(rowIndex, rowIndex); // Notifica a tabela sobre a exclusão da linha.
        }
    }
}
