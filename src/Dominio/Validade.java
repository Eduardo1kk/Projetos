package Dominio;

public class Validade {

    private double descontoBaixo = 0.25;
    private double descontoAlto = 0.50;

    public String aplicarDescontoValidade(Perecivel... peresivel) {

        String resultado = "";

        for (Perecivel p : peresivel) {

            double valorOriginal = p.getValor();
            double novoValor = valorOriginal;

            if (p.getDiasParaVencer() <= 0) {
                resultado += "\n[RECOLHIMENTO] Produto " + p.getNome() + " está VENCIDO!";
                continue;
            }

            if (p.getDiasParaVencer() <= 5) {

                if (p.getQuantidade() >= 60) {
                    novoValor = valorOriginal * (1 - descontoAlto);
                } else if (p.getQuantidade() >= 30) {
                    novoValor = valorOriginal * (1 - descontoBaixo);
                } else {
                    novoValor = valorOriginal * 0.80;
                }

                p.setValor(novoValor);

                resultado += "\nProduto " + p.getNome() +
                        " atualizado de R$ " + valorOriginal +
                        " para R$ " + novoValor;
            }
        }
        return resultado;
    }
}