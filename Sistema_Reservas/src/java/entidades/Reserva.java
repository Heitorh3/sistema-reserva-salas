
 

package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQuery;

/**
 * A Classe Reserva contém os dados necessários para efetuar a reserva de uma sala
 * em determinado dia. A reserva pode repetir-se periódicamente. O administrador
 * tem privilégios para editar, adicionar e excluir reservas.<p>
 * Somente o admin ou usuários autorizados podem editar as reservas.<p>
 * A classe Reserva será a mais importante do programa. Atraves dela que teremos
 * acesso a todos os dados para consulta.
 *
 *
 * @autor Vinicius
 * @version 1.1
 */
@Entity
@Table
@NamedQuery(name="Reserva.getByNomeReserva",query="SELECT r FROM Reserva r where r.getNomeReserva() = :parametro")
public class Reserva implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int IdReserva;                  //chave primaria no Hibernate
    @Column
    private String nomeReserva;              //nome que identificara o evento
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
    private String responsavel;             //o nome da pessoa responsavel pelo evento
    @ManyToOne(targetEntity=Pessoa.class)
    @JoinColumn(name="idPessoa")
    private Pessoa solicitante;             //nome do solicitante, deve referenciar o usuario cadastrado na lista de usuarios    
    @ManyToOne(targetEntity=Recinto.class)
    @JoinColumn(name="idRecinto")
    private Recinto sala;                   //--referencia externa--
    @Column
    private char repeticao;
    //repeticao recebera os seguintes valores
    //d - somente no dia
    //s - semanalmente
    //q - quinzenalmente
    //m - mensalmente

    /**
     * Construtor vazio para a classe Reserva.
     */
    public Reserva() {
    }

    /** Construtor da classe Reserva com todos os campos requeridos.
     *
     * @param nomeReserva - String com o nome do Evento, que irá aparecer durante a consulta
     *
     * @param dataInicioEvento - String que contém o dia inicial da reserva. O usuário
     * ficará preso à interface quando da entrada da data, portanto ele não conseguirá
     * entrar com datas fora da realidade.
     *
     * @param dataFimEvento - String que contém o dia final do evento. Se alguma periodicidade for marcada,
     * o programa "fará um while" para pegar todas as datas. O usuário
     * ficará preso à interface quando da entrada da data, portanto ele não conseguirá
     * entrar com datas fora da realidade.
     *
     * @param horarioInicioEvento - String que marca o horário inicial do evento naquele dia.
     * O usuário ficará preso à interface quando da entrada do horário, portanto ele não conseguirá
     * entrar com datas fora da realidade. (intervalos de 30 minutos).
     *
     * @param horarioFimEvento - String que marca o horário final do evento naquele dia.
     * O usuário ficará preso à interface quando da entrada do horário, portanto ele não conseguirá
     * entrar com datas fora da realidade. (intervalos de 30 minutos).
     *
     * @param finalidade - String que marca uma breve descrição sobre a reserva.
     *
     * @param responsavel - A pessoa responsável pela reserva.
     *
     * @param solicitante - A pessoa que solicitou o evento. Será retirado diretamente do login.
     *
     * @param Sala - A sala que está sendo reservada.
     *
     * @param repeticao - Caracte simples que maraca a periodicidade que a reserva terá. Quatro valores possíveis:
     * d - somente no dia , s - semanalmente, q - quinzenalmente,  m- mensalmente
     */
    public Reserva(String nomeEvento, String dataInicioEvento, String dataFimEvento,
            String horarioInicioEvento, String horarioFimEvento, String finalidade,
            String responsavel, Pessoa solicitante, Recinto sala, char repeticao) {
        this.nomeReserva = nomeEvento;
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

    /** Retorna o id da Reserva referente ao banco de dados.
     * @return idReserva - o número da Id da reserva no banco de daddos.
     */
    public int getIdReserva() {
        return IdReserva;
    }

    /** Retorna o objeto sala associado a reserva
     * @return Recinto - a classe Sala que está associada a Reserva
     */
    public Recinto getSala() {
        return sala;
    }

    /** Adiciona uma Sala a reserva.
     *
     * @param sala A sala para associar a reserva.
     */
    public void setSala(Recinto sala) {
        this.sala = sala;
    }

    /** Retorna o horario que o evento acaba no dia.
     *
     * @return O horário que o evento acaba no dia (hh:mm).
     */
    public String getHorarioFimEvento() {
        return horarioFimEvento;
    }

    /**Retorna o horário inicial do evento naquele dia
     *
     * @return string com o horario de inicio do evento no dia (hh:mm)
     */
    public String getHorarioInicioEvento() {
        return horarioInicioEvento;
    }

    /** Acerta o horario do fim da reserva no dia
     *
     * @param horarioFimEvento String com o horario completo de inicio da reserva (hh:mm)
     */
    public void setHorarioFimEvento(String horarioFimEvento) {
        this.horarioFimEvento = horarioFimEvento;
    }

    /**Acerta o horario de inicio da reserva.
     *
     * @param horarioInicioEvento O horario que a reserva começa (hh:mm).
     */
    public void setHorarioInicioEvento(String horarioInicioEvento) {
        this.horarioInicioEvento = horarioInicioEvento;
    }
    

    /** Pega a data que o evento terminará.
     *
     * @return String com a data que o evento irá terminar. (dd/mm/aaaa)
     */
    public String getDataFimEvento() {
        return dataFimEvento;
    }

    /** Pega a data do primeiro dia do evento.
     *
     * @return String com a data completa do inicio do evento.
     */
    public String getDataInicioEvento() {
        return dataInicioEvento;
    }

    /** A finalidade da reserva.
     *
     * @return String com a descriçao da finalidade do sistema.
     */
    public String getFinalidade() {
        return finalidade;
    }

    /** O nome do reserva.
     *
     * @return String com o nome da reserva.
     */
    public String getNomeEvento() {
        return nomeReserva;
    }

    /** A periodicidade da reserva.
     *
     * @return Char que indica qual a periodicidade do evento.
     * d - somente no dia , s - semanalmente, q - quinzenalmente,  m- mensalmente
     *
     */
    public char getRepeticao() {
        return repeticao;
    }

    /** A pessoa responsável pela reserva.
     *
     * @return Pessoa responsável
     */
    public String getResponsavel() {
        return responsavel;
    }

    /** A pessoa que solicitou a reserva
     *
     * @return Classe Pessoa com os dados do solicitante
     */
    public Pessoa getSolicitante() {
        return solicitante;
    }

    /**Acerta a data de final do evento
     *
     * @param dataFimEvento String com a data de fim do evento no formato dd/mm/aaaa.
     */
    public void setDataFimEvento(String dataFimEvento) {
        this.dataFimEvento = dataFimEvento;
    }

    /**Acerta a data de inicio do evento
     *
     * @param dataInicioEvento String com a data de inicio do evento no formato dd/mm/aaaa.
     */
    public void setDataInicioEvento(String dataInicioEvento) {
        this.dataInicioEvento = dataInicioEvento;
    }

    /**Acerta a finalidade da reserva.
     *
     * @param finalidade String com a descrição da reserva.
     */
    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    /**Acerta um nome para o evento
     *
     * @param nomeReserva String com o nome do evento
     */
    public void setNomeEvento(String nomeEvento) {
        this.nomeReserva = nomeEvento;
    }

    /**Acerta a periodicidade do evento
     *
     * @param repeticao char com o codigo da repeticao
     * d - somente no dia , s - semanalmente, q - quinzenalmente,  m- mensalmente
     */
    public void setRepeticao(char repeticao) {
        this.repeticao = repeticao;
    }

    /**Acerta o responsavel pela reserva
     *
     * @param responsavel Pessoa com os dados do responsavel
     */
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**Acerta um solicitante para a reserva.
     *
     * @param solicitante
     */
    public void setSolicitante(Pessoa solicitante) {
        this.solicitante = solicitante;

    }

    @Override
    public String toString() {
        return "Sala " + this.getSala().getNumero() + "   " + "por " + this.getResponsavel();
    }

    public String toStringReal() {
        return "EventoReserva{" + "nomeEvento=" + nomeReserva + "dataInicioEvento=" + dataInicioEvento + "dataFimEvento=" + dataFimEvento + "horarioInicioEvento=" + horarioInicioEvento + "horarioFimEvento=" + horarioFimEvento + "finalidade=" + finalidade + "responsavel=" + responsavel + "solicitante=" + solicitante + "sala=" + sala + "repeticao=" + repeticao + '}';
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
        if ((this.nomeReserva == null) ? (other.nomeReserva != null) : !this.nomeReserva.equals(other.nomeReserva)) {
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
        hash = 79 * hash + (this.nomeReserva != null ? this.nomeReserva.hashCode() : 0);
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

    /**
     * Método que retorna uma String com um resumo da reserva para mostrar no ListSelect
     * de reservas.
     * @return String - Resumo dos Dados da Reserva
     */
    public String getDadosReservaParaListSelect()
    {
        String tudo = "";
        tudo = this.getNomeEvento() + this.getFinalidade();
        //tudo = this.nomeReserva + "  Sala: "+this.sala.getNumero()+"  Responsavel: " + this.getResponsavel().getNomePessoa() ;
        return tudo;
    }

}
