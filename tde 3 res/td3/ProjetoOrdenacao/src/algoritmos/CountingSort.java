package algoritmos;

import metricas.Metricas;

public class CountingSort {
    public static Metricas ordenar(int[] vetor) {
        int iteracoes = 0;
        int trocas = 0;
        long inicio = System.nanoTime();
        
        int max = encontrarMax(vetor);
        int[] count = new int[max + 1];

        for (int valor : vetor) {
            count[valor]++;
            iteracoes++;
        }

        int i = 0;
        for (int j = 0; j < count.length; j++) {
            while (count[j]-- > 0) {
                vetor[i++] = j;
                trocas++;
                iteracoes++;
            }
        }

        long fim = System.nanoTime();
        return new Metricas(fim - inicio, trocas, iteracoes);
    }

    private static int encontrarMax(int[] vetor) {
        int max = vetor[0];
        for (int val : vetor) {
            if (val > max) max = val;
        }
        return max;
    }
}