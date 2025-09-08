package org.example.service;

import org.example.model.DadosMock;
import org.example.util.Utils;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Aposta {
    private static final String LINHA = "-=====================================================================-";

    public void iniciarAposta(Integer indiceUsuario) {
        DadosMock dadosMock = new DadosMock();
        Scanner leitorNumerico = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);

        System.out.println(LINHA);
        System.out.println("Bem-vindo ao jogo da sorte! Acha que consegue adivinhar o número?");
        System.out.println("Se acertar, dobra o valor apostado. Se errar, perde o valor.");
        System.out.println(LINHA);

        System.out.print("Digite o valor da sua aposta: ");
        double valorAposta = leitorNumerico.nextDouble();

        if (valorAposta > dadosMock.getSaldo(indiceUsuario)) {
            System.out.println("Saldo insuficiente para a aposta.");
            return;
        }

        System.out.print("Digite um número de 1 a 10: ");
        int numeroEscolhido = leitorNumerico.nextInt();

        if (numeroEscolhido < 1 || numeroEscolhido > 10) {
            System.out.println("Número inválido. A aposta foi cancelada.");
            return;
        }

        int numeroSorteado = ThreadLocalRandom.current().nextInt(1, 11);

        System.out.println("O número sorteado foi: " + numeroSorteado);

        if (numeroEscolhido == numeroSorteado) {
            System.out.println("Parabéns! Você acertou e dobrou o valor da aposta!");
            dadosMock.adicionarSaldo(indiceUsuario, valorAposta);
        } else {
            System.out.println("Que pena! Você errou e perdeu o valor da aposta.");
            dadosMock.removerSaldo(indiceUsuario, valorAposta);
        }
    }
}