package Dominio;

public class ProdutoNaoPerecivel extends  Produto {

    private String corredor;

    public ProdutoNaoPerecivel(String nome, int plu, double valor, int quantidade, String corredor) {
        super(nome, plu, valor, quantidade);
        this.corredor = corredor;
    }

    public void inprime(){
        System.out.println("Produto: " + getNome());
        System.out.println("Valor: " + getPreco());
        System.out.println("Corredor: " + getCorredor());

    }

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }
}
