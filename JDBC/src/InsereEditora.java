import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsereEditora {
	public static void main(String[] args) {
		String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "root";

		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();

			Scanner entrada = new Scanner(System.in);

			System.out.println("Digite o nome da editora: ");
			String nome = entrada.nextLine();

			System.out.println("Digite o email da editora: ");
			String email = entrada.nextLine();

			entrada.close();

			String sql = "INSERT INTO Editora (nome, email)" + "VALUES (?,?)";

			PreparedStatement comando = conexao.prepareStatement(sql);

			comando.setString(1, nome);
			comando.setString(2, email);

			System.out.println("Executando comando... ");
			comando.execute();

			System.out.println("Fechando a conexão..");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
