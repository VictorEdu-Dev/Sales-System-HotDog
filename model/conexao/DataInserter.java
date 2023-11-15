package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proteinas.CachorroQuente;
import roulle.CestaItens;

public class DataInserter {
	private Connection connection;

	public DataInserter(Connection connection) {
		this.connection = connection;
	}

	// Este método insere dados de um aluno na tabela "universitarios" se o aluno não existir.
	// Caso contrário, não faz nada.
	public void inserirDados(String nome, String matricula, String identificador) {
		// Obtém o ID do aluno se ele já existir na tabela
		int idAluno = obterID(matricula);

		// Verifica se o aluno não existe (-1 indica que não existe)
		if (idAluno == -1) {
			try {
				// Obtém o próximo índice disponível na tabela "universitarios"
				int index = ConnectionDatabase.obterProximoIndice(connection, "universitarios", "id");

				// Prepara a consulta SQL com placeholders
				String insertQuery = "INSERT INTO universitarios (id, idNominal, cliente, matricula) VALUES (?, ?, ?, ?)";

				// Configura os valores nos placeholders
				try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
					preparedStatement.setInt(1, index);
					preparedStatement.setString(2, identificador);
					preparedStatement.setString(3, nome);
					preparedStatement.setString(4, matricula);
					preparedStatement.executeUpdate(); // Executa a inserção no banco de dados
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Este método insere dados de venda associados a um aluno na tabela "vendarealizadas".
	// Ele verifica se o aluno já existe na tabela "universitarios" e o insere, se necessário.
	public void inserirVenda(CestaItens cesta) {
		// Obtém dados da lista advinda de CestaItens
		String nome = cesta.getListaVenda().get(0).getMembroUniversitario().getNome();
		String identificacao = cesta.getListaVenda().get(0).getMembroUniversitario().getIdentificacao();
		String identificador = cesta.getIdentificador();

		// Obtém o ID do aluno se ele já existir na tabela "universitarios"
		int idAluno = obterID(cesta.getListaVenda().get(0).getMembroUniversitario().getIdentificacao());

		// Verifica se o aluno não existe (-1 indica que não existe)
		if (idAluno == -1) {
			// Se o aluno não existe, insere seus dados na tabela "universitarios"
			inserirDados(nome, identificacao, identificador);

			// Obtém o ID do aluno recém-inserido
			idAluno = obterID(identificacao);
		}

		// Prepara a consulta SQL para inserir os dados da venda
		String insertSQL = "INSERT INTO vendarealizadas (proteina, queijo, bebida, preco, aluno_id) VALUES (?, ?, ?, ?, ?)";
		
		int posicaoVenda = 0;
		
		for(CachorroQuente item : cesta.getListaVenda().get(posicaoVenda).getCachorrosQuentes()) {

			// Configura os valores nos placeholders
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
				preparedStatement.setString(1, item.getProteina());
				preparedStatement.setString(2, item.getQueijo());
				preparedStatement.setString(3, item.getBebida());
				preparedStatement.setFloat(4, item.getPrice());
				preparedStatement.setInt(5, idAluno);
				preparedStatement.executeUpdate(); // Executa a inserção no banco de dados
			} catch (SQLException e) {
				System.out.println("Registro do processo mal-sucedido.");
				e.printStackTrace();
			}
		}
		
		cesta.getListaVenda().get(posicaoVenda).getCachorrosQuentes().removeAll(cesta.getListaVenda().get(posicaoVenda).getCachorrosQuentes());
		System.out.println("Venda registrada!");
		cesta.getListaVenda().remove(posicaoVenda);
	}

	// Este método obtém o ID de um aluno na tabela "universitarios" com base no nome e na matrícula.
	private int obterID(String identificacao) {
		// Prepara a consulta SQL para selecionar o ID com base na matrícula
		String selectSQL = "SELECT id FROM universitarios WHERE matricula = ?";
		int idAluno = -1;

		// Configura o valor do placeholder com o nome
		try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
			preparedStatement.setString(1, identificacao);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					idAluno = resultSet.getInt("id"); // Obtém o ID do aluno encontrado
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return idAluno;
	}

	public Connection getConnection() {
		return connection;
	}
}
