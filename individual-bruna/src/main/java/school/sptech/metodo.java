package school.sptech;

import java.util.Scanner;

public class metodo {

    public static Double lerValor(Scanner inpt, String txt) {
        Double valor;

        while (true) {
            System.out.println(txt);
            valor = inpt.nextDouble();

            if (valor > 0) {
                return valor;
            } else {
                System.out.println("Valor inválido! Digite um número maior do que 0.");
            }
        }
    }
}
