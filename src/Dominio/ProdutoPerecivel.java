package Dominio;

public class ProdutoPerecivel extends Produto {


    public ProdutoPerecivel(String nome, int plu, double valor, int quantidade , Integer diasParaVencer) {
        super(nome, plu, valor, quantidade,diasParaVencer);
    }

    @Override
    public void calculaDesconto() {
        if (getDiasParaVencer() <= 0) {
            return;
        }
        if (getDiasParaVencer() <= 5) {
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
}
