package Dominio;

public class CalculadorEstoque {

    private double faturamento;
    private double custos;

    public void calculadora(Perecivel... peresivel) { //Aqui é para pegar todas as variaveis da lista e eu o nomeio 'produto'
        // O VarArgs (...) permite passar vários produtos ou um array, simplificando a chamada do metodo.

        double totalFaturamento = 0;

        for (Perecivel p : peresivel) { // Para cada 'Produto p' dentro do array 'produtos'
            if (p != null) {
                totalFaturamento += p.getValor() * p.getQuantidade();
            }
        }
        this.faturamento = totalFaturamento;
    }

    public double getFaturamento() {
        return faturamento;
    }
}

