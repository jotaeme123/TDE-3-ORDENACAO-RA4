package dados;

import java.util.Random;

public class GeradorDeVetores {
    public static int[][] gerarConjuntos(int tamanho, int numConjuntos) {
        int[][] conjuntos = new int[numConjuntos][tamanho];
        for (int i = 0; i < numConjuntos; i++) {
            Random random = new Random(i); // Seed fixa para reproduzibilidade
            for (int j = 0; j < tamanho; j++) {
                conjuntos[i][j] = random.nextInt(tamanho * 10); // Valores até 10*tamanho
            }
        }
        return conjuntos;
    }

    public static int[] copiarVetor(int[] original) {
        int[] copia = new int[original.length];
        System.arraycopy(original, 0, copia, 0, original.length);
        return copia;
    }
}