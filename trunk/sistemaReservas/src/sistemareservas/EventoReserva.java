/*
 * A classe EventoReserva sera a mais importante do programa. Atraves dela que teremos
 * acesso a todos os elementos do programa e todas as consultas serao feitas
 * lendo os eventos e fazendo referencias aos Recintos e Pessoas.
 *
 */

package sistemareservas;

/**
 *
 * @author 0213101
 */
public class EventoReserva
{
    private String nomeEvento;              //nome que identificara o evento
    private String dataInicioEvento;        //data inicial do evento
    private String dataFimEvento;           //data do ultimo ocorrido do evento, serve para excluir o evento da lista de eventos
    private String horarioInicioEvento;     //horario de inicio do evento
    private String horarioFimEvento;        //horario qndo o evento acaba no dia
    private String finalidade;              //descricao da finalidade
    private Pessoa responsavel;             //o nome da pessoa responsavel pelo evento
    private Pessoa solicitante;             //nome do solicitante, deve referenciar o usuario cadastrado na lista de usuarios
    private int codSala;                    //--referencia externa--
    private char repeticao;
    //repeticao recebera os seguintes valores
    //d - somente no dia
    //s - semanalmente
    //q - quinzenalmente
    //m - mensalmente

    public EventoReserva() {
    }

    public EventoReserva(String nomeEvento, String dataInicioEvento, String dataFimEvento, String horarioInicioEvento, String horarioFimEvento, String finalidade, Pessoa responsavel, Pessoa solicitante, int codSala, char repeticao) {
        this.nomeEvento = nomeEvento;
        this.dataInicioEvento = dataInicioEvento;
        this.dataFimEvento = dataFimEvento;
        this.horarioInicioEvento = horarioInicioEvento;
        this.horarioFimEvento = horarioFimEvento;
        this.finalidade = finalidade;
        this.responsavel = responsavel;
        this.solicitante = solicitante;
        this.codSala = codSala;
        this.repeticao = repeticao;
    }

    public String getHorarioFimEvento() {
        return horarioFimEvento;
    }

    public String getHorarioInicioEvento() {
        return horarioInicioEvento;
    }

    public void setHorarioFimEvento(String horarioFimEvento) {
        this.horarioFimEvento = horarioFimEvento;
    }

    public void setHorarioInicioEvento(String horarioInicioEvento) {
        this.horarioInicioEvento = horarioInicioEvento;
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
        return horarioInicioEvento;
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
        this.horarioInicioEvento = horarioUtilizacao;
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
        return "EventoReserva{" + "nomeEvento=" + nomeEvento + "dataInicioEvento=" + dataInicioEvento + "dataFimEvento=" + dataFimEvento + "horarioInicioEvento=" + horarioInicioEvento + "horarioFimEvento=" + horarioFimEvento + "finalidade=" + finalidade + "responsavel=" + responsavel + "solicitante=" + solicitante + "codSala=" + codSala + "repeticao=" + repeticao + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }



}
