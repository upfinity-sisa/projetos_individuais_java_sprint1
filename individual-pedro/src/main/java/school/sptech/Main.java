package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        List<String> filmes = new ArrayList<>();
        filmes.add("O Grande Hotel Budapeste");
        filmes.add("Moonrise Kingdom");
        filmes.add("Fantástico Sr. Raposo");
        filmes.add("Os Excêntricos Tenembaums");
        filmes.add("Ilha de Cachorros");
        filmes.add("Cidade Asteroide");
        filmes.add("A Crônica Francesa");
        filmes.add("Rushmore");
        filmes.add("Viagem a Darjeeling");

        Integer opcao;
        do {
            System.out.println("=".repeat(25));
            System.out.println("Filmes do Wes Anderson");
            System.out.println("=".repeat(25));
            System.out.println("1. Sortear um filme aleatório");
            System.out.println("2. Mostrar todos os filmes disponíveis");
            System.out.println("3. Adicionar filme");
            System.out.println("4. Pesquisar filme");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    String filmeSorteado = filmes.get(ThreadLocalRandom.current().nextInt(filmes.size()));
                    System.out.println("Filme sorteado: " + filmeSorteado);
                    break;
                case 2:
                    System.out.println("Lista de filmes disponíveis:");
                    for (int i = 0; i < filmes.size(); i++) {
                        String filme = filmes.get(i);
                        System.out.println("- " + filme);
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do novo filme: ");
                    String novoFilme = leitor.nextLine();
                    if (!novoFilme.isBlank()) {
                        filmes.add(novoFilme);
                        System.out.println("Filme \"" + novoFilme + "\" adicionado com sucesso!");
                    } else {
                        System.out.println("Nome inválido. Nenhum filme adicionado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite parte do nome do filme para pesquisar: ");
                    String termo = leitor.nextLine().toLowerCase();

                    Boolean encontrado = false;
                    System.out.println("Resultados da pesquisa:");
                    for (String filme : filmes) {
                        if (filme.toLowerCase().contains(termo)) {
                            System.out.println("- " + filme);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Nenhum filme encontrado com esse termo.");
                    }
                    break;
                case 0:
                    System.out.println("Fechando programa... Até a próxima sessão!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}
