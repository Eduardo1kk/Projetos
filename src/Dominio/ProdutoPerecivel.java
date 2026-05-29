package Dominio;

public class ProdutoPerecivel extends Produto {
    private int diasParaVencer;

    public ProdutoPerecivel(String nome, int plu, double valor, int quantidade , int diasParaVencer) {
        super(nome, plu, valor, quantidade);
        this.diasParaVencer = diasParaVencer;

    }

    @Override
    public void calculaDesconto() {
        if (this.diasParaVencer <= 0) {
            return;
        }
        if (this.diasParaVencer <= 5) {
            if (this.getQuantidade() >= 60) {
                double preco = this.getPreco() * 0.50;
                this.setPreco(preco);  // Desconto Alto
            } else if (this.getQuantidade() >= 30) {
                double preco = this.getPreco() * 0.70;
                this.setPreco(preco); // Desconto Baixo
            } else {
                double preco = this.getPreco() * 0.80;
                this.setPreco(preco); // Desconto Padrão (20%)
            }
        }
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }


}
