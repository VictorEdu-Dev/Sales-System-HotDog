package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDatabase {

	private String host;
	private String usuario;
	private String senha;
	private String banco;
	private Connection connection;

	public ConnectionDatabase() {

		this.host = "127.0.0.1"; // localhost
		this.banco = "barracahotdog";
		this.usuario = "Victor";
		this.senha = "Vv,11111";

		getConexao();
	}

	public void getConexao() {
//		Inicia os serviços do banco de dados
//		DatabaseManager.iniciarServicos();
		
		System.out.println("Tentando se conectar ao banco de dados...");
		String url="jdbc:mysql://" + this.host + "/" + this.banco+"?verifyServerCertificate=false&useSSL=true";

		try {
			connection = DriverManager.getConnection(url, usuario, senha);
			if (connection != null) {
				System.out.println("Conexão bem-sucedida!");
			}
		} catch (SQLException ex) {
			System.out.println("Conexão com MYSQL não realizada");
			ex.printStackTrace();
		}
	}

	public static  int obterProximoIndice(Connection connection, String tabela, String colunaIndice) {
		int proximoIndice = 0;
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT MAX(" + colunaIndice + ") FROM " + tabela;
			ResultSet resultSet = statement.executeQuery(query);

			if (resultSet.next()) {
				proximoIndice = resultSet.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proximoIndice;
	}


	public Connection getConnection() {
		return connection;
	}
}
