package data.persistence;

public interface IPersistencia {

    /**
     * Salva o resultado de um pedido no sistema de persistência.
     *
     * @param nomeCliente Nome do cliente atendido.
     * @param pedido Nome do item do cardápio pedido.
     * @param acerto Indica se o pedido foi preparado corretamente.
     * @param pontuacao Pontuação total atual do jogo após o processamento do pedido.
     */
    void salvarPedido(String nomeCliente, String pedido, boolean acerto, int pontuacao);

    /**
     * Carrega a última pontuação salva do sistema de persistência.
     * Retorna 0 se não houver dados.
     *
     * @return Última pontuação persistida.
     */
    int carregarUltimaPontuacao();

    // Futuramente, outros métodos como carregarRankings() podem ser adicionados aqui.
}