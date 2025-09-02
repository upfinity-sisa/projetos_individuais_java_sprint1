package spetch.school;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vamos criar 3 clientes com saldo inicial aleatório
        Double[] saldos = {100.0, 500.0, 300.0};
        Integer[] ids = {1, 2, 3};

        System.out.println("=== Bem-vindo ao ATM ===");
        System.out.print("Digite seu ID (1-3): ");
        Integer idCliente = scanner.nextInt();

        Integer posicao = null;
        // verificar se o ID existe
        for (int i = 0; i < ids.length; i++) {
            if (ids[i].equals(idCliente)) {
                posicao = i;
                break;
            }
        }

        if (posicao == null) {
            System.out.println("ID inválido. Encerrando.");
            return;
        }

        Boolean sair = false;

        while (!sair) {
            System.out.println("\n1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            Integer opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    consultarSaldo(saldos, posicao);
                    break;
                case 2:
                    System.out.print("Digite o valor para depositar: ");
                    Double valorDeposito = scanner.nextDouble();
                    depositar(saldos, posicao, valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para sacar: ");
                    Double valorSaque = scanner.nextDouble();
                    sacar(saldos, posicao, valorSaque);
                    break;
                case 4:
                    System.out.println("Saindo... Obrigado!");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    public static void consultarSaldo(Double[] saldos, Integer posicao) {
        System.out.printf("Saldo atual: R$ %.2f\n", saldos[posicao]);
    }

    public static void depositar(Double[] saldos, Integer posicao, Double valor) {
        if (valor > 0) {
            saldos[posicao] += valor;
            System.out.printf("Depósito de R$ %.2f realizado!\n", valor);
        } else {
            System.out.println("Valor inválido.");
        }
    }

    public static void sacar(Double[] saldos, Integer posicao, Double valor) {
        if (valor > saldos[posicao]) {
            System.out.println("Saldo insuficiente!");
        } else if (valor <= 0) {
            System.out.println("Valor inválido.");
        } else {
            saldos[posicao] -= valor;
            System.out.printf("Saque de R$ %.2f realizado!\n", valor);
        }
    }
}
