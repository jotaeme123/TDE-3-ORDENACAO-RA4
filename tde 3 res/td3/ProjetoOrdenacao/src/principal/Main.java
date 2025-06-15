package principal;

import algoritmos.*;
import dados.GeradorDeVetores;
import metricas.Metricas;
import util.ExportadorCSV;

public class Main {
    static final int[] TAMANHOS = {1000, 10000, 100000, 500000, 1000000};
    static final int RODADAS = 5;

    public static void main(String[] args) {
        System.out.println("Iniciando análise de desempenho...");
        StringBuilder dados = new StringBuilder();
        dados.append(ExportadorCSV.CABECALHO).append("\n");
        
        for (int tamanho : TAMANHOS) {
            System.out.println("\nProcessando vetores de tamanho: " + tamanho);
            int[][] conjuntos = GeradorDeVetores.gerarConjuntos(tamanho, RODADAS);

            for (int rodada = 0; rodada < RODADAS; rodada++) {
                System.out.println("Rodada " + (rodada + 1) + "/" + RODADAS);
                int[] base = GeradorDeVetores.copiarVetor(conjuntos[rodada]);
                
                // Pular InsertionSort para vetores grandes
                if (tamanho <= 10000) {
                    System.out.print("InsertionSort... ");
                    registrar("InsertionSort", InsertionSort.ordenar(GeradorDeVetores.copiarVetor(base)), 
                            tamanho, rodada + 1, dados);
                    System.out.println("OK");
                }
                
                System.out.print("QuickSort... ");
                registrar("QuickSort", QuickSort.ordenar(GeradorDeVetores.copiarVetor(base)), 
                        tamanho, rodada + 1, dados);
                System.out.println("OK");
                
                System.out.print("MergeSort... ");
                registrar("MergeSort", MergeSort.ordenar(GeradorDeVetores.copiarVetor(base)), 
                        tamanho, rodada + 1, dados);
                System.out.println("OK");
                
                System.out.print("CountingSort... ");
                registrar("CountingSort", CountingSort.ordenar(GeradorDeVetores.copiarVetor(base)), 
                        tamanho, rodada + 1, dados);
                System.out.println("OK");
            }
        }

        System.out.println("\nTotal de linhas de dados coletadas: " + (dados.toString().split("\n").length - 1));
        ExportadorCSV.exportar("resultados/resultados.csv", dados);
        System.out.println("Análise concluída!");
    }

    private static void registrar(String nome, Metricas m, int tamanho, int rodada, StringBuilder dados) {
        dados.append(nome).append(",")
             .append(tamanho).append(",")
             .append(rodada).append(",")
             .append(m.tempoExecucao / 1_000_000.0).append(",") // converter para ms
             .append(m.trocas).append(",")
             .append(m.iteracoes).append("\n");
    }
}