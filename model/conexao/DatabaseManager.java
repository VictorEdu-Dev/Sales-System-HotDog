package conexao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
	private static Process mysqlProcess;
	private static Process apacheProcess;

	// Método para obter o ID do aluno de outra tabela
	public static int obterIdDoUniversitario(Connection connection, String nomeDoAluno) {
		int alunoId = -1; // Valor padrão para indicar erro ou não encontrado

		String query = "SELECT id FROM universitarios WHERE nome = ?";
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, nomeDoAluno);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				alunoId = resultSet.getInt("id");
			}
			System.out.println("Id encontrado: " + alunoId);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Id não encontrado: " + alunoId);
		}

		return alunoId;
	}



	// Método para iniciar o MySQL e o Apache
	public static void iniciarServicos() {
		try {
			// Inicie o MySQL
			mysqlProcess = new ProcessBuilder("C:\\xampp\\mysql\\bin\\mysqld.exe").start();

			// Inicie o Apache
			apacheProcess = new ProcessBuilder("C:\\xampp\\apache_start.bat").start();

			System.out.println("Serviços iniciados.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para parar o MySQL e o Apache
	public static void pararServicos() {
		if (mysqlProcess != null) {
			mysqlProcess.destroy();
			System.out.println("MySQL encerrado.");
		}

		if (apacheProcess != null) {
			apacheProcess.destroy();
			System.out.println("Apache encerrado.");
		}
	}

}
