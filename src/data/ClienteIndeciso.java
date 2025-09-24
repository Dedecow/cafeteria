package data;

public class ClienteIndeciso extends Cliente{
    public ClienteIndeciso(String nome, MenuItem pedido){
        super(ClienteGen.gerarNome());
    }

    @Override
    public String comportamento(){
        return FrasesClientes.getFrase(TipoDeCliente.INDECISO);
    }
}