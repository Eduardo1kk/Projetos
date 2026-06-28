package Dominio;

public class CalculadorEstoque {

    private double faturamento;
    private double custos;

    public void calculadora(Produto... produto) {

        double totalFaturamento = 0;

        for (Produto p : produto) { // Para cada 'Produto p' dentro do array 'produtos'
            if (p != null && p.getDiasParaVencer() > 0) {
                totalFaturamento += p.getPreco() * p.getQuantidade();
            }
        }
        this.faturamento = totalFaturamento;

    }

    public double getFaturamento() {
        return faturamento;
    }
}

