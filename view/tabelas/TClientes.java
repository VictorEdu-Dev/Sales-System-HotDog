package tabelas;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import academicos.MembroUniversitario;
import java.util.List;

public class TClientes extends AbstractTableModel {
    private static final long serialVersionUID = 2093684972794569956L;
    private List<MembroUniversitario> data;
    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
    
    public TClientes(List<MembroUniversitario> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // Três colunas: idNominal, Nome e Identificador
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < data.size()) {
            MembroUniversitario membro = data.get(rowIndex);
            if (columnIndex == 0) {
                return membro.getIdNominal(); // Coluna 0: ID Nominal
            } else if (columnIndex == 1) {
                return membro.getNome(); // Coluna 1: Nome
            } else if (columnIndex == 2) {
            	 return membro.getIdentificacao(); // Coluna 3: Identificação
            }
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID NOMINAL"; // Nome da primeira coluna
        } else if (column == 1) {
            return "NOME"; // Nome da segunda coluna
        } else if (column == 2) {
        	return "IDENTIFICAÇÃO"; // Nome da terceira coluna
        }
        return super.getColumnName(column);
    }

    public void addData(MembroUniversitario membro) {
        data.add(membro);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void removeData(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < data.size()) {
            data.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
    
}
