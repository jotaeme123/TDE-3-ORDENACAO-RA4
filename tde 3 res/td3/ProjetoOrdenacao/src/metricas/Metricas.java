package metricas;

public class Metricas {
    public long tempoExecucao; // em nanossegundos
    public long trocas;
    public long iteracoes;

    public Metricas(long tempoExecucao, long trocas, long iteracoes) {
        this.tempoExecucao = tempoExecucao;
        this.trocas = trocas;
        this.iteracoes = iteracoes;
    }
}
