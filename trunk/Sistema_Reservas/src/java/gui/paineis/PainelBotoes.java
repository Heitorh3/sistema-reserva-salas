/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.paineis;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import gui.formularios.FormGerenciaSalas;
import gui.janelas.JanelaPesquisas;

/**
 *
 * @author 0213101
 */
public class PainelBotoes extends Panel{

    Label lInicio;
    Button botaoLogin;
    Button botaoSair;
    Button botaoNovaReserva;
    Button botaoConsultaSala;
    Button botaoPesquisar;
    HorizontalLayout leiaute;
    Window win;

    public PainelBotoes(Window win)
    {
        this.win = win;
        lInicio = new Label("<b>Sistema de Reserva de Salas 2011</b>",Label.CONTENT_XHTML);
        botaoLogin = new Button();
        botaoLogin.setCaption("Entrar no sistema");
        botaoSair = new Button();
        botaoSair.setCaption("Encerrar");
        
        botaoPesquisar = new Button("Pesquisar...");
        botaoPesquisar.addListener(new EventoPesquisar());
        /*
        botaoNovaReserva.setCaption("Nova Reserva");
        botaoNovaReserva.addListener(new EventoNovaReserva());
        *
        */
        botaoConsultaSala = new Button();
        botaoConsultaSala.setCaption("Consultar / Modificar Salas");
        botaoConsultaSala.addListener(new EventoNovaSala());
        
        leiaute = new HorizontalLayout();
        leiaute.addComponent(botaoLogin);
        leiaute.addComponent(botaoSair);        
        //leiaute.addComponent(botaoNovaReserva);
        leiaute.addComponent(botaoConsultaSala);
        leiaute.addComponent(botaoPesquisar);
        this.addComponent(lInicio);
        this.addComponent(leiaute);

        
    }

    
    //maneira de fazer eventos para os botoes
    private class EventoNovaSala implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            FormGerenciaSalas FNS = new FormGerenciaSalas();
            win.addWindow(FNS);

        }

    }

    private class EventoPesquisar implements Button.ClickListener
    {
    @Override
        public void buttonClick(Button.ClickEvent event)
        {
            JanelaPesquisas jp = new JanelaPesquisas();
            win.addWindow(jp);

        }

    }

}

