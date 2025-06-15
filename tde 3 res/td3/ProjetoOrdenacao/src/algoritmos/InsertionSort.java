package algoritmos;

import metricas.Metricas;

public class InsertionSort {
    public static Metricas ordenar(int[] vetor) {
        int trocas = 0;
        int iteracoes = 0;
        long inicio = System.nanoTime();

        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            iteracoes++;

            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
                trocas++;
                iteracoes++;
            }
            vetor[j + 1] = chave;
        }

        long fim = System.nanoTime();
        return new Metricas(fim - inicio, trocas, iteracoes);
    }
}