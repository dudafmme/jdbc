import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

public class ListaEditoras {
	public static void main(String[] args) {
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "root";

		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "SELECT * FROM Editora;";

			PreparedStatement comando = conexao.prepareStatement(sql);

			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				System.out.printf(" %d : %s - %s \n ", resultado.getInt("idEditora"), resultado.getString("nome"),
						resultado.getString("email"));
			}
			System.out.println("Fechando conexão");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
