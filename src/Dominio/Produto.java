package Dominio;

public abstract class  Produto {

    private String nome;
    private int plu;
    private int quantidade;
    private double preco;
    private Integer diasParaVencer;



    public Produto(String nome, int plu, double preco,int quantidade) {
        this.nome = nome;
        this.plu = plu;
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public Produto(String nome, int plu, double preco,int quantidade,Integer diasParaVencer){
        this(nome,plu,preco,quantidade);
        this.diasParaVencer = diasParaVencer;
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
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade do produto não pode ser negativa.");
        }
        this.quantidade = quantidade;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if (preco <= 0){
            throw new IllegalArgumentException("Valor invalido!");
        }
        this.preco = preco;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }
}