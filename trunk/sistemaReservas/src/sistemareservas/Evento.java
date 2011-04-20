/*
 * A classe Evento sera a mais importante do programa. Atraves dela que teremos
 * acesso a todos os elementos do programa e todas as consultas serao feitas
 * lendo os eventos e fazendo referencias aos Recintos e Pessoas.
 *
 */

package sistemareservas;

/**
 *
 * @author 0213101
 */
public class Evento
{
    private String nomeEvento;
    private String dataInicioEvento;
    private String dataFimEvento;
    private String horarioUtilizacao;
    private String finalidade;
    private Pessoa responsavel;
    private Pessoa solicitante;
    private int codSala;    //--referencia externa--
    //repeticao recebera os seguintes valores
    //d - somente no dia
    //s - semanalmente
    //q - quinzenalmente
    //m - mensalmente
    private char repeticao;

    public Evento() {
    }

    public Evento(
            String nomeEvento, String dataInicioEvento, String dataFimEvento,
            String horarioUtilizacao, String finalidade, Pessoa responsavel,
            Pessoa solicitante, int codSala, char repeticao)
    {
        this.nomeEvento = nomeEvento;
        this.dataInicioEvento = dataInicioEvento;
        this.dataFimEvento = dataFimEvento;
        this.horarioUtilizacao = horarioUtilizacao;
        this.finalidade = finalidade;
        this.responsavel = responsavel;
        this.solicitante = solicitante;
        this.codSala = codSala;
        this.repeticao = repeticao;
    }

    

    public int getCodSala() {
        return codSala;
    }

    public String getDataFimEvento() {
        return dataFimEvento;
    }

    public String getDataInicioEvento() {
        return dataInicioEvento;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public String getHorarioUtilizacao() {
        return horarioUtilizacao;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public char getRepeticao() {
        return repeticao;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public Pessoa getSolicitante() {
        return solicitante;
    }

    public void setCodSala(int codSala) {
        this.codSala = codSala;
    }

    public void setDataFimEvento(String dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }

    public void setDataInicioEvento(String dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public void setHorarioUtilizacao(String horarioUtilizacao) {
        this.horarioUtilizacao = horarioUtilizacao;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public void setRepeticao(char repeticao) {
        this.repeticao = repeticao;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    public void setSolicitante(Pessoa solicitante) {
        this.solicitante = solicitante;
    }

    @Override
    public String toString() {
        return "Evento{" + "nomeEvento=" + nomeEvento + "dataInicioEvento=" + dataInicioEvento +
               "dataFimEvento=" + dataFimEvento + "horarioUtilizacao=" + horarioUtilizacao +
               "finalidade=" + finalidade + "responsavel=" + responsavel +
               "solicitante=" + solicitante + "codSala=" + codSala +
               "repeticao=" + repeticao + '}';
    }



}
