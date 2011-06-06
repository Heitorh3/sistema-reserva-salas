/*
 * A classe Reserva sera a mais importante do programa. Atraves dela que teremos
 * acesso a todos os elementos do programa e todas as consultas serao feitas
 * lendo os eventos e fazendo referencias aos Recintos e Pessoas.
 *
 */

package classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author 0213101
 */
@Entity
@Table
public class Reserva
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int IdReserva;                  //chave primaria no Hibernate
    @Column
    private String nomeEvento;              //nome que identificara o evento
    @Column
    private String dataInicioEvento;        //data inicial do evento
    @Column
    private String dataFimEvento;           //data do ultimo ocorrido do evento, serve para excluir o evento da lista de eventos
    @Column
    private String horarioInicioEvento;     //horario de inicio do evento
    @Column
    private String horarioFimEvento;        //horario qndo o evento acaba no dia
    @Column
    private String finalidade;              //descricao da finalidade
    @Column
    @ManyToOne
    private Pessoa responsavel;             //o nome da pessoa responsavel pelo evento
    @Column
    @ManyToOne
    private Pessoa solicitante;             //nome do solicitante, deve referenciar o usuario cadastrado na lista de usuarios
    @Column
    @ManyToOne
    private Recinto sala;                //--referencia externa--
    @Column
    private char repeticao;
    //repeticao recebera os seguintes valores
    //d - somente no dia
    //s - semanalmente
    //q - quinzenalmente
    //m - mensalmente

    public Reserva() {
    }

    public Reserva(String nomeEvento, String dataInicioEvento, String dataFimEvento, String horarioInicioEvento, String horarioFimEvento, String finalidade, Pessoa responsavel, Pessoa solicitante, Recinto Sala, char repeticao) {
        this.nomeEvento = nomeEvento;
        this.dataInicioEvento = dataInicioEvento;
        this.dataFimEvento = dataFimEvento;
        this.horarioInicioEvento = horarioInicioEvento;
        this.horarioFimEvento = horarioFimEvento;
        this.finalidade = finalidade;
        this.responsavel = responsavel;
        this.solicitante = solicitante;
        this.sala = sala;
        this.repeticao = repeticao;
    }

    public int getIdReserva() {
        return IdReserva;
    }

    public Recinto getSala() {
        return sala;
    }

    public void setSala(Recinto sala) {
        this.sala = sala;
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
    

    public Recinto getCodSala() {
        return sala;
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

    public void setCodSala(Recinto codSala) {
        this.sala = codSala;
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
        return "EventoReserva{" + "nomeEvento=" + nomeEvento + "dataInicioEvento=" + dataInicioEvento + "dataFimEvento=" + dataFimEvento + "horarioInicioEvento=" + horarioInicioEvento + "horarioFimEvento=" + horarioFimEvento + "finalidade=" + finalidade + "responsavel=" + responsavel + "solicitante=" + solicitante + "sala=" + sala + "repeticao=" + repeticao + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if ((this.nomeEvento == null) ? (other.nomeEvento != null) : !this.nomeEvento.equals(other.nomeEvento)) {
            return false;
        }
        if ((this.dataInicioEvento == null) ? (other.dataInicioEvento != null) : !this.dataInicioEvento.equals(other.dataInicioEvento)) {
            return false;
        }
        if ((this.dataFimEvento == null) ? (other.dataFimEvento != null) : !this.dataFimEvento.equals(other.dataFimEvento)) {
            return false;
        }
        if ((this.horarioInicioEvento == null) ? (other.horarioInicioEvento != null) : !this.horarioInicioEvento.equals(other.horarioInicioEvento)) {
            return false;
        }
        if ((this.horarioFimEvento == null) ? (other.horarioFimEvento != null) : !this.horarioFimEvento.equals(other.horarioFimEvento)) {
            return false;
        }
        if ((this.finalidade == null) ? (other.finalidade != null) : !this.finalidade.equals(other.finalidade)) {
            return false;
        }
        if (this.responsavel != other.responsavel && (this.responsavel == null || !this.responsavel.equals(other.responsavel))) {
            return false;
        }
        if (this.solicitante != other.solicitante && (this.solicitante == null || !this.solicitante.equals(other.solicitante))) {
            return false;
        }
        if (this.sala != other.sala && (this.sala == null || !this.sala.equals(other.sala))) {
            return false;
        }
        if (this.repeticao != other.repeticao) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.IdReserva;
        hash = 79 * hash + (this.nomeEvento != null ? this.nomeEvento.hashCode() : 0);
        hash = 79 * hash + (this.dataInicioEvento != null ? this.dataInicioEvento.hashCode() : 0);
        hash = 79 * hash + (this.dataFimEvento != null ? this.dataFimEvento.hashCode() : 0);
        hash = 79 * hash + (this.horarioInicioEvento != null ? this.horarioInicioEvento.hashCode() : 0);
        hash = 79 * hash + (this.horarioFimEvento != null ? this.horarioFimEvento.hashCode() : 0);
        hash = 79 * hash + (this.finalidade != null ? this.finalidade.hashCode() : 0);
        hash = 79 * hash + (this.responsavel != null ? this.responsavel.hashCode() : 0);
        hash = 79 * hash + (this.solicitante != null ? this.solicitante.hashCode() : 0);
        hash = 79 * hash + (this.sala != null ? this.sala.hashCode() : 0);
        hash = 79 * hash + this.repeticao;
        return hash;
    }


}
