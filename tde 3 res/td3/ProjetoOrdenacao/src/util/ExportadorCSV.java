package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportadorCSV {
    public static final String CABECALHO = "Algoritmo,TamanhoVetor,Rodada,TempoExecucaoMs,Trocas,Iteracoes";

    public static void exportar(String caminho, StringBuilder dados) {
        File file = new File(caminho);
        file.getParentFile().mkdirs(); // Cria os diretórios necessários
        
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(dados.toString());
            System.out.println("Arquivo salvo com sucesso em: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo CSV:");
            e.printStackTrace();
        }
    }
}