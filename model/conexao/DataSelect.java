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
	private ConnectionDatabase initDatabase;
	
	public DataSelect() {
	}

	// Método para obter uma lista de alunos do banco de dados
	public List<MembroUniversitario> obterClientes() {
		List<MembroUniversitario> clientes = new ArrayList<>();
		
		initDatabase = new ConnectionDatabase(
				"test_db.mysql.dbaas.com.br:3306",
				"test_db",
				"test_db",
				"TecProg23-2!@"
				);
		connection = initDatabase.getConnection();
		
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT nome, matricula FROM cachorro_quente";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				
				String nome = resultSet.getString("nome");
				String matricula = String.valueOf(resultSet.getString("matricula"));
				MembroUniversitario cliente = new MembroUniversitario(nome, matricula);
				
				cliente.setIdNominal("Membro universitário");
				clientes.add(cliente);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("Lista nula ou banco de dados não conectado.");
			e.printStackTrace();
		}
		return clientes;
	}

	// Método para obter uma lista de vendas realizadas do banco de dados
	public List<CachorroQuente> obterVendas() {
		List<CachorroQuente> vendas = new ArrayList<>();
		
		initDatabase = new ConnectionDatabase(
				"test_db.mysql.dbaas.com.br:3306",
				"test_db",
				"test_db",
				"TecProg23-2!@"
				);
		connection = initDatabase.getConnection();
		
		try {			
			Statement statement = connection.createStatement();
			String query = "SELECT nome, matricula, op_proteina, op_queijo, bebida, valor FROM cachorro_quente";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				String nome = resultSet.getString("nome");
				int matricula = resultSet.getInt("matricula");
				String proteina = resultSet.getString("op_proteina");
				String queijo = resultSet.getString("op_queijo");
				String bebida = resultSet.getString("bebida");
				float preco = resultSet.getFloat("valor");

				CachorroQuente venda = new CachorroQuente();
				venda.setBebida(bebida);
				venda.setProteina(proteina);
				venda.setQueijo(queijo);
				venda.setPrice(preco);
				venda.setNome(nome);
				venda.setMatricula(String.valueOf(matricula));

				vendas.add(venda);
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vendas;
	}

	public Connection getConnection() {
		return connection;
	}
}
