package spetch.school;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner ler = new Scanner(System.in);
            ler.useLocale(Locale.US);

            CaixaMetodos caixa = new CaixaMetodos();
            Integer opcao;

            // Tela de boas-vindas
            caixa.telaBoasVindas();

            do {
                caixa.mostrarMenu();
                System.out.print("Escolha uma opção: ");
                opcao = ler.nextInt();
                System.out.println();

                switch (opcao) {
                    case 1 -> caixa.consultarSaldo();
                    case 2 -> {
                        System.out.print("Digite o valor do depósito: ");
                        Double deposito = ler.nextDouble();
                        caixa.depositar(deposito);
                    }
                    case 3 -> {
                        System.out.print("Digite o valor do saque: ");
                        Double saque = ler.nextDouble();
                        caixa.sacar(saque);
                    }
                    case 4 -> caixa.mostrarExtrato();
                    case 0 -> System.out.println("Saindo... Obrigado!");
                    default -> System.out.println("Opção inválida!");
                }

                System.out.println();

            } while (opcao != 0);

        }
    }
