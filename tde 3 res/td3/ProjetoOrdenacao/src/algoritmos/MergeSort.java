package algoritmos;

import metricas.Metricas;

public class MergeSort {
    public static Metricas ordenar(int[] vetor) {
        long startTime = System.nanoTime();
        Metricas metricas = new Metricas(0, 0, 0);
        int[] vetorAux = vetor.clone();
        mergeSort(vetorAux, 0, vetorAux.length - 1, metricas);
        long endTime = System.nanoTime();
        metricas.tempoExecucao = endTime - startTime;
        return metricas;
    }

    private static void mergeSort(int[] vetor, int inicio, int fim, Metricas metricas) {
        metricas.iteracoes++; // Conta a chamada recursiva
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio, metricas);
            mergeSort(vetor, meio + 1, fim, metricas);
            merge(vetor, inicio, meio, fim, metricas);
        }
    }

    private static void merge(int[] vetor, int inicio, int meio, int fim, Metricas metricas) {
        int[] aux = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        // Combina as duas metades ordenadas
        while (i <= meio && j <= fim) {
            metricas.iteracoes++; // Conta CADA comparação
            if (vetor[i] <= vetor[j]) {
                aux[k++] = vetor[i++];
            } else {
                aux[k++] = vetor[j++];
                metricas.trocas++; // Agora conta APENAS trocas físicas (1 por movimento)
            }
        }

        // Copia elementos restantes da metade esquerda (se houver)
        while (i <= meio) {
            aux[k++] = vetor[i++];
        }

        // Copia elementos restantes da metade direita (se houver)
        while (j <= fim) {
            aux[k++] = vetor[j++];
        }

        // Transfere do array auxiliar para o original
        System.arraycopy(aux, 0, vetor, inicio, aux.length);
    }
}