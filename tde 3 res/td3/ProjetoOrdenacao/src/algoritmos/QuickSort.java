package algoritmos;

import metricas.Metricas;

public class QuickSort {
    private static int trocas;
    private static int iteracoes;

    public static Metricas ordenar(int[] vetor) {
        trocas = 0;
        iteracoes = 0;
        long inicio = System.nanoTime();
        quickSort(vetor, 0, vetor.length - 1);
        long fim = System.nanoTime();
        return new Metricas(fim - inicio, trocas, iteracoes);
    }

    private static void quickSort(int[] v, int inicio, int fim) {
        iteracoes++;
        if (inicio < fim) {
            int p = particionar(v, inicio, fim);
            quickSort(v, inicio, p - 1);
            quickSort(v, p + 1, fim);
        }
    }

    private static int particionar(int[] v, int inicio, int fim) {
        int pivo = v[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            iteracoes++;
            if (v[j] <= pivo) {
                i++;
                trocar(v, i, j);
            }
        }
        trocar(v, i + 1, fim);
        return i + 1;
    }

    private static void trocar(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
        trocas++;
    }
}