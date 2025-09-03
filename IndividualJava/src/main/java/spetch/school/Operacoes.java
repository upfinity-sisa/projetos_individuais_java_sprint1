package spetch.school;

public class Operacoes {
    static Double saldo = 1000.0;

    public static void consultarSaldo() {
        System.out.println("Seu saldo atual é: R$ " + saldo);
    }

    public static void depositar(Double valor) {
        if (valor > 0) {
            saldo += valor;
            Extrato.registrarExtrato("Depósito de R$ " + valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public static void sacar(Double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            Extrato.registrarExtrato("Saque de R$ " + valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }
}

