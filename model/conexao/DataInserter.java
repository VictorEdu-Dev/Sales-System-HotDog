package conexao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import proteinas.CachorroQuente;
import roulle.CestaItens;

public class DataInserter {
	private Connection connection;
	private ConnectionDatabase initDatabase;

	public DataInserter() {
	}

	// Este método insere dados de venda associados a um aluno na tabela "vendarealizadas".
	// Ele verifica se o aluno já existe na tabela "universitarios" e o insere, se necessário.
	public void inserirVenda(CestaItens cesta, String nome, String matricula) {
		initDatabase = new ConnectionDatabase(
				"test_db.mysql.dbaas.com.br:3306",
				"test_db",
				"test_db",
				"TecProg23-2!@"
				);
		connection = initDatabase.getConnection();
		try {
			// Prepara a consulta SQL para inserir os dados da venda
			String insertSQL = "INSERT INTO cachorro_quente (nome, matricula, op_queijo, op_proteina, ingredientes, bebida, valor) VALUES (?, ?, ?, ?, ?, ?, ?)";

			int posicaoVenda = 0;
			CachorroQuente item = cesta.getListaVenda().get(posicaoVenda).getCachorrosQuentes().get(0);

			// Configura os valores nos placeholders
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

				preparedStatement.setString(1, nome);
				preparedStatement.setInt(2, Integer.parseInt(matricula));
				preparedStatement.setInt(3, 1);
				preparedStatement.setInt(4, 1);
				preparedStatement.setString(5, "");
				preparedStatement.setInt(6, 1);
				preparedStatement.setBigDecimal(7, BigDecimal.valueOf(item.getPrice()));

				preparedStatement.executeUpdate();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Registro do processo mal-sucedido.");
				e.printStackTrace();
			} 


			cesta.getListaVenda().get(posicaoVenda).getCachorrosQuentes().clear();
			System.out.println("Venda registrada!");
			cesta.getListaVenda().clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
