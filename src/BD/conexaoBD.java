
package BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBD {
    private static final String URL = "jdbc:mysql://yamanote.proxy.rlwy.net:12512/railway?serverTimezone=UTC";
    private static final String USER = "root"; // usuário gerado pelo Railway
    private static final String PASSWORD = "YmHTvrJZEfBxDzDcAPdQchKuzLbRCLLi"; // senha do Railway

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = conectar()) {
            System.out.println("✅ Conectado com sucesso ao banco Railway!");
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar: " + e.getMessage());
        }
    }
}

