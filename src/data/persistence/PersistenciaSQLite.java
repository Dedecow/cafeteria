package data.persistence;

import java.sql.*;
import java.util.Date;
import java.util.UUID;

public class PersistenciaSQLite implements IPersistencia {
    
    private static final String DB_URL = "jdbc:sqlite:cafeteria.db";  // Arquivo DB na raiz do projeto
    private Connection conn;

    public PersistenciaSQLite() {
        try {
            // CORREÇÃO: Carrega o driver SQLite explicitamente
            Class.forName("org.sqlite.JDBC");
            System.out.println("Driver SQLite carregado com sucesso!");
            
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Conectado ao SQLite!");
            criarTabelaSeNaoExiste();
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite não encontrado: " + e.getMessage());
            // O JAR pode não estar no classpath - verifique Libraries no NetBeans
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao SQLite: " + e.getMessage());
            // Verifique permissões de escrita na pasta do projeto para criar cafeteria.db
        }
    }

    private void criarTabelaSeNaoExiste() {
        if (conn == null) {
            System.err.println("Conexão nula: Não é possível criar tabela.");
            return;
        }
        String sql = """
            CREATE TABLE IF NOT EXISTS pedidos (
                id TEXT PRIMARY KEY,
                nomeCliente TEXT NOT NULL,
                pedido TEXT NOT NULL,
                acerto BOOLEAN NOT NULL,
                pontuacao INTEGER NOT NULL,
                data TEXT NOT NULL
            );
            """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'pedidos' criada ou verificada.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    @Override
    public void salvarPedido(String nomeCliente, String pedido, boolean acerto, int pontuacao) {
        if (conn == null) {
            System.err.println("Conexão nula: Não é possível salvar pedido.");
            return;
        }
        String id = UUID.randomUUID().toString();
        String data = new Date().toString();
        String sql = "INSERT INTO pedidos (id, nomeCliente, pedido, acerto, pontuacao, data) VALUES (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, nomeCliente);
            pstmt.setString(3, pedido);
            pstmt.setBoolean(4, acerto);
            pstmt.setInt(5, pontuacao);
            pstmt.setString(6, data);
            pstmt.executeUpdate();
            System.out.println("Pedido salvo no SQLite: Cliente=" + nomeCliente + ", Pontos=" + pontuacao);
        } catch (SQLException e) {
            System.err.println("Erro ao salvar pedido no SQLite: " + e.getMessage());
        }
    }

    @Override
    public int carregarUltimaPontuacao() {
        if (conn == null) {
            System.err.println("Conexão nula: Retornando pontuação 0.");
            return 0;
        }
        String sql = "SELECT pontuacao FROM pedidos ORDER BY data DESC LIMIT 1;";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                int ultimaPontuacao = rs.getInt("pontuacao");
                System.out.println("Última pontuação carregada: " + ultimaPontuacao);
                return ultimaPontuacao;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar pontuação: " + e.getMessage());
        }
        System.out.println("Nenhuma pontuação encontrada. Iniciando com 0.");
        return 0;
    }

    // Método opcional: Fecha a conexão ao finalizar o app (chame em um shutdown hook se quiser)
    public void fecharConexao() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexão SQLite fechada.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}