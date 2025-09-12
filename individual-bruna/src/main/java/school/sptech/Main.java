package school.sptech;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Double saida = 0.0;
        Double saldoFinal = 0.0;
        System.out.println("Seu Simulador Financeiro");

        Scanner leitor = new Scanner(System.in);
        Scanner menu = new Scanner(System.in);

        System.out.println("Use vírgula para valores decimais!");
        System.out.println("Informe seu salário mensal: ");
        Double salario = leitor.nextDouble();
//        if (salario > 0.0) {
//
//        }


        System.out.println();


        Double contas = metodo.lerValor(leitor, "INFORME SEUS GASTOS REFERENTES A HABITAÇÃO NESTE MÊS: " );

        Double app = metodo.lerValor(leitor, "INFORME SEUS GASTOS REFERENTES A TRANSPORTE NESTE MÊS: " );

        Double mercado = metodo.lerValor(leitor, "INFORME SEUS GASTOS REFERENTES A ALIMENTAÇÃO NESTE MÊS: " );

        Double mensalidade = metodo.lerValor(leitor, "INFORME SEUS GASTOS REFERENTES A EDUCAÇÃO NESTE MÊS: " );

        Double medicamento = metodo.lerValor(leitor, "INFORME SEUS GASTOS REFERENTES A SAÚDE E BELEZA NESTE MÊS: " );

        Double stremi = metodo.lerValor(leitor, "INFORME SEUS GASTOS REFERENTES A ENTRETENIMENTO NESTE MÊS: " );


        saida = contas + app + mercado + mensalidade + medicamento + stremi;
        saldoFinal = salario - saida;

        Double[] vtSaida = new Double[]{
               contas, app, mercado, mensalidade, medicamento,stremi
        };

        Integer escolha = 0;
        while (escolha != 5) {
            System.out.print("""
                    |=================================|
                    | Menu Simulador Financeiro       |
                    |---------------------------------|
                    | Escolha:                        |
                    | 1 - Saber Quanto Gastou         |
                    | 2 - Saldo Final                 |
                    | 3 - Histórico de Gastos         |
                    | 4 - Encerrar Simulador          |
                    |=================================|
                    """);

            System.out.println("Digite uma opção: ");
            escolha = menu.nextInt();



            if (escolha == 1) {
                System.out.println("A saída desse mês é: ");
                System.out.println(saida); // Quanto gastou

            }
           else if (escolha == 2) {
                System.out.println("Seu saldo final é: ");
                System.out.println(saldoFinal); // saldo final quanto restou
            }
           else if (escolha == 3) {
                System.out.println("Seu Histórico é: ");
                System.out.println("Contas de casa: " + vtSaida[0]);
                System.out.println("Gastos com Transporte: " + vtSaida[1]);
                System.out.println("Alimentação: " + vtSaida[2]);
                System.out.println("Educação: " + vtSaida[3]);
                System.out.println("Medicamentos e Beleza: " + vtSaida[4]);
                System.out.println("Entretenimento (Saídas): " + vtSaida[5]);


            } else if (escolha == 4) {
                System.out.println("Simulador Finalizado!");
                break;


            } else {
                System.out.println("Não existe essa opção!");
            }

        }

    }

        }
