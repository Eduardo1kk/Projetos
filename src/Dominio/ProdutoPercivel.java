package Dominio;

public class ProdutoPercivel extends Produto {
    private int diasParaVencer;

    public ProdutoPercivel(String nome, int plu, double valor, int quantidade , int diasParaVencer) {
        super(nome, plu, valor, quantidade);
        this.diasParaVencer = diasParaVencer;

    }
    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

}
