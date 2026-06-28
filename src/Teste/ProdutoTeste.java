package Teste;

import java.util.ArrayList;

import Dominio.*;

import java.util.InputMismatchException;
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
            int codigo = 0;


            try {
                int cod = scanner.nextInt();
                codigo = cod;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Apenas números são permitidos neste campo.");
                continue;

            }

            System.out.print("Preço: ");
            int preco = 0;
            try {
                int pr = scanner.nextInt();
                preco = pr;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Apenas números são permitidos neste campo.");
                continue;
            }


            System.out.print("Quantidade: ");
            int qtd = 0;
            try {
                int quantidade = scanner.nextInt();
                qtd = quantidade;
                scanner.nextLine();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Apenas números são permitidos neste campo.");
                scanner.nextLine();
            }

            try {
                if (tipoProduto == TipoProduto.PRODUTO_NAO_PERECIVEL) {
                    System.out.print("Corredor: ");
                    String corredor = scanner.nextLine();
                    System.out.print("Esse produto tem dias para vencer? (S/N): ");
                    String resposta = scanner.nextLine();

                    if (resposta.equalsIgnoreCase("S")) {
                        System.out.print("Digite os dias para vencer: ");
                        int dias = scanner.nextInt();
                        scanner.nextLine(); // Limpa o enter!

                        // Chama o construtor QUE TEM diasParaVencer
                        ProdutoNaoPerecivel p = new ProdutoNaoPerecivel(nome, codigo, preco, qtd, corredor, dias);

                    } else {
                        // Chama o construtor padrão (passa sem os dias, o Java preenche com null)
                        ProdutoNaoPerecivel p = new ProdutoNaoPerecivel(nome, codigo, preco, qtd, corredor);
                    }
                    System.out.println("Produto Não Perecível adicionado!");
                }

                else if (tipoProduto == TipoProduto.PRODUTO_PERECIVEL_FRIO) {
                    System.out.print("Dias para vencer: ");
                    int vld = 0;
                    try {
                        vld = scanner.nextInt(); // Guarda direto na variável certa!
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                        System.out.println("Apenas números são permitidos neste campo.");
                    }
                    scanner.nextLine();
                    ProdutoPerecivel pfrio = new ProdutoPerecivel(nome, codigo, preco, qtd, vld);
                    listaDeProdutos.add(pfrio);
                    System.out.println("Produto frio adicionado!");


                } else if (tipoProduto == TipoProduto.PRODUTO_PERECIVEL){
                    System.out.print("Dias para vencer: ");
                    int vld = 0;
                    try {
                        vld = scanner.nextInt(); // Guarda direto na variável certa!
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                        System.out.println("Apenas números são permitidos neste campo.");
                    }

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
            } catch (Exception e){
            e.printStackTrace();
            System.out.println("\n[ERRO]: " + e.getMessage());
            }
            System.out.println("\n=== PRODUTOS NO ESTOQUE ===");
            for (Produto prod : listaDeProdutos) {
                System.out.println("-> " + prod.getNome() + " | Qtd: " + prod.getQuantidade());
            }
        }

       //validade
        Validade validador = new Validade();

        //  Cria uma lista temporária só para os perecíveis
        ArrayList<ProdutoPerecivel> apenasPereciveis = new ArrayList<>();

        //  Varre a lista principal procurando quem é Perecível
        for (Produto prod : listaDeProdutos) {
            if (prod instanceof ProdutoPerecivel) {

                apenasPereciveis.add((ProdutoPerecivel) prod);
            }
        }

        ArrayList<ProdutoPerecivel> apenasPerecivei = new ArrayList<>();

        Validade validado = new Validade();
        String relatorioDescontos = validador.aplicarDescontoValidade(apenasPereciveis);

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

        //  Pega o resultado guardado na sua classe
        System.out.println("\n=== RELATÓRIO DO CALCULADOR ===");
        System.out.printf("Faturamento Total do Estoque: R$ %.2f\n", calculador.getFaturamento());

        scanner.close();
    }
}
