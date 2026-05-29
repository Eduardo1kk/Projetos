package Dominio;

public abstract class Produto {

    private String nome;
    private int plu;
    private int quantidade;
    private double preco;



    public Produto(String nome, int plu, double preco,int quantidade) {
        this.nome = nome;
        this.plu = plu;
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public abstract void calculaDesconto();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPlu() {
        return plu;
    }

    public void setPlu(int plu) {
        this.plu = plu;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade < 0 ? 0 : quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double valor) {
        this.preco = preco < 0 ? 0 : preco;
    }
}