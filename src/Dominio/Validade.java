package Dominio;

import java.util.ArrayList;

public class Validade {

    private double descontoBaixo = 0.25;
    private double descontoAlto = 0.50;

    public String aplicarDescontoValidade(ArrayList<ProdutoPerecivel> pereciveis) {
        StringBuilder resultado = new StringBuilder();

        for (ProdutoPerecivel p : pereciveis) {
            double valorOriginal = p.getPreco();

            if (p.getDiasParaVencer() <= 0) {
                resultado.append("\n[RECOLHIMENTO] Produto ").append(p.getNome()).append(" está VENCIDO!");
                continue;
            }


            p.calculaDesconto();

            if (p.getPreco() != valorOriginal) {
                resultado.append("\nProduto ").append(p.getNome())
                        .append(" atualizado de R$ ").append(valorOriginal)
                        .append(" para R$ ").append(p.getPreco());
            }
        }
        return resultado.toString();
    }
}
