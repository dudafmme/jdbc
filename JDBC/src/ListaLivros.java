import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListaLivros {
	public static void main(String[] args) {
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "root";

		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();

			String sql = "SELECT * FROM Livro;";

			PreparedStatement comando = conexao.prepareStatement(sql);

			System.out.println("Executando comando");
			ResultSet resultado = comando.executeQuery();

			while (resultado.next()) {
				System.out.printf(" %d : %s - %s - %d \n ", resultado.getInt("idLivro"), resultado.getString("titulo"),
						resultado.getString("preco"), resultado.getInt("editora_id"));
			}
			System.out.println("Fechando conexão");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
