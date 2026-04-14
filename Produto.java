package Produto;

public class Produto {
    private String nome;
    private double valorAtacado;
    private double valorVenda;

    public Produto(String nome, double valorAtacado, double valorVenda){
        this.nome = nome;
        this.valorAtacado = valorAtacado;
        this.valorVenda = valorVenda;
    }

    public String getNome(){
        return nome;
    }
    //Calculo do lucro
    public double getLucro(){
        return valorVenda - valorAtacado;
    }

    //porcentagem
    public double getMargemLucro(){
        return (getLucro() / valorVenda) * 100;
    }
}
