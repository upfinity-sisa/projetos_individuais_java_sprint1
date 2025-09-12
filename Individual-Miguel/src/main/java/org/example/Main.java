    package org.example;

    import java.util.List;
    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.Random;

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
    // click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public class Main {
        public static void main(String[] args) {
            Integer opcao;
            Scanner leitor = new Scanner(System.in);
            List<Produto> estoque = new ArrayList<>();
            System.out.println("""
                        ==============================
                        ____    ____    ____ \s
                        |  _ \\  / ___|  / ___|\s
                        | |_) | | |  _  | |  _ \s
                        |  __/  | |_| | | |_| |\s
                        |_|      \\____|  \\____|\s
                        ==============================
                        Bem vindo ao sistema de estoque PGG (pequeno grande gestor)!
                        """);
            do {
                System.out.println("""
                        Informe a funcionalidade que deseja usar:
                        1 - Adicionar item ao inventario
                        2 - Consultar item
                        3 - Consultar inventario
                        4 - Remover item do inventario
                        5 - Sortear um item do inventario
                        6 - Editar item
                        0 - encerrar o programa
                        
                        Digite a opção:
                        """);
                opcao = leitor.nextInt();
                leitor.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("-> Adicionar novo item");
                        System.out.print("Digite o nome do produto: ");
                        String nome = leitor.nextLine();
                        System.out.print("Digite a quantidade inicial: ");
                        int quantidade = leitor.nextInt();
                        System.out.print("Digite o preço unitário: ");
                        double preco = leitor.nextDouble();
                        Produto novoProduto = new Produto(nome, quantidade, preco);
                        estoque.add(novoProduto);
                        System.out.println("Produto '" + nome + "' adicionado com sucesso!\n");
                        break;
                    case 2:
                        System.out.println("-> Consultar item por nome");
                        System.out.print("Digite o nome do produto que deseja buscar: ");
                        String nomeBusca = leitor.nextLine();
                        Produto produtoEncontrado = null;
                        for (Produto produtoDaVez : estoque) {
                            if (produtoDaVez.getNome().equalsIgnoreCase(nomeBusca)) {
                                produtoEncontrado = produtoDaVez;
                                break;
                            }
                        }
                        if (produtoEncontrado != null) {
                            System.out.println("Produto encontrado:");
                            System.out.println(produtoEncontrado);
                        } else {
                            System.out.println("Produto '" + nomeBusca + "' não encontrado no estoque.");
                        }
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("-> Lista de todos os itens no inventário");
                        if (estoque.isEmpty()) {
                            System.out.println("O estoque está vazio no momento.\n");
                        } else {
                            System.out.println("------------------------------------");
                            for (Produto produto : estoque) {
                                System.out.println(produto);
                            }
                            System.out.println("------------------------------------\n");
                        }
                        break;
                case 4:
                    System.out.println("-> Remover item do inventário");

                    if (estoque.isEmpty()) {
                        System.out.println("O estoque já está vazio. Não há itens para remover.\n");
                        break;
                    }
                    System.out.print("Digite o nome do produto que deseja remover: ");
                    String nomeRemover = leitor.nextLine();
                    Produto produtoParaRemover = null;
                    for (Produto p : estoque) {
                        if (p.getNome().equalsIgnoreCase(nomeRemover)) {
                            produtoParaRemover = p;
                            break;
                        }
                    }
                    if (produtoParaRemover != null) {
                        estoque.remove(produtoParaRemover);
                        System.out.println("Produto '" + produtoParaRemover.getNome() + "' removido com sucesso!\n");
                    } else {
                        System.out.println("Produto '" + nomeRemover + "' não encontrado. Nenhuma remoção foi feita.\n");
                    }
                    break;
                    case 5:
                        System.out.println("-> Sorteando um item do inventário...");

                        if (estoque.isEmpty()) {
                            System.out.println("Não há itens no estoque para sortear.\n");
                        } else {
                            Random random = new Random();
                            int indiceSorteado = random.nextInt(estoque.size());
                            Produto produtoSorteado = estoque.get(indiceSorteado);
                            System.out.println("O item sorteado foi:");
                            System.out.println(produtoSorteado + "\n");
                        }
                        break;
                    case 6:
                        System.out.println("-> Editar item do inventário");
                        if (estoque.isEmpty()) {
                            System.out.println("O estoque está vazio. Não há itens para editar.\n");
                            break;
                        }
                        System.out.print("Digite o nome do produto que deseja editar: ");
                        String nomeEditar = leitor.nextLine();
                        Produto produtoParaEditar = null;
                        for (Produto p : estoque) {
                            if (p.getNome().equalsIgnoreCase(nomeEditar)) {
                                produtoParaEditar = p;
                                break;
                            }
                        }
                        if (produtoParaEditar != null) {
                            System.out.println("Produto encontrado. Insira os novos dados abaixo.");
                            System.out.println("Dica: Deixe o nome em branco ou digite -1 para números se não quiser alterar.");
                            System.out.println("Dados Atuais: " + produtoParaEditar);

                            System.out.print("Digite o novo nome: ");
                            String novoNome = leitor.nextLine();
                            if (!novoNome.trim().isEmpty()) {
                                produtoParaEditar.setNome(novoNome);
                                System.out.println("Nome alterado.");
                            }

                            System.out.print("Digite a nova quantidade: ");
                            int novaQtd = leitor.nextInt();
                            if (novaQtd != -1) {
                                produtoParaEditar.setQuantidade(novaQtd);
                                System.out.println("Quantidade alterada.");
                            }
                            System.out.print("Digite o novo preço: ");
                            double novoPreco = leitor.nextDouble();
                            if (novoPreco != -1) {
                                produtoParaEditar.setPreco(novoPreco);
                                System.out.println("Preço alterado.");
                            }
                            System.out.println("\nProduto atualizado com sucesso!");
                            System.out.println("Novos Dados: " + produtoParaEditar + "\n");
                        } else {
                            System.out.println("Produto '" + nomeEditar + "' não encontrado. Nenhuma edição foi feita.\n");
                        }
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema PGG. Volte sempre!");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção do menu.\n");
                        break;
                }
            } while (opcao != 0);
        }
    }