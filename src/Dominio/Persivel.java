package Dominio;

public class Persivel {
    private String nome;
    private double valor;
    private int quantidade;
    private int plu;
    private int diasParaVencerP;


    public Persivel(String name, double value , int quantidade, int plu ){
        this.nome = name;
        this.valor = value;
        this.plu = plu;
        this.quantidade = quantidade;
        this.plu = plu;
    }

        @Override
        public String toString() {
            return "Produto: " + nome +
                    " | Código: " + plu +
                    " | Valor: R$ " + valor +
                    " | Quantidade: " + quantidade ;
        }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public double getValue() { return valor; }

    public void setValue(double value) { this.valor = value;}

    public int getQuantyti() {return quantidade;}

    public void setQuantyti(int quantyti) {this.quantidade = quantyti;}

    public int getPlu() {return plu;}

    public void setPlu(int plu) {this.plu = plu;}

    public int getDiasParaVencerP() {
        return diasParaVencerP;
    }

    public void setDiasParaVencerP(int diasParaVencerP) {
        this.diasParaVencerP = diasParaVencerP;
    }

    public int getQuantity() {
        return quantidade;
    }

    public void setQuantity(int quantity) {
        this.quantidade = quantity;
    }
}
