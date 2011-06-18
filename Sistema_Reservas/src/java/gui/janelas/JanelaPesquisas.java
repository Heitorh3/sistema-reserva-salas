/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.janelas;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import gui.paineis.PainelPesquisaReservas;
import gui.paineis.PainelPesquisaSalasDisponiveisPorHorario;
import gui.paineis.PainelPesquisarRecursos;
import gui.paineis.PainelPesquisarResponsavel;


/**
 *
 * @author 0213101
 */
public class JanelaPesquisas extends Window
{

    Panel painelBotoes;
    Panel pesquisaReservas;
    Panel pesquisaSalas;
    Panel pesquisaSalasDisponiveisEmHorario;
    Panel pesquisaResponsavelReserva;
    Panel pesquisaRecursosSala;

    public JanelaPesquisas()
    {
        this.setWidth("95%");
        this.setHeight("90%");
        this.center();
        this.setModal(true);

        HorizontalLayout leiaute = new HorizontalLayout();
        leiaute.setSpacing(true);
        painelBotoes = new Panel();

        Button botaoReservas = new Button("Pesquisar Reservas");
        botaoReservas.addListener(new EventoPesquisaReservas());
        leiaute.addComponent(botaoReservas);

        /*
         Button botaoSalas = new Button("Pesquisar Estado das Salas");
        botaoSalas.addListener(new EventoPesquisaSalas());
        leiaute.addComponent(botaoSalas);
         * 
         */

        Button botaoDispHorario = new Button("Pesquisar Salas Disponíveis em Determinado Horário");
        botaoDispHorario.addListener(new EventoPesqSalaPorHorario());
        leiaute.addComponent(botaoDispHorario);

        Button botaoResponsavelReserva = new Button("Pesquisar Responsável por Sala Reservada");
        botaoResponsavelReserva.addListener(new EventoPesquisaResponsavel());
        leiaute.addComponent(botaoResponsavelReserva);

        Button botaoRecursosSala = new Button("Pesquisar Recursos de uma Sala");
        botaoRecursosSala.addListener(new EventoPesquisaRecursos());
        leiaute.addComponent(botaoRecursosSala);

        painelBotoes.addComponent(leiaute);
        this.addComponent(painelBotoes);


        pesquisaReservas = new PainelPesquisaReservas();
        pesquisaReservas.setVisible(false);
        this.addComponent(pesquisaReservas);

        /*
         pesquisaSalas = new PainelPesquisaSalas();
        pesquisaSalas.setVisible(false);
        this.addComponent(pesquisaSalas);
         *
         */

        pesquisaSalasDisponiveisEmHorario = new PainelPesquisaSalasDisponiveisPorHorario();
        pesquisaSalasDisponiveisEmHorario.setVisible(false);
        this.addComponent(pesquisaSalasDisponiveisEmHorario);

        pesquisaResponsavelReserva = new PainelPesquisarResponsavel();
        pesquisaResponsavelReserva.setVisible(false);
        this.addComponent(pesquisaResponsavelReserva);

        pesquisaRecursosSala = new PainelPesquisarRecursos();
        pesquisaRecursosSala.setVisible(false);
        this.addComponent(pesquisaRecursosSala);



    }

    public Panel getPainelBotoes()
    {
        return this.painelBotoes;
    }

    private class EventoPesquisaReservas implements Button.ClickListener
    {
        @Override
        public void buttonClick(ClickEvent event)
        {
            painelBotoes.setEnabled(false);
            pesquisaReservas.setVisible(true);

        }
    }
    private class EventoPesquisaSalas implements Button.ClickListener
    {
        @Override
        public void buttonClick(ClickEvent event)
        {
            painelBotoes.setEnabled(false);
            pesquisaSalas.setVisible(true);

        }
    }

    private class EventoPesqSalaPorHorario implements Button.ClickListener
    {
        @Override
        public void buttonClick(ClickEvent event)
        {
            painelBotoes.setEnabled(false);
            pesquisaSalasDisponiveisEmHorario.setVisible(true);

        }
    }

    private class EventoPesquisaResponsavel implements Button.ClickListener
    {
        @Override
        public void buttonClick(ClickEvent event)
        {
            painelBotoes.setEnabled(false);
            pesquisaResponsavelReserva.setVisible(true);

        }
    }

    private class EventoPesquisaRecursos implements Button.ClickListener
    {
        @Override
        public void buttonClick(ClickEvent event) {
            painelBotoes.setEnabled(false);
            pesquisaRecursosSala.setVisible(true);
        }

    }



}
