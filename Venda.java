import Produto.Produto;
public class Venda {

    private Produto produto;
    private int quantidade;

    public Venda(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto(){
        return produto;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public double getLucroTotal(){
        return produto.getLucro() * quantidade;
    }

}
