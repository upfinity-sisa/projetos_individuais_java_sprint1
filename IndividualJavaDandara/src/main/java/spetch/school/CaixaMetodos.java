package spetch.school;

import java.util.Scanner;

class CaixaMetodos {

    void telaBoasVindas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║                                      ║");
        System.out.println("║  █ C A I X A   E L E T R Ô N I C O █ ║");
        System.out.println("║                                      ║");
        System.out.println("║   BEM-VINDO AO SEU BANCO DIGITAL     ║");
        System.out.println("║                                      ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Pressione QUALQUER TECLA para continuar...");
        sc.nextLine();
        System.out.println();
    }

    void mostrarMenu() {
        System.out.println("╔════════════════════════════╗");
        System.out.println("║        MENU PRINCIPAL      ║");
        System.out.println("╠════════════════════════════╣");
        System.out.println("║ 1 - Consultar Saldo        ║");
        System.out.println("║ 2 - Depositar              ║");
        System.out.println("║ 3 - Sacar                  ║");
        System.out.println("║ 4 - Extrato                ║");
        System.out.println("║ 0 - Sair                   ║");
        System.out.println("╚════════════════════════════╝");
    }
    double saldo = 1000.0;
    String[] extrato = new String[10];
    Integer indice = 0;


    void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
        if (saldo < 50) {
            System.out.println("⚠ Atenção: saldo baixo!");
        }
    }

    void depositar(Double valor) {
        if (valor < 1) {
            System.out.println("Valor mínimo de depósito: R$ 1,00");
            return;
        }
        saldo += valor;
        registrarExtrato("Depósito: R$ " + valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    void sacar(Double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque!");
            return;
        }
        if (valor > 500) {
            System.out.println("Limite máximo por saque: R$ 500,00");
            return;
        }
        if (valor % 10 != 0) {
            System.out.println("Saque apenas em múltiplos de 10");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        saldo -= valor;
        registrarExtrato("Saque: R$ " + valor);
        System.out.println("Saque realizado com sucesso!");
    }

    void mostrarExtrato() {
        System.out.println("=== Extrato ===");
        if (indice == 0) {
            System.out.println("Nenhuma movimentação ainda.");
        } else {
            for (int i = 0; i < indice; i++) {
                System.out.println(extrato[i]);
            }
        }
    }

    void registrarExtrato(String transacao) {
        if (indice < extrato.length) {
            extrato[indice] = transacao;
            indice++;
        } else {
            for (int i = 1; i < extrato.length; i++) {
                extrato[i - 1] = extrato[i];
            }
            extrato[extrato.length - 1] = transacao;
        }
    }
}
