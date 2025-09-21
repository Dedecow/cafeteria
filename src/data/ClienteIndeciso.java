package data;

public class ClienteIndeciso extends Cliente{
    public ClienteIndeciso(){
        super(ClienteGen.gerarNome());
    }
    @Override
    public String comportamento(){
        return FrasesClientes.getFrase("ndeciso");
    }
}
