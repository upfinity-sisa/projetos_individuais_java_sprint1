package spetch.school;

public class Extrato {
    static String[] extrato = new String[10];
    static Integer indice = 0;

    public static void mostrarExtrato() {
        System.out.println("=== Extrato ===");
        for (int i = 0; i < indice; i++) {
            System.out.println(extrato[i]);
        }
        if (indice == 0) {
            System.out.println("Nenhuma movimentação até agora.");
        }
    }

    public static void registrarExtrato(String transacao) {
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

