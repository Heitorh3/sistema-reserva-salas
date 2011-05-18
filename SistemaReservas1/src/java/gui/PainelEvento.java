/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author 0213101
 */
public class PainelEvento extends CustomComponent {

    private String nomeEvento;              //nome que identificara o evento
    private String dataInicioEvento;        //data inicial do evento
    private String dataFimEvento;           //data do ultimo ocorrido do evento, serve para excluir o evento da lista de eventos
    private String horarioInicioEvento;     //horario de inicio do evento
    private String horarioFimEvento;        //horario qndo o evento acaba no dia
    private String finalidade;              //descricao da finalidade
    private String responsavel;             //o nome da pessoa responsavel pelo evento
    private String solicitante;             //nome do solicitante, deve referenciar o usuario cadastrado na lista de usuarios
    private int sala;                //--referencia externa--

    public PainelEvento(classes.Reserva reserva)
    {
        nomeEvento = reserva.getNomeEvento();
        dataInicioEvento = reserva.getDataInicioEvento();
        dataFimEvento = reserva.getDataFimEvento();
        horarioInicioEvento = reserva.getHorarioInicioEvento();
        horarioFimEvento = reserva.getHorarioFimEvento();
        finalidade = reserva.getFinalidade();
        responsavel = reserva.getResponsavel().getNomePessoa();
        solicitante = reserva.getSolicitante().getNomePessoa();
        sala = reserva.getSala().getNumero();

        Label l_nomeEvento = new Label("Evento" + nomeEvento);
        Label l_DIE = new Label("Data Inicial" + dataInicioEvento);
        Label l_DFE = new Label("Data Final" + dataFimEvento);  //precisa aparecer a data final??
        Label l_HIE = new Label("Horario" + horarioInicioEvento);
        Label l_HFE = new Label("Até" + horarioFimEvento);
        Label l_finalidade = new Label("Finalidade" + finalidade);
        Label l_responsavel = new Label("Responsavel" + responsavel);
        Label l_solicitante = new Label("Solicitante" + solicitante);
        Label l_sala = new Label("Sala" + Integer.toString(sala));

        HorizontalLayout hL = new HorizontalLayout();
        VerticalLayout vL = new VerticalLayout();


    }

}
