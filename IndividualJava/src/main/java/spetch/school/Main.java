package spetch.school;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer opcao;

        do {
            System.out.println("=== CAIXA ELETRÔNICO ===");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Extrato");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    Operacoes.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    Double deposito = sc.nextDouble();
                    Operacoes.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    Double saque = sc.nextDouble();
                    Operacoes.sacar(saque);
                    break;
                case 4:
                    Extrato.mostrarExtrato();
                    break;
                case 0:
                    System.out.println("Saindo... Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();

        } while (opcao != 0);

        sc.close();
    }
}
