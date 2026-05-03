package Dominio;

public class Perecivel {

    private String nome;
    private double valor;
    private int quantidade;
    private int plu;
    private int diasParaVencer;


    public Perecivel(String nome, int plu , double valor, int diasParaVencer, int quantidade){
        this.nome = nome;
        this.plu = plu;
        setValor(valor);
        this.diasParaVencer = diasParaVencer;
        setQuantidade(quantidade);
    }

    public boolean estaEmFalta() {
        return quantidade == 0;
    }

    public boolean precoErrado() {
        return valor <= 0;
    }

    public boolean estaVencido() {
        return diasParaVencer <= 0;
    }

    public String getNome() { return nome; }

    public double getValor() { return valor; }

    public void setValor(double valor) {
        this.valor = valor < 0 ? 0 : valor;
    }

    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade < 0 ? 0 : quantidade;
    }

    public int getPlu() { return plu; }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }
}