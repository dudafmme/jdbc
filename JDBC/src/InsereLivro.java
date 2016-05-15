import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsereLivro {
	public static void main(String[] args) {
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "root";

		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();

			Scanner entrada = new Scanner(System.in);

			System.out.println("Digite o titulo do livro: ");
			String titulo = entrada.nextLine();

			System.out.println("Digite o preço do livro: ");
			double preco = Double.parseDouble(entrada.nextLine());

			System.out.println("Digite o id da editora: ");
			long editoraId = Long.parseLong(entrada.nextLine());

			entrada.close();

			String sql = "INSERT INTO Livro (titulo, preco, editora_id)" + "VALUES (?,?,?)";

			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, titulo);
			comando.setDouble(2, preco);
			comando.setLong(3, editoraId);

			System.out.println("Executando comando... ");
			comando.execute();

			System.out.println("Fechando a conexão..");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
