package Dominio;

public class Produto {

    private String nome;
    private int plu;
    private int quantidade;
    private double preco;


    //Aqui eu crio um contrutor para facilitar a passagem de dados e para não quebrar o cod da galera
    public Produto(String nome, int plu, double preco,int quantidade) {
        this.nome = nome;
        this.plu = plu;
        setPreco(preco);

        setQuantidade(quantidade);
    }

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
        this.preco = valor < 0 ? 0 : valor;
    }
}