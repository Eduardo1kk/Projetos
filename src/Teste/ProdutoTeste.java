package Teste;

import java.util.ArrayList;

import Dominio.*;

import java.util.Scanner;

public class ProdutoTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // A LISTA CONTINUA SENDO DE "PRODUTO" (PAI) -> Ela aceita qualquer filho!
        ArrayList<Produto> listaDeProdutos = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- CADASTRO DE PRODUTO ---");
            System.out.println("1 - Produto Não Perecível");
            System.out.println("2 - Produto Perecivel / Frio");
            System.out.println("3 - Produto Comum / Perecível");

            System.out.print("Escolha uma opção: ");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Limpa o enter

            TipoProduto tipoProduto = TipoProduto.ProdutoCadastrado(tipo);

            if (tipoProduto == null) {
                System.out.println("Opção Inválida!");
                continue;
            }

            System.out.println("\n--- DADOS DO PRODUTO ---");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();


            System.out.print("Quantidade: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();

            scanner.nextLine(); // Limpa o enter

           if (tipoProduto == TipoProduto.PRODUTO_NAO_PERECIVEL) {
                System.out.print("Corredor: ");
                String corredor = scanner.nextLine();
                ProdutoNaoPerecivel pnp = new ProdutoNaoPerecivel(nome, codigo, preco, qtd, corredor);
                listaDeProdutos.add(pnp);
                System.out.println("Produto Não Perecível adicionado!");
            } else if (tipoProduto == TipoProduto.PRODUTO_PERECIVEL_FRIO) {
                System.out.print("Dias para vencer: ");
                int vld = scanner.nextInt();
                scanner.nextLine();
                ProdutoPerecivel pfrio = new ProdutoPerecivel(nome, codigo, preco, qtd, vld);
                listaDeProdutos.add(pfrio);
                System.out.println("Produto frio adicionado!");

            } else {
                System.out.print("Dias para vencer: ");
                int vld = scanner.nextInt();
                scanner.nextLine();
                ProdutoPerecivel p = new ProdutoPerecivel(nome, codigo, preco, qtd, vld);
                listaDeProdutos.add(p);
                System.out.println("Produto Comum adicionado!");
            }

            System.out.print("\nDeseja cadastrar outro produto? (S/N): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }

        System.out.println("\n=== PRODUTOS NO ESTOQUE ===");
        for (Produto prod : listaDeProdutos) {
            System.out.println("-> " + prod.getNome() + " | Qtd: " + prod.getQuantidade());
        }

       //validade
        Validade validador = new Validade();

        // 2. Cria uma lista temporária só para os perecíveis
        ArrayList<ProdutoPerecivel> apenasPereciveis = new ArrayList<>();

        // 3. Varre a lista principal procurando quem é Perecível
        for (Produto prod : listaDeProdutos) {
            if (prod instanceof ProdutoPerecivel) {
                // O (ProdutoPercivel) antes faz o  (converte o tipo para o Java aceitar)
                apenasPereciveis.add((ProdutoPerecivel) prod);
            }
        }

        // 4. Passa a lista filtrada convertendo para Array para o seu VarArgs
        String relatorioDescontos = validador.aplicarDescontoValidade(apenasPereciveis.toArray(new ProdutoPerecivel[0]));

        // 5. Imprime o resultado que a sua classe gerou
        System.out.println("\n=== ATUALIZAÇÃO DE VALIDADE ===");
        if (relatorioDescontos.isEmpty()) {
            System.out.println("Nenhum produto precisou de desconto ou recolhimento.");
        } else {
            System.out.println(relatorioDescontos);
        }

     //calculadora
        CalculadorEstoque calculador = new CalculadorEstoque();

        // Esse 'new Produto[0]' é apenas uma instrução para o Java saber o tipo do array
        calculador.calculadora(listaDeProdutos.toArray(new Produto[0]));

        // 3. Pega o resultado guardado na sua classe
        System.out.println("\n=== RELATÓRIO DO CALCULADOR ===");
        System.out.printf("Faturamento Total do Estoque: R$ %.2f\n", calculador.getFaturamento());

        scanner.close();
    }
}
