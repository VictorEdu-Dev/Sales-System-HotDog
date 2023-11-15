package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import academicos.MembroUniversitario;
import proteinas.CachorroQuente;

public class DataSelect {
	private Connection connection;

	public DataSelect(Connection connection) {
		this.connection = connection;
	}

	// Método para obter uma lista de alunos do banco de dados
	public static List<MembroUniversitario> obterClientes(Connection connection) {
		List<MembroUniversitario> clientes = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT idNominal, cliente, matricula FROM universitarios";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String nome = resultSet.getString("cliente");
				String matricula = resultSet.getString("matricula");
				String identificador = resultSet.getString("idNominal");
				MembroUniversitario cliente = new MembroUniversitario(nome, matricula);
				cliente.setIdNominal(identificador);
				clientes.add(cliente);
			}
		} catch (SQLException e) {
			System.out.println("Lista nula ou banco de dados não conectado.");
			e.printStackTrace();
		}
		return clientes;
	}

	// Método para obter uma lista de vendas realizadas do banco de dados
	public static List<CachorroQuente> obterVendas(Connection connection) {
		List<CachorroQuente> vendas = new ArrayList<>();
		try {			
			Statement statement = connection.createStatement();
			String query = "SELECT proteina, queijo, bebida, preco, aluno_id FROM vendarealizadas";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int identificador = resultSet.getInt("aluno_id");
				String proteina = resultSet.getString("proteina");
				String queijo = resultSet.getString("queijo");
				String bebida = resultSet.getString("bebida");
				float preco = resultSet.getFloat("preco");

				CachorroQuente venda = new CachorroQuente();
				venda.setBebida(bebida);
				venda.setProteina(proteina);
				venda.setQueijo(queijo);
				venda.setPrice(preco);
				venda.setIdentificador(identificador);

				vendas.add(venda);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendas;
	}

	public Connection getConnection() {
		return connection;
	}
}
