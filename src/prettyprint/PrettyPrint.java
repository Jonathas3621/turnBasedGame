package prettyprint;

public class PrettyPrint {
    public static void limparTela() {
        System.out.println("\033[H\033[2J");
    }

    public static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void timedPrint(String string, int time) {
        System.out.println(string);
        delay(time);
    }

    public static void prettyPrint(String Frase, int Tempo) {  // Créditos para o Wender
        String frase = Frase;
        int tempo = Tempo;

        for (int i = 0; i < frase.length(); i++) {
            System.out.print(frase.charAt(i));
            try {
                Thread.sleep(tempo); // espera tempo milissegundos entre cada caractere
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

