package school.sptech;

import java.util.Scanner;
    public class Main {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Boolean rodando = true;

            System.out.println("👋 Olá! Bem-vindo ao Menu Interativo!");

            while (rodando) {
                System.out.println("\n" + "=".repeat(30));
                System.out.println("📌 O que você deseja fazer?");
                System.out.println("1️⃣  - Calcular tabuada");
                System.out.println("2️⃣  - Descobrir se um número é primo");
                System.out.println("3️⃣  - Encerrar o programa");
                System.out.println("=".repeat(30));
                System.out.print("👉 Digite sua escolha: ");

                Integer opcao = lerInteiro(sc);

                switch (opcao) {
                    case 1:
                        System.out.print("\nDigite um número inteiro para ver sua tabuada: ");

                        Integer nTabuada = lerInteiro(sc);

                        System.out.println("\n📊 Tabuada do " + nTabuada + ":");

                        for (Integer i = 1; i <= 10; i++) {
                            System.out.printf("%d x %d = %d%n", nTabuada, i, nTabuada * i);
                        }
                        break;

                    case 2:

                        System.out.print("\nDigite um número inteiro para verificar se é primo: ");

                        Integer n = lerInteiro(sc);

                        Boolean primo = ehPrimo(n);

                        if (primo) {
                            System.out.println("✅ Boa notícia! O número " + n + " é primo.");
                        }
                        else {
                            System.out.println("❌ O número " + n + " não é primo.");
                        }
                        break;

                    case 3:
                        rodando = false;
                        System.out.println("\n👋 Encerrando... Obrigado por usar o programa!");
                        break;

                    default:
                        System.out.println("⚠️ Ops! Essa opção não existe. Tente novamente.");
                }
            }

            sc.close();
        }

        public static Integer lerInteiro(Scanner sc) {
            while (!sc.hasNextInt()) {
                System.out.print("❌ Isso não parece um número válido. Tente de novo: ");
                sc.next();
            }
            return sc.nextInt();
        }

        public static Boolean ehPrimo(Integer valor) {
            if (valor == null || valor <= 1) {
                return false;
            }

            System.out.println("🔎 Verificando divisores de " + valor + "...");

            for (int i = 2; i < valor; i++) {
                if (valor % i == 0) {
                    System.out.println("❌ Achou divisor: " + i);
                    return false;
                }
            }

            return true;
        }
    }