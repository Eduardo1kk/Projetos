package Teste;

import Dominio.CalculadorEstoque;
import Dominio.Perecivel;
import Dominio.Produto;
import Dominio.Validade;

public class ProdutoTeste {
    public static void main(String[] args) {
        CalculadorEstoque calc = new CalculadorEstoque();
        Validade validade = new Validade();


        Produto p1 = new Produto("Arroz", 11111, 5.50, 10,500);
        Produto p2 = new Produto("Feijão", 5555, 5, 100,500);

        Perecivel pp1 = new Perecivel("Iogute",4844,-10,5,100);
        Perecivel pp2 = new Perecivel("Queijo",50544,50,-1,-1);


        for (Produto p : new Produto[]{p1, p2}) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Codigo: " + p.getPlu());
            System.out.println("Valor: " + p.getValor());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("-----------------------------------------------------------------");
        }

       for (Perecivel pp : new Perecivel[]{pp1,pp2}){
           if (pp.estaEmFalta()) {
               System.out.println("⚠ Produto: "+ pp.getNome() + " em falta!");
           }
           if (pp.precoErrado()) {
               System.out.println("⚠ Produto está com o valor errado!");
           }
           System.out.println("Produto: " + pp.getNome());
           System.out.println("Código: " + pp.getPlu());
           System.out.println("Valor: R$ " + pp.getValor());
           System.out.println("Quantidade: " + pp.getQuantidade());
           System.out.println("-----------------------------------------------------------------");
       }

        String resultado = validade.aplicarDescontoValidade(pp1,pp2);
        System.out.println(resultado);

        calc.calculadora(pp1,pp2);
        System.out.println("Faturamento total Perecivel: " + calc.getFaturamento());


    }
}
